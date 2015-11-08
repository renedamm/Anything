
# --- !Ups

CREATE TABLE projects
(
	  id BIGINT
		IDENTITY( 1, 1 )
		NOT NULL
		PRIMARY KEY
	, name VARCHAR( 50 )
		NOT NULL
		UNIQUE
	, path VARCHAR( 1024 )
		NOT NULL
		UNIQUE
);

CREATE TABLE files
(
	  id BIGINT
		IDENTITY( 1, 1 )
		NOT NULL
		PRIMARY KEY
	, project_id BIGINT
	, path VARCHAR( 1024 )
		NOT NULL
	, last_scan_time DATETIME
);

CREATE TABLE tokens
(
	  id BIGINT
		IDENTITY( 1, 1 )
		NOT NULL
		PRIMARY KEY
	, text VARCHAR( 64 )
		NOT NULL
		UNIQUE
);

CREATE TABLE usage_tags
(
	  id BIGINT
		IDENTITY( 1, 1 )
		NOT NULL
		PRIMARY KEY
	, name VARCHAR( 64 )
		NOT NULL
);

CREATE TABLE occurrences
(
	  id BIGINT
		IDENTITY( 1, 1 )
		NOT NULL
		PRIMARY KEY
	, token_id BIGINT
	, usage_tag_id BIGINT
	, file_id BIGINT
	, line INTEGER
		NOT NULL
	, column INTEGER
		NOT NULL
	, position INTEGER
		NOT NULL
);

# --- !Downs

DROP TABLE IF EXISTS projects;

DROP TABLE IF EXISTS files;

DROP TABLE IF EXISTS tokens;

DROP TABLE IF EXISTS usage_tags;

DROP TABLE IF EXISTS occurrences;

