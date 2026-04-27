Modify my Java FlowTracer code to improve flow clarity.

Current problem:

- It prints all methods including getters, setters, utility methods
- Output is too large and not suitable for flowchart

Required changes:

1. Filter Methods:

- Exclude methods starting with:
  get, set, is, equals, toString, hashCode
- Exclude Java built-in methods

2. Keep Only Business Logic Methods:

- Include methods that contain keywords like:
  process, update, create, validate, save, handle

3. Limit Output:

- Show only top 5–10 important methods
- If more exist, print "... and more"

4. Improve Flow Structure:
   Change output format to:

[START JSP]
ChangeInformation.jsp

↓

[ACTION]
UpdateChangeInformation

↓

[CLASS]
ChangeInformationUpdateAction.execute()

↓

[BUSINESS LOGIC]

- processEMVChangeInfo()

- processChangeInformationFormBean()

- doPostProcessing()
  
  ↓

[DECISION]
Return Value?

↓

[OUTPUT]
SUCCESS → WrapMain.jsp
ChangeInfo → ChangeInformation.jsp

5. Do NOT print:

- Total method counts
- Getters/setters lists
- Utility methods

6. Keep code simple (no external libraries)

Return only updated Java code.

STEP 5: Match Return with Results

- Compare return values with <result name="">
- Identify which return leads to the given JSP

STEP 6: Build Flow

Expected Output:

INPUT JSP: ChangeInformation.jsp

---

Action: UpdateChangeInformation
Class: ChangeInformationUpdateAction

Flow:
UpdateChangeInformation
↓
ChangeInformationUpdateAction.execute()
↓
validateUser()
↓
updateCustomerInfo()
↓
saveToDB()
↓
"ChangeInfo"
↓
ChangeInformation.jsp

---

STEP 7: Handle Multiple Matches

- If multiple actions map to same JSP, print separate flows

Classes to Implement:

- StrutsParser (parse XML)
- JavaFileResolver (find Java file)
- JavaAnalyzer (extract methods + returns)
- FlowBuilder (combine everything)
- Main class (input JSP name and run)

Constraints:

- Use only core Java (no frameworks)
- Keep implementation simple
- Use regex for parsing (no AST required initially)
- Console output only

Optional Enhancements:

- Recursive fallback search if Java file not found
- Handle multiple result mappings
- Improve method filtering

Deliver:

- Complete working Java code
- Clean class structure
- Runnable main() method

Do not include explanations—only provide code.- Sample main() method showing usage

Do NOT give explanations—only code.
