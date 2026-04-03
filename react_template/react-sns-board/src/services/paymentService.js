import api from './api'

export const paymentService = {
  purchasePost: (data) => api.post('/payments/purchase', data),
  
  chargePoints: (amount) => api.post('/payments/charge', { amount }),
  
  getPaymentHistory: (params) => api.get('/payments/history', { params }),
  
  getBalance: () => api.get('/payments/balance')
}
