import { Link } from 'react-router-dom'
import Button from '../components/common/Button'

function NotFoundPage() {
  return (
    <div className="container" style={{ textAlign: 'center', padding: '4rem 0' }}>
      <h1 style={{ fontSize: '4rem', marginBottom: '1rem' }}>404</h1>
      <p style={{ fontSize: '1.25rem', marginBottom: '2rem' }}>페이지를 찾을 수 없습니다</p>
      <Link to="/">
        <Button variant="primary">홈으로 돌아가기</Button>
      </Link>
    </div>
  )
}

export default NotFoundPage
