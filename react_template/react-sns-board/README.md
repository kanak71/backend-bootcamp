# SNS Board - 유료 컨텐츠 플랫폼

React + Spring Boot 기반의 SNS 형태 유료 컨텐츠 공유 플랫폼입니다.

## 주요 기능

- 🔐 **사용자 인증**: 로그인, 회원가입, 소셜 로그인
- 📝 **게시글 관리**: 무료/유료 컨텐츠 작성 및 공유
- 💰 **결제 시스템**: 포인트 충전 및 유료 컨텐츠 구매
- 📊 **통계 대시보드**: 조회수, 판매량, 수익 분석
- 💬 **소셜 기능**: 좋아요, 댓글, 팔로우
- 🔔 **알림 시스템**: 실시간 알림

## 기술 스택

### Frontend
- React 18
- React Router v6
- Zustand (상태 관리)
- Axios (HTTP 클라이언트)
- Recharts (차트)
- React Icons
- React Hook Form
- React Toastify

### Backend (예정)
- Spring Boot 3.x
- Spring Security + JWT
- JPA/Hibernate
- MySQL/PostgreSQL

## 프로젝트 구조

```
src/
├── components/          # 재사용 가능한 컴포넌트
│   ├── common/         # 공통 컴포넌트 (Header, Footer, Button 등)
│   ├── auth/           # 인증 관련 컴포넌트
│   ├── post/           # 게시글 관련 컴포넌트
│   ├── payment/        # 결제 관련 컴포넌트
│   ├── statistics/     # 통계 관련 컴포넌트
│   └── notification/   # 알림 관련 컴포넌트
├── pages/              # 페이지 컴포넌트
├── layouts/            # 레이아웃 컴포넌트
├── services/           # API 서비스
├── store/              # Zustand 스토어
├── utils/              # 유틸리티 함수
└── App.jsx            # 메인 앱 컴포넌트
```

## 시작하기

### 설치

```bash
npm install
```

### 개발 서버 실행

```bash
npm run dev
```

개발 서버는 `http://localhost:3000`에서 실행됩니다.

### 빌드

```bash
npm run build
```

## API 연동

백엔드 서버는 `http://localhost:8080`에서 실행되어야 합니다.

Vite 프록시 설정으로 `/api` 경로의 모든 요청이 백엔드로 전달됩니다.

## 주요 페이지

- `/` - 홈페이지
- `/login` - 로그인
- `/register` - 회원가입
- `/feed` - 피드 (로그인 필요)
- `/post/:id` - 게시글 상세
- `/create` - 글쓰기
- `/profile/:userId` - 프로필
- `/statistics` - 통계 대시보드
- `/purchase-history` - 구매 내역
- `/settings` - 설정

## 환경 변수

필요한 경우 `.env` 파일을 생성하여 환경 변수를 설정하세요:

```
VITE_API_BASE_URL=http://localhost:8080/api
```

## 라이선스

MIT License

## 개발자

SNS Board Development Team
