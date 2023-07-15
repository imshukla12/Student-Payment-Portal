import React from 'react'
import Bill from './Bill'


const Bills = ({ bills, payBill }) => {  
  if (bills === [])
    return null

  return (
    <div className='m-5 p-2 rounded regular-shadow' id="bills">
      <h2 className='ml-2'>Your Bills</h2>
      <table cellPadding={10}>
        <tr>
          <th>billDate</th>  
          <th>Deadline</th>
          <th>Bill Description</th>
          <th>billId</th>
          <th>paidAmount</th>
          <th>remainingAmount</th>
          <th>totalAmount</th>
        </tr>
        { 
          bills.map(b =>
            <Bill bill={b}
              key={b.billId}
              payBill={payBill}
            /> 
          )
        }
      </table>
    </div>
  )
}

export default Bills
