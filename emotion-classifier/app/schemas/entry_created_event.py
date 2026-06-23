from uuid import UUID

from pydantic import BaseModel

class EntryCreatedEvent(BaseModel):
    entryId: UUID

