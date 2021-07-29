import collections
'''
We want to find employees who badged into our secured room together often. Given an unordered list of names and access times over a single day, find the largest group of people that were in the room together during two or more separate time periods, and the times when they were all present.

badge_records = [
  ["Paul",     "1214", "enter"],
  ["Paul",      "830", "enter"],
  ["Curtis",   "1100", "enter"],
  ["Paul",      "903", "exit"],
  ["John",      "908", "exit"],
  ["Paul",     "1235", "exit"],
  ["Jennifer",  "900", "exit"],
  ["Curtis",   "1330", "exit"],
  ["John",      "815", "enter"],
  ["Jennifer", "1217", "enter"],
  ["Curtis",    "745", "enter"],
  ["John",     "1230", "enter"],
  ["Jennifer",  "800", "enter"],
  ["John",     "1235", "exit"],
  ["Curtis",    "810", "exit"],
  ["Jennifer", "1240", "exit"],
]
'''


'''
First part was previously asked, but I didnt get much time to get into the the follow up question. Suggestions/approach?

Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.
The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

For example:
logs1 = [
["58523", "user_1", "resource_1"],
["62314", "user_2", "resource_2"],
["54001", "user_1", "resource_3"],
["200", "user_6", "resource_5"],
["215", "user_6", "resource_4"],
["54060", "user_2", "resource_3"],
["53760", "user_3", "resource_3"],
["58522", "user_22", "resource_1"],
["53651", "user_5", "resource_3"],
["2", "user_6", "resource_1"],
["100", "user_6", "resource_6"],
["400", "user_7", "resource_2"],
["100", "user_8", "resource_6"],
["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
["300", "user_1", "resource_3"],
["599", "user_1", "resource_3"],
["900", "user_1", "resource_3"],
["1199", "user_1", "resource_3"],
["1200", "user_1", "resource_3"],
["1201", "user_1", "resource_3"],
["1202", "user_1", "resource_3"]
]

Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3)

Question 1 - Write a function that takes the logs and returns each users min and max access timestamp
Example Output:
user_3:[53760,53760]
user_2:[54060,62314]
user_1:[54001,58523]
user_7:[400,400]
user_6:[2,215]
user_5:[53651,53651]
user_4:[58522,58522]
user_8:[100,100]

Follow Up
Write a function that takes the logs as input, builds the transition graph and returns it as an adjacency list with probabilities. Add START and END states.

Specifically, for each resource, we want to compute a list of every possible next step taken by any user, together with the corresponding probabilities. The list of resources should include START but not END, since by definition END is a terminal state.

Expected output for logs1:
transition_graph(logs1) # =>
{
'START': {'resource_1': 0.25, 'resource_2': 0.125, 'resource_3': 0.5, 'resource_6': 0.125},
'resource_1': {'resource_6': 0.333, 'END': 0.667},
'resource_2': {'END': 1.0},
'resource_3': {'END': 0.4, 'resource_1': 0.2, 'resource_2': 0.2, 'resource_3': 0.2},
'resource_4': {'END': 1.0},
'resource_5': {'resource_4': 1.0},
'resource_6': {'END': 0.5, 'resource_5': 0.5}
}

For example, of 8 total users, 4 users have resource_3 as a first visit (user_1, user_2, user_3, user_5), 2 users have resource_1 as a first visit (user_6, user_22), 1 user has resource_2 as a first visit (user_7), and 1 user has resource_6 (user_8) so the possible next steps for START are resource_3 with probability 4/8, resource_1 with probability 2/8, and resource_2 and resource_6 with probability 1/8.

These are the resource paths per user for the first logs example, ordered by access time:
{
'user_1': ['resource_3', 'resource_3', 'resource_1'],
'user_2': ['resource_3', 'resource_2'],
'user_3': ['resource_3'],
'user_5': ['resource_3'],
'user_6': ['resource_1', 'resource_6', 'resource_5', 'resource_4'],
'user_7': ['resource_2'],
'user_8': ['resource_6'],
'user_22': ['resource_1'],
}

Expected output for logs2:
transition_graph(logs2) # =>
{
'START': {'resource_3': 1.0},
'resource_3': {'resource_3: 0.857, 'END': 0.143}
}

'''


