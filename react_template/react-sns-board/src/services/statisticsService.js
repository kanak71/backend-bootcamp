import api from './api'

export const statisticsService = {
  getStats: (params) => api.get('/statistics', { params }),
  
  getPostStats: (postId) => api.get(`/statistics/posts/${postId}`),
  
  getRevenueStats: (period) => api.get('/statistics/revenue', { params: { period } }),
  
  getEngagementStats: () => api.get('/statistics/engagement')
}
