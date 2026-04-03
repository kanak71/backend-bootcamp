export const API_BASE_URL = '/api'

export const POST_TYPES = {
  FREE: 'free',
  PREMIUM: 'premium'
}

export const PAYMENT_METHODS = {
  POINTS: 'points',
  CARD: 'card',
  BANK: 'bank'
}

export const POST_STATUS = {
  DRAFT: 'draft',
  PUBLISHED: 'published',
  ARCHIVED: 'archived'
}

export const USER_ROLES = {
  USER: 'user',
  CREATOR: 'creator',
  ADMIN: 'admin'
}

export const NOTIFICATION_TYPES = {
  LIKE: 'like',
  COMMENT: 'comment',
  FOLLOW: 'follow',
  PURCHASE: 'purchase'
}

export const FILE_SIZE_LIMIT = 5 * 1024 * 1024 // 5MB
export const ALLOWED_IMAGE_TYPES = ['image/jpeg', 'image/png', 'image/gif', 'image/webp']
