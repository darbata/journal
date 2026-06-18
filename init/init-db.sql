CREATE TABLE IF NOT EXISTS entries (
    UUID PRIMARY KEY id,
    TEXT author_id,
    VARCHAR(32) title,
    VARCHAR(2048) TEXT content,
    JSONB emotions,
    TIMESTAMPTZ createdAt,
    TIMESTAMPTZ updatedAt,
    TIMESTAMPTZ lastReadAt,
);
