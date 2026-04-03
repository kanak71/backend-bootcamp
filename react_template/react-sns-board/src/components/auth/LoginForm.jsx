import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import Input from '../common/Input'
import Button from '../common/Button'
import { useAuthStore } from '../../store/authStore'
import { authService } from '../../services/authService'
import './AuthForm.css'

function LoginForm() {
  const navigate = useNavigate()
  const { login } = useAuthStore()
  const [formData, setFormData] = useState({
    email: '',
    password: ''
  })
  const [loading, setLoading] = useState(false)

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    })
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    setLoading(true)

    try {
      // TODO: 백엔드 연동 시 아래 주석 해제
      // const response = await authService.login(formData)
      // login(response.data.user, response.data.token)
      
      // 임시 Mock 로그인 (개발용)
      const mockUser = {
        id: 1,
        name: '테스트 유저',
        email: formData.email,
        profileImage: null,
        followersCount: 128,
        followingCount: 94,
        postsCount: 23,
        points: 15000
      }
      const mockToken = 'mock-jwt-token-12345'
      
      // 0.5초 후 로그인 성공
      setTimeout(() => {
        login(mockUser, mockToken)
        toast.success('로그인 성공!')
        navigate('/feed')
        setLoading(false)
      }, 500)
      
    } catch (error) {
      toast.error(error.response?.data?.message || '로그인 실패')
      setLoading(false)
    }
  }

  return (
    <form onSubmit={handleSubmit} className="auth-form">
      <Input
        label="이메일"
        type="email"
        name="email"
        value={formData.email}
        onChange={handleChange}
        placeholder="이메일을 입력하세요"
        required
      />

      <Input
        label="비밀번호"
        type="password"
        name="password"
        value={formData.password}
        onChange={handleChange}
        placeholder="비밀번호를 입력하세요"
        required
      />

      <div className="form-options">
        <label className="checkbox-label">
          <input type="checkbox" />
          <span>로그인 상태 유지</span>
        </label>
        <a href="/password-reset" className="link">비밀번호 찾기</a>
      </div>

      <Button
        type="submit"
        variant="primary"
        fullWidth
        disabled={loading}
      >
        {loading ? '로그인 중...' : '로그인'}
      </Button>
    </form>
  )
}

export default LoginForm
