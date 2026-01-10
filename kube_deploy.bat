@echo off
setlocal enabledelayedexpansion
:: ... 추후 진행
 
echo [Step 1] 소스 이미지 빌드 시작...
docker build -f Dockerfile.dev -t springboot-app-jar:v20260105-01 .
if %errorlevel% neq 0 (echo 빌드 실패 && exit /b %errorlevel%)
echo [Step 1] 소스 이미지 빌드 종료

echo [Step 2] 쿠버네티스 배포 시작
:: PowerShell을 사용하여 deploy.yaml 내의 IMAGE_PLACEHOLDER를 실제 이미지명으로 치환 후 적용
kubectl apply -f -
echo [Step 2] 쿠버네티스 배포 종료

echo [완료] 배포가 성공적으로 마무리되었습니다!
pause
