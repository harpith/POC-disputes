I have AST parsed output from a Java file which includes:
- List of method calls (49 real calls)
- List of if conditions (308 conditions)
- Return values

I want to generate a clean Mermaid flowchart.

Requirements:
1. Do NOT include all 308 conditions individually
2. Group conditions into logical blocks like:
   - Validation checks
   - Business logic
   - Error handling
3. Limit main flowchart to 10–20 nodes max
4. Represent grouped conditions as single nodes like:
   "Validation Block (120 conditions)"
5. Show proper branching:
   - Validation → Pass / Fail
   - Final decision → Success / Error
6. Include method calls as a single grouped node:
   "Service Calls (49 methods)"
7. Include actual return values like:
   - nextpage
   - null
   - execute(context)

Output format:
- Generate Mermaid syntax
- Use flowchart TD
- Keep it clean and readable

Also create an OPTIONAL second Mermaid diagram for detailed view of conditions.

Input example:
Method Calls: [list]
Conditions: [list]
Returns: [list]

Output only Mermaid code.
