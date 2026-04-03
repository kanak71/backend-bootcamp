import api from './api'

export const postService = {
  getFeed: (params) => api.get('/posts/feed', { params }),
  
  getPost: (id) => api.get(`/posts/${id}`),
  
  createPost: (data) => api.post('/posts', data),
  
  updatePost: (id, data) => api.put(`/posts/${id}`, data),
  
  deletePost: (id) => api.delete(`/posts/${id}`),
  
  likePost: (id) => api.post(`/posts/${id}/like`),
  
  bookmarkPost: (id) => api.post(`/posts/${id}/bookmark`),
  
  getComments: (postId) => api.get(`/posts/${postId}/comments`),
  
  addComment: (postId, data) => api.post(`/posts/${postId}/comments`, data),
  
  deleteComment: (postId, commentId) => api.delete(`/posts/${postId}/comments/${commentId}`)
}