class SolutionResource:

    def user_min_max_time(self, logs: list):
        res = {}
        MAX = float('inf')
        for time, user, _ in logs:
            if user not in res:
                res[user] = [MAX, -MAX]
            res[user][0] = min(res[user][0], time)
            res[user][1] = max(res[user][1], time)
        return res

    # most visited resources in 5 mins interval
    # sort logs, resource map, {resource id: [time]}
    # sliding window on each resource, get the max
    def most_requested_resource(self, logs: list):
        N = len(logs)
        logs.sort()
        resourceMap = collections.defaultdict(list)
        for time, _, resource in logs:
            resourceMap[resource].append(int(time))

        res_resource = ""
        res_count = 0
        FIVE_MIN_IN_SECONDS = 5*60

        for resource, times in resourceMap.items():
            start = 0
            for end in range(len(times)):
                # inclusve [00:00:00 to 00:05:00]
                while start <= end and times[start] < times[end]-FIVE_MIN_IN_SECONDS:
                    start += 1
                count = end-start+1
                if count > res_count:
                    res_count = count
                    res_resource = resource
        return [resource, res_count]

    def transition_graph(self, logs: list):
        # sort logs
        # build graph, {user: [resource]}
        # loop user to resource graph
        # init resource graph["Start"]=[resource at the beginning]
        # resource graph, {resource: [next resource]}
        N = len(logs)
        START = "START"
        END = "END"
        user_graph = collections.defaultdict(list)
        logs.sort()
        for time, user, resource in logs:
            user_graph[user].append(resource)
        # sliding window on user graph
        resources_map = collections.defaultdict(list)
        for user, resources in user_graph.items():
            resources_map[START].append(resources[0])
            for i in range(1, len(resources)):
                resources_map[resources[i-1]].append(resources[i])
            resources_map[resources[-1]].append(END)
        res = {}
        for start, ends in resources_map.items():
            count = collections.Counter(ends)
            total = sum(count.values())
            if start not in res:
                res[start] = {}
            for resource, val in count.items():
                res[start][resource] = val/total
        return re


'''
第一问：

一堆课，找出上课顺序里,中间的那门课，只有一种正确的顺序，并且每个课只会对应另外一个prereq
比如

    ["Data Structures", "Algorithms"],
    ["COBOL", "Networking"],
    ["Algorithms", "COBOL"],

"Data Structures"->"Algorithms" -> "COBOL"-> "Networking"

返回 “Algorithms"


第二问：

/*
有多种track，返回所有path里的中间那门课

Sample input 1:
all_courses_1 = [
    ["Logic", "COBOL"],
    ["Data Structures", "Algorithms"],
    ["Creative Writing", "Data Structures"],
    ["Algorithms", "COBOL"],
    ["Intro to Computer Science", "Data Structures"],
    ["Logic", "Compilers"],
    ["Data Structures", "Logic"],
    ["Graphics", "Networking"],
    ["Networking", "Algorithms"],
    ["Creative Writing", "System Administration"],
    ["Databases", "System Administration"],
    ["Creative Writing", "Databases"],
    ["Intro to Computer Science", "Graphics"],
]

Sample output 1 (in any order):
          ["Data Structures", "Networking", "Creative Writing", "Databases"]

All paths through the curriculum (midpoint *highlighted*):

Intro to C.S. -> Graphics -> *Networking* -> Algorithms -> Cobol
Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> Compiler
Creative Writing -> *Databases* -> System Administration
*Creative Writing* -> System Administration
Creative Writing -> *Data Structures* -> Algorithms -> COBOL
Creative Writing -> *Data Structures* -> Logic -> COBOL
Creative Writing -> *Data Structures* -> Logic -> Compilers

Visual representation:

                    ____________    ______________
                    |          |    |            |
                    | Graphics |    | Networking |
               ---->|__________|--->|____________|
               |                       |      
               |                       |      
               |                       |  ______________
____________   |                       |  |            |
|          |   |    ______________     >->| Algorithms |--\     _____________
| Intro to |   |    |            |    /   |____________|   \    |           |
| C.S.     |---+    | Data       |   /                      >-->| COBOL     |
|__________|    \   | Structures |--+     ______________   /    |___________|
                 >->|____________|   \    |            |  /
____________    /                     \-->| L‍‍‌‌‌‍‍‍‍‌‌‍‌‌‍‌‌‌‌ogic      |-+      _____________
|          |   /    ______________        |____________|  \     |           |
| Creative |  /     |            |                         \--->| Compilers |
| Writing  |-+----->| Databases  |                              |___________|
|__________|  \     |____________|-\     _________________________
               \                    \    |                       |
                \--------------------+-->| System Administration |
                                         |_______________________|

Sample input 2:
all_courses_2 = [
    ["Course_3", "Course_7"],
    ["Course_0", "Course_1"],
    ["Course_1", "Course_2"],
    ["Course_2", "Course_3"],
    ["Course_3", "Course_4"],
    ["Course_4", "Course_5"],
    ["Course_5", "Course_6"],
]
Sample output 2 (in any order):
["Course_2", "Course_3"]

Complexity analysis variables:

n: number of pairs in the input

*/
'''


