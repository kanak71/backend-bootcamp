import { ALLOWED_IMAGE_TYPES, FILE_SIZE_LIMIT } from './constants'

export const validators = {
  email: (value) => {
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
    if (!value) return '이메일을 입력하세요'
    if (!pattern.test(value)) return '올바른 이메일 형식이 아닙니다'
    return null
  },

  password: (value) => {
    if (!value) return '비밀번호를 입력하세요'
    if (value.length < 8) return '비밀번호는 최소 8자 이상이어야 합니다'
    if (!/[A-Za-z]/.test(value)) return '비밀번호는 영문을 포함해야 합니다'
    if (!/[0-9]/.test(value)) return '비밀번호는 숫자를 포함해야 합니다'
    return null
  },

  required: (value) => {
    if (!value || (typeof value === 'string' && !value.trim())) {
      return '필수 입력 항목입니다'
    }
    return null
  },

  minLength: (min) => (value) => {
    if (value && value.length < min) {
      return `최소 ${min}자 이상 입력하세요`
    }
    return null
  },

  maxLength: (max) => (value) => {
    if (value && value.length > max) {
      return `최대 ${max}자까지 입력 가능합니다`
    }
    return null
  },

  imageFile: (file) => {
    if (!file) return '파일을 선택하세요'
    if (!ALLOWED_IMAGE_TYPES.includes(file.type)) {
      return '이미지 파일만 업로드 가능합니다 (JPG, PNG, GIF, WEBP)'
    }
    if (file.size > FILE_SIZE_LIMIT) {
      return '파일 크기는 5MB를 초과할 수 없습니다'
    }
    return null
  },

  price: (value) => {
    if (value < 0) return '가격은 0 이상이어야 합니다'
    if (!Number.isInteger(value)) return '가격은 정수여야 합니다'
    return null
  }
}

export const validateForm = (values, rules) => {
  const errors = {}
  
  Object.keys(rules).forEach(field => {
    const fieldRules = Array.isArray(rules[field]) ? rules[field] : [rules[field]]
    
    for (const rule of fieldRules) {
      const error = rule(values[field])
      if (error) {
        errors[field] = error
        break
      }
    }
  })
  
  return errors
}
