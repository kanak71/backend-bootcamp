import { FaGoogle } from 'react-icons/fa'
import { SiKakao, SiNaver } from 'react-icons/si'
import './AuthForm.css'

function SocialLogin() {
  const handleSocialLogin = (provider) => {
    // 실제로는 백엔드 OAuth 엔드포인트로 리다이렉트
    console.log(`${provider} 로그인`)
  }

  return (
    <div className="social-login">
      <p className="social-login-title">또는 소셜 계정으로 계속하기</p>
      <div className="social-buttons">
        <button 
          className="social-btn google" 
          onClick={() => handleSocialLogin('google')}
        >
          <FaGoogle />
          Google로 계속하기
        </button>
        <button 
          className="social-btn kakao" 
          onClick={() => handleSocialLogin('kakao')}
        >
          <SiKakao />
          카카오로 계속하기
        </button>
        <button 
          className="social-btn naver" 
          onClick={() => handleSocialLogin('naver')}
        >
          <SiNaver />
          네이버로 계속하기
        </button>
      </div>
    </div>
  )
}

export default SocialLogin