class Solution2:

    # build graph
    # dfs
    # when at the end, like no children for this course, update result
    # start with the courses 0 indgree
    def get_middle_class(self, courses: list):
        N = len(courses)
        indegrees = collections.defaultdict(int)
        graph = collections.defaultdict(list)
        for pre, cur in courses:
            indegrees[cur] += 1
            if pre not in indegrees:
                indegrees[pre] = 0
            graph[pre].append(cur)
        middle = []

        def dfs(course: str, builder=[]):
            if len(graph[course]) == 0:
                M = len(builder)
                middle.append(builder[(M-1)//2])
                return
            for child in graph[course]:
                builder.append(child)
                dfs(child, builder)
                builder.pop(-1)
            return

        for course, count in indegrees.items():
            if count == 0:
                dfs(course, builder=[course])
        return list(set(middle))


if __name__ == "__main__":
    # logs1 = [
    #     ["58523", "user_1", "resource_1"],
    #     ["62314", "user_2", "resource_2"],
    #     ["54001", "user_1", "resource_3"],
    #     ["200", "user_6", "resource_5"],
    #     ["215", "user_6", "resource_4"],
    #     ["54060", "user_2", "resource_3"],
    #     ["53760", "user_3", "resource_3"],
    #     ["58522", "user_22", "resource_1"],
    #     ["53651", "user_5", "resource_3"],
    #     ["2", "user_6", "resource_1"],
    #     ["100", "user_6", "resource_6"],
    #     ["400", "user_7", "resource_2"],
    #     ["100", "user_8", "resource_6"],
    #     ["54359", "user_1", "resource_3"],
    # ]

    # logs2 = [
    #     ["300", "user_1", "resource_3"],
    #     ["599", "user_1", "resource_3"],
    #     ["900", "user_1", "resource_3"],
    #     ["1199", "user_1", "resource_3"],
    #     ["1200", "user_1", "resource_3"],
    #     ["1201", "user_1", "resource_3"],
    #     ["1202", "user_1", "resource_3"]
    # ]
    # solution = SolutionResource()
    # print(solution.most_requested_resource(logs1))
    # print(solution.most_requested_resource(logs2))

    # print(solution.transition_graph(logs1))

    all_courses_1 = [["Logic", "COBOL"],
                     ["Data Structures", "Algorithms"],
                     ["Creative Writing", "Data Structures"],
                     ["Algorithms", "COBOL"],
                     ["Intro to Computer Science", "Data Structures"],
                     ["Logic", "Compilers"],
                     ["Data Structures", "Logic"],
                     ["Graphics", "Networking"],
                     ["Networking", "Algorithms"],
                     ["Creative Writing", "System Administration"],
                     ["Databases", "System Administration"],
                     ["Creative Writing", "Databases"],
                     ["Intro to Computer Science", "Graphics"],
                     ]

    all_courses_2 = [["Course_3", "Course_7"],
                     ["Course_0", "Course_1"],
                     ["Course_1", "Course_2"],
                     ["Course_2", "Course_3"],
                     ["Course_3", "Course_4"],
                     ["Course_4", "Course_5"],
                     ["Course_5", "Course_6"],
                     ]
    solution = Solution2()
    print(solution.get_middle_class(all_courses_1))
    print(solution.get_middle_class(all_courses_2))
