import { getMemberById, patchMember } from '../../commons/requests.js'
import { errorHandler } from '../../commons/errorHandler.js'

const editMemberForm = document.querySelector('#editMemberForm')

let oldMemberData

const loadMemberData = async () => {
  const urlParams = new URLSearchParams(window.location.search)
  const memberId = urlParams.get('id')

  oldMemberData = await getMemberById(memberId)
  oldMemberData.timeSinceStartedPlaying = getTimeSinceStartedPlayingDate(
    oldMemberData.timeSinceStartedPlaying
  )
  editMemberForm.name.value = oldMemberData.name
  editMemberForm.lastname.value = oldMemberData.lastname
  editMemberForm.email.value = oldMemberData.email
  editMemberForm.startedPlaying.value = oldMemberData.timeSinceStartedPlaying
}

const getTimeSinceStartedPlayingDate = (timeSinceStartedPlaying) => {
  if (!timeSinceStartedPlaying) {
    return null
  }
  const timeComponents = timeSinceStartedPlaying.split(' ')
  const years = parseInt(timeComponents[0])
  const months = parseInt(timeComponents[2])
  const days = parseInt(timeComponents[4])

  const today = new Date()

  const startDate = new Date(
    today.getFullYear() - years,
    today.getMonth() - months,
    today.getDate() - days + 1
  )

  return startDate.toISOString().substring(0, 10)
}

const handleFormSubmit = async () => {
  editMemberForm.addEventListener('submit', async (e) => {
    e.preventDefault()

    const member = {
      name:
        oldMemberData.name !== editMemberForm.name.value
          ? editMemberForm.name.value
          : oldMemberData.name,
      lastname:
        oldMemberData.lastname !== editMemberForm.lastname.value
          ? editMemberForm.lastname.value
          : oldMemberData.lastname,
      email:
        oldMemberData.email !== editMemberForm.email.value
          ? editMemberForm.email.value
          : oldMemberData.email,
      startedPlaying:
        oldMemberData.timeSinceStartedPlaying !==
        editMemberForm.startedPlaying.value
          ? editMemberForm.startedPlaying.value
          : oldMemberData.timeSinceStartedPlaying,
    }

    const response = await patchMember(member, oldMemberData.pin)
    if (response) {
      errorHandler(response)
      return
    }
    window.location.replace('../members-list/members-list.html')
  })
}

;(async () => {
  await loadMemberData()
  await handleFormSubmit()
})()
