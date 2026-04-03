import { Link, useNavigate } from 'react-router-dom'
import { FaBell, FaUser, FaSearch, FaPlus } from 'react-icons/fa'
import { useAuthStore } from '../../store/authStore'
import NotificationBell from '../notification/NotificationBell'
import './Header.css'

function Header() {
  const { user, isAuthenticated, logout } = useAuthStore()
  const navigate = useNavigate()

  const handleLogout = () => {
    logout()
    navigate('/login')
  }

  return (
    <header className="header">
      <div className="container header-container">
        <Link to="/" className="logo">
          <h1>SNS Board</h1>
        </Link>

        <div className="search-bar">
          <FaSearch className="search-icon" />
          <input type="text" placeholder="검색..." className="search-input" />
        </div>

        <nav className="nav-menu">
          {isAuthenticated ? (
            <>
              <Link to="/feed" className="nav-link">피드</Link>
              <Link to="/create" className="nav-link">
                <FaPlus /> 글쓰기
              </Link>
              <NotificationBell />
              <div className="user-menu">
                <button className="user-avatar">
                  {user?.profileImage ? (
                    <img src={user.profileImage} alt={user.name} />
                  ) : (
                    <FaUser />
                  )}
                </button>
                <div className="dropdown-menu">
                  <Link to={`/profile/${user?.id}`} className="dropdown-item">
                    내 프로필
                  </Link>
                  <Link to="/statistics" className="dropdown-item">
                    통계
                  </Link>
                  <Link to="/purchase-history" className="dropdown-item">
                    구매 내역
                  </Link>
                  <Link to="/settings" className="dropdown-item">
                    설정
                  </Link>
                  <hr />
                  <button onClick={handleLogout} className="dropdown-item logout-btn">
                    로그아웃
                  </button>
                </div>
              </div>
            </>
          ) : (
            <>
              <Link to="/login" className="btn btn-outline">로그인</Link>
              <Link to="/register" className="btn btn-primary">회원가입</Link>
            </>
          )}
        </nav>
      </div>
    </header>
  )
}

export default Header
