# discord-InterviewBot V1.2.1
### 🤖효율적인 기술면접 대비를 위한 디스코드 봇을 만드는 중입니다.

<img src="/img/v1.2.0.png"  width="444" height="460"/> <br>

### [봇 사용해보기👇🏻](https://discord.com/api/oauth2/authorize?client_id=1075652244936069232&permissions=8&scope=bot) <br>

### [질문 리스트 💼](https://github.com/wonyongg/discord-interviewbot/blob/main/src/main/resources/interview_questions.txt) <br>

***
<details>
<summary><strong>V1.0.0</strong></summary>

## 설명
<img src="/img/v1.0.0.png"  width="600" height="315"/> <br>

* InterviewBot 클래스에서 모든 기능 수행
* 질문 목록은 interview_question.txt에 저장
* '!도움말' 명령어를 통해 사용법을 응답받을 수 있음
* '!q' 명령어를 통해 랜덤으로 인터뷰 질문을 받을 수 있음
* 현재 저장된 질문은 총 122개
<br><br>

## 개선해야 할 사항
* 질문 데이터를 RDBMS으로 이전
* 임베드 기능 추가
* 객체 지향적으로 설계하기 위해 기능 분할 리팩토링
* 배포 자동화
</details>

<details>
<summary><strong>V1.1.0</strong></summary>

## 설명
<img src="/img/V1.1.0.png"  width="554" height="537"/> <br>

* 임베드 기능 추가
* '!도움말' 명령어를 통해 사용법을 응답받을 수 있음
* '!q' 명령어 -> 'q'로 변경
* 현재 저장된 질문은 총 128개
  <br><br>

## 추후 업데이트 예정
* AWS를 이용한 배포
* 세부 항목 별 랜덤 질문 기능 추가
</details>

<details>
<summary><strong>V1.1.1</strong></summary>

## 수정 사항
* http://www.google.com/을 접속할 때 일어나는 일에 대해 OSI 7계층과 연관지어 설명해보세요.
* 현재 로직에서는 질문 데이터를 콜론(:)을 기준으로 나눠 배열 요소에 담고 있음.
* http://에서 콜론 삽입으로 인해 질문을 정상적으로 불러오지 못하여 http:// 삭제 처리
* www.google.com을 접속할 때 일어나는 일에 대해 OSI 7계층과 연관지어 설명해보세요.로 변경함.
</details>

<details>
<summary><strong>V1.1.2</strong></summary>

## 수정 사항
* 도움말 문구 수정
* '!q'를 통해~ -> 'q'를 입력하여~
</details>

<details>
<summary><strong>V1.2.0</strong></summary>

## 수정 사항
* 도움말 문구 수정
* Embed 문구 수정
* 일부 질문 내용 수정
* 명령어 C, J, E를 활용한 세부 카테고리 별 질문 기능 추가 
* 코드 리팩토링
</details>

<details>
<summary><strong>V1.2.1</strong></summary>

## 수정 사항
* 일부 질문 수정 및 새 질문 추가
</details>

***
<strong>질문 출처 :</strong><br>
[https://github.com/ksundong/backend-interview-question](https://github.com/ksundong/backend-interview-question)<br>
[https://github.com/JaeYeopHan/Interview_Question_for_Beginner](https://github.com/JaeYeopHan/Interview_Question_for_Beginner)<br>
이외에, 저와 제 주변 지인들이 면접에서 받은 질문을 수시로 추가하고 있습니다.