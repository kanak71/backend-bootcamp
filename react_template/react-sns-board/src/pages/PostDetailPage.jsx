import { useParams } from 'react-router-dom'

function PostDetailPage() {
  const { id } = useParams()
  
  return (
    <div className="container">
      <h1>게시글 상세 - {id}</h1>
    </div>
  )
}

export default PostDetailPage
