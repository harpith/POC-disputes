Build a Java-based static flow analyzer for a Struts application.

Project Structure (fixed):

- Root: WKS-CustomerService
- struts.xml: WKS-CustomerService/webapp/WEB-INF/classes/struts.xml
- Java source: WKS-CustomerService/src/main/java/
- Action classes package: com.gecs.apollo.wkst.action
- JSP folder: WKS-CustomerService/src/main/webapp/jsp/

Goal:
Given a JSP file name as input (e.g., "ChangeInformation.jsp"), the program should:

STEP 1: Parse struts.xml

- Use DocumentBuilder
- Iterate through all <action> nodes
- For each action, iterate through all <result> nodes
- Match JSP using:
  resultPath.endsWith("ChangeInformation.jsp")

STEP 2: Extract Data
For each match, extract:

- action name
- class name (fully qualified)
- result name
- JSP path

STEP 3: Resolve Java File
Convert class name to file path:
com.gecs.apollo.wkst.action.ChangeInformationUpdateAction
→ com/gecs/apollo/wkst/action/ChangeInformationUpdateAction.java

Full path:
WKS-CustomerService/src/main/java/<converted_path>

Check if file exists.

STEP 4: Analyze Java Class

- Read Java file as text

- Extract execute() method body using regex:
  public String execute()

- Inside execute():
  
  1. Extract method calls:
     pattern: (\w+)(
     ignore keywords: if, for, while, switch, catch
  
  2. Extract return values:
     pattern: return "value"

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
