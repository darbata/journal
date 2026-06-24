import asyncio
from uuid import UUID
import requests

from app.config.settings import settings
from app.schemas.entry_content_dto import EntryContentDTO


class JournalApiClient:

    api_url: str = settings.journal_api_url

    async def get_entry_by_id(self, entry_id: UUID) -> EntryContentDTO:
        response = await asyncio.to_thread(requests.get, f"{settings.journal_api_url}/entries/{entry_id}/internal")
        return EntryContentDTO.model_validate(response.json())

journal_api_client = JournalApiClient()
