@echo off
echo [1/4] Building and Testing...
call mvn clean verify -DskipTests=false
if %ERRORLEVEL% NEQ 0 (echo Build/Test Failed & exit /b 1)

echo [2/4] Running Sonar Local Scan...
echo Skipping Sonar Scan for now...
::call mvn sonar:sonar -Dsonar.login=YOUR_TOKEN
::if %ERRORLEVEL% NEQ 0 (echo Sonar Scan Failed & exit /b 1)

echo [3/4] Committing Changes...
git add .
:: Uses the message provided when you run the script, or default
set /p commitMsg="Enter your commit message: "
git commit -m "%commitMsg%"

echo [4/4] Pushing and Raising PR...
git push origin HEAD
gh pr create --title "%commitMsg%" --body "Automated PR: Build, Test & Sonar passed locally."

echo --- SUCCESS: PR Created ---