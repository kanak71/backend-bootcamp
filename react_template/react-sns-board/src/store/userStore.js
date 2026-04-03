import { create } from 'zustand'

export const useUserStore = create((set) => ({
  users: {},
  currentProfile: null,

  setUser: (userId, userData) => set((state) => ({
    users: { ...state.users, [userId]: userData }
  })),
  
  setCurrentProfile: (profile) => set({ currentProfile: profile }),
  
  followUser: (userId) => set((state) => ({
    users: {
      ...state.users,
      [userId]: {
        ...state.users[userId],
        isFollowing: true,
        followersCount: (state.users[userId]?.followersCount || 0) + 1
      }
    }
  })),
  
  unfollowUser: (userId) => set((state) => ({
    users: {
      ...state.users,
      [userId]: {
        ...state.users[userId],
        isFollowing: false,
        followersCount: Math.max(0, (state.users[userId]?.followersCount || 0) - 1)
      }
    }
  }))
}))
