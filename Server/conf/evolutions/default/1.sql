
# --- !Ups

CREATE TABLE projects
(
	  id BIGINT
		GENERATED BY DEFAULT AS IDENTITY( START WITH 1 )
		NOT NULL
		PRIMARY KEY
	, name VARCHAR
		NOT NULL
	, path VARCHAR
		NOT NULL
);

CREATE TABLE files
(
	  id BIGINT
		GENERATED BY DEFAULT AS IDENTITY( START WITH 1 )
		NOT NULL
		PRIMARY KEY
	, project_id BIGINT
	, path VARCHAR
		NOT NULL
	, lastScanTime DATETIME
);

CREATE TABLE tokens
(
	  id BIGINT
		GENERATED BY DEFAULT AS IDENTITY( START WITH 1 )
		NOT NULL
		PRIMARY KEY
	, text VARCHAR
		NOT NULL
);

CREATE TABLE usage_tags
(
	  id BIGINT
		GENERATED BY DEFAULT AS IDENTITY( START WITH 1 )
		NOT NULL
		PRIMARY KEY
	, name VARCHAR
		NOT NULL
);

CREATE TABLE occurrences
(
	  id BIGINT
		GENERATED BY DEFAULT AS IDENTITY( START WITH 1 )
		NOT NULL
		PRIMARY KEY
	, token_id BIGINT
	, usage_tag_id BIGINT
	, file_id BIGINT
	, line INTEGER
	, column INTEGER
	, position INTEGER
);

# --- !Downs

DROP TABLE IF EXISTS projects;

DROP TABLE IF EXISTS files;

DROP TABLE IF EXISTS tokens;

DROP TABLE IF EXISTS usage_tags;

DROP TABLE IF EXISTS occurrences;
