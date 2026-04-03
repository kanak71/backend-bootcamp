import { Link } from 'react-router-dom'
import { FaRocket, FaCrown, FaChartLine } from 'react-icons/fa'
import Button from '../components/common/Button'
import './HomePage.css'

function HomePage() {
  return (
    <div className="home-page">
      <section className="hero">
        <div className="container">
          <h1 className="hero-title">
            당신의 컨텐츠로<br />수익을 창출하세요
          </h1>
          <p className="hero-subtitle">
            SNS Board는 크리에이터를 위한 프리미엄 컨텐츠 공유 플랫폼입니다
          </p>
          <div className="hero-actions">
            <Link to="/register">
              <Button variant="primary" size="large">
                지금 시작하기
              </Button>
            </Link>
            <Link to="/feed">
              <Button variant="outline" size="large">
                둘러보기
              </Button>
            </Link>
          </div>
        </div>
      </section>

      <section className="features">
        <div className="container">
          <h2>주요 기능</h2>
          <div className="features-grid">
            <div className="feature-card">
              <div className="feature-icon">
                <FaRocket />
              </div>
              <h3>쉬운 컨텐츠 공유</h3>
              <p>간편하게 컨텐츠를 업로드하고 팔로워들과 공유하세요</p>
            </div>
            <div className="feature-card">
              <div className="feature-icon">
                <FaCrown />
              </div>
              <h3>유료 컨텐츠 판매</h3>
              <p>프리미엄 컨텐츠를 만들고 수익을 창출하세요</p>
            </div>
            <div className="feature-card">
              <div className="feature-icon">
                <FaChartLine />
              </div>
              <h3>상세한 통계</h3>
              <p>조회수, 판매량, 수익을 한눈에 확인하세요</p>
            </div>
          </div>
        </div>
      </section>

      <section className="cta">
        <div className="container">
          <h2>지금 바로 시작하세요!</h2>
          <p>무료로 회원가입하고 컨텐츠를 공유해보세요</p>
          <Link to="/register">
            <Button variant="primary" size="large">
              무료 회원가입
            </Button>
          </Link>
        </div>
      </section>
    </div>
  )
}

export default HomePage
