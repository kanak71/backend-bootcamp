import { create } from 'zustand'

export const usePostStore = create((set) => ({
  posts: [],
  currentPost: null,
  loading: false,
  error: null,

  setPosts: (posts) => set({ posts }),
  
  setCurrentPost: (post) => set({ currentPost: post }),
  
  addPost: (post) => set((state) => ({ posts: [post, ...state.posts] })),
  
  updatePost: (id, updates) => set((state) => ({
    posts: state.posts.map(post => 
      post.id === id ? { ...post, ...updates } : post
    )
  })),
  
  deletePost: (id) => set((state) => ({
    posts: state.posts.filter(post => post.id !== id)
  })),
  
  setLoading: (loading) => set({ loading }),
  
  setError: (error) => set({ error })
}))
