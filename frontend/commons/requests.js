import { errorHandler } from '../commons/errorHandler.js'

const API_URL = 'http://localhost:8080'

export const getMembers = async () => {
  const response = await fetch(`${API_URL}/player`)
  if (!response.ok) {
    errorHandler(response)
    return
  }
  const members = await response.json()
  return members
}

export const getMemberById = async (memberId) => {
  const response = await fetch(`${API_URL}/player/${memberId}`)
  if (!response.ok) {
    errorHandler(response)
    return
  }
  const member = await response.json()
  return member
}

export const saveMember = async (member) => {
  const response = await fetch(`${API_URL}/player`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(member),
  })
  if (!response.ok) {
    errorHandler(response)
    return false
  }
  return true
}

export const patchMember = async (member, id) => {
  const response = await fetch(`${API_URL}/player/${id}`, {
    method: 'PATCH',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(member),
  })
  if (!response.ok) {
    errorHandler(response)
    return false
  }
  return true
}

export const deleteMemberById = async (memberId) => {
  await fetch(`${API_URL}/player/${memberId}`, {
    method: 'DELETE',
  })
  if (!response.ok) {
    errorHandler(response)
  }
}
