import { useState, useEffect } from 'react'
import Dashboard from '../components/statistics/Dashboard'
import { statisticsService } from '../services/statisticsService'

function StatisticsPage() {
  const [stats, setStats] = useState(null)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    fetchStatistics()
  }, [])

  const fetchStatistics = async () => {
    try {
      // TODO: 백엔드 연동 시 아래 주석 해제
      // const response = await statisticsService.getStats()
      // setStats(response.data)
      
      // 임시 Mock 데이터 (개발용)
      const mockStats = {
        totalViews: 45230,
        totalLikes: 3456,
        totalSales: 89,
        totalRevenue: 1245000,
        viewsData: [
          { date: '01/23', views: 1200 },
          { date: '01/24', views: 1450 },
          { date: '01/25', views: 1800 },
          { date: '01/26', views: 1350 },
          { date: '01/27', views: 2100 },
          { date: '01/28', views: 1900 },
          { date: '01/29', views: 2300 }
        ],
        revenueData: [
          { date: '01/23', revenue: 45000 },
          { date: '01/24', revenue: 67000 },
          { date: '01/25', revenue: 89000 },
          { date: '01/26', revenue: 56000 },
          { date: '01/27', revenue: 123000 },
          { date: '01/28', revenue: 98000 },
          { date: '01/29', revenue: 134000 }
        ],
        topPosts: [
          { title: 'React 완전 정복 강의', views: 8900, likes: 567, revenue: 445500 },
          { title: 'Spring Boot 실전', views: 6700, likes: 445, revenue: 334500 },
          { title: 'JavaScript 마스터', views: 5600, likes: 389, revenue: 223400 },
          { title: 'TypeScript 기초', views: 4500, likes: 312, revenue: 178900 },
          { title: 'Node.js 백엔드', views: 3890, likes: 267, revenue: 156700 }
        ]
      }
      
      setTimeout(() => {
        setStats(mockStats)
        setLoading(false)
      }, 500)
      
    } catch (error) {
      console.error('Failed to fetch statistics:', error)
      setLoading(false)
    }
  }

  if (loading) {
    return <div>Loading...</div>
  }

  return <Dashboard stats={stats} />
}

export default StatisticsPage
