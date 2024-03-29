import { getMembers, deleteMemberById } from '../../commons/requests.js'

const renderMemberList = (members) => {
  const memberListTable = document.querySelector('#memberListTable')
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

    const actionsCell = document.createElement('td')
    actionsCell.classList = 'd-flex justify-content-evenly'
    memberRow.appendChild(actionsCell)

    const editBtn = document.createElement('a')
    editBtn.innerText = 'edit'
    editBtn.classList = 'btn btn-warning'
    editBtn.addEventListener('click', async () => {
      window.location.replace(`../edit-member/edit-member.html?id=${m.id}`)
    })
    actionsCell.appendChild(editBtn)

    const deleteBtn = document.createElement('button')
    deleteBtn.innerText = 'delete'
    deleteBtn.classList = 'btn btn-danger'
    deleteBtn.addEventListener('click', () => {
      deleteMemberById(m.id)
      alert('Member deleted')
      window.location.reload()
    })
    actionsCell.appendChild(deleteBtn)

    memberListTableBody.appendChild(memberRow)
  })
}

;(async () => {
  const members = await getMembers()
  if (members != null) {
    renderMemberList(members)
  }
})()
