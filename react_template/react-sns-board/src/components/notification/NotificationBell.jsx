import { useState } from 'react'
import { FaBell } from 'react-icons/fa'
import './NotificationBell.css'

function NotificationBell() {
  const [unreadCount] = useState(3)
  const [showDropdown, setShowDropdown] = useState(false)

  const notifications = [
    { id: 1, message: '새로운 좋아요가 있습니다', time: '5분 전', unread: true },
    { id: 2, message: '댓글이 달렸습니다', time: '1시간 전', unread: true },
    { id: 3, message: '게시글이 판매되었습니다', time: '2시간 전', unread: false }
  ]

  return (
    <div className="notification-bell">
      <button 
        className="bell-button"
        onClick={() => setShowDropdown(!showDropdown)}
      >
        <FaBell />
        {unreadCount > 0 && <span className="badge">{unreadCount}</span>}
      </button>

      {showDropdown && (
        <div className="notification-dropdown">
          <div className="dropdown-header">
            <h4>알림</h4>
          </div>
          <div className="notification-list">
            {notifications.map((notif) => (
              <div key={notif.id} className={`notification-item ${notif.unread ? 'unread' : ''}`}>
                <p className="notif-message">{notif.message}</p>
                <span className="notif-time">{notif.time}</span>
              </div>
            ))}
          </div>
          <div className="dropdown-footer">
            <a href="/notifications">모든 알림 보기</a>
          </div>
        </div>
      )}
    </div>
  )
}

export default NotificationBell
