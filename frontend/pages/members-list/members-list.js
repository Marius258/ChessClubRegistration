import { getMembers, deleteMemberById } from '../../commons/requests.js'

const renderMemberList = (members) => {
  const memberListTable = document.querySelector('#memberListTable')
  if (members.message) {
    // TODO add error message
    return
  }
  memberListTable.classList = 'd-table table table-striped '
  const memberListTableBody = document.querySelector('#memberListTableBody')
  members.forEach((m) => {
    const memberRow = document.createElement('tr')

    const nameCell = document.createElement('td')
    nameCell.innerText = m.name
    memberRow.appendChild(nameCell)

    const lastnameCell = document.createElement('td')
    lastnameCell.innerText = m.lastname
    memberRow.appendChild(lastnameCell)

    const emailCell = document.createElement('td')
    emailCell.innerText = m.email
    memberRow.appendChild(emailCell)

    const genderCell = document.createElement('td')
    genderCell.innerText = m.gender
    memberRow.appendChild(genderCell)

    const ageCell = document.createElement('td')
    ageCell.innerText = m.age
    memberRow.appendChild(ageCell)

    const timeSinceStartedPlayingCell = document.createElement('td')
    timeSinceStartedPlayingCell.innerText = m.timeSinceStartedPlaying
    memberRow.appendChild(timeSinceStartedPlayingCell)

    const deleteBtn = document.createElement('button')
    deleteBtn.innerText = 'delete'
    deleteBtn.classList = 'btn btn-danger'
    memberRow.appendChild(deleteBtn)
    deleteBtn.addEventListener('click', () => {
      deleteMemberById(m.pin)
    })
    memberListTableBody.appendChild(memberRow)
  })
}

;(async () => {
  const members = await getMembers()
  console.log(members)
  renderMemberList(members)
})()
