import React, { useState } from 'react'

/*
  This component is used for rendering a single Bills's view
  Show's the Bills details like name, bill amount, due date, etc.
  Also has the payment button next to it, on clicking which, the payment method is executed
  bill: The Bill object that has to be rendered
  payBill: Method that uses the axios service to pay the specified bill, i.e. send a DELETE request
  Note that the key attribute is not written here, its only written in the map() method that renders
  the collection
*/
const Bill = ({ bill, payBill }) => {
  /*
    Instruments are added to watchlists with the help of a dropdown list <select>.
    Add a <option> element with value=-1 in the <select> list that will serve as the default option.
    "value" property corresponds to index of a watchlist in the filteredWatchlists list.
    When user clicks an entry, the onChange of the <select> is triggered which will call createWatchlistInstrument.
    If user clicks default option, then nothing should happen which is why we check for watchlistIdx == -1
    in the createWatchlistInstrument function.
  */
  const [amt, setAmt] = useState([]);
  var billObject = {}
  billObject[bill.id] = {
    "amountPaid" : amt,
    "dateOfPayment" : new Date()
  }
  
  return (
    <tr>
      {/* Render the Bill's details */}
      <td>{bill.billDate}</td>
      <td>{bill.deadline}</td>
      <td>{bill.description}</td>
      <td>{bill.id}</td>
      <td>{bill.paidAmount}</td>
      <td>{bill.remainingAmount}</td>
      <td>{bill.totalAmount}</td>
      <td>
        <input type="number" onChange={(e)=>{
          setAmt(e.target.value);
          /*console.log(e.target.value)*/}}/>
      </td>
      <td>
        {/* Payment button that calls the payBill() method with the given Bill object onClick */}
        <button onClick={() => payBill(billObject)}>
          Pay Bill
        </button>
      </td>
    </tr>
  )
}

export default Bill
