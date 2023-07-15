import axios from 'axios'

const billsUrl = `http://localhost:8080/api/bill/pay`

const billsgetUrl='http://localhost:8080/api/bill/getbills'
const getUserBills = async (student) => {
  const response = await axios.get(`${billsgetUrl}/${student.studentId}`)
  
  return response.data
}

const payBill = async (bill) => {
  const response = await axios.post(billsUrl,bill)
  return response.data
}

const exportObject = { getUserBills,payBill }

export default exportObject
