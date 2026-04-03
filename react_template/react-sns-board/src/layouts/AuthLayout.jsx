import { Outlet } from 'react-router-dom'
import './AuthLayout.css'

function AuthLayout() {
  return (
    <div className="auth-layout">
      <div className="auth-container">
        <div className="auth-brand">
          <h1>SNS Board</h1>
          <p>프리미엄 컨텐츠 공유 플랫폼</p>
        </div>
        <div className="auth-content">
          <Outlet />
        </div>
      </div>
    </div>
  )
}

export default AuthLayout
