import { Link } from 'react-router-dom'
import LoginForm from '../components/auth/LoginForm'
import SocialLogin from '../components/auth/SocialLogin'
import './AuthPage.css'

function LoginPage() {
  return (
    <div className="auth-page">
      <h2 className="auth-title">로그인</h2>
      <p className="auth-description">계정에 로그인하세요</p>
      
      <LoginForm />
      <SocialLogin />
      
      <div className="auth-footer">
        <p>
          계정이 없으신가요?{' '}
          <Link to="/register" className="link">회원가입</Link>
        </p>
      </div>
    </div>
  )
}

export default LoginPage
