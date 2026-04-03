import { Link } from 'react-router-dom'
import RegisterForm from '../components/auth/RegisterForm'
import SocialLogin from '../components/auth/SocialLogin'
import './AuthPage.css'

function RegisterPage() {
  return (
    <div className="auth-page">
      <h2 className="auth-title">회원가입</h2>
      <p className="auth-description">새 계정을 만드세요</p>
      
      <RegisterForm />
      <SocialLogin />
      
      <div className="auth-footer">
        <p>
          이미 계정이 있으신가요?{' '}
          <Link to="/login" className="link">로그인</Link>
        </p>
      </div>
    </div>
  )
}

export default RegisterPage
