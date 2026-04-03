import PostCard from './PostCard'
import Loading from '../common/Loading'
import './PostList.css'

function PostList({ posts, loading, onLike, onBookmark }) {
  if (loading) {
    return <Loading />
  }

  if (!posts || posts.length === 0) {
    return (
      <div className="empty-state">
        <p>게시글이 없습니다.</p>
      </div>
    )
  }

  return (
    <div className="post-list">
      {posts.map((post) => (
        <PostCard
          key={post.id}
          post={post}
          onLike={onLike}
          onBookmark={onBookmark}
        />
      ))}
    </div>
  )
}

export default PostList
