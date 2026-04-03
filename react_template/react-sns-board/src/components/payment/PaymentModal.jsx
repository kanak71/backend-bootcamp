import { useState } from 'react'
import Modal from '../common/Modal'
import Button from '../common/Button'
import { FaCreditCard, FaWallet } from 'react-icons/fa'
import { toast } from 'react-toastify'
import { paymentService } from '../../services/paymentService'
import './PaymentModal.css'

function PaymentModal({ isOpen, onClose, post, onSuccess }) {
  const [loading, setLoading] = useState(false)
  const [paymentMethod, setPaymentMethod] = useState('points')

  const handlePurchase = async () => {
    setLoading(true)
    try {
      await paymentService.purchasePost({
        postId: post.id,
        amount: post.price,
        method: paymentMethod
      })
      toast.success('구매가 완료되었습니다!')
      onSuccess && onSuccess()
      onClose()
    } catch (error) {
      toast.error(error.response?.data?.message || '구매 실패')
    } finally {
      setLoading(false)
    }
  }

  return (
    <Modal isOpen={isOpen} onClose={onClose} title="컨텐츠 구매">
      <div className="payment-modal">
        <div className="purchase-summary">
          <h3>{post?.title}</h3>
          <div className="price-info">
            <span className="price-label">가격</span>
            <span className="price-amount">{post?.price.toLocaleString()}P</span>
          </div>
        </div>

        <div className="payment-methods">
          <h4>결제 방법</h4>
          <div className="method-list">
            <label className={`method-option ${paymentMethod === 'points' ? 'active' : ''}`}>
              <input
                type="radio"
                name="paymentMethod"
                value="points"
                checked={paymentMethod === 'points'}
                onChange={(e) => setPaymentMethod(e.target.value)}
              />
              <FaWallet />
              <span>포인트 결제</span>
            </label>
            <label className={`method-option ${paymentMethod === 'card' ? 'active' : ''}`}>
              <input
                type="radio"
                name="paymentMethod"
                value="card"
                checked={paymentMethod === 'card'}
                onChange={(e) => setPaymentMethod(e.target.value)}
              />
              <FaCreditCard />
              <span>카드 결제</span>
            </label>
          </div>
        </div>

        <div className="payment-notice">
          <p>• 구매한 컨텐츠는 마이페이지에서 확인할 수 있습니다.</p>
          <p>• 구매 후 환불은 불가능합니다.</p>
        </div>

        <div className="payment-actions">
          <Button variant="outline" onClick={onClose}>
            취소
          </Button>
          <Button
            variant="primary"
            onClick={handlePurchase}
            disabled={loading}
          >
            {loading ? '처리 중...' : `${post?.price.toLocaleString()}P 결제하기`}
          </Button>
        </div>
      </div>
    </Modal>
  )
}

export default PaymentModal
