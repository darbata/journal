import asyncio
from uuid import UUID
import requests

from app.config.settings import settings
from app.schemas.entry import Entry


class JournalApiClient:

    api_url: str = settings.journal_api_url

    async def get_entry_by_id(self, entry_id: UUID) -> Entry:
        response = await asyncio.to_thread(requests.get, f"{settings.journal_api_url}/entries/{entry_id}/internal")
        return Entry.model_validate(response.json())

journal_api_client = JournalApiClient()
