import { Link } from 'react-router-dom'
import { FaHeart, FaComment, FaShare, FaBookmark, FaLock } from 'react-icons/fa'
import { formatDistanceToNow } from 'date-fns'
import { ko } from 'date-fns/locale'
import PremiumBadge from './PremiumBadge'
import './PostCard.css'

function PostCard({ post, onLike, onBookmark }) {
  const isPremium = post.price > 0
  const isPurchased = post.isPurchased
  const isPreview = isPremium && !isPurchased

  const handleLike = (e) => {
    e.preventDefault()
    onLike && onLike(post.id)
  }

  const handleBookmark = (e) => {
    e.preventDefault()
    onBookmark && onBookmark(post.id)
  }

  return (
    <article className="post-card">
      <div className="post-card-header">
        <Link to={`/profile/${post.author.id}`} className="author-info">
          <img 
            src={post.author.profileImage || '/default-avatar.png'} 
            alt={post.author.name}
            className="author-avatar"
          />
          <div>
            <h4 className="author-name">{post.author.name}</h4>
            <span className="post-time">
              {formatDistanceToNow(new Date(post.createdAt), { addSuffix: true, locale: ko })}
            </span>
          </div>
        </Link>
        {isPremium && <PremiumBadge price={post.price} />}
      </div>

      <Link to={`/post/${post.id}`} className="post-card-content">
        <h3 className="post-title">{post.title}</h3>
        
        {isPreview ? (
          <div className="post-preview">
            <p className="preview-text">{post.preview}</p>
            <div className="premium-lock">
              <FaLock />
              <p>이 콘텐츠는 {post.price.toLocaleString()}P에 구매하실 수 있습니다</p>
            </div>
          </div>
        ) : (
          <div className="post-content">
            <p>{post.content}</p>
            {post.images && post.images.length > 0 && (
              <div className="post-images">
                {post.images.map((image, index) => (
                  <img key={index} src={image} alt={`post-${index}`} />
                ))}
              </div>
            )}
          </div>
        )}

        {post.tags && post.tags.length > 0 && (
          <div className="post-tags">
            {post.tags.map((tag, index) => (
              <span key={index} className="tag">#{tag}</span>
            ))}
          </div>
        )}
      </Link>

      <div className="post-card-footer">
        <div className="post-stats">
          <button 
            className={`stat-btn ${post.isLiked ? 'active' : ''}`}
            onClick={handleLike}
          >
            <FaHeart /> {post.likesCount}
          </button>
          <Link to={`/post/${post.id}#comments`} className="stat-btn">
            <FaComment /> {post.commentsCount}
          </Link>
          <button className="stat-btn">
            <FaShare /> {post.sharesCount || 0}
          </button>
        </div>
        <button 
          className={`bookmark-btn ${post.isBookmarked ? 'active' : ''}`}
          onClick={handleBookmark}
        >
          <FaBookmark />
        </button>
      </div>
    </article>
  )
}

export default PostCard
