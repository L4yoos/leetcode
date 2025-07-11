import os
import re
from datetime import datetime
import subprocess

README_PATH = "README.md"
SOLUTIONS_BASE_PATH = "./"

GITHUB_USERNAME = "L4yoos"
GITHUB_REPO_NAME = "leetcode"
GITHUB_MAIN_BRANCH = "main"

def get_git_commit_date(file_path):
    try:
        date_str = subprocess.check_output(
            ['git', 'log', '-1', '--format=%ad', '--date=format:%Y.%m.%d', '--', file_path],
            cwd=SOLUTIONS_BASE_PATH
        ).decode('utf-8').strip()
        return date_str
    except Exception as e:
        print(f"Warning: Could not get git log date for {file_path}. Error: {e}")
        return datetime.now().strftime("%Y.%m.%d")


def get_solution_stats(base_path):
    easy_count = 0
    medium_count = 0
    hard_count = 0
    total_count = 0
    all_solutions_details = []

    problem_folder_pattern = re.compile(r'^\d+_(.*?)_(Easy|Medium|Hard)$', re.IGNORECASE)

    for entry_name in os.listdir(base_path):
        entry_path = os.path.join(base_path, entry_name)

        if os.path.isdir(entry_path):
            match = problem_folder_pattern.match(entry_name)
            if match:
                problem_name_raw = match.group(1)
                difficulty_raw = match.group(2)

                problem_name_display = ' '.join(re.findall(r'[A-Z][a-z0-9]*', problem_name_raw)).strip()
                difficulty = difficulty_raw.capitalize()

                solution_files = [f for f in os.listdir(entry_path) if
                                  f.endswith(('.java'))]

                if solution_files:
                    total_count += 1

                    if difficulty == "Easy":
                        easy_count += 1
                    elif difficulty == "Medium":
                        medium_count += 1
                    elif difficulty == "Hard":
                        hard_count += 1
                    else:
                        print(
                            f"Warning: Unknown difficulty '{difficulty}' for problem '{problem_name_display}'. Counting as Medium.")
                        # medium_count += 1

                    solution_file_path = os.path.join(entry_path, solution_files[0])
                    commit_date = get_git_commit_date(solution_file_path)

                    relative_solution_path = os.path.relpath(solution_file_path, base_path)
                    github_link = f"https://github.com/{GITHUB_USERNAME}/{GITHUB_REPO_NAME}/blob/{GITHUB_MAIN_BRANCH}/{relative_solution_path}"

                    all_solutions_details.append({
                        "name": problem_name_display,
                        "difficulty": difficulty,
                        "link": github_link,
                        "date": commit_date,
                        "raw_date": datetime.strptime(commit_date, "%Y.%m.%d")
                    })

    all_solutions_details.sort(key=lambda x: x['raw_date'], reverse=True)

    recently_solved = all_solutions_details[:5]

    return easy_count, medium_count, hard_count, total_count, recently_solved


def update_readme_content(easy, medium, hard, total, recently_solved_list):
    status_section = f"""## LeetCode Status 📈

Here's an overview of my current progress on LeetCode:
    
* **Easy Problems Solved:** {easy}
* **Medium Problems Solved:** {medium}
* **Hard Problems Solved:** {hard}
    
**Total Problems Solved:** {total}
    """

    recently_solved_items = []
    if not recently_solved_list:
        recently_solved_items.append("No problems solved yet. Start your LeetCode journey!")
    else:
        for i, item in enumerate(recently_solved_list):
            recently_solved_items.append(
                f"{i + 1}.  **[{item['name']}]** ({item['difficulty']}) - [Link to my solution]({item['link']}) ({item['date']})"
            )

    recently_solved_section = f"""## Recently Solved Problems ✨

Here are some of the latest problems I've tackled. You can find the solutions linked below:
    
{"\n".join(recently_solved_items)}
    """

    return status_section, recently_solved_section


def insert_sections_into_readme(readme_path, status_section, recently_solved_section):
    with open(readme_path, "r", encoding="utf-8") as f:
        content = f.read()

    status_pattern = re.compile(r'## LeetCode Status 📈.*?---', re.DOTALL)

    recently_solved_pattern = re.compile(r'## Recently Solved Problems ✨.*?---', re.DOTALL)

    if status_pattern.search(content):
        content = status_pattern.sub(status_section + "\n\n---", content)
    else:
        print("Warning: 'LeetCode Status' section not found. Appending to end.")
        content += "\n\n" + status_section + "\n\n---"

    if recently_solved_pattern.search(content):
        content = recently_solved_pattern.sub(recently_solved_section + "\n---", content)
    else:
        print("Warning: 'Recently Solved Problems' section not found. Appending to end.")
        content += "\n\n" + recently_solved_section + "\n---"

    with open(readme_path, "w", encoding="utf-8") as f:
        f.write(content)

if __name__ == "__main__":
    easy, medium, hard, total, recently_solved_list = get_solution_stats(SOLUTIONS_BASE_PATH)
    status_section_content, recently_solved_section_content = update_readme_content(
        easy, medium, hard, total, recently_solved_list
    )
    insert_sections_into_readme(README_PATH, status_section_content, recently_solved_section_content)
    print("README.md updated successfully!")