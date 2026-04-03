import { FaCrown } from 'react-icons/fa'
import './PremiumBadge.css'

function PremiumBadge({ price }) {
  return (
    <div className="premium-badge">
      <FaCrown />
      <span>{price.toLocaleString()}P</span>
    </div>
  )
}

export default PremiumBadge
