Build a Java-based static flow analyzer for a Struts application with the following requirements.

Project Structure (fixed):

- Root module: WKS-CustomerService
- struts.xml location: WKS-CustomerService/webapp/WEB-INF/classes/struts.xml
- Java source folder: WKS-CustomerService/src/main/java/
- Action classes package: com.ges.apollo.wkst.action
- JSP folder: WKS-CustomerService/src/main/webapp/jsp/

Goal:
Given the path to struts.xml and an action name (e.g., "changeInfo"), the program should automatically:

1. Parse struts.xml
2. Find the matching <action> entry
3. Extract:
   - action name
   - fully qualified class name
   - result JSP path (for result name "success")
4. Locate the corresponding Java file
5. Locate the corresponding JSP file
6. Analyze the Java class to find:
   - execute() method
   - return values (e.g., "success")
7. Output a readable flow

Expected Output Format:
changeInfo
↓
ChangeInformationUpdateAction.execute()
↓
"success"
↓
changeinformation.jsp

Implementation Details:

1. XML Parsing:

- Use DocumentBuilder (javax.xml.parsers)
- Iterate through <action> tags
- Match action name
- Extract class attribute and <result> value

2. Java File Resolution:

- Convert class name to path:
  com.ges.apollo.wkst.action.ChangeInformationUpdateAction
  → com/ges/apollo/wkst/action/ChangeInformationUpdateAction.java
- Append to:
  WKS-CustomerService/src/main/java/
- Validate file exists

3. JSP File Resolution:

- Extract JSP path from <result> (e.g., /jsp/changeinformation.jsp)
- Remove leading slash
- Append to:
  WKS-CustomerService/src/main/webapp/

4. Java File Analysis (basic):

- Read file as string
- Detect:
  - execute() method
  - return "success"
- No need for full AST, simple parsing is fine

5. Classes to Implement:

- StrutsParser (parse XML)
- PathResolver (resolve Java/JSP paths)
- JavaAnalyzer (extract method + return)
- FlowBuilder (combine everything)
- Main class to run

6. Constraints:

- Do NOT use heavy frameworks
- Keep it simple and readable
- Focus on one action at a time
- No UI required (console output is enough)

7. Optional (if possible):

- Add fallback recursive search if file not found
- Handle multiple <result> tags

Deliver:

- Complete working Java code
- Proper class structure
- Sample main() method showing usage

Do NOT give explanations—only code.
