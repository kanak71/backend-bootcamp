import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import Input from '../common/Input'
import Button from '../common/Button'
import { authService } from '../../services/authService'
import './AuthForm.css'

function RegisterForm() {
  const navigate = useNavigate()
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    confirmPassword: ''
  })
  const [errors, setErrors] = useState({})
  const [loading, setLoading] = useState(false)

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    })
    // Clear error for this field
    if (errors[e.target.name]) {
      setErrors({
        ...errors,
        [e.target.name]: ''
      })
    }
  }

  const validate = () => {
    const newErrors = {}

    if (!formData.name.trim()) {
      newErrors.name = '이름을 입력하세요'
    }

    if (!formData.email.trim()) {
      newErrors.email = '이메일을 입력하세요'
    } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
      newErrors.email = '올바른 이메일 형식이 아닙니다'
    }

    if (!formData.password) {
      newErrors.password = '비밀번호를 입력하세요'
    } else if (formData.password.length < 8) {
      newErrors.password = '비밀번호는 최소 8자 이상이어야 합니다'
    }

    if (formData.password !== formData.confirmPassword) {
      newErrors.confirmPassword = '비밀번호가 일치하지 않습니다'
    }

    setErrors(newErrors)
    return Object.keys(newErrors).length === 0
  }

  const handleSubmit = async (e) => {
    e.preventDefault()

    if (!validate()) return

    setLoading(true)

    try {
      // TODO: 백엔드 연동 시 아래 주석 해제
      // await authService.register(formData)
      
      // 임시 Mock 회원가입 (개발용)
      setTimeout(() => {
        toast.success('회원가입 성공! 로그인해주세요.')
        navigate('/login')
        setLoading(false)
      }, 500)
      
    } catch (error) {
      toast.error(error.response?.data?.message || '회원가입 실패')
      setLoading(false)
    }
  }

  return (
    <form onSubmit={handleSubmit} className="auth-form">
      <Input
        label="이름"
        type="text"
        name="name"
        value={formData.name}
        onChange={handleChange}
        placeholder="이름을 입력하세요"
        error={errors.name}
        required
      />

      <Input
        label="이메일"
        type="email"
        name="email"
        value={formData.email}
        onChange={handleChange}
        placeholder="이메일을 입력하세요"
        error={errors.email}
        required
      />

      <Input
        label="비밀번호"
        type="password"
        name="password"
        value={formData.password}
        onChange={handleChange}
        placeholder="비밀번호를 입력하세요 (최소 8자)"
        error={errors.password}
        required
      />

      <Input
        label="비밀번호 확인"
        type="password"
        name="confirmPassword"
        value={formData.confirmPassword}
        onChange={handleChange}
        placeholder="비밀번호를 다시 입력하세요"
        error={errors.confirmPassword}
        required
      />

      <div className="terms-agree">
        <label className="checkbox-label">
          <input type="checkbox" required />
          <span>이용약관 및 개인정보처리방침에 동의합니다</span>
        </label>
      </div>

      <Button
        type="submit"
        variant="primary"
        fullWidth
        disabled={loading}
      >
        {loading ? '가입 중...' : '회원가입'}
      </Button>
    </form>
  )
}

export default RegisterForm
