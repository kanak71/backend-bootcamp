import { useParams } from 'react-router-dom'

function ProfilePage() {
  const { userId } = useParams()
  
  return (
    <div className="container">
      <h1>프로필 - {userId}</h1>
    </div>
  )
}

export default ProfilePage
