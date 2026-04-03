import { Link } from 'react-router-dom'
import { FaGithub, FaTwitter, FaInstagram, FaFacebook } from 'react-icons/fa'
import './Footer.css'

function Footer() {
  return (
    <footer className="footer">
      <div className="container footer-container">
        <div className="footer-section">
          <h3>SNS Board</h3>
          <p>프리미엄 컨텐츠 공유 플랫폼</p>
          <div className="social-links">
            <a href="#" aria-label="GitHub"><FaGithub /></a>
            <a href="#" aria-label="Twitter"><FaTwitter /></a>
            <a href="#" aria-label="Instagram"><FaInstagram /></a>
            <a href="#" aria-label="Facebook"><FaFacebook /></a>
          </div>
        </div>

        <div className="footer-section">
          <h4>서비스</h4>
          <ul>
            <li><Link to="/feed">피드</Link></li>
            <li><Link to="/create">글쓰기</Link></li>
            <li><Link to="/statistics">통계</Link></li>
          </ul>
        </div>

        <div className="footer-section">
          <h4>정보</h4>
          <ul>
            <li><Link to="/about">회사 소개</Link></li>
            <li><Link to="/terms">이용약관</Link></li>
            <li><Link to="/privacy">개인정보처리방침</Link></li>
          </ul>
        </div>

        <div className="footer-section">
          <h4>고객지원</h4>
          <ul>
            <li><Link to="/faq">FAQ</Link></li>
            <li><Link to="/contact">문의하기</Link></li>
            <li><Link to="/help">도움말</Link></li>
          </ul>
        </div>
      </div>
      
      <div className="footer-bottom">
        <div className="container">
          <p>&copy; 2024 SNS Board. All rights reserved.</p>
        </div>
      </div>
    </footer>
  )
}

export default Footer
