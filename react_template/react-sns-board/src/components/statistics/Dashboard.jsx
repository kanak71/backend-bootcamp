import { LineChart, Line, BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts'
import { FaEye, FaHeart, FaShoppingCart, FaDollarSign } from 'react-icons/fa'
import './Dashboard.css'

function Dashboard({ stats }) {
  const summaryCards = [
    {
      icon: <FaEye />,
      label: '총 조회수',
      value: stats?.totalViews || 0,
      color: '#3b82f6'
    },
    {
      icon: <FaHeart />,
      label: '총 좋아요',
      value: stats?.totalLikes || 0,
      color: '#ef4444'
    },
    {
      icon: <FaShoppingCart />,
      label: '총 판매',
      value: stats?.totalSales || 0,
      color: '#10b981'
    },
    {
      icon: <FaDollarSign />,
      label: '총 수익',
      value: `${(stats?.totalRevenue || 0).toLocaleString()}P`,
      color: '#f59e0b'
    }
  ]

  return (
    <div className="dashboard">
      <div className="dashboard-header">
        <h2>통계 대시보드</h2>
        <select className="period-selector">
          <option value="7">최근 7일</option>
          <option value="30">최근 30일</option>
          <option value="90">최근 90일</option>
        </select>
      </div>

      <div className="summary-cards">
        {summaryCards.map((card, index) => (
          <div key={index} className="summary-card" style={{ borderLeftColor: card.color }}>
            <div className="card-icon" style={{ color: card.color }}>
              {card.icon}
            </div>
            <div className="card-content">
              <p className="card-label">{card.label}</p>
              <h3 className="card-value">{card.value}</h3>
            </div>
          </div>
        ))}
      </div>

      <div className="charts-grid">
        <div className="chart-container">
          <h3>조회수 추이</h3>
          <ResponsiveContainer width="100%" height={300}>
            <LineChart data={stats?.viewsData || []}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="date" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Line type="monotone" dataKey="views" stroke="#3b82f6" strokeWidth={2} />
            </LineChart>
          </ResponsiveContainer>
        </div>

        <div className="chart-container">
          <h3>매출 추이</h3>
          <ResponsiveContainer width="100%" height={300}>
            <BarChart data={stats?.revenueData || []}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="date" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Bar dataKey="revenue" fill="#10b981" />
            </BarChart>
          </ResponsiveContainer>
        </div>
      </div>

      <div className="top-posts">
        <h3>인기 게시글 Top 5</h3>
        <div className="posts-table">
          <table>
            <thead>
              <tr>
                <th>제목</th>
                <th>조회수</th>
                <th>좋아요</th>
                <th>수익</th>
              </tr>
            </thead>
            <tbody>
              {(stats?.topPosts || []).map((post, index) => (
                <tr key={index}>
                  <td>{post.title}</td>
                  <td>{post.views.toLocaleString()}</td>
                  <td>{post.likes.toLocaleString()}</td>
                  <td>{post.revenue.toLocaleString()}P</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}

export default Dashboard
