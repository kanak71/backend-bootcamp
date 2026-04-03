import { useState, useEffect } from 'react'
import PostList from '../components/post/PostList'
import Sidebar from '../components/common/Sidebar'
import { postService } from '../services/postService'
import './FeedPage.css'

function FeedPage() {
  const [posts, setPosts] = useState([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    fetchPosts()
  }, [])

  const fetchPosts = async () => {
    try {
      // TODO: 백엔드 연동 시 아래 주석 해제
      // const response = await postService.getFeed()
      // setPosts(response.data)
      
      // 임시 Mock 데이터 (개발용)
      const mockPosts = [
        {
          id: 1,
          title: '프리미엄 React 강의 - 완전 정복',
          content: 'React의 모든 것을 배울 수 있는 강의입니다. Hooks, Context API, Redux, 성능 최적화까지 모두 다룹니다.',
          preview: 'React의 모든 것을 배울 수 있는 강의입니다. Hooks, Context API, Redux...',
          price: 9900,
          isPurchased: false,
          author: {
            id: 2,
            name: '개발자김',
            profileImage: null
          },
          likesCount: 245,
          commentsCount: 38,
          sharesCount: 12,
          isLiked: false,
          isBookmarked: false,
          tags: ['React', '강의', '프론트엔드'],
          createdAt: new Date(Date.now() - 2 * 60 * 60 * 1000).toISOString()
        },
        {
          id: 2,
          title: '무료로 배우는 JavaScript ES6+',
          content: 'ES6+의 최신 문법과 활용법을 무료로 배워보세요. let/const, 화살표 함수, 구조 분해 할당, Promise, async/await 등을 다룹니다.',
          price: 0,
          isPurchased: true,
          author: {
            id: 3,
            name: '코딩마스터',
            profileImage: null
          },
          images: [],
          likesCount: 892,
          commentsCount: 156,
          sharesCount: 45,
          isLiked: true,
          isBookmarked: true,
          tags: ['JavaScript', 'ES6', '무료'],
          createdAt: new Date(Date.now() - 5 * 60 * 60 * 1000).toISOString()
        },
        {
          id: 3,
          title: 'Spring Boot 실전 프로젝트',
          content: 'Spring Boot로 실제 서비스를 만들어보는 프로젝트 강의입니다. REST API, JPA, Security, JWT 인증까지 구현합니다.',
          preview: 'Spring Boot로 실제 서비스를 만들어보는 프로젝트 강의입니다...',
          price: 15000,
          isPurchased: true,
          author: {
            id: 4,
            name: '백엔드고수',
            profileImage: null
          },
          likesCount: 567,
          commentsCount: 89,
          sharesCount: 23,
          isLiked: false,
          isBookmarked: false,
          tags: ['Spring Boot', 'Java', '백엔드'],
          createdAt: new Date(Date.now() - 1 * 24 * 60 * 60 * 1000).toISOString()
        },
        {
          id: 4,
          title: 'CSS 디자인 팁 모음집',
          content: '실무에서 바로 쓸 수 있는 CSS 디자인 팁들을 모았습니다. Flexbox, Grid, 애니메이션, 반응형 디자인 등을 다룹니다.',
          price: 0,
          isPurchased: true,
          author: {
            id: 5,
            name: '디자인개발자',
            profileImage: null
          },
          likesCount: 1234,
          commentsCount: 201,
          sharesCount: 78,
          isLiked: true,
          isBookmarked: false,
          tags: ['CSS', '디자인', '무료'],
          createdAt: new Date(Date.now() - 2 * 24 * 60 * 60 * 1000).toISOString()
        }
      ]
      
      setTimeout(() => {
        setPosts(mockPosts)
        setLoading(false)
      }, 500)
      
    } catch (error) {
      console.error('Failed to fetch posts:', error)
      setLoading(false)
    }
  }

  const handleLike = async (postId) => {
    try {
      await postService.likePost(postId)
      // Update posts state
      setPosts(posts.map(post => 
        post.id === postId 
          ? { ...post, isLiked: !post.isLiked, likesCount: post.isLiked ? post.likesCount - 1 : post.likesCount + 1 }
          : post
      ))
    } catch (error) {
      console.error('Failed to like post:', error)
    }
  }

  const handleBookmark = async (postId) => {
    try {
      await postService.bookmarkPost(postId)
      setPosts(posts.map(post => 
        post.id === postId 
          ? { ...post, isBookmarked: !post.isBookmarked }
          : post
      ))
    } catch (error) {
      console.error('Failed to bookmark post:', error)
    }
  }

  return (
    <div className="feed-page">
      <div className="container feed-container">
        <Sidebar />
        <div className="feed-main">
          <h1>피드</h1>
          <PostList 
            posts={posts} 
            loading={loading}
            onLike={handleLike}
            onBookmark={handleBookmark}
          />
        </div>
      </div>
    </div>
  )
}

export default FeedPage
