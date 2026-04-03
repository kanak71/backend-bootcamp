import { Link } from 'react-router-dom'
import { FaHome, FaFire, FaUsers, FaBookmark, FaCog } from 'react-icons/fa'
import { useAuthStore } from '../../store/authStore'
import './Sidebar.css'

function Sidebar() {
  const { user } = useAuthStore()

  return (
    <aside className="sidebar">
      <div className="sidebar-profile">
        <div className="profile-avatar">
          {user?.profileImage ? (
            <img src={user.profileImage} alt={user.name} />
          ) : (
            <div className="avatar-placeholder">{user?.name?.[0]}</div>
          )}
        </div>
        <h3>{user?.name}</h3>
        <p className="profile-email">{user?.email}</p>
        <div className="profile-stats">
          <div className="stat-item">
            <span className="stat-value">{user?.followersCount || 0}</span>
            <span className="stat-label">팔로워</span>
          </div>
          <div className="stat-item">
            <span className="stat-value">{user?.followingCount || 0}</span>
            <span className="stat-label">팔로잉</span>
          </div>
          <div className="stat-item">
            <span className="stat-value">{user?.postsCount || 0}</span>
            <span className="stat-label">게시글</span>
          </div>
        </div>
      </div>

      <nav className="sidebar-nav">
        <Link to="/feed" className="sidebar-link">
          <FaHome /> 홈
        </Link>
        <Link to="/feed?filter=trending" className="sidebar-link">
          <FaFire /> 인기글
        </Link>
        <Link to="/feed?filter=following" className="sidebar-link">
          <FaUsers /> 팔로잉
        </Link>
        <Link to="/bookmarks" className="sidebar-link">
          <FaBookmark /> 북마크
        </Link>
        <Link to="/settings" className="sidebar-link">
          <FaCog /> 설정
        </Link>
      </nav>

      <div className="sidebar-footer">
        <div className="balance-card">
          <p className="balance-label">내 포인트</p>
          <p className="balance-amount">{(user?.points || 0).toLocaleString()}P</p>
          <button className="btn btn-primary btn-sm">충전하기</button>
        </div>
      </div>
    </aside>
  )
}

export default Sidebar
