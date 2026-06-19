CREATE TABLE IF NOT EXISTS entries (
    id UUID PRIMARY KEY,
    author_id TEXT,
    title VARCHAR(32),
    content VARCHAR(2048),
    emotions JSONB,
    created_at TIMESTAMPTZ,
    updated_at TIMESTAMPTZ 
);

INSERT INTO entries (id, author_id, title, content, emotions, created_at, updated_at) VALUES
    ('a1b2c3d4-0001-4000-8000-000000000001', 'user_alice', 'First day of summer',
     'Walked along the river this morning. The light was incredible.',
     '{"anger": 0.0041, "disgust": 0.0016, "fear": 0.0021, "joy": 0.9012, "neutral": 0.0598, "sadness": 0.0089, "surprise": 0.0223}',
     '2026-06-01T08:30:00Z', '2026-06-01T08:30:00Z'),

    ('a1b2c3d4-0002-4000-8000-000000000002', 'user_alice', 'Exam stress',
     'Three deadlines this week. Trying not to panic but it is a lot.',
     '{"anger": 0.0712, "disgust": 0.0345, "fear": 0.6234, "joy": 0.0123, "neutral": 0.0876, "sadness": 0.1502, "surprise": 0.0208}',
     '2026-06-03T22:15:00Z', '2026-06-03T22:15:00Z'),

    ('a1b2c3d4-0003-4000-8000-000000000003', 'user_bob', 'Finally shipped it',
     'The feature went live today. Relieved and a little proud.',
     '{"anger": 0.0034, "disgust": 0.0019, "fear": 0.0087, "joy": 0.8421, "neutral": 0.0712, "sadness": 0.0098, "surprise": 0.0629}',
     '2026-06-05T17:45:00Z', '2026-06-05T18:02:00Z'),

    ('a1b2c3d4-0004-4000-8000-000000000004', 'user_carol', 'Quiet weekend',
     'Did nothing in particular. It was exactly what I needed.',
     '{"anger": 0.0021, "disgust": 0.0014, "fear": 0.0033, "joy": 0.2104, "neutral": 0.7512, "sadness": 0.0211, "surprise": 0.0105}',
     '2026-06-07T11:00:00Z', '2026-06-07T11:00:00Z'),

    ('a1b2c3d4-0005-4000-8000-000000000005', 'user_bob', 'Missing home',
     'Saw an old photo and it hit harder than expected.',
     '{"anger": 0.0123, "disgust": 0.0089, "fear": 0.0211, "joy": 0.0342, "neutral": 0.0876, "sadness": 0.7891, "surprise": 0.0468}',
     '2026-06-10T20:30:00Z', '2026-06-10T20:30:00Z');
