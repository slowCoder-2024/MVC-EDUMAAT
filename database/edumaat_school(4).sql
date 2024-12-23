-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2017 at 11:56 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `edumaat_school`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_academic_year`
--

CREATE TABLE `tbl_academic_year` (
  `academic_year_id` bigint(20) NOT NULL,
  `academic_year_status` int(11) NOT NULL,
  `academic_year_title` varchar(100) NOT NULL,
  `institution_id` bigint(20) DEFAULT NULL,
  `academic_total_working_days` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_academic_year`
--

INSERT INTO `tbl_academic_year` (`academic_year_id`, `academic_year_status`, `academic_year_title`, `institution_id`, `academic_total_working_days`) VALUES
(1, 1, '2017-2018', 1, 215),
(2, 0, '2016-2017', 1, 221),
(3, 0, '2015-2016', 1, 216),
(4, 0, '2014-2015', 1, 210),
(5, 0, '2013-2014', 1, 217);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_academic_year_fees_term`
--

CREATE TABLE `tbl_academic_year_fees_term` (
  `academic_year_fees_term_id` bigint(20) NOT NULL,
  `fees_term_title` varchar(100) NOT NULL,
  `academic_year_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admission`
--

CREATE TABLE `tbl_admission` (
  `admission_id` bigint(20) NOT NULL,
  `admission_code` varchar(50) NOT NULL,
  `admission_rank` double DEFAULT NULL,
  `candidate_addressLine_one` varchar(100) DEFAULT NULL,
  `candidate_addressLine_two` varchar(100) DEFAULT NULL,
  `candidate_city` varchar(255) DEFAULT NULL,
  `candidate_contact_no` varchar(20) DEFAULT NULL,
  `candidate_country` varchar(255) DEFAULT NULL,
  `candidate_email` varchar(50) DEFAULT NULL,
  `candidate_first_name` varchar(50) DEFAULT NULL,
  `candidate_gender` varchar(7) DEFAULT NULL,
  `candidate_last_name` varchar(50) DEFAULT NULL,
  `candidate_photo_path` varchar(255) DEFAULT NULL,
  `candidate_postcode` varchar(10) DEFAULT NULL,
  `candidate_state` varchar(255) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `disability` varchar(3) DEFAULT NULL,
  `candidate_father_first_name` varchar(50) DEFAULT NULL,
  `father_income` double DEFAULT NULL,
  `candidate_father_last_name` varchar(50) DEFAULT NULL,
  `candidate_father_occupation` varchar(100) DEFAULT NULL,
  `candidate_guardian_first_name` varchar(50) DEFAULT NULL,
  `candidate_guardian_last_name` varchar(50) DEFAULT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `candidate_mother_first_name` varchar(50) DEFAULT NULL,
  `mother_income` double DEFAULT NULL,
  `candidate_mother_last_name` varchar(50) DEFAULT NULL,
  `candidate_mother_occupation` varchar(50) DEFAULT NULL,
  `passport_issued_country` varchar(255) DEFAULT NULL,
  `candidate_passport_no` varchar(50) DEFAULT NULL,
  `previous_student_id` varchar(50) DEFAULT NULL,
  `referenceOne_addressLine_one` varchar(100) DEFAULT NULL,
  `referenceOne_addressLine_two` varchar(100) DEFAULT NULL,
  `referenceOne_country` varchar(255) DEFAULT NULL,
  `referenceOne_email` varchar(50) DEFAULT NULL,
  `referenceOne_first_name` varchar(50) DEFAULT NULL,
  `referenceOne_last_name` varchar(50) DEFAULT NULL,
  `referenceOne_mobile` varchar(20) DEFAULT NULL,
  `referenceOne_pincode` varchar(10) DEFAULT NULL,
  `referenceTwo_addressLine_one` varchar(100) DEFAULT NULL,
  `referenceTwo_addressLine_two` varchar(100) DEFAULT NULL,
  `referenceTwo_country` varchar(255) DEFAULT NULL,
  `referenceTwo_email` varchar(100) DEFAULT NULL,
  `referenceTwo_first_name` varchar(50) DEFAULT NULL,
  `referenceTwo_last_name` varchar(50) DEFAULT NULL,
  `referenceTwo_mobile` varchar(20) DEFAULT NULL,
  `referenceTwo_pincode` varchar(10) DEFAULT NULL,
  `scanned_signature_path` varchar(255) DEFAULT NULL,
  `studied_here_before` varchar(3) DEFAULT NULL,
  `submit_status` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `admission_config_id` bigint(20) NOT NULL,
  `admission_status_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `class_id` bigint(20) DEFAULT NULL,
  `education_level_id` bigint(20) NOT NULL,
  `hearedus_id` bigint(20) DEFAULT NULL,
  `religion_id` bigint(20) DEFAULT NULL,
  `special_category_id` bigint(20) DEFAULT NULL,
  `sponser_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admission`
--

INSERT INTO `tbl_admission` (`admission_id`, `admission_code`, `admission_rank`, `candidate_addressLine_one`, `candidate_addressLine_two`, `candidate_city`, `candidate_contact_no`, `candidate_country`, `candidate_email`, `candidate_first_name`, `candidate_gender`, `candidate_last_name`, `candidate_photo_path`, `candidate_postcode`, `candidate_state`, `created_date`, `date_of_birth`, `disability`, `candidate_father_first_name`, `father_income`, `candidate_father_last_name`, `candidate_father_occupation`, `candidate_guardian_first_name`, `candidate_guardian_last_name`, `modified_date`, `candidate_mother_first_name`, `mother_income`, `candidate_mother_last_name`, `candidate_mother_occupation`, `passport_issued_country`, `candidate_passport_no`, `previous_student_id`, `referenceOne_addressLine_one`, `referenceOne_addressLine_two`, `referenceOne_country`, `referenceOne_email`, `referenceOne_first_name`, `referenceOne_last_name`, `referenceOne_mobile`, `referenceOne_pincode`, `referenceTwo_addressLine_one`, `referenceTwo_addressLine_two`, `referenceTwo_country`, `referenceTwo_email`, `referenceTwo_first_name`, `referenceTwo_last_name`, `referenceTwo_mobile`, `referenceTwo_pincode`, `scanned_signature_path`, `studied_here_before`, `submit_status`, `total`, `admission_config_id`, `admission_status_id`, `category_id`, `class_id`, `education_level_id`, `hearedus_id`, `religion_id`, `special_category_id`, `sponser_id`, `user_id`) VALUES
(1, 'CBSE-PRIMARY-CLASS-I1491808178476', 1, 'Line1', 'Line2', 'Tiruchirapalli', '1234567890', 'India', 'joanand009@gmail.com', 'Jo', 'Male', 'Anand', '/resources/themes/images/profile-pic/a.png', '123456', 'Tamil Nadu', '2017-04-10 12:39:38', '2017-04-10', 'Yes', 'FN', 0, '', '', 'GN', '', '2017-04-11 05:19:16', 'MN', 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '/resources/themes/images/profile-pic/a.png', NULL, 0, 0.039, 1, 4, 5, 1, 2, NULL, 3, 1, NULL, 9),
(2, 'CBSE-PRIMARY-CLASS-I1491887918941', 2, 'Line1', 'Line2', 'Tiruchirapalli', '1234567890', 'India', 'joanand999@gmail.com', 'Test', 'Male', 'Test', '/resources/themes/images/profile-pic/a.png', '123456', 'Tamil Nadu', '2017-04-11 10:48:39', '2017-04-11', 'No', 'Ss', 0, '', '', 'Ss', '', '2017-04-11 05:18:39', 'Ss', 0, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '/resources/themes/images/profile-pic/a.png', NULL, 0, 0.017, 1, 1, 1, 1, 1, NULL, 3, 2, NULL, 9),
(4, 'CBSE-PRIMARY-CLASS-I1492510772331', 0, 'Line1', 'Line2', 'Chennai', '7894561230', 'India', 'a@gmail.com', 'Anand', 'Male', 'Jo', '/resources/themes/images/profile-pic/a.png', '465789', 'Tamil Nadu', '2017-04-18 15:49:32', '2017-08-09', 'No', 'Anand', 0, NULL, NULL, 'Anand', NULL, '2017-04-18 10:19:32', 'Anand', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ' ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, ' ', NULL, NULL, NULL, NULL, '/resources/themes/images/profile-pic/a.png', NULL, 0, NULL, 1, 1, 5, 1, 2, NULL, 3, 1, NULL, 9);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admission_config`
--

CREATE TABLE `tbl_admission_config` (
  `admission_config_id` bigint(20) NOT NULL,
  `admission_end_date` date NOT NULL,
  `admission_process_year` varchar(10) NOT NULL,
  `admission_start_date` date NOT NULL,
  `admission_application_code_format` varchar(20) NOT NULL,
  `application_fees` double NOT NULL,
  `application_total_seats` bigint(20) NOT NULL,
  `admission_process_status_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admission_config`
--

INSERT INTO `tbl_admission_config` (`admission_config_id`, `admission_end_date`, `admission_process_year`, `admission_start_date`, `admission_application_code_format`, `application_fees`, `application_total_seats`, `admission_process_status_id`) VALUES
(1, '2017-04-30', '2017', '2017-04-10', 'CBSE-Primary-Class-I', 150, 25, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admission_config_class`
--

CREATE TABLE `tbl_admission_config_class` (
  `admission_config_id` bigint(20) NOT NULL,
  `class_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admission_config_class`
--

INSERT INTO `tbl_admission_config_class` (`admission_config_id`, `class_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admission_document`
--

CREATE TABLE `tbl_admission_document` (
  `admission_document_id` bigint(20) NOT NULL,
  `document_name` varchar(50) NOT NULL,
  `document_path` varchar(255) NOT NULL,
  `admission_id` bigint(20) NOT NULL,
  `admission_document_type_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admission_document`
--

INSERT INTO `tbl_admission_document` (`admission_document_id`, `document_name`, `document_path`, `admission_id`, `admission_document_type_id`) VALUES
(1, '', '/resources/themes/images/profile-pic/a.png', 1, 2),
(2, '', '/resources/themes/images/profile-pic/a.png', 1, 1),
(3, '', '/resources/themes/images/profile-pic/a.png', 1, 3),
(4, '', '/resources/themes/images/profile-pic/a.png', 1, 4),
(5, '', '/resources/themes/images/profile-pic/a.png', 2, 2),
(6, '', '/resources/themes/images/profile-pic/a.png', 2, 1),
(7, '', '/resources/themes/images/profile-pic/a.png', 2, 3),
(8, '', '/resources/themes/images/profile-pic/a.png', 2, 4),
(13, 'candidateHSCCertificate', '/resources/themes/images/profile-pic/a.png', 4, 2),
(14, 'candidateSSLCCertificate', '/resources/themes/images/profile-pic/a.png', 4, 1),
(15, 'candidateTCCertificate', '/resources/themes/images/profile-pic/a.png', 4, 3),
(16, 'candidatePreviousMarkSheetCertificate', '/resources/themes/images/profile-pic/a.png', 4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admission_document_types`
--

CREATE TABLE `tbl_admission_document_types` (
  `admission_document_type_id` bigint(20) NOT NULL,
  `document_mandatory` int(11) NOT NULL,
  `admission_document_type_title` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admission_document_types`
--

INSERT INTO `tbl_admission_document_types` (`admission_document_type_id`, `document_mandatory`, `admission_document_type_title`) VALUES
(1, 1, 'SSLC CERTIFICATE COPY'),
(2, 1, 'HSC CERTIFICATE COPY'),
(3, 1, 'TRANSFER CERTIFICATE'),
(4, 1, 'PREVIOUS MARKSHEET');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admission_education_level_detail`
--

CREATE TABLE `tbl_admission_education_level_detail` (
  `admission_education_level_id` bigint(20) NOT NULL,
  `board_or_university` varchar(255) NOT NULL,
  `certificate_no` varchar(30) DEFAULT NULL,
  `cgpa` double DEFAULT NULL,
  `completed_date` date DEFAULT NULL,
  `degree_name` varchar(150) NOT NULL,
  `institution_city` varchar(255) NOT NULL,
  `institution_country` varchar(255) NOT NULL,
  `institution_name` varchar(255) NOT NULL,
  `institution_state` varchar(255) NOT NULL,
  `markType` varchar(255) NOT NULL,
  `marks_obtained` double NOT NULL,
  `percentage` double DEFAULT NULL,
  `roll_no` varchar(30) NOT NULL,
  `started_date` date DEFAULT NULL,
  `year_of_passing` varchar(255) NOT NULL,
  `admission_id` bigint(20) NOT NULL,
  `education_level_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admission_education_level_detail`
--

INSERT INTO `tbl_admission_education_level_detail` (`admission_education_level_id`, `board_or_university`, `certificate_no`, `cgpa`, `completed_date`, `degree_name`, `institution_city`, `institution_country`, `institution_name`, `institution_state`, `markType`, `marks_obtained`, `percentage`, `roll_no`, `started_date`, `year_of_passing`, `admission_id`, `education_level_id`) VALUES
(1, 'TamilNadu State Board', '', 0, '2017-04-10', 'Ukg', 'Tiruchirapalli', 'India', 'Asset Management Institution', 'Tamil Nadu', 'Percentage', 12.6, 12.6, '811211104301', '2017-04-10', '2017', 1, 2),
(2, 'fsfsf', '', 0, '2017-04-11', 'Sdfs', 'Tiruchirapalli', 'India', 'sfsf', 'Tamil Nadu', 'Percentage', 5.5, 5.5, '1231312313', '2017-04-11', '2017', 2, 1),
(4, 'Testing', NULL, 0, '2016-08-09', 'UKG', 'Chennai', 'India', 'Testing', 'Tamil Nadu', 'Percentage', 56, 56, '7894561230', '2015-08-08', '2016', 4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admission_education_level_subject`
--

CREATE TABLE `tbl_admission_education_level_subject` (
  `admission_education_level_subject_id` bigint(20) NOT NULL,
  `subject_title` varchar(255) NOT NULL,
  `subject_marks` double NOT NULL,
  `admission_id` bigint(20) NOT NULL,
  `admission_education_level_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admission_fees_payment_details`
--

CREATE TABLE `tbl_admission_fees_payment_details` (
  `fees_payment_id` bigint(20) NOT NULL,
  `ifsc_code` varchar(20) NOT NULL,
  `fees_paid` double NOT NULL,
  `bank_name` varchar(30) NOT NULL,
  `payment_mode` varchar(20) NOT NULL,
  `transaction_code` varchar(30) NOT NULL,
  `transaction_status` varchar(10) NOT NULL,
  `admission_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admission_process_status`
--

CREATE TABLE `tbl_admission_process_status` (
  `admission_process_status_id` bigint(20) NOT NULL,
  `admission_process_status_title` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admission_process_status`
--

INSERT INTO `tbl_admission_process_status` (`admission_process_status_id`, `admission_process_status_title`) VALUES
(2, 'Closed'),
(3, 'On Going'),
(1, 'On Hold');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admission_status`
--

CREATE TABLE `tbl_admission_status` (
  `admission_status_id` bigint(20) NOT NULL,
  `admission_status_title` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admission_status`
--

INSERT INTO `tbl_admission_status` (`admission_status_id`, `admission_status_title`) VALUES
(6, 'Pending'),
(3, 'Rejected'),
(1, 'Saved'),
(5, 'Selected And Paid'),
(4, 'Selected But Not Paid'),
(2, 'Submitted');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_assesment_type`
--

CREATE TABLE `tbl_assesment_type` (
  `assesment_type_id` bigint(20) NOT NULL,
  `assesment_type_code` varchar(100) NOT NULL,
  `assesment_type_enable` tinyint(1) NOT NULL,
  `assesment_type_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_assesment_type`
--

INSERT INTO `tbl_assesment_type` (`assesment_type_id`, `assesment_type_code`, `assesment_type_enable`, `assesment_type_name`) VALUES
(1, 'module', 1, 'Modules Baesd'),
(2, 'csarea', 1, 'Co-Scholastic Area'),
(3, 'csactivity', 1, 'Co-Scholastic Activity'),
(4, 'moduleskill', 1, 'Module & Skill Based');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_blood_group`
--

CREATE TABLE `tbl_blood_group` (
  `blood_group_id` bigint(20) NOT NULL,
  `blood_group_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_blood_group`
--

INSERT INTO `tbl_blood_group` (`blood_group_id`, `blood_group_name`) VALUES
(2, 'A+'),
(1, 'A-'),
(5, 'AB+'),
(6, 'AB-'),
(4, 'B+'),
(3, 'B-'),
(8, 'O+'),
(7, 'O-'),
(9, 'Others');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_category`
--

CREATE TABLE `tbl_category` (
  `category_id` bigint(20) NOT NULL,
  `category_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_category`
--

INSERT INTO `tbl_category` (`category_id`, `category_name`) VALUES
(5, 'BC'),
(4, 'MBC'),
(3, 'OBC(General)'),
(6, 'OC'),
(7, 'Others'),
(1, 'SC'),
(2, 'ST');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class`
--

CREATE TABLE `tbl_class` (
  `class_id` bigint(20) NOT NULL,
  `class_exam_config_status` int(11) NOT NULL,
  `class_name` varchar(100) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_class`
--

INSERT INTO `tbl_class` (`class_id`, `class_exam_config_status`, `class_name`, `institution_id`) VALUES
(1, 1, 'Class-I', 1),
(2, 1, 'Class-II', 1),
(3, 2, 'Class-III', 1),
(4, 2, 'Class-IV', 1),
(5, 2, 'Class-V', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section`
--

CREATE TABLE `tbl_class_section` (
  `class_section_id` bigint(20) NOT NULL,
  `class_id` bigint(20) DEFAULT NULL,
  `section_id` bigint(20) DEFAULT NULL,
  `classSectionExamConfigStatus` int(11) DEFAULT NULL,
  `staff_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_class_section`
--

INSERT INTO `tbl_class_section` (`class_section_id`, `class_id`, `section_id`, `classSectionExamConfigStatus`, `staff_id`) VALUES
(1, 1, 1, NULL, 3),
(2, 1, 2, NULL, 5),
(3, 1, 3, NULL, 6),
(4, 2, 1, 1, 2),
(5, 2, 2, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_assesment_type`
--

CREATE TABLE `tbl_class_section_assesment_type` (
  `class_section_assesment_type_id` bigint(20) NOT NULL,
  `assessment_limit` int(11) NOT NULL,
  `class_section_assesment_name` varchar(100) NOT NULL,
  `is_grade_method` tinyint(1) NOT NULL,
  `class_section_id` bigint(20) NOT NULL,
  `grade_system_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_class_section_assesment_type`
--

INSERT INTO `tbl_class_section_assesment_type` (`class_section_assesment_type_id`, `assessment_limit`, `class_section_assesment_name`, `is_grade_method`, `class_section_id`, `grade_system_id`) VALUES
(1, 0, 'ModulesBased', 1, 4, 1),
(2, 0, 'ModulesBased', 1, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_coscholastic_activity`
--

CREATE TABLE `tbl_class_section_coscholastic_activity` (
  `class_section_coscholastic_activity_id` bigint(20) NOT NULL,
  `class_section_id` bigint(20) NOT NULL,
  `co_scholastic_activity_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_coscholastic_activity_exam`
--

CREATE TABLE `tbl_class_section_coscholastic_activity_exam` (
  `class_section_coscholastic_activity_exam_id` bigint(20) NOT NULL,
  `class_section_coscholastic_activity_id` bigint(20) NOT NULL,
  `class_section_term_id` bigint(20) NOT NULL,
  `class_section_term_exam_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_coscholastic_area`
--

CREATE TABLE `tbl_class_section_coscholastic_area` (
  `class_section_coscholastic_area_id` bigint(20) NOT NULL,
  `class_section_id` bigint(20) NOT NULL,
  `co_scholastic_area_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_coscholastic_area_exam`
--

CREATE TABLE `tbl_class_section_coscholastic_area_exam` (
  `class_section_coscholastic_area_exam_id` bigint(20) NOT NULL,
  `class_section_coscholastic_area_id` bigint(20) NOT NULL,
  `class_section_term_id` bigint(20) NOT NULL,
  `class_section_term_exam_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_module`
--

CREATE TABLE `tbl_class_section_module` (
  `class_section_module_id` bigint(20) NOT NULL,
  `is_skill_based` tinyint(1) NOT NULL,
  `status` int(11) NOT NULL,
  `class_section_id` bigint(20) NOT NULL,
  `module_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_class_section_module`
--

INSERT INTO `tbl_class_section_module` (`class_section_module_id`, `is_skill_based`, `status`, `class_section_id`, `module_id`) VALUES
(1, 0, 1, 1, 1),
(2, 0, 1, 1, 2),
(3, 0, 1, 1, 3),
(4, 0, 1, 1, 4),
(5, 0, 1, 1, 5),
(6, 0, 1, 2, 1),
(7, 0, 1, 2, 2),
(8, 0, 1, 2, 3),
(9, 0, 1, 2, 4),
(10, 0, 1, 2, 5),
(11, 0, 1, 3, 1),
(12, 0, 1, 3, 2),
(13, 0, 1, 3, 3),
(14, 0, 1, 3, 4),
(15, 0, 1, 3, 5),
(16, 0, 1, 4, 1),
(17, 0, 1, 5, 1),
(18, 0, 1, 5, 2),
(19, 0, 1, 5, 4),
(20, 0, 1, 5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_module_exam`
--

CREATE TABLE `tbl_class_section_module_exam` (
  `class_section_module_exam_id` bigint(20) NOT NULL,
  `class_section_module_id` bigint(20) NOT NULL,
  `class_section_term_id` bigint(20) NOT NULL,
  `class_section_term_exam_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_class_section_module_exam`
--

INSERT INTO `tbl_class_section_module_exam` (`class_section_module_exam_id`, `class_section_module_id`, `class_section_term_id`, `class_section_term_exam_id`) VALUES
(1, 16, 1, 1),
(2, 16, 1, 2),
(3, 16, 1, 3),
(4, 16, 2, 4),
(5, 16, 2, 5),
(6, 16, 2, 6);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_module_skill`
--

CREATE TABLE `tbl_class_section_module_skill` (
  `class_section_module_skill_id` bigint(20) NOT NULL,
  `class_section_module_id` bigint(20) NOT NULL,
  `module_skill_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_module_skill_exam`
--

CREATE TABLE `tbl_class_section_module_skill_exam` (
  `class_section_module_skill_exam_id` bigint(20) NOT NULL,
  `class_section_module_skill_id` bigint(20) NOT NULL,
  `class_section_term_id` bigint(20) NOT NULL,
  `class_section_term_exam_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_module_staff`
--

CREATE TABLE `tbl_class_section_module_staff` (
  `class_section_module_staff_id` bigint(20) NOT NULL,
  `academic_year_id` bigint(20) DEFAULT NULL,
  `class_section_module_id` bigint(20) DEFAULT NULL,
  `staff_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_class_section_module_staff`
--

INSERT INTO `tbl_class_section_module_staff` (`class_section_module_staff_id`, `academic_year_id`, `class_section_module_id`, `staff_id`) VALUES
(1, 1, 1, 2),
(2, 1, 2, 3),
(3, 1, 3, 4),
(4, 1, 4, 5),
(5, 1, 5, 6),
(6, 1, 6, 2),
(7, 1, 7, 3),
(8, 1, 8, 4),
(9, 1, 9, 5),
(10, 1, 10, 6),
(11, 1, 11, 2),
(12, 1, 12, 3),
(13, 1, 13, 4),
(14, 1, 14, 5),
(15, 1, 15, 6),
(16, 1, 16, 1),
(17, 1, 17, 6),
(18, 1, 18, 5),
(19, 1, 19, 3),
(20, 1, 20, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_term`
--

CREATE TABLE `tbl_class_section_term` (
  `class_section_term_id` bigint(20) NOT NULL,
  `term_name` varchar(100) NOT NULL,
  `class_section_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_class_section_term`
--

INSERT INTO `tbl_class_section_term` (`class_section_term_id`, `term_name`, `class_section_id`) VALUES
(1, 'June-Augest', 4),
(2, 'October-December', 4),
(3, 'June-Augest', 5),
(4, 'October-December', 5);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_term_exam`
--

CREATE TABLE `tbl_class_section_term_exam` (
  `class_section_term_exam_id` bigint(20) NOT NULL,
  `term_exam_name` varchar(100) NOT NULL,
  `class_section_term_exam_percentage` double NOT NULL,
  `class_section_term_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_class_section_term_exam`
--

INSERT INTO `tbl_class_section_term_exam` (`class_section_term_exam_id`, `term_exam_name`, `class_section_term_exam_percentage`, `class_section_term_id`) VALUES
(1, 'FA1', 20, 1),
(2, 'FA2', 20, 1),
(3, 'SA1', 60, 1),
(4, 'FA3', 20, 2),
(5, 'FA4', 20, 2),
(6, 'SA2', 60, 2),
(7, 'FA1', 20, 3),
(8, 'FA2', 20, 3),
(9, 'SA1', 60, 3),
(10, 'FA3', 20, 4),
(11, 'FA4', 20, 4),
(12, 'SA2', 60, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class_section_term_exam_activity`
--

CREATE TABLE `tbl_class_section_term_exam_activity` (
  `class_section_term_exam_activity_id` bigint(20) NOT NULL,
  `term_exam_activity_name` varchar(100) NOT NULL,
  `maximum_mark` double NOT NULL,
  `class_section_term_exam_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_class_section_term_exam_activity`
--

INSERT INTO `tbl_class_section_term_exam_activity` (`class_section_term_exam_activity_id`, `term_exam_activity_name`, `maximum_mark`, `class_section_term_exam_id`) VALUES
(1, 'FA1', 100, 1),
(2, 'FA2', 100, 2),
(3, 'SA1', 100, 3),
(4, 'FA3', 100, 4),
(5, 'FA4', 100, 5),
(6, 'SA2', 100, 6);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_feedback_and_others`
--

CREATE TABLE `tbl_communication_feedback_and_others` (
  `communication_feedback_and_others_id` bigint(20) NOT NULL,
  `communication_feedback_and_others_message` varchar(255) DEFAULT NULL,
  `communication_feedback_and_others_subject` varchar(255) DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `communication_feedback_and_others_status` int(11) NOT NULL,
  `communication_feedback_and_others_archive_id` bigint(20) DEFAULT NULL,
  `communication_message_mode_id` bigint(20) NOT NULL,
  `communication_target_group_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `portal_message_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_feedback_and_others_archive`
--

CREATE TABLE `tbl_communication_feedback_and_others_archive` (
  `communication_feedback_and_others_archive_id` bigint(20) NOT NULL,
  `communication_feedback_and_others_archive_message` varchar(255) DEFAULT NULL,
  `communication_feedback_and_others_archive_subject` varchar(255) DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `communication_feedback_and_others_archive_status` int(11) NOT NULL,
  `communication_feedback_and_others_id` bigint(20) DEFAULT NULL,
  `communication_message_mode_id` bigint(20) NOT NULL,
  `communication_target_group_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_feedback_and_others_archive_users`
--

CREATE TABLE `tbl_communication_feedback_and_others_archive_users` (
  `communication_feedback_and_others_archive_id` bigint(20) NOT NULL,
  `target_user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_feedback_and_others_history`
--

CREATE TABLE `tbl_communication_feedback_and_others_history` (
  `communication_feedback_and_others_history_id` bigint(20) NOT NULL,
  `communication_feedback_and_others_history_message` varchar(255) DEFAULT NULL,
  `communication_feedback_and_others_history_subject` varchar(255) DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `message_link` varchar(255) NOT NULL,
  `communication_feedback_and_others_history_status` int(11) NOT NULL,
  `communication_feedback_and_others_id` bigint(20) DEFAULT NULL,
  `portal_reply_message_id` bigint(20) DEFAULT NULL,
  `target_user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_feedback_and_others_users`
--

CREATE TABLE `tbl_communication_feedback_and_others_users` (
  `communication_feedback_and_others_id` bigint(20) NOT NULL,
  `target_user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_message_mode`
--

CREATE TABLE `tbl_communication_message_mode` (
  `communication_message_mode_id` bigint(20) NOT NULL,
  `communication_message_mode_title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_communication_message_mode`
--

INSERT INTO `tbl_communication_message_mode` (`communication_message_mode_id`, `communication_message_mode_title`) VALUES
(2, 'FeedBack'),
(3, 'Issue'),
(1, 'Notification'),
(4, 'Others');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_notification`
--

CREATE TABLE `tbl_communication_notification` (
  `communication_notification_id` bigint(20) NOT NULL,
  `communication_notification_message` varchar(255) DEFAULT NULL,
  `communication_notification_subject` varchar(255) DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `communication_notification_status` int(11) NOT NULL,
  `communication_message_mode_id` bigint(20) NOT NULL,
  `communication_target_group_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `portal_notification_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_communication_notification`
--

INSERT INTO `tbl_communication_notification` (`communication_notification_id`, `communication_notification_message`, `communication_notification_subject`, `created_by`, `created_date`, `communication_notification_status`, `communication_message_mode_id`, `communication_target_group_id`, `institution_id`, `portal_notification_id`) VALUES
(1, 'Hi', 'General Message', 'admin@jdsoft.in', '2017-04-04 10:48:43', 1, 1, 7, 1, 1),
(2, 'You are selected', 'Application Status Updated', 'admin@jdsoft.in', '2017-04-10 12:57:17', 1, 1, 9, 1, 2),
(3, 'You are selected', 'Application Status Updated', 'admin@jdsoft.in', '2017-04-11 10:21:31', 1, 1, 9, 1, 3),
(4, 'You are selected', 'Application Status Updated', 'admin@jdsoft.in', '2017-04-11 12:01:24', 1, 1, 9, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_notification_archive`
--

CREATE TABLE `tbl_communication_notification_archive` (
  `communication_notification_archive_id` bigint(20) NOT NULL,
  `communication_notification_archive_message` varchar(255) DEFAULT NULL,
  `communication_notification_archive_subject` varchar(255) DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `communication_notification_archive_status` int(11) NOT NULL,
  `communication_message_mode_id` bigint(20) NOT NULL,
  `communication_notification_id` bigint(20) DEFAULT NULL,
  `communication_target_group_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_notification_archive_users`
--

CREATE TABLE `tbl_communication_notification_archive_users` (
  `communication_notification_archive_id` bigint(20) NOT NULL,
  `target_user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_notification_users`
--

CREATE TABLE `tbl_communication_notification_users` (
  `communication_notification_id` bigint(20) NOT NULL,
  `target_user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_communication_notification_users`
--

INSERT INTO `tbl_communication_notification_users` (`communication_notification_id`, `target_user_id`) VALUES
(1, 7),
(2, 9),
(3, 9),
(4, 9);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_communication_target_group`
--

CREATE TABLE `tbl_communication_target_group` (
  `communication_target_group_id` bigint(20) NOT NULL,
  `communication_target_group_title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_communication_target_group`
--

INSERT INTO `tbl_communication_target_group` (`communication_target_group_id`, `communication_target_group_title`) VALUES
(9, 'Admission Candidate'),
(1, 'All'),
(4, 'All Parent'),
(2, 'All Staff'),
(3, 'All Student'),
(8, 'Others'),
(5, 'Specific Parent'),
(6, 'Specific Staff'),
(7, 'Specific Student');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_co_scholastic_activity`
--

CREATE TABLE `tbl_co_scholastic_activity` (
  `co_scholastic_activity_id` bigint(20) NOT NULL,
  `co_scholastic_activity_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_co_scholastic_activity`
--

INSERT INTO `tbl_co_scholastic_activity` (`co_scholastic_activity_id`, `co_scholastic_activity_name`) VALUES
(2, 'Health and Physical Education'),
(1, 'Skills');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_co_scholastic_activity_indicator`
--

CREATE TABLE `tbl_co_scholastic_activity_indicator` (
  `co_scholastic_activity_indicator_id` bigint(20) NOT NULL,
  `co_scholastic_activity_indicator_name` varchar(150) NOT NULL,
  `co_scholastic_activity_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_co_scholastic_activity_indicator`
--

INSERT INTO `tbl_co_scholastic_activity_indicator` (`co_scholastic_activity_indicator_id`, `co_scholastic_activity_indicator_name`, `co_scholastic_activity_id`) VALUES
(3, 'Aesthetic and Performing art', 1),
(4, 'clubs', 1),
(8, 'First -aid', 2),
(7, 'Gymnastics', 2),
(1, 'Literary and Creative Skills', 1),
(2, 'Scientific Skills', 1),
(6, 'Scouting and guiding', 2),
(5, 'Sports/Indigenous sports', 2),
(9, 'Swimming', 2),
(10, 'Yoga', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_co_scholastic_area`
--

CREATE TABLE `tbl_co_scholastic_area` (
  `co_scholastic_area_id` bigint(20) NOT NULL,
  `co_scholastic_area_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_co_scholastic_area`
--

INSERT INTO `tbl_co_scholastic_area` (`co_scholastic_area_id`, `co_scholastic_area_name`) VALUES
(4, 'Attitudes & Values'),
(1, 'Life Skills'),
(3, 'Visual and Performing Arts'),
(2, 'Work Education');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_co_scholastic_area_indicator`
--

CREATE TABLE `tbl_co_scholastic_area_indicator` (
  `co_scholastic_area_indicator_id` bigint(20) NOT NULL,
  `co_scholastic_area_indicator_name` varchar(150) NOT NULL,
  `co_scholastic_area_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_co_scholastic_area_indicator`
--

INSERT INTO `tbl_co_scholastic_area_indicator` (`co_scholastic_area_indicator_id`, `co_scholastic_area_indicator_name`, `co_scholastic_area_id`) VALUES
(17, 'Attitude towards Peers', 4),
(18, 'Attitude towards School Programme and Environment', 4),
(16, 'Attitude towards Teachers', 4),
(5, 'Creative Thinking', 1),
(4, 'Critical Thinking', 1),
(15, 'Dance', 3),
(10, 'Dealing with Stress', 1),
(3, 'Decision Making', 1),
(14, 'Drawing', 3),
(7, 'Effective Communication', 1),
(8, 'Empathy', 1),
(6, 'Interpersonel Relationships', 1),
(9, 'Managing Emotions', 1),
(12, 'Model Making', 2),
(13, 'Pot Painting', 2),
(2, 'Problem Solving', 1),
(1, 'Self Awareness', 1),
(11, 'Value System', 1),
(19, 'Value System', 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_currency`
--

CREATE TABLE `tbl_currency` (
  `iso` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_currency`
--

INSERT INTO `tbl_currency` (`iso`, `name`) VALUES
('KRW', '(South) Korean Won'),
('AFA', 'Afghanistan Afghani'),
('ALL', 'Albanian Lek'),
('DZD', 'Algerian Dinar'),
('ADP', 'Andorran Peseta'),
('AOK', 'Angolan Kwanza'),
('ARS', 'Argentine Peso'),
('AMD', 'Armenian Dram'),
('AWG', 'Aruban Florin'),
('AUD', 'Australian Dollar'),
('BSD', 'Bahamian Dollar'),
('BHD', 'Bahraini Dinar'),
('BDT', 'Bangladeshi Taka'),
('BBD', 'Barbados Dollar'),
('BZD', 'Belize Dollar'),
('BMD', 'Bermudian Dollar'),
('BTN', 'Bhutan Ngultrum'),
('BOB', 'Bolivian Boliviano'),
('BWP', 'Botswanian Pula'),
('BRL', 'Brazilian Real'),
('GBP', 'British Pound'),
('BND', 'Brunei Dollar'),
('BGN', 'Bulgarian Lev'),
('BUK', 'Burma Kyat'),
('BIF', 'Burundi Franc'),
('CAD', 'Canadian Dollar'),
('CVE', 'Cape Verde Escudo'),
('KYD', 'Cayman Islands Dollar'),
('CLP', 'Chilean Peso'),
('CLF', 'Chilean Unidades De Fomento'),
('COP', 'Colombian Peso'),
('XOF', 'CommunautÃ© FinanciÃ¨re Africaine BCEAO - Francs'),
('XAF', 'CommunautÃ© FinanciÃ¨re Africaine BEAC, Francs'),
('KMF', 'Comoros Franc'),
('XPF', 'Comptoirs FranÃ§ais Du Pacifique Francs'),
('CRC', 'Costa Rican Colon'),
('CUP', 'Cuban Peso'),
('CYP', 'Cyprus Pound'),
('CZK', 'Czech Republic Koruna'),
('DKK', 'Danish Krone'),
('YDD', 'Democratic Yemeni Dinar'),
('DOP', 'Dominican Peso'),
('XCD', 'East Caribbean Dollar'),
('TPE', 'East Timor Escudo'),
('ECS', 'Ecuador Sucre'),
('EGP', 'Egyptian Pound'),
('SVC', 'El Salvador Colon'),
('EEK', 'Estonian Kroon (EEK)'),
('ETB', 'Ethiopian Birr'),
('EUR', 'Euro'),
('FKP', 'Falkland Islands Pound'),
('FJD', 'Fiji Dollar'),
('GMD', 'Gambian Dalasi'),
('GHC', 'Ghanaian Cedi'),
('GIP', 'Gibraltar Pound'),
('XAU', 'Gold, Ounces'),
('GTQ', 'Guatemalan Quetzal'),
('GNF', 'Guinea Franc'),
('GWP', 'Guinea-Bissau Peso'),
('GYD', 'Guyanan Dollar'),
('HTG', 'Haitian Gourde'),
('HNL', 'Honduran Lempira'),
('HKD', 'Hong Kong Dollar'),
('HUF', 'Hungarian Forint'),
('INR', 'Indian Rupee'),
('IDR', 'Indonesian Rupiah'),
('XDR', 'International Monetary Fund (IMF) Special Drawing Rights'),
('IRR', 'Iranian Rial'),
('IQD', 'Iraqi Dinar'),
('IEP', 'Irish Punt'),
('ILS', 'Israeli Shekel'),
('JMD', 'Jamaican Dollar'),
('JPY', 'Japanese Yen'),
('JOD', 'Jordanian Dinar'),
('KHR', 'Kampuchean (Cambodian) Riel'),
('KES', 'Kenyan Schilling'),
('KWD', 'Kuwaiti Dinar'),
('LAK', 'Lao Kip'),
('LBP', 'Lebanese Pound'),
('LSL', 'Lesotho Loti'),
('LRD', 'Liberian Dollar'),
('LYD', 'Libyan Dinar'),
('MOP', 'Macau Pataca'),
('MGF', 'Malagasy Franc'),
('MWK', 'Malawi Kwacha'),
('MYR', 'Malaysian Ringgit'),
('MVR', 'Maldive Rufiyaa'),
('MTL', 'Maltese Lira'),
('MRO', 'Mauritanian Ouguiya'),
('MUR', 'Mauritius Rupee'),
('MXP', 'Mexican Peso'),
('MNT', 'Mongolian Tugrik'),
('MAD', 'Moroccan Dirham'),
('MZM', 'Mozambique Metical'),
('NAD', 'Namibian Dollar'),
('NPR', 'Nepalese Rupee'),
('ANG', 'Netherlands Antillian Guilder'),
('YUD', 'New Yugoslavia Dinar'),
('NZD', 'New Zealand Dollar'),
('NIO', 'Nicaraguan Cordoba'),
('NGN', 'Nigerian Naira'),
('KPW', 'North Korean Won'),
('NOK', 'Norwegian Kroner'),
('OMR', 'Omani Rial'),
('PKR', 'Pakistan Rupee'),
('XPD', 'Palladium Ounces'),
('PAB', 'Panamanian Balboa'),
('PGK', 'Papua New Guinea Kina'),
('PYG', 'Paraguay Guarani'),
('PEN', 'Peruvian Nuevo Sol'),
('PHP', 'Philippine Peso'),
('XPT', 'Platinum, Ounces'),
('PLN', 'Polish Zloty'),
('QAR', 'Qatari Rial'),
('RON', 'Romanian Leu'),
('RUB', 'Russian Ruble'),
('RWF', 'Rwanda Franc'),
('WST', 'Samoan Tala'),
('STD', 'Sao Tome And Principe Dobra'),
('SAR', 'Saudi Arabian Riyal'),
('SCR', 'Seychelles Rupee'),
('SLL', 'Sierra Leone Leone'),
('XAG', 'Silver, Ounces'),
('SGD', 'Singapore Dollar'),
('SKK', 'Slovak Koruna'),
('SBD', 'Solomon Islands Dollar'),
('SOS', 'Somali Schilling'),
('ZAR', 'South African Rand'),
('LKR', 'Sri Lanka Rupee'),
('SHP', 'St. Helena Pound'),
('SDP', 'Sudanese Pound'),
('SRG', 'Suriname Guilder'),
('SZL', 'Swaziland Lilangeni'),
('SEK', 'Swedish Krona'),
('CHF', 'Swiss Franc'),
('SYP', 'Syrian Potmd'),
('TWD', 'Taiwan Dollar'),
('TZS', 'Tanzanian Schilling'),
('THB', 'Thai Baht'),
('TOP', 'Tongan Paanga'),
('TTD', 'Trinidad And Tobago Dollar'),
('TND', 'Tunisian Dinar'),
('TRY', 'Turkish Lira'),
('UGX', 'Uganda Shilling'),
('AED', 'United Arab Emirates Dirham'),
('UYU', 'Uruguayan Peso'),
('USD', 'US Dollar'),
('VUV', 'Vanuatu Vatu'),
('VEF', 'Venezualan Bolivar'),
('VND', 'Vietnamese Dong'),
('YER', 'Yemeni Rial'),
('CNY', 'Yuan (Chinese) Renminbi'),
('ZRZ', 'Zaire Zaire'),
('ZMK', 'Zambian Kwacha'),
('ZWD', 'Zimbabwe Dollar');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_education_level`
--

CREATE TABLE `tbl_education_level` (
  `education_level_id` bigint(20) NOT NULL,
  `education_level_title` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_education_level`
--

INSERT INTO `tbl_education_level` (`education_level_id`, `education_level_title`) VALUES
(3, 'Class-I'),
(4, 'Class-II'),
(5, 'Class-III'),
(6, 'Class-IV'),
(11, 'Class-IX'),
(7, 'Class-V'),
(8, 'Class-VI'),
(9, 'Class-VII'),
(10, 'Class-VIII'),
(12, 'Class-X'),
(13, 'Class-XI'),
(14, 'Class-XII'),
(1, 'LKG'),
(2, 'UKG');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_education_level_subject`
--

CREATE TABLE `tbl_education_level_subject` (
  `education_level_subject_id` bigint(20) NOT NULL,
  `education_level_subject_title` varchar(100) NOT NULL,
  `education_level_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_education_level_subject`
--

INSERT INTO `tbl_education_level_subject` (`education_level_subject_id`, `education_level_subject_title`, `education_level_id`) VALUES
(1, 'Subject1', 3),
(2, 'Subject2', 3),
(3, 'Subject3', 3),
(4, 'Subject4', 3),
(5, 'Subject1', 4),
(6, 'Subject2', 4),
(7, 'Subject3', 4),
(8, 'Subject4', 4),
(11, 'Subject1', 5),
(12, 'Subject2', 5),
(13, 'Subject3', 5),
(15, 'Subject4', 5),
(16, 'Subject1', 6),
(17, 'Subject2', 6),
(18, 'Subject3', 6),
(19, 'Subject4', 6),
(21, 'Subject1', 7),
(22, 'Subject2', 7),
(23, 'Subject3', 7),
(24, 'Subject4', 7),
(26, 'Subject1', 8),
(27, 'Subject2', 8),
(28, 'Subject3', 8),
(29, 'Subject4', 8),
(31, 'Subject1', 9),
(32, 'Subject2', 9),
(33, 'Subject3', 9),
(34, 'Subject4', 9),
(36, 'Subject1', 10),
(37, 'Subject2', 10),
(38, 'Subject3', 10),
(39, 'Subject4', 10),
(41, 'Subject1', 11),
(42, 'Subject2', 11),
(43, 'Subject3', 11),
(44, 'Subject4', 11),
(46, 'Subject1', 12),
(47, 'Subject2', 12),
(48, 'Subject3', 12),
(49, 'Subject4', 12),
(51, 'Subject1', 13),
(52, 'Subject2', 13),
(53, 'Subject3', 13),
(54, 'Subject4', 13),
(56, 'Subject1', 14),
(57, 'Subject2', 14),
(58, 'Subject3', 14),
(59, 'Subject4', 14);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_exam_template`
--

CREATE TABLE `tbl_exam_template` (
  `exam_template_id` bigint(20) NOT NULL,
  `exam_template_name` varchar(150) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_exam_template`
--

INSERT INTO `tbl_exam_template` (`exam_template_id`, `exam_template_name`, `institution_id`) VALUES
(1, '2017-2018  Academic Regulation', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fees_item`
--

CREATE TABLE `tbl_fees_item` (
  `fees_item_id` bigint(20) NOT NULL,
  `fees_item_name` varchar(100) NOT NULL,
  `fees_item_price` double NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `ledger_account_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_fees_item`
--

INSERT INTO `tbl_fees_item` (`fees_item_id`, `fees_item_name`, `fees_item_price`, `institution_id`, `ledger_account_id`) VALUES
(1, 'Book Fees', 250, 1, 1),
(2, 'Exam Fees', 500, 1, 1),
(3, 'Library Fees', 400, 1, 2),
(4, 'Tuition Fees', 1000, 1, 2),
(5, 'Bus Fees', 5000, 1, 2),
(6, 'Laboratory Fees', 200, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fees_structure`
--

CREATE TABLE `tbl_fees_structure` (
  `fees_structure_id` bigint(20) NOT NULL,
  `fees_structure_name` varchar(100) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_fees_structure`
--

INSERT INTO `tbl_fees_structure` (`fees_structure_id`, `fees_structure_name`, `institution_id`) VALUES
(1, 'FS1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fees_structure_mapping`
--

CREATE TABLE `tbl_fees_structure_mapping` (
  `fees_structure_id` bigint(20) NOT NULL,
  `fees_item_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_fees_structure_mapping`
--

INSERT INTO `tbl_fees_structure_mapping` (`fees_structure_id`, `fees_item_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_fees_term`
--

CREATE TABLE `tbl_fees_term` (
  `fees_term_id` bigint(20) NOT NULL,
  `fees_term_name` varchar(100) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_fees_term`
--

INSERT INTO `tbl_fees_term` (`fees_term_id`, `fees_term_name`, `institution_id`) VALUES
(1, 'Term-I', 1),
(2, 'Term-II', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_geographical_location`
--

CREATE TABLE `tbl_geographical_location` (
  `location_id` bigint(20) NOT NULL,
  `location_type` int(11) NOT NULL,
  `is_visible` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `parent_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_geographical_location`
--

INSERT INTO `tbl_geographical_location` (`location_id`, `location_type`, `is_visible`, `name`, `parent_id`) VALUES
(1, 0, 0, 'Aruba', 0),
(2, 0, 0, 'Afghanistan', 0),
(3, 0, 0, 'Angola', 0),
(4, 0, 0, 'Anguilla', 0),
(5, 0, 0, 'Albania', 0),
(6, 0, 0, 'Andorra', 0),
(7, 0, 0, 'Netherlands Antilles', 0),
(8, 0, 0, 'United Arab Emirates', 0),
(9, 0, 0, 'Argentina', 0),
(10, 0, 0, 'Armenia', 0),
(11, 0, 0, 'American Samoa', 0),
(12, 0, 0, 'Antarctica', 0),
(13, 0, 0, 'French Southern Territories', 0),
(14, 0, 0, 'Antigua And Barbuda', 0),
(15, 0, 0, 'Australia', 0),
(16, 0, 0, 'Austria', 0),
(17, 0, 0, 'Azerbaijan', 0),
(18, 0, 0, 'Burundi', 0),
(19, 0, 0, 'Belgium', 0),
(20, 0, 0, 'Benin', 0),
(21, 0, 0, 'Burkina Faso', 0),
(22, 0, 0, 'Bangladesh', 0),
(23, 0, 0, 'Bulgaria', 0),
(24, 0, 0, 'Bahrain', 0),
(25, 0, 0, 'Bahamas', 0),
(26, 0, 0, 'Bosnia And Herzegovina', 0),
(27, 0, 0, 'Belarus', 0),
(28, 0, 0, 'Belize', 0),
(29, 0, 0, 'Bermuda', 0),
(30, 0, 0, 'Bolivia', 0),
(31, 0, 0, 'Brazil', 0),
(32, 0, 0, 'Barbados', 0),
(33, 0, 0, 'Brunei', 0),
(34, 0, 0, 'Bhutan', 0),
(35, 0, 0, 'Bouvet Island', 0),
(36, 0, 0, 'Botswana', 0),
(37, 0, 0, 'Central African Republic', 0),
(38, 0, 0, 'Canada', 0),
(39, 0, 0, 'Cocos (Keeling) Islands', 0),
(40, 0, 0, 'Switzerland', 0),
(41, 0, 0, 'Chile', 0),
(42, 0, 0, 'China', 0),
(43, 0, 0, 'CÃƒÂ´te DÃ¢â‚¬â„¢Ivoire', 0),
(44, 0, 0, 'Cameroon', 0),
(45, 0, 0, 'Congo, The Democratic Republic', 0),
(46, 0, 0, 'Congo', 0),
(47, 0, 0, 'Cook Islands', 0),
(48, 0, 0, 'Colombia', 0),
(49, 0, 0, 'Comoros', 0),
(50, 0, 0, 'Cape Verde', 0),
(51, 0, 0, 'Costa Rica', 0),
(52, 0, 0, 'Cuba', 0),
(53, 0, 0, 'Christmas Island', 0),
(54, 0, 0, 'Cayman Islands', 0),
(55, 0, 0, 'Cyprus', 0),
(56, 0, 0, 'Czech Republic', 0),
(57, 0, 0, 'Germany', 0),
(58, 0, 0, 'Djibouti', 0),
(59, 0, 0, 'Dominica', 0),
(60, 0, 0, 'Denmark', 0),
(61, 0, 0, 'Dominican Republic', 0),
(62, 0, 0, 'Algeria', 0),
(63, 0, 0, 'Ecuador', 0),
(64, 0, 0, 'Egypt', 0),
(65, 0, 0, 'Eritrea', 0),
(66, 0, 0, 'Western Sahara', 0),
(67, 0, 0, 'Spain', 0),
(68, 0, 0, 'Estonia', 0),
(69, 0, 0, 'Ethiopia', 0),
(70, 0, 0, 'Finland', 0),
(71, 0, 0, 'Fiji Islands', 0),
(72, 0, 0, 'Falkland Islands', 0),
(73, 0, 0, 'France', 0),
(74, 0, 0, 'Faroe Islands', 0),
(75, 0, 0, 'Micronesia, Federated States O', 0),
(76, 0, 0, 'Gabon', 0),
(77, 0, 0, 'United Kingdom', 0),
(78, 0, 0, 'Georgia', 0),
(79, 0, 0, 'Ghana', 0),
(80, 0, 0, 'Gibraltar', 0),
(81, 0, 0, 'Guinea', 0),
(82, 0, 0, 'Guadeloupe', 0),
(83, 0, 0, 'Gambia', 0),
(84, 0, 0, 'Guinea-Bissau', 0),
(85, 0, 0, 'Equatorial Guinea', 0),
(86, 0, 0, 'Greece', 0),
(87, 0, 0, 'Grenada', 0),
(88, 0, 0, 'Greenland', 0),
(89, 0, 0, 'Guatemala', 0),
(90, 0, 0, 'French Guiana', 0),
(91, 0, 0, 'Guam', 0),
(92, 0, 0, 'Guyana', 0),
(93, 0, 0, 'Hong Kong', 0),
(94, 0, 0, 'Heard Island And McDonald Isla', 0),
(95, 0, 0, 'Honduras', 0),
(96, 0, 0, 'Croatia', 0),
(97, 0, 0, 'Haiti', 0),
(98, 0, 0, 'Hungary', 0),
(99, 0, 0, 'Indonesia', 0),
(100, 0, 0, 'India', 0),
(101, 0, 0, 'British Indian Ocean Territory', 0),
(102, 0, 0, 'Ireland', 0),
(103, 0, 0, 'Iran', 0),
(104, 0, 0, 'Iraq', 0),
(105, 0, 0, 'Iceland', 0),
(106, 0, 0, 'Israel', 0),
(107, 0, 0, 'Italy', 0),
(108, 0, 0, 'Jamaica', 0),
(109, 0, 0, 'Jordan', 0),
(110, 0, 0, 'Japan', 0),
(111, 0, 0, 'Kazakstan', 0),
(112, 0, 0, 'Kenya', 0),
(113, 0, 0, 'Kyrgyzstan', 0),
(114, 0, 0, 'Cambodia', 0),
(115, 0, 0, 'Kiribati', 0),
(116, 0, 0, 'Saint Kitts And Nevis', 0),
(117, 0, 0, 'South Korea', 0),
(118, 0, 0, 'Kuwait', 0),
(119, 0, 0, 'Laos', 0),
(120, 0, 0, 'Lebanon', 0),
(121, 0, 0, 'Liberia', 0),
(122, 0, 0, 'Libyan Arab Jamahiriya', 0),
(123, 0, 0, 'Saint Lucia', 0),
(124, 0, 0, 'Liechtenstein', 0),
(125, 0, 0, 'Sri Lanka', 0),
(126, 0, 0, 'Lesotho', 0),
(127, 0, 0, 'Lithuania', 0),
(128, 0, 0, 'Luxembourg', 0),
(129, 0, 0, 'Latvia', 0),
(130, 0, 0, 'Macao', 0),
(131, 0, 0, 'Morocco', 0),
(132, 0, 0, 'Monaco', 0),
(133, 0, 0, 'Moldova', 0),
(134, 0, 0, 'Madagascar', 0),
(135, 0, 0, 'Maldives', 0),
(136, 0, 0, 'Mexico', 0),
(137, 0, 0, 'Marshall Islands', 0),
(138, 0, 0, 'Macedonia', 0),
(139, 0, 0, 'Mali', 0),
(140, 0, 0, 'Malta', 0),
(141, 0, 0, 'Myanmar', 0),
(142, 0, 0, 'Mongolia', 0),
(143, 0, 0, 'Northern Mariana Islands', 0),
(144, 0, 0, 'Mozambique', 0),
(145, 0, 0, 'Mauritania', 0),
(146, 0, 0, 'Montserrat', 0),
(147, 0, 0, 'Martinique', 0),
(148, 0, 0, 'Mauritius', 0),
(149, 0, 0, 'Malawi', 0),
(150, 0, 0, 'Malaysia', 0),
(151, 0, 0, 'Mayotte', 0),
(152, 0, 0, 'Namibia', 0),
(153, 0, 0, 'New Caledonia', 0),
(154, 0, 0, 'Niger', 0),
(155, 0, 0, 'Norfolk Island', 0),
(156, 0, 0, 'Nigeria', 0),
(157, 0, 0, 'Nicaragua', 0),
(158, 0, 0, 'Niue', 0),
(159, 0, 0, 'Netherlands', 0),
(160, 0, 0, 'Norway', 0),
(161, 0, 0, 'Nepal', 0),
(162, 0, 0, 'Nauru', 0),
(163, 0, 0, 'New Zealand', 0),
(164, 0, 0, 'Oman', 0),
(165, 0, 0, 'Pakistan', 0),
(166, 0, 0, 'Panama', 0),
(167, 0, 0, 'Pitcairn', 0),
(168, 0, 0, 'Peru', 0),
(169, 0, 0, 'Philippines', 0),
(170, 0, 0, 'Palau', 0),
(171, 0, 0, 'Papua New Guinea', 0),
(172, 0, 0, 'Poland', 0),
(173, 0, 0, 'Puerto Rico', 0),
(174, 0, 0, 'North Korea', 0),
(175, 0, 0, 'Portugal', 0),
(176, 0, 0, 'Paraguay', 0),
(177, 0, 0, 'Palestine', 0),
(178, 0, 0, 'French Polynesia', 0),
(179, 0, 0, 'Qatar', 0),
(180, 0, 0, 'RÃƒÂ©union', 0),
(181, 0, 0, 'Romania', 0),
(182, 0, 0, 'Russian Federation', 0),
(183, 0, 0, 'Rwanda', 0),
(184, 0, 0, 'Saudi Arabia', 0),
(185, 0, 0, 'Sudan', 0),
(186, 0, 0, 'Senegal', 0),
(187, 0, 0, 'Singapore', 0),
(188, 0, 0, 'South Georgia And The South Sa', 0),
(189, 0, 0, 'Saint Helena', 0),
(190, 0, 0, 'Svalbard And Jan Mayen', 0),
(191, 0, 0, 'Solomon Islands', 0),
(192, 0, 0, 'Sierra Leone', 0),
(193, 0, 0, 'El Salvador', 0),
(194, 0, 0, 'San Marino', 0),
(195, 0, 0, 'Somalia', 0),
(196, 0, 0, 'Saint Pierre And Miquelon', 0),
(197, 0, 0, 'Sao Tome And Principe', 0),
(198, 0, 0, 'Suriname', 0),
(199, 0, 0, 'Slovakia', 0),
(200, 0, 0, 'Slovenia', 0),
(201, 0, 0, 'Sweden', 0),
(202, 0, 0, 'Swaziland', 0),
(203, 0, 0, 'Seychelles', 0),
(204, 0, 0, 'Syria', 0),
(205, 0, 0, 'Turks And Caicos Islands', 0),
(206, 0, 0, 'Chad', 0),
(207, 0, 0, 'Togo', 0),
(208, 0, 0, 'Thailand', 0),
(209, 0, 0, 'Tajikistan', 0),
(210, 0, 0, 'Tokelau', 0),
(211, 0, 0, 'Turkmenistan', 0),
(212, 0, 0, 'East Timor', 0),
(213, 0, 0, 'Tonga', 0),
(214, 0, 0, 'Trinidad And Tobago', 0),
(215, 0, 0, 'Tunisia', 0),
(216, 0, 0, 'Turkey', 0),
(217, 0, 0, 'Tuvalu', 0),
(218, 0, 0, 'Taiwan', 0),
(219, 0, 0, 'Tanzania', 0),
(220, 0, 0, 'Uganda', 0),
(221, 0, 0, 'Ukraine', 0),
(222, 0, 0, 'United States Minor Outlying I', 0),
(223, 0, 0, 'Uruguay', 0),
(224, 0, 0, 'United States', 0),
(225, 0, 0, 'Uzbekistan', 0),
(226, 0, 0, 'Holy See (Vatican City State)', 0),
(227, 0, 0, 'Saint Vincent And The Grenadin', 0),
(228, 0, 0, 'Venezuela', 0),
(229, 0, 0, 'Virgin Islands, British', 0),
(230, 0, 0, 'Virgin Islands, U.S.', 0),
(231, 0, 0, 'Vietnam', 0),
(232, 0, 0, 'Vanuatu', 0),
(233, 0, 0, 'Wallis And Futuna', 0),
(234, 0, 0, 'Samoa', 0),
(235, 0, 0, 'Yemen', 0),
(236, 0, 0, 'Yugoslavia', 0),
(237, 0, 0, 'South Africa', 0),
(238, 0, 0, 'Zambia', 0),
(239, 0, 0, 'Zimbabwe', 0),
(240, 1, 0, 'Ã‚â‚¬â€œ', 1),
(241, 1, 0, 'Balkh', 2),
(242, 1, 0, 'Herat', 2),
(243, 1, 0, 'Kabol', 2),
(244, 1, 0, 'Qandahar', 2),
(245, 1, 0, 'Benguela', 3),
(246, 1, 0, 'Huambo', 3),
(247, 1, 0, 'Luanda', 3),
(248, 1, 0, 'Namibe', 3),
(249, 1, 0, 'Ã‚â‚¬â€œ', 4),
(250, 1, 0, 'Tirana', 5),
(251, 1, 0, 'Andorra La Vella', 6),
(252, 1, 0, 'CuraÃƒÂ§ao', 7),
(253, 1, 0, 'Abu Dhabi', 8),
(254, 1, 0, 'Ajman', 8),
(255, 1, 0, 'Dubai', 8),
(256, 1, 0, 'Sharja', 8),
(257, 1, 0, 'Buenos Aires', 9),
(258, 1, 0, 'Catamarca', 9),
(259, 1, 0, 'CÃƒÂ³rdoba', 9),
(260, 1, 0, 'Chaco', 9),
(261, 1, 0, 'Chubut', 9),
(262, 1, 0, 'Corrientes', 9),
(263, 1, 0, 'Distrito Federal', 9),
(264, 1, 0, 'Entre Rios', 9),
(265, 1, 0, 'Formosa', 9),
(266, 1, 0, 'Jujuy', 9),
(267, 1, 0, 'La Rioja', 9),
(268, 1, 0, 'Mendoza', 9),
(269, 1, 0, 'Misiones', 9),
(270, 1, 0, 'NeuquÃƒÂ©n', 9),
(271, 1, 0, 'Salta', 9),
(272, 1, 0, 'San Juan', 9),
(273, 1, 0, 'San Luis', 9),
(274, 1, 0, 'Santa FÃƒÂ©', 9),
(275, 1, 0, 'Santiago Del Estero', 9),
(276, 1, 0, 'TucumÃƒÂ¡n', 9),
(277, 1, 0, 'Lori', 10),
(278, 1, 0, 'Yerevan', 10),
(279, 1, 0, 'Ã…Â irak', 10),
(280, 1, 0, 'Tutuila', 11),
(281, 1, 0, 'St John', 14),
(282, 1, 0, 'Capital Region', 15),
(283, 1, 0, 'New South Wales', 15),
(284, 1, 0, 'Queensland', 15),
(285, 1, 0, 'South Australia', 15),
(286, 1, 0, 'Tasmania', 15),
(287, 1, 0, 'Victoria', 15),
(288, 1, 0, 'West Australia', 15),
(289, 1, 0, 'KÃƒÂ¤rnten', 16),
(290, 1, 0, 'North Austria', 16),
(291, 1, 0, 'Salzburg', 16),
(292, 1, 0, 'Steiermark', 16),
(293, 1, 0, 'Tiroli', 16),
(294, 1, 0, 'Wien', 16),
(295, 1, 0, 'Baki', 17),
(296, 1, 0, 'GÃƒÂ¤ncÃƒÂ¤', 17),
(297, 1, 0, 'MingÃƒÂ¤ÃƒÂ§evir', 17),
(298, 1, 0, 'Sumqayit', 17),
(299, 1, 0, 'Bujumbura', 18),
(300, 1, 0, 'Antwerpen', 19),
(301, 1, 0, 'Bryssel', 19),
(302, 1, 0, 'East Flanderi', 19),
(303, 1, 0, 'Hainaut', 19),
(304, 1, 0, 'LiÃƒÂ¨ge', 19),
(305, 1, 0, 'Namur', 19),
(306, 1, 0, 'West Flanderi', 19),
(307, 1, 0, 'Atacora', 20),
(308, 1, 0, 'Atlantique', 20),
(309, 1, 0, 'Borgou', 20),
(310, 1, 0, 'OuÃƒÂ©mÃƒÂ©', 20),
(311, 1, 0, 'BoulkiemdÃƒÂ©', 21),
(312, 1, 0, 'Houet', 21),
(313, 1, 0, 'Kadiogo', 21),
(314, 1, 0, 'Barisal', 22),
(315, 1, 0, 'Chittagong', 22),
(316, 1, 0, 'Dhaka', 22),
(317, 1, 0, 'Khulna', 22),
(318, 1, 0, 'Rajshahi', 22),
(319, 1, 0, 'Sylhet', 22),
(320, 1, 0, 'Burgas', 23),
(321, 1, 0, 'Grad Sofija', 23),
(322, 1, 0, 'Haskovo', 23),
(323, 1, 0, 'Lovec', 23),
(324, 1, 0, 'Plovdiv', 23),
(325, 1, 0, 'Ruse', 23),
(326, 1, 0, 'Varna', 23),
(327, 1, 0, 'Al-Manama', 24),
(328, 1, 0, 'New Providence', 25),
(329, 1, 0, 'Federaatio', 26),
(330, 1, 0, 'Republika Srpska', 26),
(331, 1, 0, 'Brest', 27),
(332, 1, 0, 'Gomel', 27),
(333, 1, 0, 'Grodno', 27),
(334, 1, 0, 'Horad Minsk', 27),
(335, 1, 0, 'Minsk', 27),
(336, 1, 0, 'Mogiljov', 27),
(337, 1, 0, 'Vitebsk', 27),
(338, 1, 0, 'Belize City', 28),
(339, 1, 0, 'Cayo', 28),
(340, 1, 0, 'Hamilton', 29),
(341, 1, 0, 'Saint GeorgeÃ‚Â´s', 29),
(342, 1, 0, 'Chuquisaca', 30),
(343, 1, 0, 'Cochabamba', 30),
(344, 1, 0, 'La Paz', 30),
(345, 1, 0, 'Oruro', 30),
(346, 1, 0, 'PotosÃƒÂ­', 30),
(347, 1, 0, 'Santa Cruz', 30),
(348, 1, 0, 'Tarija', 30),
(349, 1, 0, 'Acre', 31),
(350, 1, 0, 'Alagoas', 31),
(351, 1, 0, 'AmapÃƒÂ¡', 31),
(352, 1, 0, 'Amazonas', 31),
(353, 1, 0, 'Bahia', 31),
(354, 1, 0, 'CearÃƒÂ¡', 31),
(355, 1, 0, 'Distrito Federal', 31),
(356, 1, 0, 'EspÃƒÂ­rito Santo', 31),
(357, 1, 0, 'GoiÃƒÂ¡s', 31),
(358, 1, 0, 'MaranhÃƒÂ£o', 31),
(359, 1, 0, 'Mato Grosso', 31),
(360, 1, 0, 'Mato Grosso Do Sul', 31),
(361, 1, 0, 'Minas Gerais', 31),
(362, 1, 0, 'ParaÃƒÂ­ba', 31),
(363, 1, 0, 'ParanÃƒÂ¡', 31),
(364, 1, 0, 'ParÃƒÂ¡', 31),
(365, 1, 0, 'Pernambuco', 31),
(366, 1, 0, 'PiauÃƒÂ­', 31),
(367, 1, 0, 'Rio De Janeiro', 31),
(368, 1, 0, 'Rio Grande Do Norte', 31),
(369, 1, 0, 'Rio Grande Do Sul', 31),
(370, 1, 0, 'RondÃƒÂ´nia', 31),
(371, 1, 0, 'Roraima', 31),
(372, 1, 0, 'Santa Catarina', 31),
(373, 1, 0, 'SÃƒÂ£o Paulo', 31),
(374, 1, 0, 'Sergipe', 31),
(375, 1, 0, 'Tocantins', 31),
(376, 1, 0, 'St Michael', 32),
(377, 1, 0, 'Brunei And Muara', 33),
(378, 1, 0, 'Thimphu', 34),
(379, 1, 0, 'Francistown', 36),
(380, 1, 0, 'Gaborone', 36),
(381, 1, 0, 'Bangui', 37),
(382, 1, 0, 'Alberta', 38),
(383, 1, 0, 'British Colombia', 38),
(384, 1, 0, 'Manitoba', 38),
(385, 1, 0, 'Newfoundland', 38),
(386, 1, 0, 'Nova Scotia', 38),
(387, 1, 0, 'Ontario', 38),
(388, 1, 0, 'QuÃƒÂ©bec', 38),
(389, 1, 0, 'Saskatchewan', 38),
(390, 1, 0, 'Home Island', 39),
(391, 1, 0, 'West Island', 39),
(392, 1, 0, 'Basel-Stadt', 40),
(393, 1, 0, 'Bern', 40),
(394, 1, 0, 'Geneve', 40),
(395, 1, 0, 'Vaud', 40),
(396, 1, 0, 'ZÃƒÂ¼rich', 40),
(397, 1, 0, 'Antofagasta', 41),
(398, 1, 0, 'Atacama', 41),
(399, 1, 0, 'BÃƒÂ­obÃƒÂ­o', 41),
(400, 1, 0, 'Coquimbo', 41),
(401, 1, 0, 'La AraucanÃƒÂ­a', 41),
(402, 1, 0, 'Los Lagos', 41),
(403, 1, 0, 'Magallanes', 41),
(404, 1, 0, 'Maule', 41),
(405, 1, 0, 'OÃ‚Â´Higgins', 41),
(406, 1, 0, 'Santiago', 41),
(407, 1, 0, 'TarapacÃƒÂ¡', 41),
(408, 1, 0, 'ValparaÃƒÂ­so', 41),
(409, 1, 0, 'Anhui', 42),
(410, 1, 0, 'Chongqing', 42),
(411, 1, 0, 'Fujian', 42),
(412, 1, 0, 'Gansu', 42),
(413, 1, 0, 'Guangdong', 42),
(414, 1, 0, 'Guangxi', 42),
(415, 1, 0, 'Guizhou', 42),
(416, 1, 0, 'Hainan', 42),
(417, 1, 0, 'Hebei', 42),
(418, 1, 0, 'Heilongjiang', 42),
(419, 1, 0, 'Henan', 42),
(420, 1, 0, 'Hubei', 42),
(421, 1, 0, 'Hunan', 42),
(422, 1, 0, 'Inner Mongolia', 42),
(423, 1, 0, 'Jiangsu', 42),
(424, 1, 0, 'Jiangxi', 42),
(425, 1, 0, 'Jilin', 42),
(426, 1, 0, 'Liaoning', 42),
(427, 1, 0, 'Ningxia', 42),
(428, 1, 0, 'Peking', 42),
(429, 1, 0, 'Qinghai', 42),
(430, 1, 0, 'Shaanxi', 42),
(431, 1, 0, 'Shandong', 42),
(432, 1, 0, 'Shanghai', 42),
(433, 1, 0, 'Shanxi', 42),
(434, 1, 0, 'Sichuan', 42),
(435, 1, 0, 'Tianjin', 42),
(436, 1, 0, 'Tibet', 42),
(437, 1, 0, 'Xinxiang', 42),
(438, 1, 0, 'Yunnan', 42),
(439, 1, 0, 'Zhejiang', 42),
(440, 1, 0, 'Abidjan', 43),
(441, 1, 0, 'BouakÃƒÂ©', 43),
(442, 1, 0, 'Daloa', 43),
(443, 1, 0, 'Korhogo', 43),
(444, 1, 0, 'Yamoussoukro', 43),
(445, 1, 0, 'Centre', 44),
(446, 1, 0, 'ExtrÃƒÂªme-Nord', 44),
(447, 1, 0, 'Littoral', 44),
(448, 1, 0, 'Nord', 44),
(449, 1, 0, 'Nord-Ouest', 44),
(450, 1, 0, 'Ouest', 44),
(451, 1, 0, 'Bandundu', 0),
(452, 1, 0, 'Bas-ZaÃƒÂ¯re', 0),
(453, 1, 0, 'East Kasai', 0),
(454, 1, 0, 'Equateur', 0),
(455, 1, 0, 'Haute-ZaÃƒÂ¯re', 0),
(456, 1, 0, 'Kinshasa', 0),
(457, 1, 0, 'North Kivu', 0),
(458, 1, 0, 'Shaba', 0),
(459, 1, 0, 'South Kivu', 0),
(460, 1, 0, 'West Kasai', 0),
(461, 1, 0, 'Brazzaville', 46),
(462, 1, 0, 'Kouilou', 46),
(463, 1, 0, 'Rarotonga', 47),
(464, 1, 0, 'Antioquia', 48),
(465, 1, 0, 'AtlÃƒÂ¡ntico', 48),
(466, 1, 0, 'BolÃƒÂ­var', 48),
(467, 1, 0, 'BoyacÃƒÂ¡', 48),
(468, 1, 0, 'Caldas', 48),
(469, 1, 0, 'CaquetÃƒÂ¡', 48),
(470, 1, 0, 'Cauca', 48),
(471, 1, 0, 'CÃƒÂ³rdoba', 48),
(472, 1, 0, 'Cesar', 48),
(473, 1, 0, 'Cundinamarca', 48),
(474, 1, 0, 'Huila', 48),
(475, 1, 0, 'La Guajira', 48),
(476, 1, 0, 'Magdalena', 48),
(477, 1, 0, 'Meta', 48),
(478, 1, 0, 'NariÃƒÂ±o', 48),
(479, 1, 0, 'Norte De Santander', 48),
(480, 1, 0, 'QuindÃƒÂ­o', 48),
(481, 1, 0, 'Risaralda', 48),
(482, 1, 0, 'SantafÃƒÂ© De BogotÃƒÂ¡', 48),
(483, 1, 0, 'Santander', 48),
(484, 1, 0, 'Sucre', 48),
(485, 1, 0, 'Tolima', 48),
(486, 1, 0, 'Valle', 48),
(487, 1, 0, 'Njazidja', 49),
(488, 1, 0, 'SÃƒÂ£o Tiago', 50),
(489, 1, 0, 'San JosÃƒÂ©', 51),
(490, 1, 0, 'CamagÃƒÂ¼ey', 52),
(491, 1, 0, 'Ciego De Ãƒ?vila', 52),
(492, 1, 0, 'Cienfuegos', 52),
(493, 1, 0, 'Granma', 52),
(494, 1, 0, 'GuantÃƒÂ¡namo', 52),
(495, 1, 0, 'HolguÃƒÂ­n', 52),
(496, 1, 0, 'La Habana', 52),
(497, 1, 0, 'Las Tunas', 52),
(498, 1, 0, 'Matanzas', 52),
(499, 1, 0, 'Pinar Del RÃƒÂ­o', 52),
(500, 1, 0, 'Sancti-SpÃƒÂ­ritus', 52),
(501, 1, 0, 'Santiago De Cuba', 52),
(502, 1, 0, 'Villa Clara', 52),
(503, 1, 0, 'Ã‚â‚¬â€œ', 53),
(504, 1, 0, 'Grand Cayman', 54),
(505, 1, 0, 'Limassol', 55),
(506, 1, 0, 'Nicosia', 55),
(507, 1, 0, 'HlavnÃƒÂ­ Mesto Praha', 56),
(508, 1, 0, 'JiznÃƒÂ­ Cechy', 56),
(509, 1, 0, 'JiznÃƒÂ­ Morava', 56),
(510, 1, 0, 'SevernÃƒÂ­ Cechy', 56),
(511, 1, 0, 'SevernÃƒÂ­ Morava', 56),
(512, 1, 0, 'VÃƒÂ½chodnÃƒÂ­ Cechy', 56),
(513, 1, 0, 'ZapadnÃƒÂ­ Cechy', 56),
(514, 1, 0, 'Anhalt Sachsen', 57),
(515, 1, 0, 'Baden-WÃƒÂ¼rttemberg', 57),
(516, 1, 0, 'Baijeri', 57),
(517, 1, 0, 'Berliini', 57),
(518, 1, 0, 'Brandenburg', 57),
(519, 1, 0, 'Bremen', 57),
(520, 1, 0, 'Hamburg', 57),
(521, 1, 0, 'Hessen', 57),
(522, 1, 0, 'Mecklenburg-Vorpomme', 57),
(523, 1, 0, 'Niedersachsen', 57),
(524, 1, 0, 'Nordrhein-Westfalen', 57),
(525, 1, 0, 'Rheinland-Pfalz', 57),
(526, 1, 0, 'Saarland', 57),
(527, 1, 0, 'Saksi', 57),
(528, 1, 0, 'Schleswig-Holstein', 57),
(529, 1, 0, 'ThÃƒÂ¼ringen', 57),
(530, 1, 0, 'Djibouti', 58),
(531, 1, 0, 'St George', 59),
(532, 1, 0, 'Ãƒâ€¦rhus', 60),
(533, 1, 0, 'Frederiksberg', 60),
(534, 1, 0, 'Fyn', 60),
(535, 1, 0, 'KÃƒÂ¸benhavn', 60),
(536, 1, 0, 'Nordjylland', 60),
(537, 1, 0, 'Distrito Nacional', 61),
(538, 1, 0, 'Duarte', 61),
(539, 1, 0, 'La Romana', 61),
(540, 1, 0, 'Puerto Plata', 61),
(541, 1, 0, 'San Pedro De MacorÃƒÂ­', 61),
(542, 1, 0, 'Santiago', 61),
(543, 1, 0, 'Alger', 62),
(544, 1, 0, 'Annaba', 62),
(545, 1, 0, 'Batna', 62),
(546, 1, 0, 'BÃƒÂ©char', 62),
(547, 1, 0, 'BÃƒÂ©jaÃƒÂ¯a', 62),
(548, 1, 0, 'Biskra', 62),
(549, 1, 0, 'Blida', 62),
(550, 1, 0, 'Chlef', 62),
(551, 1, 0, 'Constantine', 62),
(552, 1, 0, 'GhardaÃƒÂ¯a', 62),
(553, 1, 0, 'Mostaganem', 62),
(554, 1, 0, 'Oran', 62),
(555, 1, 0, 'SÃƒÂ©tif', 62),
(556, 1, 0, 'Sidi Bel AbbÃƒÂ¨s', 62),
(557, 1, 0, 'Skikda', 62),
(558, 1, 0, 'TÃƒÂ©bessa', 62),
(559, 1, 0, 'Tiaret', 62),
(560, 1, 0, 'Tlemcen', 62),
(561, 1, 0, 'Azuay', 63),
(562, 1, 0, 'Chimborazo', 63),
(563, 1, 0, 'El Oro', 63),
(564, 1, 0, 'Esmeraldas', 63),
(565, 1, 0, 'Guayas', 63),
(566, 1, 0, 'Imbabura', 63),
(567, 1, 0, 'Loja', 63),
(568, 1, 0, 'Los RÃƒÂ­os', 63),
(569, 1, 0, 'ManabÃƒÂ­', 63),
(570, 1, 0, 'Pichincha', 63),
(571, 1, 0, 'Tungurahua', 63),
(572, 1, 0, 'Al-Buhayra', 64),
(573, 1, 0, 'Al-Daqahliya', 64),
(574, 1, 0, 'Al-Faiyum', 64),
(575, 1, 0, 'Al-Gharbiya', 64),
(576, 1, 0, 'Al-Minufiya', 64),
(577, 1, 0, 'Al-Minya', 64),
(578, 1, 0, 'Al-Qalyubiya', 64),
(579, 1, 0, 'Al-Sharqiya', 64),
(580, 1, 0, 'Aleksandria', 64),
(581, 1, 0, 'Assuan', 64),
(582, 1, 0, 'Asyut', 64),
(583, 1, 0, 'Bani Suwayf', 64),
(584, 1, 0, 'Giza', 64),
(585, 1, 0, 'Ismailia', 64),
(586, 1, 0, 'Kafr Al-Shaykh', 64),
(587, 1, 0, 'Kairo', 64),
(588, 1, 0, 'Luxor', 64),
(589, 1, 0, 'Port Said', 64),
(590, 1, 0, 'Qina', 64),
(591, 1, 0, 'Sawhaj', 64),
(592, 1, 0, 'Shamal Sina', 64),
(593, 1, 0, 'Suez', 64),
(594, 1, 0, 'Maekel', 65),
(595, 1, 0, 'El-AaiÃƒÂºn', 66),
(596, 1, 0, 'Andalusia', 67),
(597, 1, 0, 'Aragonia', 67),
(598, 1, 0, 'Asturia', 67),
(599, 1, 0, 'Balears', 67),
(600, 1, 0, 'Baskimaa', 67),
(601, 1, 0, 'Canary Islands', 67),
(602, 1, 0, 'Cantabria', 67),
(603, 1, 0, 'Castilla And LeÃƒÂ³n', 67),
(604, 1, 0, 'Extremadura', 67),
(605, 1, 0, 'Galicia', 67),
(606, 1, 0, 'Kastilia-La Mancha', 67),
(607, 1, 0, 'Katalonia', 67),
(608, 1, 0, 'La Rioja', 67),
(609, 1, 0, 'Madrid', 67),
(610, 1, 0, 'Murcia', 67),
(611, 1, 0, 'Navarra', 67),
(612, 1, 0, 'Valencia', 67),
(613, 1, 0, 'Harjumaa', 68),
(614, 1, 0, 'Tartumaa', 68),
(615, 1, 0, 'Addis Abeba', 69),
(616, 1, 0, 'Amhara', 69),
(617, 1, 0, 'Dire Dawa', 69),
(618, 1, 0, 'Oromia', 69),
(619, 1, 0, 'Tigray', 69),
(620, 1, 0, 'Newmaa', 70),
(621, 1, 0, 'PÃƒÂ¤ijÃƒÂ¤t-HÃƒÂ¤me', 70),
(622, 1, 0, 'Pirkanmaa', 70),
(623, 1, 0, 'Pohjois-Pohjanmaa', 70),
(624, 1, 0, 'Varsinais-Suomi', 70),
(625, 1, 0, 'Central', 71),
(626, 1, 0, 'East Falkland', 72),
(627, 1, 0, 'Alsace', 73),
(628, 1, 0, 'Aquitaine', 73),
(629, 1, 0, 'Auvergne', 73),
(630, 1, 0, 'ÃƒÅ½le-de-France', 73),
(631, 1, 0, 'Basse-Normandie', 73),
(632, 1, 0, 'Bourgogne', 73),
(633, 1, 0, 'Bretagne', 73),
(634, 1, 0, 'Centre', 73),
(635, 1, 0, 'Champagne-Ardenne', 73),
(636, 1, 0, 'Franche-ComtÃƒÂ©', 73),
(637, 1, 0, 'Haute-Normandie', 73),
(638, 1, 0, 'Languedoc-Roussillon', 73),
(639, 1, 0, 'Limousin', 73),
(640, 1, 0, 'Lorraine', 73),
(641, 1, 0, 'Midi-PyrÃƒÂ©nÃƒÂ©es', 73),
(642, 1, 0, 'Nord-Pas-de-Calais', 73),
(643, 1, 0, 'Pays De La Loire', 73),
(644, 1, 0, 'Picardie', 73),
(645, 1, 0, 'Provence-Alpes-CÃƒÂ´te', 73),
(646, 1, 0, 'RhÃƒÂ´ne-Alpes', 73),
(647, 1, 0, 'Streymoyar', 74),
(648, 1, 0, 'Chuuk', 0),
(649, 1, 0, 'Pohnpei', 0),
(650, 1, 0, 'Estuaire', 76),
(651, 1, 0, 'Ã‚â‚¬â€œ', 77),
(652, 1, 0, 'England', 77),
(653, 1, 0, 'Jersey', 77),
(654, 1, 0, 'North Ireland', 77),
(655, 1, 0, 'Scotland', 77),
(656, 1, 0, 'Wales', 77),
(657, 1, 0, 'Abhasia [Aphazeti]', 78),
(658, 1, 0, 'Adzaria [AtÃ…Â¡ara]', 78),
(659, 1, 0, 'Imereti', 78),
(660, 1, 0, 'Kvemo Kartli', 78),
(661, 1, 0, 'Tbilisi', 78),
(662, 1, 0, 'Ashanti', 79),
(663, 1, 0, 'Greater Accra', 79),
(664, 1, 0, 'Northern', 79),
(665, 1, 0, 'Western', 79),
(666, 1, 0, 'Ã‚â‚¬â€œ', 80),
(667, 1, 0, 'Conakry', 81),
(668, 1, 0, 'Basse-Terre', 82),
(669, 1, 0, 'Grande-Terre', 82),
(670, 1, 0, 'Banjul', 83),
(671, 1, 0, 'Kombo St Mary', 83),
(672, 1, 0, 'Bissau', 84),
(673, 1, 0, 'Bioko', 85),
(674, 1, 0, 'Attika', 86),
(675, 1, 0, 'Central Macedonia', 86),
(676, 1, 0, 'Crete', 86),
(677, 1, 0, 'Thessalia', 86),
(678, 1, 0, 'West Greece', 86),
(679, 1, 0, 'St George', 87),
(680, 1, 0, 'Kitaa', 88),
(681, 1, 0, 'Guatemala', 89),
(682, 1, 0, 'Quetzaltenango', 89),
(683, 1, 0, 'Cayenne', 90),
(684, 1, 0, 'Ã‚â‚¬â€œ', 91),
(685, 1, 0, 'Georgetown', 92),
(686, 1, 0, 'Hongkong', 93),
(687, 1, 0, 'Kowloon And New Kowl', 93),
(688, 1, 0, 'AtlÃƒÂ¡ntida', 95),
(689, 1, 0, 'CortÃƒÂ©s', 95),
(690, 1, 0, 'Distrito Central', 95),
(691, 1, 0, 'Grad Zagreb', 96),
(692, 1, 0, 'Osijek-Baranja', 96),
(693, 1, 0, 'Primorje-Gorski Kota', 96),
(694, 1, 0, 'Split-Dalmatia', 96),
(695, 1, 0, 'Nord', 97),
(696, 1, 0, 'Ouest', 97),
(697, 1, 0, 'Baranya', 98),
(698, 1, 0, 'BÃƒÂ¡cs-Kiskun', 98),
(699, 1, 0, 'Borsod-AbaÃƒÂºj-ZemplÃƒ', 98),
(700, 1, 0, 'Budapest', 98),
(701, 1, 0, 'CsongrÃƒÂ¡d', 98),
(702, 1, 0, 'FejÃƒÂ©r', 98),
(703, 1, 0, 'GyÃƒÂ¶r-Moson-Sopron', 98),
(704, 1, 0, 'HajdÃƒÂº-Bihar', 98),
(705, 1, 0, 'Szabolcs-SzatmÃƒÂ¡r-Be', 98),
(706, 1, 0, 'Aceh', 99),
(707, 1, 0, 'Bali', 99),
(708, 1, 0, 'Bengkulu', 99),
(709, 1, 0, 'Central Java', 99),
(710, 1, 0, 'East Java', 99),
(711, 1, 0, 'Jakarta Raya', 99),
(712, 1, 0, 'Jambi', 99),
(713, 1, 0, 'Kalimantan Barat', 99),
(714, 1, 0, 'Kalimantan Selatan', 99),
(715, 1, 0, 'Kalimantan Tengah', 99),
(716, 1, 0, 'Kalimantan Timur', 99),
(717, 1, 0, 'Lampung', 99),
(718, 1, 0, 'Molukit', 99),
(719, 1, 0, 'Nusa Tenggara Barat', 99),
(720, 1, 0, 'Nusa Tenggara Timur', 99),
(721, 1, 0, 'Riau', 99),
(722, 1, 0, 'Sulawesi Selatan', 99),
(723, 1, 0, 'Sulawesi Tengah', 99),
(724, 1, 0, 'Sulawesi Tenggara', 99),
(725, 1, 0, 'Sulawesi Utara', 99),
(726, 1, 0, 'Sumatera Barat', 99),
(727, 1, 0, 'Sumatera Selatan', 99),
(728, 1, 0, 'Sumatera Utara', 99),
(729, 1, 0, 'West Irian', 99),
(730, 1, 0, 'West Java', 99),
(731, 1, 0, 'Yogyakarta', 99),
(732, 1, 0, 'Andhra Pradesh', 100),
(733, 1, 0, 'Assam', 100),
(734, 1, 0, 'Bihar', 100),
(735, 1, 0, 'Chandigarh', 100),
(736, 1, 0, 'Chhatisgarh', 100),
(737, 1, 0, 'Delhi', 100),
(738, 1, 0, 'Gujarat', 100),
(739, 1, 0, 'Haryana', 100),
(740, 1, 0, 'Jammu And Kashmir', 100),
(741, 1, 0, 'Jharkhand', 100),
(742, 1, 0, 'Karnataka', 100),
(743, 1, 0, 'Kerala', 100),
(744, 1, 0, 'Madhya Pradesh', 100),
(745, 1, 0, 'Maharashtra', 100),
(746, 1, 0, 'Manipur', 100),
(747, 1, 0, 'Meghalaya', 100),
(748, 1, 0, 'Mizoram', 100),
(749, 1, 0, 'Orissa', 100),
(750, 1, 0, 'Pondicherry', 100),
(751, 1, 0, 'Punjab', 100),
(752, 1, 0, 'Rajasthan', 100),
(753, 1, 0, 'Tamil Nadu', 100),
(754, 1, 0, 'Tripura', 100),
(755, 1, 0, 'Uttar Pradesh', 100),
(756, 1, 0, 'Uttaranchal', 100),
(757, 1, 0, 'West Bengali', 100),
(758, 1, 0, 'Leinster', 102),
(759, 1, 0, 'Munster', 102),
(760, 1, 0, 'Ardebil', 103),
(761, 1, 0, 'Bushehr', 103),
(762, 1, 0, 'Chaharmahal Va Bakht', 103),
(763, 1, 0, 'East Azerbaidzan', 103),
(764, 1, 0, 'Esfahan', 103),
(765, 1, 0, 'Fars', 103),
(766, 1, 0, 'Gilan', 103),
(767, 1, 0, 'Golestan', 103),
(768, 1, 0, 'Hamadan', 103),
(769, 1, 0, 'Hormozgan', 103),
(770, 1, 0, 'Ilam', 103),
(771, 1, 0, 'Kerman', 103),
(772, 1, 0, 'Kermanshah', 103),
(773, 1, 0, 'Khorasan', 103),
(774, 1, 0, 'Khuzestan', 103),
(775, 1, 0, 'Kordestan', 103),
(776, 1, 0, 'Lorestan', 103),
(777, 1, 0, 'Markazi', 103),
(778, 1, 0, 'Mazandaran', 103),
(779, 1, 0, 'Qazvin', 103),
(780, 1, 0, 'Qom', 103),
(781, 1, 0, 'Semnan', 103),
(782, 1, 0, 'Sistan Va Baluchesta', 103),
(783, 1, 0, 'Teheran', 103),
(784, 1, 0, 'West Azerbaidzan', 103),
(785, 1, 0, 'Yazd', 103),
(786, 1, 0, 'Zanjan', 103),
(787, 1, 0, 'Al-Anbar', 104),
(788, 1, 0, 'Al-Najaf', 104),
(789, 1, 0, 'Al-Qadisiya', 104),
(790, 1, 0, 'Al-Sulaymaniya', 104),
(791, 1, 0, 'Al-Tamim', 104),
(792, 1, 0, 'Babil', 104),
(793, 1, 0, 'Baghdad', 104),
(794, 1, 0, 'Basra', 104),
(795, 1, 0, 'DhiQar', 104),
(796, 1, 0, 'Diyala', 104),
(797, 1, 0, 'Irbil', 104),
(798, 1, 0, 'Karbala', 104),
(799, 1, 0, 'Maysan', 104),
(800, 1, 0, 'Ninawa', 104),
(801, 1, 0, 'Wasit', 104),
(802, 1, 0, 'HÃƒÂ¶fuÃƒÂ°borgarsvÃƒÂ¦ÃƒÂ°i', 105),
(803, 1, 0, 'Ha Darom', 106),
(804, 1, 0, 'Ha Merkaz', 106),
(805, 1, 0, 'Haifa', 106),
(806, 1, 0, 'Jerusalem', 106),
(807, 1, 0, 'Tel Aviv', 106),
(808, 1, 0, 'Abruzzit', 107),
(809, 1, 0, 'Apulia', 107),
(810, 1, 0, 'Calabria', 107),
(811, 1, 0, 'Campania', 107),
(812, 1, 0, 'Emilia-Romagna', 107),
(813, 1, 0, 'Friuli-Venezia Giuli', 107),
(814, 1, 0, 'Latium', 107),
(815, 1, 0, 'Liguria', 107),
(816, 1, 0, 'Lombardia', 107),
(817, 1, 0, 'Marche', 107),
(818, 1, 0, 'Piemonte', 107),
(819, 1, 0, 'Sardinia', 107),
(820, 1, 0, 'Sisilia', 107),
(821, 1, 0, 'Toscana', 107),
(822, 1, 0, 'Trentino-Alto Adige', 107),
(823, 1, 0, 'Umbria', 107),
(824, 1, 0, 'Veneto', 107),
(825, 1, 0, 'St. Andrew', 108),
(826, 1, 0, 'St. Catherine', 108),
(827, 1, 0, 'Al-Zarqa', 109),
(828, 1, 0, 'Amman', 109),
(829, 1, 0, 'Irbid', 109),
(830, 1, 0, 'Aichi', 110),
(831, 1, 0, 'Akita', 110),
(832, 1, 0, 'Aomori', 110),
(833, 1, 0, 'Chiba', 110),
(834, 1, 0, 'Ehime', 110),
(835, 1, 0, 'Fukui', 110),
(836, 1, 0, 'Fukuoka', 110),
(837, 1, 0, 'Fukushima', 110),
(838, 1, 0, 'Gifu', 110),
(839, 1, 0, 'Gumma', 110),
(840, 1, 0, 'Hiroshima', 110),
(841, 1, 0, 'Hokkaido', 110),
(842, 1, 0, 'Hyogo', 110),
(843, 1, 0, 'Ibaragi', 110),
(844, 1, 0, 'Ishikawa', 110),
(845, 1, 0, 'Iwate', 110),
(846, 1, 0, 'Kagawa', 110),
(847, 1, 0, 'Kagoshima', 110),
(848, 1, 0, 'Kanagawa', 110),
(849, 1, 0, 'Kochi', 110),
(850, 1, 0, 'Kumamoto', 110),
(851, 1, 0, 'Kyoto', 110),
(852, 1, 0, 'Mie', 110),
(853, 1, 0, 'Miyagi', 110),
(854, 1, 0, 'Miyazaki', 110),
(855, 1, 0, 'Nagano', 110),
(856, 1, 0, 'Nagasaki', 110),
(857, 1, 0, 'Nara', 110),
(858, 1, 0, 'Niigata', 110),
(859, 1, 0, 'Oita', 110),
(860, 1, 0, 'Okayama', 110),
(861, 1, 0, 'Okinawa', 110),
(862, 1, 0, 'Osaka', 110),
(863, 1, 0, 'Saga', 110),
(864, 1, 0, 'Saitama', 110),
(865, 1, 0, 'Shiga', 110),
(866, 1, 0, 'Shimane', 110),
(867, 1, 0, 'Shizuoka', 110),
(868, 1, 0, 'Tochigi', 110),
(869, 1, 0, 'Tokushima', 110),
(870, 1, 0, 'Tokyo-to', 110),
(871, 1, 0, 'Tottori', 110),
(872, 1, 0, 'Toyama', 110),
(873, 1, 0, 'Wakayama', 110),
(874, 1, 0, 'Yamagata', 110),
(875, 1, 0, 'Yamaguchi', 110),
(876, 1, 0, 'Yamanashi', 110),
(877, 1, 0, 'Almaty', 111),
(878, 1, 0, 'Almaty Qalasy', 111),
(879, 1, 0, 'AqtÃƒÂ¶be', 111),
(880, 1, 0, 'Astana', 111),
(881, 1, 0, 'Atyrau', 111),
(882, 1, 0, 'East Kazakstan', 111),
(883, 1, 0, 'Mangghystau', 111),
(884, 1, 0, 'North Kazakstan', 111),
(885, 1, 0, 'Pavlodar', 111),
(886, 1, 0, 'Qaraghandy', 111),
(887, 1, 0, 'Qostanay', 111),
(888, 1, 0, 'Qyzylorda', 111),
(889, 1, 0, 'South Kazakstan', 111),
(890, 1, 0, 'Taraz', 111),
(891, 1, 0, 'West Kazakstan', 111),
(892, 1, 0, 'Central', 112),
(893, 1, 0, 'Coast', 112),
(894, 1, 0, 'Eastern', 112),
(895, 1, 0, 'Nairobi', 112),
(896, 1, 0, 'Nyanza', 112),
(897, 1, 0, 'Rift Valley', 112),
(898, 1, 0, 'Bishkek Shaary', 113),
(899, 1, 0, 'Osh', 113),
(900, 1, 0, 'Battambang', 114),
(901, 1, 0, 'Phnom Penh', 114),
(902, 1, 0, 'Siem Reap', 114),
(903, 1, 0, 'South Tarawa', 115),
(904, 1, 0, 'St George Basseterre', 116),
(905, 1, 0, 'Cheju', 117),
(906, 1, 0, 'Chollabuk', 117),
(907, 1, 0, 'Chollanam', 117),
(908, 1, 0, 'Chungchongbuk', 117),
(909, 1, 0, 'Chungchongnam', 117),
(910, 1, 0, 'Inchon', 117),
(911, 1, 0, 'Kang-won', 117),
(912, 1, 0, 'Kwangju', 117),
(913, 1, 0, 'Kyonggi', 117),
(914, 1, 0, 'Kyongsangbuk', 117),
(915, 1, 0, 'Kyongsangnam', 117),
(916, 1, 0, 'Pusan', 117),
(917, 1, 0, 'Seoul', 117),
(918, 1, 0, 'Taegu', 117),
(919, 1, 0, 'Taejon', 117),
(920, 1, 0, 'Al-Asima', 118),
(921, 1, 0, 'Hawalli', 118),
(922, 1, 0, 'Savannakhet', 119),
(923, 1, 0, 'Viangchan', 119),
(924, 1, 0, 'Al-Shamal', 120),
(925, 1, 0, 'Beirut', 120),
(926, 1, 0, 'Montserrado', 121),
(927, 1, 0, 'Al-Zawiya', 122),
(928, 1, 0, 'Bengasi', 122),
(929, 1, 0, 'Misrata', 122),
(930, 1, 0, 'Tripoli', 122),
(931, 1, 0, 'Castries', 123),
(932, 1, 0, 'Schaan', 124),
(933, 1, 0, 'Vaduz', 124),
(934, 1, 0, 'Central', 125),
(935, 1, 0, 'Northern', 125),
(936, 1, 0, 'Western', 125),
(937, 1, 0, 'Maseru', 126),
(938, 1, 0, 'Kaunas', 127),
(939, 1, 0, 'Klaipeda', 127),
(940, 1, 0, 'Panevezys', 127),
(941, 1, 0, 'Vilna', 127),
(942, 1, 0, 'Ã…Â iauliai', 127),
(943, 1, 0, 'Luxembourg', 128),
(944, 1, 0, 'Daugavpils', 129),
(945, 1, 0, 'Liepaja', 129),
(946, 1, 0, 'Riika', 129),
(947, 1, 0, 'Macau', 130),
(948, 1, 0, 'Casablanca', 131),
(949, 1, 0, 'Chaouia-Ouardigha', 131),
(950, 1, 0, 'Doukkala-Abda', 131),
(951, 1, 0, 'FÃƒÂ¨s-Boulemane', 131),
(952, 1, 0, 'Gharb-Chrarda-BÃƒÂ©ni', 131),
(953, 1, 0, 'Marrakech-Tensift-Al', 131),
(954, 1, 0, 'MeknÃƒÂ¨s-Tafilalet', 131),
(955, 1, 0, 'Oriental', 131),
(956, 1, 0, 'Rabat-SalÃƒÂ©-Zammour-', 131),
(957, 1, 0, 'Souss Massa-DraÃƒÂ¢', 131),
(958, 1, 0, 'Tadla-Azilal', 131),
(959, 1, 0, 'Tanger-TÃƒÂ©touan', 131),
(960, 1, 0, 'Taza-Al Hoceima-Taou', 131),
(961, 1, 0, 'Ã‚â‚¬â€œ', 132),
(962, 1, 0, 'Balti', 133),
(963, 1, 0, 'Bender (TÃƒÂ®ghina)', 133),
(964, 1, 0, 'Chisinau', 133),
(965, 1, 0, 'Dnjestria', 133),
(966, 1, 0, 'Antananarivo', 134),
(967, 1, 0, 'Fianarantsoa', 134),
(968, 1, 0, 'Mahajanga', 134),
(969, 1, 0, 'Toamasina', 134),
(970, 1, 0, 'Maale', 135),
(971, 1, 0, 'Aguascalientes', 136),
(972, 1, 0, 'Baja California', 136),
(973, 1, 0, 'Baja California Sur', 136),
(974, 1, 0, 'Campeche', 136),
(975, 1, 0, 'Chiapas', 136),
(976, 1, 0, 'Chihuahua', 136),
(977, 1, 0, 'Coahuila De Zaragoza', 136),
(978, 1, 0, 'Colima', 136),
(979, 1, 0, 'Distrito Federal', 136),
(980, 1, 0, 'Durango', 136),
(981, 1, 0, 'Guanajuato', 136),
(982, 1, 0, 'Guerrero', 136),
(983, 1, 0, 'Hidalgo', 136),
(984, 1, 0, 'Jalisco', 136),
(985, 1, 0, 'MÃƒÂ©xico', 136),
(986, 1, 0, 'MichoacÃƒÂ¡n De Ocampo', 136),
(987, 1, 0, 'Morelos', 136),
(988, 1, 0, 'Nayarit', 136),
(989, 1, 0, 'Nuevo LeÃƒÂ³n', 136),
(990, 1, 0, 'Oaxaca', 136),
(991, 1, 0, 'Puebla', 136),
(992, 1, 0, 'QuerÃƒÂ©taro', 136),
(993, 1, 0, 'QuerÃƒÂ©taro De Arteag', 136),
(994, 1, 0, 'Quintana Roo', 136),
(995, 1, 0, 'San Luis PotosÃƒÂ­', 136),
(996, 1, 0, 'Sinaloa', 136),
(997, 1, 0, 'Sonora', 136),
(998, 1, 0, 'Tabasco', 136),
(999, 1, 0, 'Tamaulipas', 136),
(1000, 1, 0, 'Veracruz', 136),
(1001, 1, 0, 'Veracruz-Llave', 136),
(1002, 1, 0, 'YucatÃƒÂ¡n', 136),
(1003, 1, 0, 'Zacatecas', 136),
(1004, 1, 0, 'Majuro', 137),
(1005, 1, 0, 'Skopje', 138),
(1006, 1, 0, 'Bamako', 139),
(1007, 1, 0, 'Inner Harbour', 140),
(1008, 1, 0, 'Outer Harbour', 140),
(1009, 1, 0, 'Irrawaddy [Ayeyarwad', 141),
(1010, 1, 0, 'Magwe [Magway]', 141),
(1011, 1, 0, 'Mandalay', 141),
(1012, 1, 0, 'Mon', 141),
(1013, 1, 0, 'Pegu [Bago]', 141),
(1014, 1, 0, 'Rakhine', 141),
(1015, 1, 0, 'Rangoon [Yangon]', 141),
(1016, 1, 0, 'Sagaing', 141),
(1017, 1, 0, 'Shan', 141),
(1018, 1, 0, 'Tenasserim [Tanintha', 141),
(1019, 1, 0, 'Ulaanbaatar', 142),
(1020, 1, 0, 'Saipan', 143),
(1021, 1, 0, 'Gaza', 144),
(1022, 1, 0, 'Inhambane', 144),
(1023, 1, 0, 'Manica', 144),
(1024, 1, 0, 'Maputo', 144),
(1025, 1, 0, 'Nampula', 144),
(1026, 1, 0, 'Sofala', 144),
(1027, 1, 0, 'Tete', 144),
(1028, 1, 0, 'ZambÃƒÂ©zia', 144),
(1029, 1, 0, 'Dakhlet NouÃƒÂ¢dhibou', 145),
(1030, 1, 0, 'Nouakchott', 145),
(1031, 1, 0, 'Plymouth', 146),
(1032, 1, 0, 'Fort-de-France', 147),
(1033, 1, 0, 'Plaines Wilhelms', 148),
(1034, 1, 0, 'Port-Louis', 148),
(1035, 1, 0, 'Blantyre', 149),
(1036, 1, 0, 'Lilongwe', 149),
(1037, 1, 0, 'Johor', 150),
(1038, 1, 0, 'Kedah', 150),
(1039, 1, 0, 'Kelantan', 150),
(1040, 1, 0, 'Negeri Sembilan', 150),
(1041, 1, 0, 'Pahang', 150),
(1042, 1, 0, 'Perak', 150),
(1043, 1, 0, 'Pulau Pinang', 150),
(1044, 1, 0, 'Sabah', 150),
(1045, 1, 0, 'Sarawak', 150),
(1046, 1, 0, 'Selangor', 150),
(1047, 1, 0, 'Terengganu', 150),
(1048, 1, 0, 'Wilayah Persekutuan', 150),
(1049, 1, 0, 'Mamoutzou', 151),
(1050, 1, 0, 'Khomas', 152),
(1051, 1, 0, 'Ã‚â‚¬â€œ', 153),
(1052, 1, 0, 'Maradi', 154),
(1053, 1, 0, 'Niamey', 154),
(1054, 1, 0, 'Zinder', 154),
(1055, 1, 0, 'Ã‚â‚¬â€œ', 155),
(1056, 1, 0, 'Anambra & Enugu & Eb', 156),
(1057, 1, 0, 'Bauchi & Gombe', 156),
(1058, 1, 0, 'Benue', 156),
(1059, 1, 0, 'Borno & Yobe', 156),
(1060, 1, 0, 'Cross River', 156),
(1061, 1, 0, 'Edo & Delta', 156),
(1062, 1, 0, 'Federal Capital Dist', 156),
(1063, 1, 0, 'Imo & Abia', 156),
(1064, 1, 0, 'Kaduna', 156),
(1065, 1, 0, 'Kano & Jigawa', 156),
(1066, 1, 0, 'Katsina', 156),
(1067, 1, 0, 'Kwara & Kogi', 156),
(1068, 1, 0, 'Lagos', 156),
(1069, 1, 0, 'Niger', 156),
(1070, 1, 0, 'Ogun', 156),
(1071, 1, 0, 'Ondo & Ekiti', 156),
(1072, 1, 0, 'Oyo & Osun', 156),
(1073, 1, 0, 'Plateau & Nassarawa', 156),
(1074, 1, 0, 'Rivers & Bayelsa', 156),
(1075, 1, 0, 'Sokoto & Kebbi & Zam', 156),
(1076, 1, 0, 'Chinandega', 157),
(1077, 1, 0, 'LeÃƒÂ³n', 157),
(1078, 1, 0, 'Managua', 157),
(1079, 1, 0, 'Masaya', 157),
(1080, 1, 0, 'Ã‚â‚¬â€œ', 158),
(1081, 1, 0, 'Drenthe', 159),
(1082, 1, 0, 'Flevoland', 159),
(1083, 1, 0, 'Gelderland', 159),
(1084, 1, 0, 'Groningen', 159),
(1085, 1, 0, 'Limburg', 159),
(1086, 1, 0, 'Noord-Brabant', 159),
(1087, 1, 0, 'Noord-Holland', 159),
(1088, 1, 0, 'Overijssel', 159),
(1089, 1, 0, 'Utrecht', 159),
(1090, 1, 0, 'Zuid-Holland', 159),
(1091, 1, 0, 'Akershus', 160),
(1092, 1, 0, 'Hordaland', 160),
(1093, 1, 0, 'Oslo', 160),
(1094, 1, 0, 'Rogaland', 160),
(1095, 1, 0, 'SÃƒÂ¸r-TrÃƒÂ¸ndelag', 160),
(1096, 1, 0, 'Central', 161),
(1097, 1, 0, 'Eastern', 161),
(1098, 1, 0, 'Western', 161),
(1099, 1, 0, 'Ã‚â‚¬â€œ', 162),
(1100, 1, 0, 'Auckland', 163),
(1101, 1, 0, 'Canterbury', 163),
(1102, 1, 0, 'Dunedin', 163),
(1103, 1, 0, 'Hamilton', 163),
(1104, 1, 0, 'Wellington', 163),
(1105, 1, 0, 'Al-Batina', 164),
(1106, 1, 0, 'Masqat', 164),
(1107, 1, 0, 'Zufar', 164),
(1108, 1, 0, 'Baluchistan', 165),
(1109, 1, 0, 'Islamabad', 165),
(1110, 1, 0, 'Nothwest Border Prov', 165),
(1111, 1, 0, 'Punjab', 165),
(1112, 1, 0, 'Sind', 165),
(1113, 1, 0, 'Sindh', 165),
(1114, 1, 0, 'PanamÃƒÂ¡', 166),
(1115, 1, 0, 'San Miguelito', 166),
(1116, 1, 0, 'Ã‚â‚¬â€œ', 167),
(1117, 1, 0, 'Ancash', 168),
(1118, 1, 0, 'Arequipa', 168),
(1119, 1, 0, 'Ayacucho', 168),
(1120, 1, 0, 'Cajamarca', 168),
(1121, 1, 0, 'Callao', 168),
(1122, 1, 0, 'Cusco', 168),
(1123, 1, 0, 'Huanuco', 168),
(1124, 1, 0, 'Ica', 168),
(1125, 1, 0, 'JunÃƒÂ­n', 168),
(1126, 1, 0, 'La Libertad', 168),
(1127, 1, 0, 'Lambayeque', 168),
(1128, 1, 0, 'Lima', 168),
(1129, 1, 0, 'Loreto', 168),
(1130, 1, 0, 'Piura', 168),
(1131, 1, 0, 'Puno', 168),
(1132, 1, 0, 'Tacna', 168),
(1133, 1, 0, 'Ucayali', 168),
(1134, 1, 0, 'ARMM', 169),
(1135, 1, 0, 'Bicol', 169),
(1136, 1, 0, 'Cagayan Valley', 169),
(1137, 1, 0, 'CAR', 169),
(1138, 1, 0, 'Caraga', 169),
(1139, 1, 0, 'Central Luzon', 169),
(1140, 1, 0, 'Central Mindanao', 169),
(1141, 1, 0, 'Central Visayas', 169),
(1142, 1, 0, 'Eastern Visayas', 169),
(1143, 1, 0, 'Ilocos', 169),
(1144, 1, 0, 'National Capital Reg', 169),
(1145, 1, 0, 'Northern Mindanao', 169),
(1146, 1, 0, 'Southern Mindanao', 169),
(1147, 1, 0, 'Southern Tagalog', 169),
(1148, 1, 0, 'Western Mindanao', 169),
(1149, 1, 0, 'Western Visayas', 169),
(1150, 1, 0, 'Koror', 170),
(1151, 1, 0, 'National Capital Dis', 171),
(1152, 1, 0, 'Dolnoslaskie', 172),
(1153, 1, 0, 'Kujawsko-Pomorskie', 172),
(1154, 1, 0, 'Lodzkie', 172),
(1155, 1, 0, 'Lubelskie', 172),
(1156, 1, 0, 'Lubuskie', 172),
(1157, 1, 0, 'Malopolskie', 172),
(1158, 1, 0, 'Mazowieckie', 172),
(1159, 1, 0, 'Opolskie', 172),
(1160, 1, 0, 'Podkarpackie', 172),
(1161, 1, 0, 'Podlaskie', 172),
(1162, 1, 0, 'Pomorskie', 172),
(1163, 1, 0, 'Slaskie', 172),
(1164, 1, 0, 'Swietokrzyskie', 172),
(1165, 1, 0, 'Warminsko-Mazurskie', 172),
(1166, 1, 0, 'Wielkopolskie', 172),
(1167, 1, 0, 'Zachodnio-Pomorskie', 172),
(1168, 1, 0, 'Arecibo', 173),
(1169, 1, 0, 'BayamÃƒÂ³n', 173),
(1170, 1, 0, 'Caguas', 173),
(1171, 1, 0, 'Carolina', 173),
(1172, 1, 0, 'Guaynabo', 173),
(1173, 1, 0, 'MayagÃƒÂ¼ez', 173),
(1174, 1, 0, 'Ponce', 173),
(1175, 1, 0, 'San Juan', 173),
(1176, 1, 0, 'Toa Baja', 173),
(1177, 1, 0, 'Chagang', 174),
(1178, 1, 0, 'Hamgyong N', 174),
(1179, 1, 0, 'Hamgyong P', 174),
(1180, 1, 0, 'Hwanghae N', 174),
(1181, 1, 0, 'Hwanghae P', 174),
(1182, 1, 0, 'Kaesong-si', 174),
(1183, 1, 0, 'Kangwon', 174),
(1184, 1, 0, 'Nampo-si', 174),
(1185, 1, 0, 'Pyongan N', 174),
(1186, 1, 0, 'Pyongan P', 174),
(1187, 1, 0, 'Pyongyang-si', 174),
(1188, 1, 0, 'Yanggang', 174),
(1189, 1, 0, 'Braga', 175),
(1190, 1, 0, 'CoÃƒÂ­mbra', 175),
(1191, 1, 0, 'Lisboa', 175),
(1192, 1, 0, 'Porto', 175),
(1193, 1, 0, 'Alto ParanÃƒÂ¡', 176),
(1194, 1, 0, 'AsunciÃƒÂ³n', 176),
(1195, 1, 0, 'Central', 176),
(1196, 1, 0, 'Gaza', 177),
(1197, 1, 0, 'Hebron', 177),
(1198, 1, 0, 'Khan Yunis', 177),
(1199, 1, 0, 'Nablus', 177),
(1200, 1, 0, 'North Gaza', 177),
(1201, 1, 0, 'Rafah', 177),
(1202, 1, 0, 'Tahiti', 178),
(1203, 1, 0, 'Doha', 179),
(1204, 1, 0, 'Saint-Denis', 180),
(1205, 1, 0, 'Arad', 181),
(1206, 1, 0, 'Arges', 181),
(1207, 1, 0, 'Bacau', 181),
(1208, 1, 0, 'Bihor', 181),
(1209, 1, 0, 'Botosani', 181),
(1210, 1, 0, 'Braila', 181),
(1211, 1, 0, 'Brasov', 181),
(1212, 1, 0, 'Bukarest', 181),
(1213, 1, 0, 'Buzau', 181),
(1214, 1, 0, 'Caras-Severin', 181),
(1215, 1, 0, 'Cluj', 181),
(1216, 1, 0, 'Constanta', 181),
(1217, 1, 0, 'DÃƒÂ¢mbovita', 181),
(1218, 1, 0, 'Dolj', 181),
(1219, 1, 0, 'Galati', 181),
(1220, 1, 0, 'Gorj', 181),
(1221, 1, 0, 'Iasi', 181),
(1222, 1, 0, 'Maramures', 181),
(1223, 1, 0, 'Mehedinti', 181),
(1224, 1, 0, 'Mures', 181),
(1225, 1, 0, 'Neamt', 181),
(1226, 1, 0, 'Prahova', 181),
(1227, 1, 0, 'Satu Mare', 181),
(1228, 1, 0, 'Sibiu', 181),
(1229, 1, 0, 'Suceava', 181),
(1230, 1, 0, 'Timis', 181),
(1231, 1, 0, 'Tulcea', 181),
(1232, 1, 0, 'VÃƒÂ¢lcea', 181),
(1233, 1, 0, 'Vrancea', 181),
(1234, 1, 0, 'Adygea', 182),
(1235, 1, 0, 'Altai', 182),
(1236, 1, 0, 'Amur', 182),
(1237, 1, 0, 'Arkangeli', 182),
(1238, 1, 0, 'Astrahan', 182),
(1239, 1, 0, 'BaÃ…Â¡kortostan', 182),
(1240, 1, 0, 'Belgorod', 182),
(1241, 1, 0, 'Brjansk', 182),
(1242, 1, 0, 'Burjatia', 182),
(1243, 1, 0, 'Dagestan', 182),
(1244, 1, 0, 'Habarovsk', 182),
(1245, 1, 0, 'Hakassia', 182),
(1246, 1, 0, 'Hanti-Mansia', 182),
(1247, 1, 0, 'Irkutsk', 182),
(1248, 1, 0, 'Ivanovo', 182),
(1249, 1, 0, 'Jaroslavl', 182),
(1250, 1, 0, 'Kabardi-Balkaria', 182),
(1251, 1, 0, 'Kaliningrad', 182),
(1252, 1, 0, 'Kalmykia', 182),
(1253, 1, 0, 'Kaluga', 182),
(1254, 1, 0, 'KamtÃ…Â¡atka', 182),
(1255, 1, 0, 'KaratÃ…Â¡ai-TÃ…Â¡erkessi', 182),
(1256, 1, 0, 'Karjala', 182),
(1257, 1, 0, 'Kemerovo', 182),
(1258, 1, 0, 'Kirov', 182),
(1259, 1, 0, 'Komi', 182),
(1260, 1, 0, 'Kostroma', 182),
(1261, 1, 0, 'Krasnodar', 182),
(1262, 1, 0, 'Krasnojarsk', 182),
(1263, 1, 0, 'Kurgan', 182),
(1264, 1, 0, 'Kursk', 182),
(1265, 1, 0, 'Lipetsk', 182),
(1266, 1, 0, 'Magadan', 182),
(1267, 1, 0, 'Marinmaa', 182),
(1268, 1, 0, 'Mordva', 182),
(1269, 1, 0, 'Moscow (City)', 182),
(1270, 1, 0, 'Moskova', 182),
(1271, 1, 0, 'Murmansk', 182),
(1272, 1, 0, 'Nizni Novgorod', 182),
(1273, 1, 0, 'North Ossetia-Alania', 182),
(1274, 1, 0, 'Novgorod', 182),
(1275, 1, 0, 'Novosibirsk', 182),
(1276, 1, 0, 'Omsk', 182),
(1277, 1, 0, 'Orenburg', 182),
(1278, 1, 0, 'Orjol', 182),
(1279, 1, 0, 'Penza', 182),
(1280, 1, 0, 'Perm', 182),
(1281, 1, 0, 'Pietari', 182),
(1282, 1, 0, 'Pihkova', 182),
(1283, 1, 0, 'Primorje', 182),
(1284, 1, 0, 'Rjazan', 182),
(1285, 1, 0, 'Rostov-na-Donu', 182),
(1286, 1, 0, 'Saha (Jakutia)', 182),
(1287, 1, 0, 'Sahalin', 182),
(1288, 1, 0, 'Samara', 182),
(1289, 1, 0, 'Saratov', 182),
(1290, 1, 0, 'Smolensk', 182),
(1291, 1, 0, 'Stavropol', 182),
(1292, 1, 0, 'Sverdlovsk', 182),
(1293, 1, 0, 'Tambov', 182),
(1294, 1, 0, 'Tatarstan', 182),
(1295, 1, 0, 'Tjumen', 182),
(1296, 1, 0, 'Tomsk', 182),
(1297, 1, 0, 'Tula', 182),
(1298, 1, 0, 'Tver', 182),
(1299, 1, 0, 'Tyva', 182),
(1300, 1, 0, 'TÃ…Â¡eljabinsk', 182),
(1301, 1, 0, 'TÃ…Â¡etÃ…Â¡enia', 182),
(1302, 1, 0, 'TÃ…Â¡ita', 182),
(1303, 1, 0, 'TÃ…Â¡uvassia', 182),
(1304, 1, 0, 'Udmurtia', 182),
(1305, 1, 0, 'Uljanovsk', 182),
(1306, 1, 0, 'Vladimir', 182),
(1307, 1, 0, 'Volgograd', 182),
(1308, 1, 0, 'Vologda', 182),
(1309, 1, 0, 'Voronez', 182),
(1310, 1, 0, 'Yamalin Nenetsia', 182),
(1311, 1, 0, 'Kigali', 183),
(1312, 1, 0, 'Al-Khudud Al-Samaliy', 184),
(1313, 1, 0, 'Al-Qasim', 184),
(1314, 1, 0, 'Al-Sharqiya', 184),
(1315, 1, 0, 'Asir', 184),
(1316, 1, 0, 'Hail', 184),
(1317, 1, 0, 'Medina', 184),
(1318, 1, 0, 'Mekka', 184),
(1319, 1, 0, 'Najran', 184),
(1320, 1, 0, 'Qasim', 184),
(1321, 1, 0, 'Riad', 184),
(1322, 1, 0, 'Riyadh', 184),
(1323, 1, 0, 'Tabuk', 184),
(1324, 1, 0, 'Al-Bahr Al-Abyad', 185),
(1325, 1, 0, 'Al-Bahr Al-Ahmar', 185),
(1326, 1, 0, 'Al-Jazira', 185),
(1327, 1, 0, 'Al-Qadarif', 185),
(1328, 1, 0, 'Bahr Al-Jabal', 185),
(1329, 1, 0, 'Darfur Al-Janubiya', 185),
(1330, 1, 0, 'Darfur Al-Shamaliya', 185),
(1331, 1, 0, 'Kassala', 185),
(1332, 1, 0, 'Khartum', 185),
(1333, 1, 0, 'Kurdufan Al-Shamaliy', 185),
(1334, 1, 0, 'Cap-Vert', 186),
(1335, 1, 0, 'Diourbel', 186),
(1336, 1, 0, 'Kaolack', 186),
(1337, 1, 0, 'Saint-Louis', 186),
(1338, 1, 0, 'ThiÃƒÂ¨s', 186),
(1339, 1, 0, 'Ziguinchor', 186),
(1340, 1, 0, 'Ã‚â‚¬â€œ', 187),
(1341, 1, 0, 'Saint Helena', 189),
(1342, 1, 0, 'LÃƒÂ¤nsimaa', 190),
(1343, 1, 0, 'Honiara', 191),
(1344, 1, 0, 'Western', 192),
(1345, 1, 0, 'La Libertad', 193),
(1346, 1, 0, 'San Miguel', 193),
(1347, 1, 0, 'San Salvador', 193),
(1348, 1, 0, 'Santa Ana', 193),
(1349, 1, 0, 'San Marino', 194),
(1350, 1, 0, 'Serravalle/Dogano', 194),
(1351, 1, 0, 'Banaadir', 195),
(1352, 1, 0, 'Jubbada Hoose', 195),
(1353, 1, 0, 'Woqooyi Galbeed', 195),
(1354, 1, 0, 'Saint-Pierre', 196),
(1355, 1, 0, 'Aqua Grande', 197),
(1356, 1, 0, 'Paramaribo', 198),
(1357, 1, 0, 'Bratislava', 199),
(1358, 1, 0, 'VÃƒÂ½chodnÃƒÂ© Slovensko', 199),
(1359, 1, 0, 'Osrednjeslovenska', 200),
(1360, 1, 0, 'Podravska', 200),
(1361, 1, 0, 'Ãƒâ€“rebros LÃƒÂ¤n', 201),
(1362, 1, 0, 'East GÃƒÂ¶tanmaan LÃƒÂ¤n', 201),
(1363, 1, 0, 'GÃƒÂ¤vleborgs LÃƒÂ¤n', 201),
(1364, 1, 0, 'JÃƒÂ¶nkÃƒÂ¶pings LÃƒÂ¤n', 201),
(1365, 1, 0, 'Lisboa', 201),
(1366, 1, 0, 'SkÃƒÂ¥ne LÃƒÂ¤n', 201),
(1367, 1, 0, 'Uppsala LÃƒÂ¤n', 201),
(1368, 1, 0, 'VÃƒÂ¤sterbottens LÃƒÂ¤n', 201),
(1369, 1, 0, 'VÃƒÂ¤sternorrlands LÃƒÂ¤', 201),
(1370, 1, 0, 'VÃƒÂ¤stmanlands LÃƒÂ¤n', 201),
(1371, 1, 0, 'West GÃƒÂ¶tanmaan LÃƒÂ¤n', 201),
(1372, 1, 0, 'Hhohho', 202),
(1373, 1, 0, 'MahÃƒÂ©', 203),
(1374, 1, 0, 'Al-Hasaka', 204),
(1375, 1, 0, 'Al-Raqqa', 204),
(1376, 1, 0, 'Aleppo', 204),
(1377, 1, 0, 'Damascus', 204),
(1378, 1, 0, 'Damaskos', 204),
(1379, 1, 0, 'Dayr Al-Zawr', 204),
(1380, 1, 0, 'Hama', 204),
(1381, 1, 0, 'Hims', 204),
(1382, 1, 0, 'Idlib', 204),
(1383, 1, 0, 'Latakia', 204),
(1384, 1, 0, 'Grand Turk', 205),
(1385, 1, 0, 'Chari-Baguirmi', 206),
(1386, 1, 0, 'Logone Occidental', 206),
(1387, 1, 0, 'Maritime', 207),
(1388, 1, 0, 'Bangkok', 208),
(1389, 1, 0, 'Chiang Mai', 208),
(1390, 1, 0, 'Khon Kaen', 208),
(1391, 1, 0, 'Nakhon Pathom', 208),
(1392, 1, 0, 'Nakhon Ratchasima', 208),
(1393, 1, 0, 'Nakhon Sawan', 208),
(1394, 1, 0, 'Nonthaburi', 208),
(1395, 1, 0, 'Songkhla', 208),
(1396, 1, 0, 'Ubon Ratchathani', 208),
(1397, 1, 0, 'Udon Thani', 208),
(1398, 1, 0, 'Karotegin', 209),
(1399, 1, 0, 'Khujand', 209),
(1400, 1, 0, 'Fakaofo', 210),
(1401, 1, 0, 'Ahal', 211),
(1402, 1, 0, 'Dashhowuz', 211),
(1403, 1, 0, 'Lebap', 211),
(1404, 1, 0, 'Mary', 211),
(1405, 1, 0, 'Dili', 212),
(1406, 1, 0, 'Tongatapu', 213),
(1407, 1, 0, 'Caroni', 214),
(1408, 1, 0, 'Port-of-Spain', 214),
(1409, 1, 0, 'Ariana', 215),
(1410, 1, 0, 'Biserta', 215),
(1411, 1, 0, 'GabÃƒÂ¨s', 215),
(1412, 1, 0, 'Kairouan', 215),
(1413, 1, 0, 'Sfax', 215),
(1414, 1, 0, 'Sousse', 215),
(1415, 1, 0, 'Tunis', 215),
(1416, 1, 0, 'Adana', 216),
(1417, 1, 0, 'Adiyaman', 216),
(1418, 1, 0, 'Afyon', 216),
(1419, 1, 0, 'Aksaray', 216),
(1420, 1, 0, 'Ankara', 216),
(1421, 1, 0, 'Antalya', 216),
(1422, 1, 0, 'Aydin', 216),
(1423, 1, 0, 'Ãƒâ€¡orum', 216),
(1424, 1, 0, 'Balikesir', 216),
(1425, 1, 0, 'Batman', 216),
(1426, 1, 0, 'Bursa', 216),
(1427, 1, 0, 'Denizli', 216),
(1428, 1, 0, 'Diyarbakir', 216),
(1429, 1, 0, 'Edirne', 216),
(1430, 1, 0, 'ElÃƒÂ¢zig', 216),
(1431, 1, 0, 'Erzincan', 216),
(1432, 1, 0, 'Erzurum', 216),
(1433, 1, 0, 'Eskisehir', 216),
(1434, 1, 0, 'Gaziantep', 216),
(1435, 1, 0, 'Hatay', 216),
(1436, 1, 0, 'IÃƒÂ§el', 216),
(1437, 1, 0, 'Isparta', 216),
(1438, 1, 0, 'Istanbul', 216),
(1439, 1, 0, 'Izmir', 216),
(1440, 1, 0, 'Kahramanmaras', 216),
(1441, 1, 0, 'KarabÃƒÂ¼k', 216),
(1442, 1, 0, 'Karaman', 216),
(1443, 1, 0, 'Kars', 216),
(1444, 1, 0, 'Kayseri', 216),
(1445, 1, 0, 'KÃƒÂ¼tahya', 216),
(1446, 1, 0, 'Kilis', 216),
(1447, 1, 0, 'Kirikkale', 216),
(1448, 1, 0, 'Kocaeli', 216),
(1449, 1, 0, 'Konya', 216),
(1450, 1, 0, 'Malatya', 216),
(1451, 1, 0, 'Manisa', 216),
(1452, 1, 0, 'Mardin', 216),
(1453, 1, 0, 'Ordu', 216),
(1454, 1, 0, 'Osmaniye', 216),
(1455, 1, 0, 'Sakarya', 216),
(1456, 1, 0, 'Samsun', 216),
(1457, 1, 0, 'Sanliurfa', 216),
(1458, 1, 0, 'Siirt', 216),
(1459, 1, 0, 'Sivas', 216),
(1460, 1, 0, 'Tekirdag', 216),
(1461, 1, 0, 'Tokat', 216),
(1462, 1, 0, 'Trabzon', 216),
(1463, 1, 0, 'Usak', 216),
(1464, 1, 0, 'Van', 216),
(1465, 1, 0, 'Zonguldak', 216),
(1466, 1, 0, 'Funafuti', 217),
(1467, 1, 0, '', 218),
(1468, 1, 0, 'Changhwa', 218),
(1469, 1, 0, 'Chiayi', 218),
(1470, 1, 0, 'Hsinchu', 218),
(1471, 1, 0, 'Hualien', 218),
(1472, 1, 0, 'Ilan', 218),
(1473, 1, 0, 'Kaohsiung', 218),
(1474, 1, 0, 'Keelung', 218),
(1475, 1, 0, 'Miaoli', 218),
(1476, 1, 0, 'Nantou', 218),
(1477, 1, 0, 'Pingtung', 218),
(1478, 1, 0, 'Taichung', 218),
(1479, 1, 0, 'Tainan', 218),
(1480, 1, 0, 'Taipei', 218),
(1481, 1, 0, 'Taitung', 218),
(1482, 1, 0, 'Taoyuan', 218),
(1483, 1, 0, 'YÃƒÂ¼nlin', 218),
(1484, 1, 0, 'Arusha', 219),
(1485, 1, 0, 'Dar Es Salaam', 219),
(1486, 1, 0, 'Dodoma', 219),
(1487, 1, 0, 'Kilimanjaro', 219),
(1488, 1, 0, 'Mbeya', 219),
(1489, 1, 0, 'Morogoro', 219),
(1490, 1, 0, 'Mwanza', 219),
(1491, 1, 0, 'Tabora', 219),
(1492, 1, 0, 'Tanga', 219),
(1493, 1, 0, 'Zanzibar West', 219),
(1494, 1, 0, 'Central', 220),
(1495, 1, 0, 'Dnipropetrovsk', 221),
(1496, 1, 0, 'Donetsk', 221),
(1497, 1, 0, 'Harkova', 221),
(1498, 1, 0, 'Herson', 221),
(1499, 1, 0, 'Hmelnytskyi', 221),
(1500, 1, 0, 'Ivano-Frankivsk', 221),
(1501, 1, 0, 'Kiova', 221),
(1502, 1, 0, 'Kirovograd', 221),
(1503, 1, 0, 'Krim', 221),
(1504, 1, 0, 'Lugansk', 221),
(1505, 1, 0, 'Lviv', 221),
(1506, 1, 0, 'Mykolajiv', 221),
(1507, 1, 0, 'Odesa', 221),
(1508, 1, 0, 'Pultava', 221),
(1509, 1, 0, 'Rivne', 221),
(1510, 1, 0, 'Sumy', 221),
(1511, 1, 0, 'Taka-Karpatia', 221),
(1512, 1, 0, 'Ternopil', 221),
(1513, 1, 0, 'TÃ…Â¡erkasy', 221),
(1514, 1, 0, 'TÃ…Â¡ernigiv', 221),
(1515, 1, 0, 'TÃ…Â¡ernivtsi', 221),
(1516, 1, 0, 'Vinnytsja', 221),
(1517, 1, 0, 'Volynia', 221),
(1518, 1, 0, 'Zaporizzja', 221),
(1519, 1, 0, 'Zytomyr', 221),
(1520, 1, 0, 'Montevideo', 223),
(1521, 1, 0, 'Alabama', 224),
(1522, 1, 0, 'Alaska', 224),
(1523, 1, 0, 'Arizona', 224),
(1524, 1, 0, 'Arkansas', 224),
(1525, 1, 0, 'California', 224),
(1526, 1, 0, 'Colorado', 224),
(1527, 1, 0, 'Connecticut', 224),
(1528, 1, 0, 'District Of Columbia', 224),
(1529, 1, 0, 'Florida', 224),
(1530, 1, 0, 'Georgia', 224),
(1531, 1, 0, 'Hawaii', 224),
(1532, 1, 0, 'Idaho', 224),
(1533, 1, 0, 'Illinois', 224),
(1534, 1, 0, 'Indiana', 224),
(1535, 1, 0, 'Iowa', 224),
(1536, 1, 0, 'Kansas', 224),
(1537, 1, 0, 'Kentucky', 224),
(1538, 1, 0, 'Louisiana', 224),
(1539, 1, 0, 'Maryland', 224),
(1540, 1, 0, 'Massachusetts', 224),
(1541, 1, 0, 'Michigan', 224),
(1542, 1, 0, 'Minnesota', 224),
(1543, 1, 0, 'Mississippi', 224),
(1544, 1, 0, 'Missouri', 224),
(1545, 1, 0, 'Montana', 224),
(1546, 1, 0, 'Nebraska', 224),
(1547, 1, 0, 'Nevada', 224),
(1548, 1, 0, 'New Hampshire', 224),
(1549, 1, 0, 'New Jersey', 224),
(1550, 1, 0, 'New Mexico', 224),
(1551, 1, 0, 'New York', 224),
(1552, 1, 0, 'North Carolina', 224),
(1553, 1, 0, 'Ohio', 224),
(1554, 1, 0, 'Oklahoma', 224),
(1555, 1, 0, 'Oregon', 224),
(1556, 1, 0, 'Pennsylvania', 224),
(1557, 1, 0, 'Rhode Island', 224),
(1558, 1, 0, 'South Carolina', 224),
(1559, 1, 0, 'South Dakota', 224),
(1560, 1, 0, 'Tennessee', 224),
(1561, 1, 0, 'Texas', 224),
(1562, 1, 0, 'Utah', 224),
(1563, 1, 0, 'Virginia', 224),
(1564, 1, 0, 'Washington', 224),
(1565, 1, 0, 'Wisconsin', 224),
(1566, 1, 0, 'Andijon', 225),
(1567, 1, 0, 'Buhoro', 225),
(1568, 1, 0, 'Cizah', 225),
(1569, 1, 0, 'Fargona', 225),
(1570, 1, 0, 'Karakalpakistan', 225),
(1571, 1, 0, 'Khorazm', 225),
(1572, 1, 0, 'Namangan', 225),
(1573, 1, 0, 'Navoi', 225),
(1574, 1, 0, 'Qashqadaryo', 225),
(1575, 1, 0, 'Samarkand', 225),
(1576, 1, 0, 'Surkhondaryo', 225),
(1577, 1, 0, 'Toskent', 225),
(1578, 1, 0, 'Toskent Shahri', 225),
(1579, 1, 0, 'Ã‚â‚¬â€œ', 226),
(1580, 1, 0, 'St George', 0),
(1581, 1, 0, '', 228),
(1582, 1, 0, 'AnzoÃƒÂ¡tegui', 228),
(1583, 1, 0, 'Apure', 228),
(1584, 1, 0, 'Aragua', 228),
(1585, 1, 0, 'Barinas', 228),
(1586, 1, 0, 'BolÃƒÂ­var', 228),
(1587, 1, 0, 'Carabobo', 228),
(1588, 1, 0, 'Distrito Federal', 228),
(1589, 1, 0, 'FalcÃƒÂ³n', 228),
(1590, 1, 0, 'GuÃƒÂ¡rico', 228),
(1591, 1, 0, 'Lara', 228),
(1592, 1, 0, 'MÃƒÂ©rida', 228),
(1593, 1, 0, 'Miranda', 228),
(1594, 1, 0, 'Monagas', 228),
(1595, 1, 0, 'Portuguesa', 228),
(1596, 1, 0, 'Sucre', 228),
(1597, 1, 0, 'TÃƒÂ¡chira', 228),
(1598, 1, 0, 'Trujillo', 228),
(1599, 1, 0, 'Yaracuy', 228),
(1600, 1, 0, 'Zulia', 228),
(1601, 1, 0, 'Tortola', 229),
(1602, 1, 0, 'St Thomas', 230),
(1603, 1, 0, 'An Giang', 231),
(1604, 1, 0, 'Ba Ria-Vung Tau', 231),
(1605, 1, 0, 'Bac Thai', 231),
(1606, 1, 0, 'Binh Dinh', 231),
(1607, 1, 0, 'Binh Thuan', 231),
(1608, 1, 0, 'Can Tho', 231),
(1609, 1, 0, 'Dac Lac', 231),
(1610, 1, 0, 'Dong Nai', 231),
(1611, 1, 0, 'Haiphong', 231),
(1612, 1, 0, 'Hanoi', 231),
(1613, 1, 0, 'Ho Chi Minh City', 231),
(1614, 1, 0, 'Khanh Hoa', 231),
(1615, 1, 0, 'Kien Giang', 231),
(1616, 1, 0, 'Lam Dong', 231),
(1617, 1, 0, 'Nam Ha', 231),
(1618, 1, 0, 'Nghe An', 231),
(1619, 1, 0, 'Quang Binh', 231),
(1620, 1, 0, 'Quang Nam-Da Nang', 231),
(1621, 1, 0, 'Quang Ninh', 231),
(1622, 1, 0, 'Thua Thien-Hue', 231),
(1623, 1, 0, 'Tien Giang', 231),
(1624, 1, 0, 'Shefa', 232),
(1625, 1, 0, 'Wallis', 233),
(1626, 1, 0, 'Upolu', 234),
(1627, 1, 0, 'Aden', 235),
(1628, 1, 0, 'Hadramawt', 235),
(1629, 1, 0, 'Hodeida', 235),
(1630, 1, 0, 'Ibb', 235),
(1631, 1, 0, 'Sanaa', 235),
(1632, 1, 0, 'Taizz', 235),
(1633, 1, 0, 'Central Serbia', 236),
(1634, 1, 0, 'Kosovo And Metohija', 236),
(1635, 1, 0, 'Montenegro', 236),
(1636, 1, 0, 'Vojvodina', 236),
(1637, 1, 0, 'Eastern Cape', 237),
(1638, 1, 0, 'Free State', 237),
(1639, 1, 0, 'Gauteng', 237),
(1640, 1, 0, 'KwaZulu-Natal', 237),
(1641, 1, 0, 'Mpumalanga', 237),
(1642, 1, 0, 'North West', 237),
(1643, 1, 0, 'Northern Cape', 237),
(1644, 1, 0, 'Western Cape', 237),
(1645, 1, 0, 'Central', 238),
(1646, 1, 0, 'Copperbelt', 238),
(1647, 1, 0, 'Lusaka', 238),
(1648, 1, 0, 'Bulawayo', 239),
(1649, 1, 0, 'Harare', 239),
(1650, 1, 0, 'Manicaland', 239),
(1651, 1, 0, 'Midlands', 239),
(1652, 2, 0, 'South Hill', 240),
(1653, 2, 0, 'The Valley', 240),
(1654, 2, 0, 'Oranjestad', 240),
(1655, 2, 0, 'Douglas', 240),
(1656, 2, 0, 'Gibraltar', 240),
(1657, 2, 0, 'Tamuning', 240),
(1658, 2, 0, 'AgaÃƒÂ±a', 240),
(1659, 2, 0, 'Flying Fish Cove', 240),
(1660, 2, 0, 'Monte-Carlo', 240),
(1661, 2, 0, 'Monaco-Ville', 240),
(1662, 2, 0, 'Yangor', 240),
(1663, 2, 0, 'Yaren', 240),
(1664, 2, 0, 'Alofi', 240),
(1665, 2, 0, 'Kingston', 240),
(1666, 2, 0, 'Adamstown', 240),
(1667, 2, 0, 'Singapore', 240),
(1668, 2, 0, 'NoumÃƒÂ©a', 240),
(1669, 2, 0, 'CittÃƒÂ  Del Vaticano', 240),
(1670, 2, 0, 'Mazar-e-Sharif', 241),
(1671, 2, 0, 'Herat', 242),
(1672, 2, 0, 'Kabul', 243),
(1673, 2, 0, 'Qandahar', 244),
(1674, 2, 0, 'Lobito', 245),
(1675, 2, 0, 'Benguela', 245),
(1676, 2, 0, 'Huambo', 246),
(1677, 2, 0, 'Luanda', 247),
(1678, 2, 0, 'Namibe', 248),
(1679, 2, 0, 'South Hill', 249),
(1680, 2, 0, 'The Valley', 249),
(1681, 2, 0, 'Oranjestad', 249),
(1682, 2, 0, 'Douglas', 249),
(1683, 2, 0, 'Gibraltar', 249),
(1684, 2, 0, 'Tamuning', 249),
(1685, 2, 0, 'AgaÃƒÂ±a', 249),
(1686, 2, 0, 'Flying Fish Cove', 249),
(1687, 2, 0, 'Monte-Carlo', 249),
(1688, 2, 0, 'Monaco-Ville', 249),
(1689, 2, 0, 'Yangor', 249),
(1690, 2, 0, 'Yaren', 249),
(1691, 2, 0, 'Alofi', 249),
(1692, 2, 0, 'Kingston', 249),
(1693, 2, 0, 'Adamstown', 249),
(1694, 2, 0, 'Singapore', 249),
(1695, 2, 0, 'NoumÃƒÂ©a', 249),
(1696, 2, 0, 'CittÃƒÂ  Del Vaticano', 249),
(1697, 2, 0, 'Tirana', 250),
(1698, 2, 0, 'Andorra La Vella', 251),
(1699, 2, 0, 'Willemstad', 252),
(1700, 2, 0, 'Abu Dhabi', 253),
(1701, 2, 0, 'Al-Ayn', 253),
(1702, 2, 0, 'Ajman', 254),
(1703, 2, 0, 'Dubai', 255),
(1704, 2, 0, 'Sharja', 256),
(1705, 2, 0, 'La Matanza', 257),
(1706, 2, 0, 'Lomas De Zamora', 257),
(1707, 2, 0, 'Quilmes', 257),
(1708, 2, 0, 'Almirante Brown', 257),
(1709, 2, 0, 'La Plata', 257),
(1710, 2, 0, 'Mar Del Plata', 257),
(1711, 2, 0, 'LanÃƒÂºs', 257),
(1712, 2, 0, 'Merlo', 257),
(1713, 2, 0, 'General San MartÃƒÂ­n', 257),
(1714, 2, 0, 'Moreno', 257),
(1715, 2, 0, 'Avellaneda', 257),
(1716, 2, 0, 'Tres De Febrero', 257),
(1717, 2, 0, 'MorÃƒÂ³n', 257);
INSERT INTO `tbl_geographical_location` (`location_id`, `location_type`, `is_visible`, `name`, `parent_id`) VALUES
(1718, 2, 0, 'Florencio Varela', 257),
(1719, 2, 0, 'San Isidro', 257),
(1720, 2, 0, 'Tigre', 257),
(1721, 2, 0, 'Malvinas Argentinas', 257),
(1722, 2, 0, 'Vicente LÃƒÂ³pez', 257),
(1723, 2, 0, 'Berazategui', 257),
(1724, 2, 0, 'San Miguel', 257),
(1725, 2, 0, 'BahÃƒÂ­a Blanca', 257),
(1726, 2, 0, 'Esteban EcheverrÃƒÂ­a', 257),
(1727, 2, 0, 'JosÃƒÂ© C. Paz', 257),
(1728, 2, 0, 'Hurlingham', 257),
(1729, 2, 0, 'ItuzaingÃƒÂ³', 257),
(1730, 2, 0, 'San Fernando', 257),
(1731, 2, 0, 'San NicolÃƒÂ¡s De Los Arroyos', 257),
(1732, 2, 0, 'Escobar', 257),
(1733, 2, 0, 'Pilar', 257),
(1734, 2, 0, 'Ezeiza', 257),
(1735, 2, 0, 'Tandil', 257),
(1736, 2, 0, 'San Fernando Del Valle De Cata', 258),
(1737, 2, 0, 'CÃƒÂ³rdoba', 259),
(1738, 2, 0, 'RÃƒÂ­o Cuarto', 259),
(1739, 2, 0, 'MonterÃƒÂ­a', 259),
(1740, 2, 0, 'Resistencia', 260),
(1741, 2, 0, 'Comodoro Rivadavia', 261),
(1742, 2, 0, 'Corrientes', 262),
(1743, 2, 0, 'Buenos Aires', 263),
(1744, 2, 0, 'BrasÃƒÂ­lia', 263),
(1745, 2, 0, 'Ciudad De MÃƒÂ©xico', 263),
(1746, 2, 0, 'Caracas', 263),
(1747, 2, 0, 'Catia La Mar', 263),
(1748, 2, 0, 'ParanÃƒÂ¡', 264),
(1749, 2, 0, 'Concordia', 264),
(1750, 2, 0, 'Formosa', 265),
(1751, 2, 0, 'San Salvador De Jujuy', 266),
(1752, 2, 0, 'La Rioja', 267),
(1753, 2, 0, 'LogroÃƒÂ±o', 267),
(1754, 2, 0, 'Godoy Cruz', 268),
(1755, 2, 0, 'GuaymallÃƒÂ©n', 268),
(1756, 2, 0, 'Las Heras', 268),
(1757, 2, 0, 'Mendoza', 268),
(1758, 2, 0, 'San Rafael', 268),
(1759, 2, 0, 'Posadas', 269),
(1760, 2, 0, 'NeuquÃƒÂ©n', 270),
(1761, 2, 0, 'Salta', 271),
(1762, 2, 0, 'San Juan', 272),
(1763, 2, 0, 'San Juan', 272),
(1764, 2, 0, 'San Luis', 273),
(1765, 2, 0, 'Rosario', 274),
(1766, 2, 0, 'Santa FÃƒÂ©', 274),
(1767, 2, 0, 'Santiago Del Estero', 275),
(1768, 2, 0, 'San Miguel De TucumÃƒÂ¡n', 276),
(1769, 2, 0, 'Vanadzor', 277),
(1770, 2, 0, 'Yerevan', 278),
(1771, 2, 0, 'Gjumri', 279),
(1772, 2, 0, 'Tafuna', 280),
(1773, 2, 0, 'Fagatogo', 280),
(1774, 2, 0, 'Saint JohnÃ‚Â´s', 281),
(1775, 2, 0, 'Canberra', 282),
(1776, 2, 0, 'Sydney', 283),
(1777, 2, 0, 'Newcastle', 283),
(1778, 2, 0, 'Central Coast', 283),
(1779, 2, 0, 'Wollongong', 283),
(1780, 2, 0, 'Brisbane', 284),
(1781, 2, 0, 'Gold Coast', 284),
(1782, 2, 0, 'Townsville', 284),
(1783, 2, 0, 'Cairns', 284),
(1784, 2, 0, 'Adelaide', 285),
(1785, 2, 0, 'Hobart', 286),
(1786, 2, 0, 'Melbourne', 287),
(1787, 2, 0, 'Geelong', 287),
(1788, 2, 0, 'Perth', 288),
(1789, 2, 0, 'Klagenfurt', 289),
(1790, 2, 0, 'Linz', 290),
(1791, 2, 0, 'Salzburg', 291),
(1792, 2, 0, 'Graz', 292),
(1793, 2, 0, 'Innsbruck', 293),
(1794, 2, 0, 'Wien', 294),
(1795, 2, 0, 'Baku', 295),
(1796, 2, 0, 'GÃƒÂ¤ncÃƒÂ¤', 296),
(1797, 2, 0, 'MingÃƒÂ¤ÃƒÂ§evir', 297),
(1798, 2, 0, 'Sumqayit', 298),
(1799, 2, 0, 'Bujumbura', 299),
(1800, 2, 0, 'Antwerpen', 300),
(1801, 2, 0, 'Bruxelles [Brussel]', 301),
(1802, 2, 0, 'Schaerbeek', 301),
(1803, 2, 0, 'Gent', 302),
(1804, 2, 0, 'Charleroi', 303),
(1805, 2, 0, 'Mons', 303),
(1806, 2, 0, 'LiÃƒÂ¨ge', 304),
(1807, 2, 0, 'Namur', 305),
(1808, 2, 0, 'Brugge', 306),
(1809, 2, 0, 'Djougou', 307),
(1810, 2, 0, 'Cotonou', 308),
(1811, 2, 0, 'Parakou', 309),
(1812, 2, 0, 'Porto-Novo', 310),
(1813, 2, 0, 'Koudougou', 311),
(1814, 2, 0, 'Bobo-Dioulasso', 312),
(1815, 2, 0, 'Ouagadougou', 313),
(1816, 2, 0, 'Barisal', 314),
(1817, 2, 0, 'Chittagong', 315),
(1818, 2, 0, 'Comilla', 315),
(1819, 2, 0, 'Brahmanbaria', 315),
(1820, 2, 0, 'Dhaka', 316),
(1821, 2, 0, 'Narayanganj', 316),
(1822, 2, 0, 'Mymensingh', 316),
(1823, 2, 0, 'Tungi', 316),
(1824, 2, 0, 'Tangail', 316),
(1825, 2, 0, 'Jamalpur', 316),
(1826, 2, 0, 'Narsinghdi', 316),
(1827, 2, 0, 'Gazipur', 316),
(1828, 2, 0, 'Khulna', 317),
(1829, 2, 0, 'Jessore', 317),
(1830, 2, 0, 'Rajshahi', 318),
(1831, 2, 0, 'Rangpur', 318),
(1832, 2, 0, 'Nawabganj', 318),
(1833, 2, 0, 'Dinajpur', 318),
(1834, 2, 0, 'Bogra', 318),
(1835, 2, 0, 'Pabna', 318),
(1836, 2, 0, 'Naogaon', 318),
(1837, 2, 0, 'Sirajganj', 318),
(1838, 2, 0, 'Saidpur', 318),
(1839, 2, 0, 'Sylhet', 319),
(1840, 2, 0, 'Burgas', 320),
(1841, 2, 0, 'Sliven', 320),
(1842, 2, 0, 'Sofija', 321),
(1843, 2, 0, 'Stara Zagora', 322),
(1844, 2, 0, 'Pleven', 323),
(1845, 2, 0, 'Plovdiv', 324),
(1846, 2, 0, 'Ruse', 325),
(1847, 2, 0, 'Varna', 326),
(1848, 2, 0, 'Dobric', 326),
(1849, 2, 0, 'Ã…Â umen', 326),
(1850, 2, 0, 'Al-Manama', 327),
(1851, 2, 0, 'Nassau', 328),
(1852, 2, 0, 'Sarajevo', 329),
(1853, 2, 0, 'Zenica', 329),
(1854, 2, 0, 'Banja Luka', 330),
(1855, 2, 0, 'Brest', 331),
(1856, 2, 0, 'BaranovitÃ…Â¡i', 331),
(1857, 2, 0, 'Pinsk', 331),
(1858, 2, 0, 'Gomel', 332),
(1859, 2, 0, 'Mozyr', 332),
(1860, 2, 0, 'Grodno', 333),
(1861, 2, 0, 'Lida', 333),
(1862, 2, 0, 'Minsk', 334),
(1863, 2, 0, 'Borisov', 335),
(1864, 2, 0, 'Soligorsk', 335),
(1865, 2, 0, 'MolodetÃ…Â¡no', 335),
(1866, 2, 0, 'Mogiljov', 336),
(1867, 2, 0, 'Bobruisk', 336),
(1868, 2, 0, 'Vitebsk', 337),
(1869, 2, 0, 'OrÃ…Â¡a', 337),
(1870, 2, 0, 'Novopolotsk', 337),
(1871, 2, 0, 'Belize City', 338),
(1872, 2, 0, 'Belmopan', 339),
(1873, 2, 0, 'Hamilton', 340),
(1874, 2, 0, 'Hamilton', 340),
(1875, 2, 0, 'Saint George', 341),
(1876, 2, 0, 'Sucre', 342),
(1877, 2, 0, 'Cochabamba', 343),
(1878, 2, 0, 'La Paz', 344),
(1879, 2, 0, 'El Alto', 344),
(1880, 2, 0, 'Oruro', 345),
(1881, 2, 0, 'PotosÃƒÂ­', 346),
(1882, 2, 0, 'Santa Cruz De La Sierra', 347),
(1883, 2, 0, 'Tarija', 348),
(1884, 2, 0, 'Rio Branco', 349),
(1885, 2, 0, 'MaceiÃƒÂ³', 350),
(1886, 2, 0, 'Arapiraca', 350),
(1887, 2, 0, 'MacapÃƒÂ¡', 351),
(1888, 2, 0, 'Manaus', 352),
(1889, 2, 0, 'Salvador', 353),
(1890, 2, 0, 'Feira De Santana', 353),
(1891, 2, 0, 'IlhÃƒÂ©us', 353),
(1892, 2, 0, 'VitÃƒÂ³ria Da Conquista', 353),
(1893, 2, 0, 'Juazeiro', 353),
(1894, 2, 0, 'Itabuna', 353),
(1895, 2, 0, 'JequiÃƒÂ©', 353),
(1896, 2, 0, 'CamaÃƒÂ§ari', 353),
(1897, 2, 0, 'Barreiras', 353),
(1898, 2, 0, 'Alagoinhas', 353),
(1899, 2, 0, 'Lauro De Freitas', 353),
(1900, 2, 0, 'Teixeira De Freitas', 353),
(1901, 2, 0, 'Paulo Afonso', 353),
(1902, 2, 0, 'EunÃƒÂ¡polis', 353),
(1903, 2, 0, 'Jacobina', 353),
(1904, 2, 0, 'Fortaleza', 354),
(1905, 2, 0, 'Caucaia', 354),
(1906, 2, 0, 'Juazeiro Do Norte', 354),
(1907, 2, 0, 'MaracanaÃƒÂº', 354),
(1908, 2, 0, 'Sobral', 354),
(1909, 2, 0, 'Crato', 354),
(1910, 2, 0, 'Buenos Aires', 355),
(1911, 2, 0, 'BrasÃƒÂ­lia', 355),
(1912, 2, 0, 'Ciudad De MÃƒÂ©xico', 355),
(1913, 2, 0, 'Caracas', 355),
(1914, 2, 0, 'Catia La Mar', 355),
(1915, 2, 0, 'Cariacica', 356),
(1916, 2, 0, 'Vila Velha', 356),
(1917, 2, 0, 'Serra', 356),
(1918, 2, 0, 'VitÃƒÂ³ria', 356),
(1919, 2, 0, 'Cachoeiro De Itapemirim', 356),
(1920, 2, 0, 'Colatina', 356),
(1921, 2, 0, 'Linhares', 356),
(1922, 2, 0, 'GoiÃƒÂ¢nia', 357),
(1923, 2, 0, 'Aparecida De GoiÃƒÂ¢nia', 357),
(1924, 2, 0, 'AnÃƒÂ¡polis', 357),
(1925, 2, 0, 'LuziÃƒÂ¢nia', 357),
(1926, 2, 0, 'Rio Verde', 357),
(1927, 2, 0, 'Ãƒ?guas Lindas De GoiÃƒÂ¡s', 357),
(1928, 2, 0, 'SÃƒÂ£o LuÃƒÂ­s', 358),
(1929, 2, 0, 'Imperatriz', 358),
(1930, 2, 0, 'Caxias', 358),
(1931, 2, 0, 'Timon', 358),
(1932, 2, 0, 'CodÃƒÂ³', 358),
(1933, 2, 0, 'SÃƒÂ£o JosÃƒÂ© De Ribamar', 358),
(1934, 2, 0, 'Bacabal', 358),
(1935, 2, 0, 'CuiabÃƒÂ¡', 359),
(1936, 2, 0, 'VÃƒÂ¡rzea Grande', 359),
(1937, 2, 0, 'RondonÃƒÂ³polis', 359),
(1938, 2, 0, 'Campo Grande', 360),
(1939, 2, 0, 'Dourados', 360),
(1940, 2, 0, 'CorumbÃƒÂ¡', 360),
(1941, 2, 0, 'Belo Horizonte', 361),
(1942, 2, 0, 'Contagem', 361),
(1943, 2, 0, 'UberlÃƒÂ¢ndia', 361),
(1944, 2, 0, 'Juiz De Fora', 361),
(1945, 2, 0, 'Betim', 361),
(1946, 2, 0, 'Montes Claros', 361),
(1947, 2, 0, 'Uberaba', 361),
(1948, 2, 0, 'RibeirÃƒÂ£o Das Neves', 361),
(1949, 2, 0, 'Governador Valadares', 361),
(1950, 2, 0, 'Ipatinga', 361),
(1951, 2, 0, 'DivinÃƒÂ³polis', 361),
(1952, 2, 0, 'Sete Lagoas', 361),
(1953, 2, 0, 'Santa Luzia', 361),
(1954, 2, 0, 'PoÃƒÂ§os De Caldas', 361),
(1955, 2, 0, 'IbiritÃƒÂ©', 361),
(1956, 2, 0, 'TeÃƒÂ³filo Otoni', 361),
(1957, 2, 0, 'Patos De Minas', 361),
(1958, 2, 0, 'Barbacena', 361),
(1959, 2, 0, 'Varginha', 361),
(1960, 2, 0, 'SabarÃƒÂ¡', 361),
(1961, 2, 0, 'Itabira', 361),
(1962, 2, 0, 'Pouso Alegre', 361),
(1963, 2, 0, 'Passos', 361),
(1964, 2, 0, 'Araguari', 361),
(1965, 2, 0, 'Conselheiro Lafaiete', 361),
(1966, 2, 0, 'Coronel Fabriciano', 361),
(1967, 2, 0, 'Ituiutaba', 361),
(1968, 2, 0, 'JoÃƒÂ£o Pessoa', 362),
(1969, 2, 0, 'Campina Grande', 362),
(1970, 2, 0, 'Santa Rita', 362),
(1971, 2, 0, 'Patos', 362),
(1972, 2, 0, 'Curitiba', 363),
(1973, 2, 0, 'Londrina', 363),
(1974, 2, 0, 'MaringÃƒÂ¡', 363),
(1975, 2, 0, 'Ponta Grossa', 363),
(1976, 2, 0, 'Foz Do IguaÃƒÂ§u', 363),
(1977, 2, 0, 'Cascavel', 363),
(1978, 2, 0, 'SÃƒÂ£o JosÃƒÂ© Dos Pinhais', 363),
(1979, 2, 0, 'Colombo', 363),
(1980, 2, 0, 'Guarapuava', 363),
(1981, 2, 0, 'ParanaguÃƒÂ¡', 363),
(1982, 2, 0, 'Apucarana', 363),
(1983, 2, 0, 'Toledo', 363),
(1984, 2, 0, 'Pinhais', 363),
(1985, 2, 0, 'Campo Largo', 363),
(1986, 2, 0, 'BelÃƒÂ©m', 364),
(1987, 2, 0, 'Ananindeua', 364),
(1988, 2, 0, 'SantarÃƒÂ©m', 364),
(1989, 2, 0, 'MarabÃƒÂ¡', 364),
(1990, 2, 0, 'Castanhal', 364),
(1991, 2, 0, 'Abaetetuba', 364),
(1992, 2, 0, 'Itaituba', 364),
(1993, 2, 0, 'CametÃƒÂ¡', 364),
(1994, 2, 0, 'Recife', 365),
(1995, 2, 0, 'JaboatÃƒÂ£o Dos Guararapes', 365),
(1996, 2, 0, 'Olinda', 365),
(1997, 2, 0, 'Paulista', 365),
(1998, 2, 0, 'Caruaru', 365),
(1999, 2, 0, 'Petrolina', 365),
(2000, 2, 0, 'Cabo De Santo Agostinho', 365),
(2001, 2, 0, 'Camaragibe', 365),
(2002, 2, 0, 'Garanhuns', 365),
(2003, 2, 0, 'VitÃƒÂ³ria De Santo AntÃƒÂ£o', 365),
(2004, 2, 0, 'SÃƒÂ£o LourenÃƒÂ§o Da Mata', 365),
(2005, 2, 0, 'Teresina', 366),
(2006, 2, 0, 'ParnaÃƒÂ­ba', 366),
(2007, 2, 0, 'Rio De Janeiro', 367),
(2008, 2, 0, 'SÃƒÂ£o GonÃƒÂ§alo', 367),
(2009, 2, 0, 'Nova IguaÃƒÂ§u', 367),
(2010, 2, 0, 'Duque De Caxias', 367),
(2011, 2, 0, 'NiterÃƒÂ³i', 367),
(2012, 2, 0, 'SÃƒÂ£o JoÃƒÂ£o De Meriti', 367),
(2013, 2, 0, 'Belford Roxo', 367),
(2014, 2, 0, 'Campos Dos Goytacazes', 367),
(2015, 2, 0, 'PetrÃƒÂ³polis', 367),
(2016, 2, 0, 'Volta Redonda', 367),
(2017, 2, 0, 'MagÃƒÂ©', 367),
(2018, 2, 0, 'ItaboraÃƒÂ­', 367),
(2019, 2, 0, 'Nova Friburgo', 367),
(2020, 2, 0, 'Barra Mansa', 367),
(2021, 2, 0, 'NilÃƒÂ³polis', 367),
(2022, 2, 0, 'TeresÃƒÂ³polis', 367),
(2023, 2, 0, 'MacaÃƒÂ©', 367),
(2024, 2, 0, 'Cabo Frio', 367),
(2025, 2, 0, 'Queimados', 367),
(2026, 2, 0, 'Resende', 367),
(2027, 2, 0, 'Angra Dos Reis', 367),
(2028, 2, 0, 'Barra Do PiraÃƒÂ­', 367),
(2029, 2, 0, 'Natal', 368),
(2030, 2, 0, 'MossorÃƒÂ³', 368),
(2031, 2, 0, 'Parnamirim', 368),
(2032, 2, 0, 'Porto Alegre', 369),
(2033, 2, 0, 'Caxias Do Sul', 369),
(2034, 2, 0, 'Pelotas', 369),
(2035, 2, 0, 'Canoas', 369),
(2036, 2, 0, 'Novo Hamburgo', 369),
(2037, 2, 0, 'Santa Maria', 369),
(2038, 2, 0, 'GravataÃƒÂ­', 369),
(2039, 2, 0, 'ViamÃƒÂ£o', 369),
(2040, 2, 0, 'SÃƒÂ£o Leopoldo', 369),
(2041, 2, 0, 'Rio Grande', 369),
(2042, 2, 0, 'Alvorada', 369),
(2043, 2, 0, 'Passo Fundo', 369),
(2044, 2, 0, 'Uruguaiana', 369),
(2045, 2, 0, 'BagÃƒÂ©', 369),
(2046, 2, 0, 'Sapucaia Do Sul', 369),
(2047, 2, 0, 'Santa Cruz Do Sul', 369),
(2048, 2, 0, 'Cachoeirinha', 369),
(2049, 2, 0, 'GuaÃƒÂ­ba', 369),
(2050, 2, 0, 'Santana Do Livramento', 369),
(2051, 2, 0, 'Bento GonÃƒÂ§alves', 369),
(2052, 2, 0, 'Porto Velho', 370),
(2053, 2, 0, 'Ji-ParanÃƒÂ¡', 370),
(2054, 2, 0, 'Boa Vista', 371),
(2055, 2, 0, 'Joinville', 372),
(2056, 2, 0, 'FlorianÃƒÂ³polis', 372),
(2057, 2, 0, 'Blumenau', 372),
(2058, 2, 0, 'CriciÃƒÂºma', 372),
(2059, 2, 0, 'SÃƒÂ£o JosÃƒÂ©', 372),
(2060, 2, 0, 'ItajaÃƒÂ­', 372),
(2061, 2, 0, 'ChapecÃƒÂ³', 372),
(2062, 2, 0, 'Lages', 372),
(2063, 2, 0, 'JaraguÃƒÂ¡ Do Sul', 372),
(2064, 2, 0, 'PalhoÃƒÂ§a', 372),
(2065, 2, 0, 'SÃƒÂ£o Paulo', 373),
(2066, 2, 0, 'Guarulhos', 373),
(2067, 2, 0, 'Campinas', 373),
(2068, 2, 0, 'SÃƒÂ£o Bernardo Do Campo', 373),
(2069, 2, 0, 'Osasco', 373),
(2070, 2, 0, 'Santo AndrÃƒÂ©', 373),
(2071, 2, 0, 'SÃƒÂ£o JosÃƒÂ© Dos Campos', 373),
(2072, 2, 0, 'RibeirÃƒÂ£o Preto', 373),
(2073, 2, 0, 'Sorocaba', 373),
(2074, 2, 0, 'Santos', 373),
(2075, 2, 0, 'MauÃƒÂ¡', 373),
(2076, 2, 0, 'CarapicuÃƒÂ­ba', 373),
(2077, 2, 0, 'SÃƒÂ£o JosÃƒÂ© Do Rio Preto', 373),
(2078, 2, 0, 'Moji Das Cruzes', 373),
(2079, 2, 0, 'Diadema', 373),
(2080, 2, 0, 'Piracicaba', 373),
(2081, 2, 0, 'Bauru', 373),
(2082, 2, 0, 'JundÃƒÂ­aÃƒÂ­', 373),
(2083, 2, 0, 'Franca', 373),
(2084, 2, 0, 'SÃƒÂ£o Vicente', 373),
(2085, 2, 0, 'Itaquaquecetuba', 373),
(2086, 2, 0, 'Limeira', 373),
(2087, 2, 0, 'GuarujÃƒÂ¡', 373),
(2088, 2, 0, 'TaubatÃƒÂ©', 373),
(2089, 2, 0, 'Embu', 373),
(2090, 2, 0, 'Barueri', 373),
(2091, 2, 0, 'TaboÃƒÂ£o Da Serra', 373),
(2092, 2, 0, 'Suzano', 373),
(2093, 2, 0, 'MarÃƒÂ­lia', 373),
(2094, 2, 0, 'SÃƒÂ£o Carlos', 373),
(2095, 2, 0, 'SumarÃƒÂ©', 373),
(2096, 2, 0, 'Presidente Prudente', 373),
(2097, 2, 0, 'Americana', 373),
(2098, 2, 0, 'Araraquara', 373),
(2099, 2, 0, 'Santa BÃƒÂ¡rbara DÃ‚Â´Oeste', 373),
(2100, 2, 0, 'JacareÃƒÂ­', 373),
(2101, 2, 0, 'AraÃƒÂ§atuba', 373),
(2102, 2, 0, 'Praia Grande', 373),
(2103, 2, 0, 'Rio Claro', 373),
(2104, 2, 0, 'Itapevi', 373),
(2105, 2, 0, 'Cotia', 373),
(2106, 2, 0, 'Ferraz De Vasconcelos', 373),
(2107, 2, 0, 'Indaiatuba', 373),
(2108, 2, 0, 'HortolÃƒÂ¢ndia', 373),
(2109, 2, 0, 'SÃƒÂ£o Caetano Do Sul', 373),
(2110, 2, 0, 'Itu', 373),
(2111, 2, 0, 'Itapecerica Da Serra', 373),
(2112, 2, 0, 'Moji-GuaÃƒÂ§u', 373),
(2113, 2, 0, 'Pindamonhangaba', 373),
(2114, 2, 0, 'Francisco Morato', 373),
(2115, 2, 0, 'Itapetininga', 373),
(2116, 2, 0, 'BraganÃƒÂ§a Paulista', 373),
(2117, 2, 0, 'JaÃƒÂº', 373),
(2118, 2, 0, 'Franco Da Rocha', 373),
(2119, 2, 0, 'RibeirÃƒÂ£o Pires', 373),
(2120, 2, 0, 'Catanduva', 373),
(2121, 2, 0, 'Botucatu', 373),
(2122, 2, 0, 'Barretos', 373),
(2123, 2, 0, 'GuaratinguetÃƒÂ¡', 373),
(2124, 2, 0, 'CubatÃƒÂ£o', 373),
(2125, 2, 0, 'Araras', 373),
(2126, 2, 0, 'Atibaia', 373),
(2127, 2, 0, 'SertÃƒÂ£ozinho', 373),
(2128, 2, 0, 'Salto', 373),
(2129, 2, 0, 'Ourinhos', 373),
(2130, 2, 0, 'Birigui', 373),
(2131, 2, 0, 'TatuÃƒÂ­', 373),
(2132, 2, 0, 'Votorantim', 373),
(2133, 2, 0, 'PoÃƒÂ¡', 373),
(2134, 2, 0, 'Aracaju', 374),
(2135, 2, 0, 'Nossa Senhora Do Socorro', 374),
(2136, 2, 0, 'Palmas', 375),
(2137, 2, 0, 'AraguaÃƒÂ­na', 375),
(2138, 2, 0, 'Bridgetown', 376),
(2139, 2, 0, 'Bandar Seri Begawan', 377),
(2140, 2, 0, 'Thimphu', 378),
(2141, 2, 0, 'Francistown', 379),
(2142, 2, 0, 'Gaborone', 380),
(2143, 2, 0, 'Bangui', 381),
(2144, 2, 0, 'Calgary', 382),
(2145, 2, 0, 'Edmonton', 382),
(2146, 2, 0, 'Vancouver', 383),
(2147, 2, 0, 'Surrey', 383),
(2148, 2, 0, 'Burnaby', 383),
(2149, 2, 0, 'Richmond', 383),
(2150, 2, 0, 'Abbotsford', 383),
(2151, 2, 0, 'Coquitlam', 383),
(2152, 2, 0, 'Saanich', 383),
(2153, 2, 0, 'Delta', 383),
(2154, 2, 0, 'Kelowna', 383),
(2155, 2, 0, 'Winnipeg', 384),
(2156, 2, 0, 'Saint JohnÃ‚Â´s', 385),
(2157, 2, 0, 'Cape Breton', 386),
(2158, 2, 0, 'Halifax', 386),
(2159, 2, 0, 'Toronto', 387),
(2160, 2, 0, 'North York', 387),
(2161, 2, 0, 'Mississauga', 387),
(2162, 2, 0, 'Scarborough', 387),
(2163, 2, 0, 'Etobicoke', 387),
(2164, 2, 0, 'London', 387),
(2165, 2, 0, 'Hamilton', 387),
(2166, 2, 0, 'Ottawa', 387),
(2167, 2, 0, 'Brampton', 387),
(2168, 2, 0, 'Windsor', 387),
(2169, 2, 0, 'Kitchener', 387),
(2170, 2, 0, 'Markham', 387),
(2171, 2, 0, 'York', 387),
(2172, 2, 0, 'Vaughan', 387),
(2173, 2, 0, 'Burlington', 387),
(2174, 2, 0, 'Oshawa', 387),
(2175, 2, 0, 'Oakville', 387),
(2176, 2, 0, 'Saint Catharines', 387),
(2177, 2, 0, 'Richmond Hill', 387),
(2178, 2, 0, 'Thunder Bay', 387),
(2179, 2, 0, 'Nepean', 387),
(2180, 2, 0, 'East York', 387),
(2181, 2, 0, 'Cambridge', 387),
(2182, 2, 0, 'Gloucester', 387),
(2183, 2, 0, 'Guelph', 387),
(2184, 2, 0, 'Sudbury', 387),
(2185, 2, 0, 'Barrie', 387),
(2186, 2, 0, 'MontrÃƒÂ©al', 388),
(2187, 2, 0, 'Laval', 388),
(2188, 2, 0, 'QuÃƒÂ©bec', 388),
(2189, 2, 0, 'Longueuil', 388),
(2190, 2, 0, 'Gatineau', 388),
(2191, 2, 0, 'Saskatoon', 389),
(2192, 2, 0, 'Regina', 389),
(2193, 2, 0, 'Bantam', 390),
(2194, 2, 0, 'West Island', 391),
(2195, 2, 0, 'Basel', 392),
(2196, 2, 0, 'Bern', 393),
(2197, 2, 0, 'Geneve', 394),
(2198, 2, 0, 'Lausanne', 395),
(2199, 2, 0, 'ZÃƒÂ¼rich', 396),
(2200, 2, 0, 'Antofagasta', 397),
(2201, 2, 0, 'Calama', 397),
(2202, 2, 0, 'CopiapÃƒÂ³', 398),
(2203, 2, 0, 'Talcahuano', 399),
(2204, 2, 0, 'ConcepciÃƒÂ³n', 399),
(2205, 2, 0, 'ChillÃƒÂ¡n', 399),
(2206, 2, 0, 'Los Angeles', 399),
(2207, 2, 0, 'Coronel', 399),
(2208, 2, 0, 'San Pedro De La Paz', 399),
(2209, 2, 0, 'Coquimbo', 400),
(2210, 2, 0, 'La Serena', 400),
(2211, 2, 0, 'Ovalle', 400),
(2212, 2, 0, 'Temuco', 401),
(2213, 2, 0, 'Puerto Montt', 402),
(2214, 2, 0, 'Osorno', 402),
(2215, 2, 0, 'Valdivia', 402),
(2216, 2, 0, 'Punta Arenas', 403),
(2217, 2, 0, 'Talca', 404),
(2218, 2, 0, 'CuricÃƒÂ³', 404),
(2219, 2, 0, 'Rancagua', 405),
(2220, 2, 0, 'Santiago De Chile', 406),
(2221, 2, 0, 'Puente Alto', 406),
(2222, 2, 0, 'San Bernardo', 406),
(2223, 2, 0, 'Melipilla', 406),
(2224, 2, 0, 'Santiago De Los Caballeros', 406),
(2225, 2, 0, 'Arica', 407),
(2226, 2, 0, 'Iquique', 407),
(2227, 2, 0, 'ViÃƒÂ±a Del Mar', 408),
(2228, 2, 0, 'ValparaÃƒÂ­so', 408),
(2229, 2, 0, 'QuilpuÃƒÂ©', 408),
(2230, 2, 0, 'Hefei', 409),
(2231, 2, 0, 'Huainan', 409),
(2232, 2, 0, 'Bengbu', 409),
(2233, 2, 0, 'Wuhu', 409),
(2234, 2, 0, 'Huaibei', 409),
(2235, 2, 0, 'MaÃ‚Â´anshan', 409),
(2236, 2, 0, 'Anqing', 409),
(2237, 2, 0, 'Tongling', 409),
(2238, 2, 0, 'Fuyang', 409),
(2239, 2, 0, 'Suzhou', 409),
(2240, 2, 0, 'LiuÃ‚Â´an', 409),
(2241, 2, 0, 'Chuzhou', 409),
(2242, 2, 0, 'Chaohu', 409),
(2243, 2, 0, 'Xuangzhou', 409),
(2244, 2, 0, 'Bozhou', 409),
(2245, 2, 0, 'Huangshan', 409),
(2246, 2, 0, 'Chongqing', 410),
(2247, 2, 0, 'Fuzhou', 411),
(2248, 2, 0, 'Amoy [Xiamen]', 411),
(2249, 2, 0, 'Nanping', 411),
(2250, 2, 0, 'Quanzhou', 411),
(2251, 2, 0, 'Zhangzhou', 411),
(2252, 2, 0, 'Sanming', 411),
(2253, 2, 0, 'Longyan', 411),
(2254, 2, 0, 'YongÃ‚Â´an', 411),
(2255, 2, 0, 'FuÃ‚Â´an', 411),
(2256, 2, 0, 'Fuqing', 411),
(2257, 2, 0, 'Putian', 411),
(2258, 2, 0, 'Shaowu', 411),
(2259, 2, 0, 'Lanzhou', 412),
(2260, 2, 0, 'Tianshui', 412),
(2261, 2, 0, 'Baiyin', 412),
(2262, 2, 0, 'Wuwei', 412),
(2263, 2, 0, 'Yumen', 412),
(2264, 2, 0, 'Jinchang', 412),
(2265, 2, 0, 'Pingliang', 412),
(2266, 2, 0, 'Kanton [Guangzhou]', 413),
(2267, 2, 0, 'Shenzhen', 413),
(2268, 2, 0, 'Shantou', 413),
(2269, 2, 0, 'Zhangjiang', 413),
(2270, 2, 0, 'Shaoguan', 413),
(2271, 2, 0, 'Chaozhou', 413),
(2272, 2, 0, 'Dongwan', 413),
(2273, 2, 0, 'Foshan', 413),
(2274, 2, 0, 'Zhongshan', 413),
(2275, 2, 0, 'Jiangmen', 413),
(2276, 2, 0, 'Yangjiang', 413),
(2277, 2, 0, 'Zhaoqing', 413),
(2278, 2, 0, 'Maoming', 413),
(2279, 2, 0, 'Zhuhai', 413),
(2280, 2, 0, 'Qingyuan', 413),
(2281, 2, 0, 'Huizhou', 413),
(2282, 2, 0, 'Meixian', 413),
(2283, 2, 0, 'Heyuan', 413),
(2284, 2, 0, 'Shanwei', 413),
(2285, 2, 0, 'Jieyang', 413),
(2286, 2, 0, 'Nanning', 414),
(2287, 2, 0, 'Liuzhou', 414),
(2288, 2, 0, 'Guilin', 414),
(2289, 2, 0, 'Wuzhou', 414),
(2290, 2, 0, 'Yulin', 414),
(2291, 2, 0, 'Qinzhou', 414),
(2292, 2, 0, 'Guigang', 414),
(2293, 2, 0, 'Beihai', 414),
(2294, 2, 0, 'Bose', 414),
(2295, 2, 0, 'Guiyang', 415),
(2296, 2, 0, 'Liupanshui', 415),
(2297, 2, 0, 'Zunyi', 415),
(2298, 2, 0, 'Anshun', 415),
(2299, 2, 0, 'Duyun', 415),
(2300, 2, 0, 'Kaili', 415),
(2301, 2, 0, 'Haikou', 416),
(2302, 2, 0, 'Sanya', 416),
(2303, 2, 0, 'Shijiazhuang', 417),
(2304, 2, 0, 'Tangshan', 417),
(2305, 2, 0, 'Handan', 417),
(2306, 2, 0, 'Zhangjiakou', 417),
(2307, 2, 0, 'Baoding', 417),
(2308, 2, 0, 'Qinhuangdao', 417),
(2309, 2, 0, 'Xingtai', 417),
(2310, 2, 0, 'Chengde', 417),
(2311, 2, 0, 'Cangzhou', 417),
(2312, 2, 0, 'Langfang', 417),
(2313, 2, 0, 'Renqiu', 417),
(2314, 2, 0, 'Hengshui', 417),
(2315, 2, 0, 'Harbin', 418),
(2316, 2, 0, 'Qiqihar', 418),
(2317, 2, 0, 'Yichun', 418),
(2318, 2, 0, 'Jixi', 418),
(2319, 2, 0, 'Daqing', 418),
(2320, 2, 0, 'Mudanjiang', 418),
(2321, 2, 0, 'Hegang', 418),
(2322, 2, 0, 'Jiamusi', 418),
(2323, 2, 0, 'Shuangyashan', 418),
(2324, 2, 0, 'Tieli', 418),
(2325, 2, 0, 'Suihua', 418),
(2326, 2, 0, 'Shangzi', 418),
(2327, 2, 0, 'Qitaihe', 418),
(2328, 2, 0, 'BeiÃ‚Â´an', 418),
(2329, 2, 0, 'Acheng', 418),
(2330, 2, 0, 'Zhaodong', 418),
(2331, 2, 0, 'Shuangcheng', 418),
(2332, 2, 0, 'Anda', 418),
(2333, 2, 0, 'Hailun', 418),
(2334, 2, 0, 'Mishan', 418),
(2335, 2, 0, 'Fujin', 418),
(2336, 2, 0, 'Zhengzhou', 419),
(2337, 2, 0, 'Luoyang', 419),
(2338, 2, 0, 'Kaifeng', 419),
(2339, 2, 0, 'Xinxiang', 419),
(2340, 2, 0, 'Anyang', 419),
(2341, 2, 0, 'Pingdingshan', 419),
(2342, 2, 0, 'Jiaozuo', 419),
(2343, 2, 0, 'Nanyang', 419),
(2344, 2, 0, 'Hebi', 419),
(2345, 2, 0, 'Xuchang', 419),
(2346, 2, 0, 'Xinyang', 419),
(2347, 2, 0, 'Puyang', 419),
(2348, 2, 0, 'Shangqiu', 419),
(2349, 2, 0, 'Zhoukou', 419),
(2350, 2, 0, 'Luohe', 419),
(2351, 2, 0, 'Zhumadian', 419),
(2352, 2, 0, 'Sanmenxia', 419),
(2353, 2, 0, 'Yuzhou', 419),
(2354, 2, 0, 'Wuhan', 420),
(2355, 2, 0, 'Huangshi', 420),
(2356, 2, 0, 'Xiangfan', 420),
(2357, 2, 0, 'Yichang', 420),
(2358, 2, 0, 'Shashi', 420),
(2359, 2, 0, 'Shiyan', 420),
(2360, 2, 0, 'Xiantao', 420),
(2361, 2, 0, 'Qianjiang', 420),
(2362, 2, 0, 'Honghu', 420),
(2363, 2, 0, 'Ezhou', 420),
(2364, 2, 0, 'Tianmen', 420),
(2365, 2, 0, 'Xiaogan', 420),
(2366, 2, 0, 'Zaoyang', 420),
(2367, 2, 0, 'Jinmen', 420),
(2368, 2, 0, 'Suizhou', 420),
(2369, 2, 0, 'Xianning', 420),
(2370, 2, 0, 'Laohekou', 420),
(2371, 2, 0, 'Puqi', 420),
(2372, 2, 0, 'Shishou', 420),
(2373, 2, 0, 'Danjiangkou', 420),
(2374, 2, 0, 'Guangshui', 420),
(2375, 2, 0, 'Enshi', 420),
(2376, 2, 0, 'Changsha', 421),
(2377, 2, 0, 'Hengyang', 421),
(2378, 2, 0, 'Xiangtan', 421),
(2379, 2, 0, 'Zhuzhou', 421),
(2380, 2, 0, 'Yueyang', 421),
(2381, 2, 0, 'Changde', 421),
(2382, 2, 0, 'Shaoyang', 421),
(2383, 2, 0, 'Yiyang', 421),
(2384, 2, 0, 'Chenzhou', 421),
(2385, 2, 0, 'Lengshuijiang', 421),
(2386, 2, 0, 'Leiyang', 421),
(2387, 2, 0, 'Loudi', 421),
(2388, 2, 0, 'Huaihua', 421),
(2389, 2, 0, 'Lianyuan', 421),
(2390, 2, 0, 'Hongjiang', 421),
(2391, 2, 0, 'Zixing', 421),
(2392, 2, 0, 'Liling', 421),
(2393, 2, 0, 'Yuanjiang', 421),
(2394, 2, 0, 'Baotou', 422),
(2395, 2, 0, 'Hohhot', 422),
(2396, 2, 0, 'Yakeshi', 422),
(2397, 2, 0, 'Chifeng', 422),
(2398, 2, 0, 'Wuhai', 422),
(2399, 2, 0, 'Tongliao', 422),
(2400, 2, 0, 'Hailar', 422),
(2401, 2, 0, 'Jining', 422),
(2402, 2, 0, 'Ulanhot', 422),
(2403, 2, 0, 'Linhe', 422),
(2404, 2, 0, 'Zalantun', 422),
(2405, 2, 0, 'Manzhouli', 422),
(2406, 2, 0, 'Xilin Hot', 422),
(2407, 2, 0, 'Nanking [Nanjing]', 423),
(2408, 2, 0, 'Wuxi', 423),
(2409, 2, 0, 'Xuzhou', 423),
(2410, 2, 0, 'Suzhou', 423),
(2411, 2, 0, 'Changzhou', 423),
(2412, 2, 0, 'Zhenjiang', 423),
(2413, 2, 0, 'Lianyungang', 423),
(2414, 2, 0, 'Nantong', 423),
(2415, 2, 0, 'Yangzhou', 423),
(2416, 2, 0, 'Yancheng', 423),
(2417, 2, 0, 'Huaiyin', 423),
(2418, 2, 0, 'Jiangyin', 423),
(2419, 2, 0, 'Yixing', 423),
(2420, 2, 0, 'Dongtai', 423),
(2421, 2, 0, 'Changshu', 423),
(2422, 2, 0, 'Danyang', 423),
(2423, 2, 0, 'Xinghua', 423),
(2424, 2, 0, 'Taizhou', 423),
(2425, 2, 0, 'HuaiÃ‚Â´an', 423),
(2426, 2, 0, 'Qidong', 423),
(2427, 2, 0, 'Liyang', 423),
(2428, 2, 0, 'Yizheng', 423),
(2429, 2, 0, 'Suqian', 423),
(2430, 2, 0, 'Kunshan', 423),
(2431, 2, 0, 'Zhangjiagang', 423),
(2432, 2, 0, 'Nanchang', 424),
(2433, 2, 0, 'Pingxiang', 424),
(2434, 2, 0, 'Jiujiang', 424),
(2435, 2, 0, 'Jingdezhen', 424),
(2436, 2, 0, 'Ganzhou', 424),
(2437, 2, 0, 'Fengcheng', 424),
(2438, 2, 0, 'Xinyu', 424),
(2439, 2, 0, 'Yichun', 424),
(2440, 2, 0, 'JiÃ‚Â´an', 424),
(2441, 2, 0, 'Shangrao', 424),
(2442, 2, 0, 'Linchuan', 424),
(2443, 2, 0, 'Changchun', 425),
(2444, 2, 0, 'Jilin', 425),
(2445, 2, 0, 'Hunjiang', 425),
(2446, 2, 0, 'Liaoyuan', 425),
(2447, 2, 0, 'Tonghua', 425),
(2448, 2, 0, 'Siping', 425),
(2449, 2, 0, 'Dunhua', 425),
(2450, 2, 0, 'Yanji', 425),
(2451, 2, 0, 'Gongziling', 425),
(2452, 2, 0, 'Baicheng', 425),
(2453, 2, 0, 'Meihekou', 425),
(2454, 2, 0, 'Fuyu', 425),
(2455, 2, 0, 'Jiutai', 425),
(2456, 2, 0, 'Jiaohe', 425),
(2457, 2, 0, 'Huadian', 425),
(2458, 2, 0, 'Taonan', 425),
(2459, 2, 0, 'Longjing', 425),
(2460, 2, 0, 'DaÃ‚Â´an', 425),
(2461, 2, 0, 'Yushu', 425),
(2462, 2, 0, 'Tumen', 425),
(2463, 2, 0, 'Shenyang', 426),
(2464, 2, 0, 'Dalian', 426),
(2465, 2, 0, 'Anshan', 426),
(2466, 2, 0, 'Fushun', 426),
(2467, 2, 0, 'Benxi', 426),
(2468, 2, 0, 'Fuxin', 426),
(2469, 2, 0, 'Jinzhou', 426),
(2470, 2, 0, 'Dandong', 426),
(2471, 2, 0, 'Liaoyang', 426),
(2472, 2, 0, 'Yingkou', 426),
(2473, 2, 0, 'Panjin', 426),
(2474, 2, 0, 'Jinxi', 426),
(2475, 2, 0, 'Tieling', 426),
(2476, 2, 0, 'Wafangdian', 426),
(2477, 2, 0, 'Chaoyang', 426),
(2478, 2, 0, 'Haicheng', 426),
(2479, 2, 0, 'Beipiao', 426),
(2480, 2, 0, 'Tiefa', 426),
(2481, 2, 0, 'Kaiyuan', 426),
(2482, 2, 0, 'Xingcheng', 426),
(2483, 2, 0, 'Jinzhou', 426),
(2484, 2, 0, 'Yinchuan', 427),
(2485, 2, 0, 'Shizuishan', 427),
(2486, 2, 0, 'Peking', 428),
(2487, 2, 0, 'Tong Xian', 428),
(2488, 2, 0, 'Xining', 429),
(2489, 2, 0, 'XiÃ‚Â´an', 430),
(2490, 2, 0, 'Xianyang', 430),
(2491, 2, 0, 'Baoji', 430),
(2492, 2, 0, 'Tongchuan', 430),
(2493, 2, 0, 'Hanzhong', 430),
(2494, 2, 0, 'Ankang', 430),
(2495, 2, 0, 'Weinan', 430),
(2496, 2, 0, 'YanÃ‚Â´an', 430),
(2497, 2, 0, 'Qingdao', 431),
(2498, 2, 0, 'Jinan', 431),
(2499, 2, 0, 'Zibo', 431),
(2500, 2, 0, 'Yantai', 431),
(2501, 2, 0, 'Weifang', 431),
(2502, 2, 0, 'Zaozhuang', 431),
(2503, 2, 0, 'TaiÃ‚Â´an', 431),
(2504, 2, 0, 'Linyi', 431),
(2505, 2, 0, 'Tengzhou', 431),
(2506, 2, 0, 'Dongying', 431),
(2507, 2, 0, 'Xintai', 431),
(2508, 2, 0, 'Jining', 431),
(2509, 2, 0, 'Laiwu', 431),
(2510, 2, 0, 'Liaocheng', 431),
(2511, 2, 0, 'Laizhou', 431),
(2512, 2, 0, 'Dezhou', 431),
(2513, 2, 0, 'Heze', 431),
(2514, 2, 0, 'Rizhao', 431),
(2515, 2, 0, 'Liangcheng', 431),
(2516, 2, 0, 'Jiaozhou', 431),
(2517, 2, 0, 'Pingdu', 431),
(2518, 2, 0, 'Longkou', 431),
(2519, 2, 0, 'Laiyang', 431),
(2520, 2, 0, 'Wendeng', 431),
(2521, 2, 0, 'Binzhou', 431),
(2522, 2, 0, 'Weihai', 431),
(2523, 2, 0, 'Qingzhou', 431),
(2524, 2, 0, 'Linqing', 431),
(2525, 2, 0, 'Jiaonan', 431),
(2526, 2, 0, 'Zhucheng', 431),
(2527, 2, 0, 'Junan', 431),
(2528, 2, 0, 'Pingyi', 431),
(2529, 2, 0, 'Shanghai', 432),
(2530, 2, 0, 'Taiyuan', 433),
(2531, 2, 0, 'Datong', 433),
(2532, 2, 0, 'Yangquan', 433),
(2533, 2, 0, 'Changzhi', 433),
(2534, 2, 0, 'Yuci', 433),
(2535, 2, 0, 'Linfen', 433),
(2536, 2, 0, 'Jincheng', 433),
(2537, 2, 0, 'Yuncheng', 433),
(2538, 2, 0, 'Xinzhou', 433),
(2539, 2, 0, 'Chengdu', 434),
(2540, 2, 0, 'Panzhihua', 434),
(2541, 2, 0, 'Zigong', 434),
(2542, 2, 0, 'Leshan', 434),
(2543, 2, 0, 'Mianyang', 434),
(2544, 2, 0, 'Luzhou', 434),
(2545, 2, 0, 'Neijiang', 434),
(2546, 2, 0, 'Yibin', 434),
(2547, 2, 0, 'Daxian', 434),
(2548, 2, 0, 'Deyang', 434),
(2549, 2, 0, 'Guangyuan', 434),
(2550, 2, 0, 'Nanchong', 434),
(2551, 2, 0, 'Jiangyou', 434),
(2552, 2, 0, 'Fuling', 434),
(2553, 2, 0, 'Wanxian', 434),
(2554, 2, 0, 'Suining', 434),
(2555, 2, 0, 'Xichang', 434),
(2556, 2, 0, 'Dujiangyan', 434),
(2557, 2, 0, 'YaÃ‚Â´an', 434),
(2558, 2, 0, 'Emeishan', 434),
(2559, 2, 0, 'Huaying', 434),
(2560, 2, 0, 'Tianjin', 435),
(2561, 2, 0, 'Lhasa', 436),
(2562, 2, 0, 'UrumtÃ…Â¡i [ÃƒÅ“rÃƒÂ¼mqi]', 437),
(2563, 2, 0, 'Shihezi', 437),
(2564, 2, 0, 'Qaramay', 437),
(2565, 2, 0, 'Ghulja', 437),
(2566, 2, 0, 'Qashqar', 437),
(2567, 2, 0, 'Aqsu', 437),
(2568, 2, 0, 'Hami', 437),
(2569, 2, 0, 'Korla', 437),
(2570, 2, 0, 'Changji', 437),
(2571, 2, 0, 'Kuytun', 437),
(2572, 2, 0, 'Kunming', 438),
(2573, 2, 0, 'Gejiu', 438),
(2574, 2, 0, 'Qujing', 438),
(2575, 2, 0, 'Dali', 438),
(2576, 2, 0, 'Kaiyuan', 438),
(2577, 2, 0, 'Hangzhou', 439),
(2578, 2, 0, 'Ningbo', 439),
(2579, 2, 0, 'Wenzhou', 439),
(2580, 2, 0, 'Huzhou', 439),
(2581, 2, 0, 'Jiaxing', 439),
(2582, 2, 0, 'Shaoxing', 439),
(2583, 2, 0, 'Xiaoshan', 439),
(2584, 2, 0, 'RuiÃ‚Â´an', 439),
(2585, 2, 0, 'Zhoushan', 439),
(2586, 2, 0, 'Jinhua', 439),
(2587, 2, 0, 'Yuyao', 439),
(2588, 2, 0, 'Quzhou', 439),
(2589, 2, 0, 'Cixi', 439),
(2590, 2, 0, 'Haining', 439),
(2591, 2, 0, 'Linhai', 439),
(2592, 2, 0, 'Huangyan', 439),
(2593, 2, 0, 'Abidjan', 440),
(2594, 2, 0, 'BouakÃƒÂ©', 441),
(2595, 2, 0, 'Daloa', 442),
(2596, 2, 0, 'Korhogo', 443),
(2597, 2, 0, 'Yamoussoukro', 444),
(2598, 2, 0, 'YaoundÃƒÂ©', 445),
(2599, 2, 0, 'Tours', 445),
(2600, 2, 0, 'OrlÃƒÂ©ans', 445),
(2601, 2, 0, 'Maroua', 446),
(2602, 2, 0, 'Douala', 447),
(2603, 2, 0, 'Nkongsamba', 447),
(2604, 2, 0, 'Le-Cap-HaÃƒÂ¯tien', 448),
(2605, 2, 0, 'Garoua', 448),
(2606, 2, 0, 'Bamenda', 449),
(2607, 2, 0, 'Port-au-Prince', 450),
(2608, 2, 0, 'Carrefour', 450),
(2609, 2, 0, 'Delmas', 450),
(2610, 2, 0, 'Bafoussam', 450),
(2611, 2, 0, 'Kikwit', 451),
(2612, 2, 0, 'Matadi', 452),
(2613, 2, 0, 'Boma', 452),
(2614, 2, 0, 'Mbuji-Mayi', 453),
(2615, 2, 0, 'Mwene-Ditu', 453),
(2616, 2, 0, 'Mbandaka', 454),
(2617, 2, 0, 'Kisangani', 455),
(2618, 2, 0, 'Kinshasa', 456),
(2619, 2, 0, 'Butembo', 457),
(2620, 2, 0, 'Goma', 457),
(2621, 2, 0, 'Lubumbashi', 458),
(2622, 2, 0, 'Kolwezi', 458),
(2623, 2, 0, 'Likasi', 458),
(2624, 2, 0, 'Kalemie', 458),
(2625, 2, 0, 'Bukavu', 459),
(2626, 2, 0, 'Uvira', 459),
(2627, 2, 0, 'Kananga', 460),
(2628, 2, 0, 'Tshikapa', 460),
(2629, 2, 0, 'Brazzaville', 461),
(2630, 2, 0, 'Pointe-Noire', 462),
(2631, 2, 0, 'Avarua', 463),
(2632, 2, 0, 'MedellÃƒÂ­n', 464),
(2633, 2, 0, 'Bello', 464),
(2634, 2, 0, 'ItagÃƒÂ¼ÃƒÂ­', 464),
(2635, 2, 0, 'Envigado', 464),
(2636, 2, 0, 'Barranquilla', 465),
(2637, 2, 0, 'Soledad', 465),
(2638, 2, 0, 'Cartagena', 466),
(2639, 2, 0, 'Ciudad Guayana', 466),
(2640, 2, 0, 'Ciudad BolÃƒÂ­var', 466),
(2641, 2, 0, 'Tunja', 467),
(2642, 2, 0, 'Sogamoso', 467),
(2643, 2, 0, 'Manizales', 468),
(2644, 2, 0, 'Florencia', 469),
(2645, 2, 0, 'PopayÃƒÂ¡n', 470),
(2646, 2, 0, 'CÃƒÂ³rdoba', 471),
(2647, 2, 0, 'RÃƒÂ­o Cuarto', 471),
(2648, 2, 0, 'MonterÃƒÂ­a', 471),
(2649, 2, 0, 'Valledupar', 472),
(2650, 2, 0, 'Soacha', 473),
(2651, 2, 0, 'Girardot', 473),
(2652, 2, 0, 'Neiva', 474),
(2653, 2, 0, 'Maicao', 475),
(2654, 2, 0, 'Santa Marta', 476),
(2655, 2, 0, 'Villavicencio', 477),
(2656, 2, 0, 'Pasto', 478),
(2657, 2, 0, 'CÃƒÂºcuta', 479),
(2658, 2, 0, 'Armenia', 480),
(2659, 2, 0, 'Pereira', 481),
(2660, 2, 0, 'Dos Quebradas', 481),
(2661, 2, 0, 'SantafÃƒÂ© De BogotÃƒÂ¡', 482),
(2662, 2, 0, 'Bucaramanga', 483),
(2663, 2, 0, 'Floridablanca', 483),
(2664, 2, 0, 'Barrancabermeja', 483),
(2665, 2, 0, 'Giron', 483),
(2666, 2, 0, 'Sincelejo', 484),
(2667, 2, 0, 'CumanÃƒÂ¡', 484),
(2668, 2, 0, 'CarÃƒÂºpano', 484),
(2669, 2, 0, 'IbaguÃƒÂ©', 485),
(2670, 2, 0, 'Cali', 486),
(2671, 2, 0, 'Palmira', 486),
(2672, 2, 0, 'Buenaventura', 486),
(2673, 2, 0, 'TuluÃƒÂ¡', 486),
(2674, 2, 0, 'Cartago', 486),
(2675, 2, 0, 'Buga', 486),
(2676, 2, 0, 'Moroni', 487),
(2677, 2, 0, 'Praia', 488),
(2678, 2, 0, 'San JosÃƒÂ©', 489),
(2679, 2, 0, 'CamagÃƒÂ¼ey', 490),
(2680, 2, 0, 'Ciego De Ãƒ?vila', 491),
(2681, 2, 0, 'Cienfuegos', 492),
(2682, 2, 0, 'Bayamo', 493),
(2683, 2, 0, 'Manzanillo', 493),
(2684, 2, 0, 'GuantÃƒÂ¡namo', 494),
(2685, 2, 0, 'HolguÃƒÂ­n', 495),
(2686, 2, 0, 'La Habana', 496),
(2687, 2, 0, 'Victoria De Las Tunas', 497),
(2688, 2, 0, 'Matanzas', 498),
(2689, 2, 0, 'Pinar Del RÃƒÂ­o', 499),
(2690, 2, 0, 'Sancti-SpÃƒÂ­ritus', 500),
(2691, 2, 0, 'Santiago De Cuba', 501),
(2692, 2, 0, 'Santa Clara', 502),
(2693, 2, 0, 'South Hill', 503),
(2694, 2, 0, 'The Valley', 503),
(2695, 2, 0, 'Oranjestad', 503),
(2696, 2, 0, 'Douglas', 503),
(2697, 2, 0, 'Gibraltar', 503),
(2698, 2, 0, 'Tamuning', 503),
(2699, 2, 0, 'AgaÃƒÂ±a', 503),
(2700, 2, 0, 'Flying Fish Cove', 503),
(2701, 2, 0, 'Monte-Carlo', 503),
(2702, 2, 0, 'Monaco-Ville', 503),
(2703, 2, 0, 'Yangor', 503),
(2704, 2, 0, 'Yaren', 503),
(2705, 2, 0, 'Alofi', 503),
(2706, 2, 0, 'Kingston', 503),
(2707, 2, 0, 'Adamstown', 503),
(2708, 2, 0, 'Singapore', 503),
(2709, 2, 0, 'NoumÃƒÂ©a', 503),
(2710, 2, 0, 'CittÃƒÂ  Del Vaticano', 503),
(2711, 2, 0, 'George Town', 504),
(2712, 2, 0, 'Limassol', 505),
(2713, 2, 0, 'Nicosia', 506),
(2714, 2, 0, 'Praha', 507),
(2715, 2, 0, 'CeskÃƒÂ© Budejovice', 508),
(2716, 2, 0, 'Brno', 509),
(2717, 2, 0, 'Liberec', 510),
(2718, 2, 0, 'ÃƒÅ¡stÃƒÂ­ Nad Labem', 510),
(2719, 2, 0, 'Ostrava', 511),
(2720, 2, 0, 'Olomouc', 511),
(2721, 2, 0, 'Hradec KrÃƒÂ¡lovÃƒÂ©', 512),
(2722, 2, 0, 'Pardubice', 512),
(2723, 2, 0, 'Plzen', 513),
(2724, 2, 0, 'Halle/Saale', 514),
(2725, 2, 0, 'Magdeburg', 514),
(2726, 2, 0, 'Stuttgart', 515),
(2727, 2, 0, 'Mannheim', 515),
(2728, 2, 0, 'Karlsruhe', 515),
(2729, 2, 0, 'Freiburg Im Breisgau', 515),
(2730, 2, 0, 'Heidelberg', 515),
(2731, 2, 0, 'Heilbronn', 515),
(2732, 2, 0, 'Pforzheim', 515),
(2733, 2, 0, 'Ulm', 515),
(2734, 2, 0, 'Reutlingen', 515),
(2735, 2, 0, 'Esslingen Am Neckar', 515),
(2736, 2, 0, 'Munich [MÃƒÂ¼nchen]', 516),
(2737, 2, 0, 'NÃƒÂ¼rnberg', 516),
(2738, 2, 0, 'Augsburg', 516),
(2739, 2, 0, 'WÃƒÂ¼rzburg', 516),
(2740, 2, 0, 'Regensburg', 516),
(2741, 2, 0, 'Ingolstadt', 516),
(2742, 2, 0, 'FÃƒÂ¼rth', 516),
(2743, 2, 0, 'Erlangen', 516),
(2744, 2, 0, 'Berlin', 517),
(2745, 2, 0, 'Potsdam', 518),
(2746, 2, 0, 'Cottbus', 518),
(2747, 2, 0, 'Bremen', 519),
(2748, 2, 0, 'Bremerhaven', 519),
(2749, 2, 0, 'Hamburg', 520),
(2750, 2, 0, 'Frankfurt Am Main', 521),
(2751, 2, 0, 'Wiesbaden', 521),
(2752, 2, 0, 'Kassel', 521),
(2753, 2, 0, 'Darmstadt', 521),
(2754, 2, 0, 'Offenbach Am Main', 521),
(2755, 2, 0, 'Rostock', 522),
(2756, 2, 0, 'Schwerin', 522),
(2757, 2, 0, 'Hannover', 523),
(2758, 2, 0, 'Braunschweig', 523),
(2759, 2, 0, 'OsnabrÃƒÂ¼ck', 523),
(2760, 2, 0, 'Oldenburg', 523),
(2761, 2, 0, 'GÃƒÂ¶ttingen', 523),
(2762, 2, 0, 'Wolfsburg', 523),
(2763, 2, 0, 'Salzgitter', 523),
(2764, 2, 0, 'Hildesheim', 523),
(2765, 2, 0, 'KÃƒÂ¶ln', 524),
(2766, 2, 0, 'Essen', 524),
(2767, 2, 0, 'Dortmund', 524),
(2768, 2, 0, 'DÃƒÂ¼sseldorf', 524),
(2769, 2, 0, 'Duisburg', 524),
(2770, 2, 0, 'Bochum', 524),
(2771, 2, 0, 'Wuppertal', 524),
(2772, 2, 0, 'Bielefeld', 524),
(2773, 2, 0, 'Bonn', 524),
(2774, 2, 0, 'Gelsenkirchen', 524),
(2775, 2, 0, 'MÃƒÂ¼nster', 524),
(2776, 2, 0, 'MÃƒÂ¶nchengladbach', 524),
(2777, 2, 0, 'Aachen', 524),
(2778, 2, 0, 'Krefeld', 524),
(2779, 2, 0, 'Oberhausen', 524),
(2780, 2, 0, 'Hagen', 524),
(2781, 2, 0, 'Hamm', 524),
(2782, 2, 0, 'Herne', 524),
(2783, 2, 0, 'MÃƒÂ¼lheim An Der Ruhr', 524),
(2784, 2, 0, 'Solingen', 524),
(2785, 2, 0, 'Leverkusen', 524),
(2786, 2, 0, 'Neuss', 524),
(2787, 2, 0, 'Paderborn', 524),
(2788, 2, 0, 'Recklinghausen', 524),
(2789, 2, 0, 'Bottrop', 524),
(2790, 2, 0, 'Remscheid', 524),
(2791, 2, 0, 'Siegen', 524),
(2792, 2, 0, 'Moers', 524),
(2793, 2, 0, 'Bergisch Gladbach', 524),
(2794, 2, 0, 'Witten', 524),
(2795, 2, 0, 'Iserlohn', 524),
(2796, 2, 0, 'GÃƒÂ¼tersloh', 524),
(2797, 2, 0, 'Marl', 524),
(2798, 2, 0, 'LÃƒÂ¼nen', 524),
(2799, 2, 0, 'DÃƒÂ¼ren', 524),
(2800, 2, 0, 'Ratingen', 524),
(2801, 2, 0, 'Velbert', 524),
(2802, 2, 0, 'Mainz', 525),
(2803, 2, 0, 'Ludwigshafen Am Rhein', 525),
(2804, 2, 0, 'Koblenz', 525),
(2805, 2, 0, 'Kaiserslautern', 525),
(2806, 2, 0, 'Trier', 525),
(2807, 2, 0, 'SaarbrÃƒÂ¼cken', 526),
(2808, 2, 0, 'Leipzig', 527),
(2809, 2, 0, 'Dresden', 527),
(2810, 2, 0, 'Chemnitz', 527),
(2811, 2, 0, 'Zwickau', 527),
(2812, 2, 0, 'Kiel', 528),
(2813, 2, 0, 'LÃƒÂ¼beck', 528),
(2814, 2, 0, 'Erfurt', 529),
(2815, 2, 0, 'Gera', 529),
(2816, 2, 0, 'Jena', 529),
(2817, 2, 0, 'Djibouti', 530),
(2818, 2, 0, 'Roseau', 531),
(2819, 2, 0, 'Saint GeorgeÃ‚Â´s', 531),
(2820, 2, 0, 'Kingstown', 531),
(2821, 2, 0, 'Ãƒâ€¦rhus', 532),
(2822, 2, 0, 'Frederiksberg', 533),
(2823, 2, 0, 'Odense', 534),
(2824, 2, 0, 'KÃƒÂ¸benhavn', 535),
(2825, 2, 0, 'Aalborg', 536),
(2826, 2, 0, 'Santo Domingo De GuzmÃƒÂ¡n', 537),
(2827, 2, 0, 'San Francisco De MacorÃƒÂ­s', 538),
(2828, 2, 0, 'La Romana', 539),
(2829, 2, 0, 'San Felipe De Puerto Plata', 540),
(2830, 2, 0, 'San Pedro De MacorÃƒÂ­s', 541),
(2831, 2, 0, 'Santiago De Chile', 542),
(2832, 2, 0, 'Puente Alto', 542),
(2833, 2, 0, 'San Bernardo', 542),
(2834, 2, 0, 'Melipilla', 542),
(2835, 2, 0, 'Santiago De Los Caballeros', 542),
(2836, 2, 0, 'Alger', 543),
(2837, 2, 0, 'Annaba', 544),
(2838, 2, 0, 'Batna', 545),
(2839, 2, 0, 'BÃƒÂ©char', 546),
(2840, 2, 0, 'BÃƒÂ©jaÃƒÂ¯a', 547),
(2841, 2, 0, 'Biskra', 548),
(2842, 2, 0, 'Blida (el-Boulaida)', 549),
(2843, 2, 0, 'Ech-Chleff (el-Asnam)', 550),
(2844, 2, 0, 'Constantine', 551),
(2845, 2, 0, 'GhardaÃƒÂ¯a', 552),
(2846, 2, 0, 'Mostaganem', 553),
(2847, 2, 0, 'Oran', 554),
(2848, 2, 0, 'SÃƒÂ©tif', 555),
(2849, 2, 0, 'Sidi Bel AbbÃƒÂ¨s', 556),
(2850, 2, 0, 'Skikda', 557),
(2851, 2, 0, 'TÃƒÂ©bessa', 558),
(2852, 2, 0, 'Tiaret', 559),
(2853, 2, 0, 'Tlemcen (Tilimsen)', 560),
(2854, 2, 0, 'Cuenca', 561),
(2855, 2, 0, 'RÃƒÂ­obamba', 562),
(2856, 2, 0, 'Machala', 563),
(2857, 2, 0, 'Esmeraldas', 564),
(2858, 2, 0, 'Guayaquil', 565),
(2859, 2, 0, 'Duran [Eloy Alfaro]', 565),
(2860, 2, 0, 'Milagro', 565),
(2861, 2, 0, 'Ibarra', 566),
(2862, 2, 0, 'Loja', 567),
(2863, 2, 0, 'Quevedo', 568),
(2864, 2, 0, 'Portoviejo', 569),
(2865, 2, 0, 'Manta', 569),
(2866, 2, 0, 'Quito', 570),
(2867, 2, 0, 'Santo Domingo De Los Colorados', 570),
(2868, 2, 0, 'Ambato', 571),
(2869, 2, 0, 'Kafr Al-Dawwar', 572),
(2870, 2, 0, 'Damanhur', 572),
(2871, 2, 0, 'Al-Mansura', 573),
(2872, 2, 0, 'Mit Ghamr', 573),
(2873, 2, 0, 'Talkha', 573),
(2874, 2, 0, 'Al-Faiyum', 574),
(2875, 2, 0, 'Al-Mahallat Al-Kubra', 575),
(2876, 2, 0, 'Tanta', 575),
(2877, 2, 0, 'Shibin Al-Kawm', 576),
(2878, 2, 0, 'Al-Minya', 577),
(2879, 2, 0, 'Mallawi', 577),
(2880, 2, 0, 'Shubra Al-Khayma', 578),
(2881, 2, 0, 'Bahtim', 578),
(2882, 2, 0, 'Banha', 578),
(2883, 2, 0, 'Qalyub', 578),
(2884, 2, 0, 'Zagazig', 579),
(2885, 2, 0, 'Bilbays', 579),
(2886, 2, 0, 'Al-Dammam', 579),
(2887, 2, 0, 'Al-Hufuf', 579),
(2888, 2, 0, 'Al-Mubarraz', 579),
(2889, 2, 0, 'Al-Khubar', 579),
(2890, 2, 0, 'Jubayl', 579),
(2891, 2, 0, 'Hafar Al-Batin', 579),
(2892, 2, 0, 'Al-Tuqba', 579),
(2893, 2, 0, 'Al-Qatif', 579),
(2894, 2, 0, 'Alexandria', 580),
(2895, 2, 0, 'Assuan', 581),
(2896, 2, 0, 'Asyut', 582),
(2897, 2, 0, 'Bani Suwayf', 583),
(2898, 2, 0, 'Giza', 584),
(2899, 2, 0, 'Bulaq Al-Dakrur', 584),
(2900, 2, 0, 'Warraq Al-Arab', 584),
(2901, 2, 0, 'Al-Hawamidiya', 584),
(2902, 2, 0, 'Ismailia', 585),
(2903, 2, 0, 'Kafr Al-Shaykh', 586),
(2904, 2, 0, 'Disuq', 586),
(2905, 2, 0, 'Cairo', 587),
(2906, 2, 0, 'Luxor', 588),
(2907, 2, 0, 'Port Said', 589),
(2908, 2, 0, 'Qina', 590),
(2909, 2, 0, 'Idfu', 590),
(2910, 2, 0, 'Sawhaj', 591),
(2911, 2, 0, 'Jirja', 591),
(2912, 2, 0, 'Al-Arish', 592),
(2913, 2, 0, 'Suez', 593),
(2914, 2, 0, 'Asmara', 594),
(2915, 2, 0, 'El-AaiÃƒÂºn', 595),
(2916, 2, 0, 'Sevilla', 596),
(2917, 2, 0, 'MÃƒÂ¡laga', 596),
(2918, 2, 0, 'CÃƒÂ³rdoba', 596),
(2919, 2, 0, 'Granada', 596),
(2920, 2, 0, 'Jerez De La Frontera', 596),
(2921, 2, 0, 'AlmerÃƒÂ­a', 596),
(2922, 2, 0, 'CÃƒÂ¡diz', 596),
(2923, 2, 0, 'Huelva', 596),
(2924, 2, 0, 'JaÃƒÂ©n', 596),
(2925, 2, 0, 'Algeciras', 596),
(2926, 2, 0, 'Marbella', 596),
(2927, 2, 0, 'Dos Hermanas', 596),
(2928, 2, 0, 'Zaragoza', 597),
(2929, 2, 0, 'GijÃƒÂ³n', 598),
(2930, 2, 0, 'Oviedo', 598),
(2931, 2, 0, 'Palma De Mallorca', 599),
(2932, 2, 0, 'Bilbao', 600),
(2933, 2, 0, 'Vitoria-Gasteiz', 600),
(2934, 2, 0, 'Donostia-San SebastiÃƒÂ¡n', 600),
(2935, 2, 0, 'Barakaldo', 600),
(2936, 2, 0, 'Las Palmas De Gran Canaria', 601),
(2937, 2, 0, 'Santa Cruz De Tenerife', 601),
(2938, 2, 0, 'San CristÃƒÂ³bal De La Laguna', 601),
(2939, 2, 0, 'Santander', 602),
(2940, 2, 0, 'Valladolid', 603),
(2941, 2, 0, 'Burgos', 603),
(2942, 2, 0, 'Salamanca', 603),
(2943, 2, 0, 'LeÃƒÂ³n', 603),
(2944, 2, 0, 'Badajoz', 604),
(2945, 2, 0, 'Vigo', 605),
(2946, 2, 0, 'A CoruÃƒÂ±a (La CoruÃƒÂ±a)', 605),
(2947, 2, 0, 'Ourense (Orense)', 605),
(2948, 2, 0, 'Santiago De Compostela', 605),
(2949, 2, 0, 'Albacete', 606),
(2950, 2, 0, 'Barcelona', 607),
(2951, 2, 0, 'LÃ‚Â´Hospitalet De Llobregat', 607),
(2952, 2, 0, 'Badalona', 607),
(2953, 2, 0, 'Sabadell', 607),
(2954, 2, 0, 'Terrassa', 607),
(2955, 2, 0, 'Santa Coloma De Gramenet', 607),
(2956, 2, 0, 'Tarragona', 607),
(2957, 2, 0, 'Lleida (LÃƒÂ©rida)', 607),
(2958, 2, 0, 'MatarÃƒÂ³', 607),
(2959, 2, 0, 'La Rioja', 608),
(2960, 2, 0, 'LogroÃƒÂ±o', 608),
(2961, 2, 0, 'Madrid', 609),
(2962, 2, 0, 'MÃƒÂ³stoles', 609),
(2963, 2, 0, 'LeganÃƒÂ©s', 609),
(2964, 2, 0, 'Fuenlabrada', 609),
(2965, 2, 0, 'AlcalÃƒÂ¡ De Henares', 609),
(2966, 2, 0, 'Getafe', 609),
(2967, 2, 0, 'AlcorcÃƒÂ³n', 609),
(2968, 2, 0, 'TorrejÃƒÂ³n De Ardoz', 609),
(2969, 2, 0, 'Murcia', 610),
(2970, 2, 0, 'Cartagena', 610),
(2971, 2, 0, 'Pamplona [IruÃƒÂ±a]', 611),
(2972, 2, 0, 'Valencia', 612),
(2973, 2, 0, 'Alicante [Alacant]', 612),
(2974, 2, 0, 'Elche [Elx]', 612),
(2975, 2, 0, 'CastellÃƒÂ³n De La Plana', 612),
(2976, 2, 0, 'Tallinn', 613),
(2977, 2, 0, 'Tartu', 614),
(2978, 2, 0, 'Addis Abeba', 615),
(2979, 2, 0, 'Gonder', 616),
(2980, 2, 0, 'Dese', 616),
(2981, 2, 0, 'Bahir Dar', 616),
(2982, 2, 0, 'Dire Dawa', 617),
(2983, 2, 0, 'Nazret', 618),
(2984, 2, 0, 'Mekele', 619),
(2985, 2, 0, 'Helsinki [Helsingfors]', 620),
(2986, 2, 0, 'Espoo', 620),
(2987, 2, 0, 'Vantaa', 620),
(2988, 2, 0, 'Lahti', 621),
(2989, 2, 0, 'Tampere', 622),
(2990, 2, 0, 'Oulu', 623),
(2991, 2, 0, 'Turku [Ãƒâ€¦bo]', 624),
(2992, 2, 0, 'Suva', 625),
(2993, 2, 0, 'Nyeri', 625),
(2994, 2, 0, 'Kathmandu', 625),
(2995, 2, 0, 'Lalitapur', 625),
(2996, 2, 0, 'Birgunj', 625),
(2997, 2, 0, 'San Lorenzo', 625),
(2998, 2, 0, 'LambarÃƒÂ©', 625),
(2999, 2, 0, 'Fernando De La Mora', 625),
(3000, 2, 0, 'Kabwe', 625),
(3001, 2, 0, 'Kandy', 625),
(3002, 2, 0, 'Kampala', 625),
(3003, 2, 0, 'Stanley', 626),
(3004, 2, 0, 'Strasbourg', 627),
(3005, 2, 0, 'Mulhouse', 627),
(3006, 2, 0, 'Bordeaux', 628),
(3007, 2, 0, 'Clermont-Ferrand', 629),
(3008, 2, 0, 'Paris', 630),
(3009, 2, 0, 'Boulogne-Billancourt', 630),
(3010, 2, 0, 'Argenteuil', 630),
(3011, 2, 0, 'Montreuil', 630),
(3012, 2, 0, 'Caen', 631),
(3013, 2, 0, 'Dijon', 632),
(3014, 2, 0, 'St-Ãƒâ€°tienne', 633),
(3015, 2, 0, 'Brest', 633),
(3016, 2, 0, 'YaoundÃƒÂ©', 634),
(3017, 2, 0, 'Tours', 634),
(3018, 2, 0, 'OrlÃƒÂ©ans', 634),
(3019, 2, 0, 'Le Havre', 635),
(3020, 2, 0, 'BesanÃƒÂ§on', 636),
(3021, 2, 0, 'Rennes', 637),
(3022, 2, 0, 'Rouen', 637),
(3023, 2, 0, 'Montpellier', 638),
(3024, 2, 0, 'NÃƒÂ®mes', 638),
(3025, 2, 0, 'Perpignan', 638),
(3026, 2, 0, 'Limoges', 639),
(3027, 2, 0, 'Metz', 640),
(3028, 2, 0, 'Nancy', 640),
(3029, 2, 0, 'Toulouse', 641),
(3030, 2, 0, 'Reims', 642),
(3031, 2, 0, 'Roubaix', 642),
(3032, 2, 0, 'Tourcoing', 642),
(3033, 2, 0, 'Nantes', 643),
(3034, 2, 0, 'Angers', 643),
(3035, 2, 0, 'Le Mans', 643),
(3036, 2, 0, 'Amiens', 644),
(3037, 2, 0, 'Marseille', 645),
(3038, 2, 0, 'Nice', 645),
(3039, 2, 0, 'Toulon', 645),
(3040, 2, 0, 'Aix-en-Provence', 645),
(3041, 2, 0, 'Lyon', 646),
(3042, 2, 0, 'Lille', 646),
(3043, 2, 0, 'Grenoble', 646),
(3044, 2, 0, 'Villeurbanne', 646),
(3045, 2, 0, 'TÃƒÂ³rshavn', 647),
(3046, 2, 0, 'Weno', 648),
(3047, 2, 0, 'Palikir', 649),
(3048, 2, 0, 'Libreville', 650),
(3049, 2, 0, 'South Hill', 651),
(3050, 2, 0, 'The Valley', 651),
(3051, 2, 0, 'Oranjestad', 651),
(3052, 2, 0, 'Douglas', 651),
(3053, 2, 0, 'Gibraltar', 651),
(3054, 2, 0, 'Tamuning', 651),
(3055, 2, 0, 'AgaÃƒÂ±a', 651),
(3056, 2, 0, 'Flying Fish Cove', 651),
(3057, 2, 0, 'Monte-Carlo', 651),
(3058, 2, 0, 'Monaco-Ville', 651),
(3059, 2, 0, 'Yangor', 651),
(3060, 2, 0, 'Yaren', 651),
(3061, 2, 0, 'Alofi', 651),
(3062, 2, 0, 'Kingston', 651),
(3063, 2, 0, 'Adamstown', 651),
(3064, 2, 0, 'Singapore', 651),
(3065, 2, 0, 'NoumÃƒÂ©a', 651),
(3066, 2, 0, 'CittÃƒÂ  Del Vaticano', 651),
(3067, 2, 0, 'London', 652),
(3068, 2, 0, 'Birmingham', 652),
(3069, 2, 0, 'Liverpool', 652),
(3070, 2, 0, 'Sheffield', 652),
(3071, 2, 0, 'Manchester', 652),
(3072, 2, 0, 'Leeds', 652),
(3073, 2, 0, 'Bristol', 652),
(3074, 2, 0, 'Coventry', 652),
(3075, 2, 0, 'Leicester', 652),
(3076, 2, 0, 'Bradford', 652),
(3077, 2, 0, 'Nottingham', 652),
(3078, 2, 0, 'Kingston Upon Hull', 652),
(3079, 2, 0, 'Plymouth', 652),
(3080, 2, 0, 'Stoke-on-Trent', 652),
(3081, 2, 0, 'Wolverhampton', 652),
(3082, 2, 0, 'Derby', 652),
(3083, 2, 0, 'Southampton', 652),
(3084, 2, 0, 'Northampton', 652),
(3085, 2, 0, 'Dudley', 652),
(3086, 2, 0, 'Portsmouth', 652),
(3087, 2, 0, 'Newcastle Upon Tyne', 652),
(3088, 2, 0, 'Sunderland', 652),
(3089, 2, 0, 'Luton', 652),
(3090, 2, 0, 'Swindon', 652),
(3091, 2, 0, 'Southend-on-Sea', 652),
(3092, 2, 0, 'Walsall', 652),
(3093, 2, 0, 'Bournemouth', 652),
(3094, 2, 0, 'Peterborough', 652),
(3095, 2, 0, 'Brighton', 652),
(3096, 2, 0, 'Blackpool', 652),
(3097, 2, 0, 'West Bromwich', 652),
(3098, 2, 0, 'Reading', 652),
(3099, 2, 0, 'Oldbury/Smethwick (Warley)', 652),
(3100, 2, 0, 'Middlesbrough', 652),
(3101, 2, 0, 'Huddersfield', 652),
(3102, 2, 0, 'Oxford', 652),
(3103, 2, 0, 'Poole', 652),
(3104, 2, 0, 'Bolton', 652),
(3105, 2, 0, 'Blackburn', 652),
(3106, 2, 0, 'Preston', 652),
(3107, 2, 0, 'Stockport', 652),
(3108, 2, 0, 'Norwich', 652),
(3109, 2, 0, 'Rotherham', 652),
(3110, 2, 0, 'Cambridge', 652),
(3111, 2, 0, 'Watford', 652),
(3112, 2, 0, 'Ipswich', 652),
(3113, 2, 0, 'Slough', 652),
(3114, 2, 0, 'Exeter', 652),
(3115, 2, 0, 'Cheltenham', 652),
(3116, 2, 0, 'Gloucester', 652),
(3117, 2, 0, 'Saint Helens', 652),
(3118, 2, 0, 'Sutton Coldfield', 652),
(3119, 2, 0, 'York', 652),
(3120, 2, 0, 'Oldham', 652),
(3121, 2, 0, 'Basildon', 652),
(3122, 2, 0, 'Worthing', 652),
(3123, 2, 0, 'Chelmsford', 652),
(3124, 2, 0, 'Colchester', 652),
(3125, 2, 0, 'Crawley', 652),
(3126, 2, 0, 'Gillingham', 652),
(3127, 2, 0, 'Solihull', 652),
(3128, 2, 0, 'Rochdale', 652),
(3129, 2, 0, 'Birkenhead', 652),
(3130, 2, 0, 'Worcester', 652),
(3131, 2, 0, 'Hartlepool', 652),
(3132, 2, 0, 'Halifax', 652),
(3133, 2, 0, 'Woking/Byfleet', 652),
(3134, 2, 0, 'Southport', 652),
(3135, 2, 0, 'Maidstone', 652),
(3136, 2, 0, 'Eastbourne', 652),
(3137, 2, 0, 'Grimsby', 652),
(3138, 2, 0, 'Saint Helier', 653),
(3139, 2, 0, 'Belfast', 654),
(3140, 2, 0, 'Glasgow', 655),
(3141, 2, 0, 'Edinburgh', 655),
(3142, 2, 0, 'Aberdeen', 655),
(3143, 2, 0, 'Dundee', 655),
(3144, 2, 0, 'Cardiff', 656),
(3145, 2, 0, 'Swansea', 656),
(3146, 2, 0, 'Newport', 656),
(3147, 2, 0, 'Sohumi', 657),
(3148, 2, 0, 'Batumi', 658),
(3149, 2, 0, 'Kutaisi', 659),
(3150, 2, 0, 'Rustavi', 660),
(3151, 2, 0, 'Tbilisi', 661),
(3152, 2, 0, 'Kumasi', 662),
(3153, 2, 0, 'Accra', 663),
(3154, 2, 0, 'Tema', 663),
(3155, 2, 0, 'Tamale', 664),
(3156, 2, 0, 'Jaffna', 664),
(3157, 2, 0, 'Sekondi-Takoradi', 665),
(3158, 2, 0, 'Pokhara', 665),
(3159, 2, 0, 'Freetown', 665),
(3160, 2, 0, 'Colombo', 665),
(3161, 2, 0, 'Dehiwala', 665),
(3162, 2, 0, 'Moratuwa', 665),
(3163, 2, 0, 'Sri Jayawardenepura Kotte', 665),
(3164, 2, 0, 'Negombo', 665),
(3165, 2, 0, 'South Hill', 666),
(3166, 2, 0, 'The Valley', 666),
(3167, 2, 0, 'Oranjestad', 666),
(3168, 2, 0, 'Douglas', 666),
(3169, 2, 0, 'Gibraltar', 666),
(3170, 2, 0, 'Tamuning', 666),
(3171, 2, 0, 'AgaÃƒÂ±a', 666),
(3172, 2, 0, 'Flying Fish Cove', 666),
(3173, 2, 0, 'Monte-Carlo', 666),
(3174, 2, 0, 'Monaco-Ville', 666),
(3175, 2, 0, 'Yangor', 666),
(3176, 2, 0, 'Yaren', 666),
(3177, 2, 0, 'Alofi', 666),
(3178, 2, 0, 'Kingston', 666),
(3179, 2, 0, 'Adamstown', 666),
(3180, 2, 0, 'Singapore', 666),
(3181, 2, 0, 'NoumÃƒÂ©a', 666),
(3182, 2, 0, 'CittÃƒÂ  Del Vaticano', 666),
(3183, 2, 0, 'Conakry', 667),
(3184, 2, 0, 'Basse-Terre', 668),
(3185, 2, 0, 'Les Abymes', 669),
(3186, 2, 0, 'Banjul', 670),
(3187, 2, 0, 'Serekunda', 671),
(3188, 2, 0, 'Bissau', 672),
(3189, 2, 0, 'Malabo', 673),
(3190, 2, 0, 'Athenai', 674),
(3191, 2, 0, 'Pireus', 674),
(3192, 2, 0, 'Peristerion', 674),
(3193, 2, 0, 'Kallithea', 674),
(3194, 2, 0, 'Thessaloniki', 675),
(3195, 2, 0, 'Herakleion', 676),
(3196, 2, 0, 'Larisa', 677),
(3197, 2, 0, 'Patras', 678),
(3198, 2, 0, 'Roseau', 679),
(3199, 2, 0, 'Saint GeorgeÃ‚Â´s', 679),
(3200, 2, 0, 'Kingstown', 679),
(3201, 2, 0, 'Nuuk', 680),
(3202, 2, 0, 'Ciudad De Guatemala', 681),
(3203, 2, 0, 'Mixco', 681),
(3204, 2, 0, 'Villa Nueva', 681),
(3205, 2, 0, 'Quetzaltenango', 682),
(3206, 2, 0, 'Cayenne', 683),
(3207, 2, 0, 'South Hill', 684),
(3208, 2, 0, 'The Valley', 684),
(3209, 2, 0, 'Oranjestad', 684),
(3210, 2, 0, 'Douglas', 684),
(3211, 2, 0, 'Gibraltar', 684),
(3212, 2, 0, 'Tamuning', 684),
(3213, 2, 0, 'AgaÃƒÂ±a', 684),
(3214, 2, 0, 'Flying Fish Cove', 684),
(3215, 2, 0, 'Monte-Carlo', 684),
(3216, 2, 0, 'Monaco-Ville', 684),
(3217, 2, 0, 'Yangor', 684),
(3218, 2, 0, 'Yaren', 684),
(3219, 2, 0, 'Alofi', 684),
(3220, 2, 0, 'Kingston', 684),
(3221, 2, 0, 'Adamstown', 684),
(3222, 2, 0, 'Singapore', 684),
(3223, 2, 0, 'NoumÃƒÂ©a', 684),
(3224, 2, 0, 'CittÃƒÂ  Del Vaticano', 684),
(3225, 2, 0, 'Georgetown', 685),
(3226, 2, 0, 'Victoria', 686),
(3227, 2, 0, 'Kowloon And New Kowloon', 687),
(3228, 2, 0, 'La Ceiba', 688),
(3229, 2, 0, 'San Pedro Sula', 689),
(3230, 2, 0, 'Tegucigalpa', 690),
(3231, 2, 0, 'Zagreb', 691),
(3232, 2, 0, 'Osijek', 692),
(3233, 2, 0, 'Rijeka', 693),
(3234, 2, 0, 'Split', 694),
(3235, 2, 0, 'Le-Cap-HaÃƒÂ¯tien', 695),
(3236, 2, 0, 'Garoua', 695),
(3237, 2, 0, 'Port-au-Prince', 696),
(3238, 2, 0, 'Carrefour', 696),
(3239, 2, 0, 'Delmas', 696),
(3240, 2, 0, 'Bafoussam', 696),
(3241, 2, 0, 'PÃƒÂ©cs', 697),
(3242, 2, 0, 'KecskemÃƒÂ©t', 698),
(3243, 2, 0, 'Miskolc', 699),
(3244, 2, 0, 'Budapest', 700),
(3245, 2, 0, 'Szeged', 701),
(3246, 2, 0, 'SzÃƒÂ©kesfehÃƒÂ©rvÃƒÂ¡r', 702),
(3247, 2, 0, 'GyÃƒÂ¶r', 703),
(3248, 2, 0, 'Debrecen', 704),
(3249, 2, 0, 'NyiregyhÃƒÂ¡za', 705),
(3250, 2, 0, 'Banda Aceh', 706),
(3251, 2, 0, 'Lhokseumawe', 706),
(3252, 2, 0, 'Denpasar', 707),
(3253, 2, 0, 'Bengkulu', 708),
(3254, 2, 0, 'Semarang', 709),
(3255, 2, 0, 'Surakarta', 709),
(3256, 2, 0, 'Pekalongan', 709),
(3257, 2, 0, 'Tegal', 709),
(3258, 2, 0, 'Cilacap', 709),
(3259, 2, 0, 'Purwokerto', 709),
(3260, 2, 0, 'Magelang', 709),
(3261, 2, 0, 'Pemalang', 709),
(3262, 2, 0, 'Klaten', 709),
(3263, 2, 0, 'Salatiga', 709),
(3264, 2, 0, 'Kudus', 709),
(3265, 2, 0, 'Surabaya', 710),
(3266, 2, 0, 'Malang', 710),
(3267, 2, 0, 'Kediri', 710),
(3268, 2, 0, 'Jember', 710),
(3269, 2, 0, 'Madiun', 710),
(3270, 2, 0, 'Pasuruan', 710),
(3271, 2, 0, 'Waru', 710),
(3272, 2, 0, 'Blitar', 710),
(3273, 2, 0, 'Probolinggo', 710),
(3274, 2, 0, 'Taman', 710),
(3275, 2, 0, 'Mojokerto', 710),
(3276, 2, 0, 'Jombang', 710),
(3277, 2, 0, 'Banyuwangi', 710),
(3278, 2, 0, 'Jakarta', 711),
(3279, 2, 0, 'Jambi', 712),
(3280, 2, 0, 'Pontianak', 713),
(3281, 2, 0, 'Banjarmasin', 714),
(3282, 2, 0, 'Palangka Raya', 715),
(3283, 2, 0, 'Samarinda', 716),
(3284, 2, 0, 'Balikpapan', 716),
(3285, 2, 0, 'Bandar Lampung', 717),
(3286, 2, 0, 'Ambon', 718),
(3287, 2, 0, 'Mataram', 719),
(3288, 2, 0, 'Kupang', 720),
(3289, 2, 0, 'Pekan Baru', 721),
(3290, 2, 0, 'Batam', 721),
(3291, 2, 0, 'Tanjung Pinang', 721),
(3292, 2, 0, 'Ujung Pandang', 722),
(3293, 2, 0, 'Palu', 723),
(3294, 2, 0, 'Kendari', 724),
(3295, 2, 0, 'Manado', 725),
(3296, 2, 0, 'Gorontalo', 725),
(3297, 2, 0, 'Padang', 726),
(3298, 2, 0, 'Palembang', 727),
(3299, 2, 0, 'Pangkal Pinang', 727),
(3300, 2, 0, 'Medan', 728),
(3301, 2, 0, 'Pematang Siantar', 728),
(3302, 2, 0, 'Tebing Tinggi', 728),
(3303, 2, 0, 'Percut Sei Tuan', 728),
(3304, 2, 0, 'Binjai', 728),
(3305, 2, 0, 'Sunggal', 728),
(3306, 2, 0, 'Padang Sidempuan', 728),
(3307, 2, 0, 'Jaya Pura', 729),
(3308, 2, 0, 'Bandung', 730),
(3309, 2, 0, 'Tangerang', 730),
(3310, 2, 0, 'Bekasi', 730),
(3311, 2, 0, 'Depok', 730),
(3312, 2, 0, 'Cimahi', 730),
(3313, 2, 0, 'Bogor', 730),
(3314, 2, 0, 'Ciputat', 730),
(3315, 2, 0, 'Pondokgede', 730),
(3316, 2, 0, 'Cirebon', 730),
(3317, 2, 0, 'Cimanggis', 730),
(3318, 2, 0, 'Ciomas', 730),
(3319, 2, 0, 'Tasikmalaya', 730),
(3320, 2, 0, 'Karawang', 730),
(3321, 2, 0, 'Sukabumi', 730),
(3322, 2, 0, 'Serang', 730),
(3323, 2, 0, 'Cilegon', 730),
(3324, 2, 0, 'Cianjur', 730),
(3325, 2, 0, 'Ciparay', 730),
(3326, 2, 0, 'Citeureup', 730),
(3327, 2, 0, 'Cibinong', 730),
(3328, 2, 0, 'Purwakarta', 730),
(3329, 2, 0, 'Garut', 730),
(3330, 2, 0, 'Majalaya', 730),
(3331, 2, 0, 'Pondok Aren', 730),
(3332, 2, 0, 'Sawangan', 730),
(3333, 2, 0, 'Yogyakarta', 731),
(3334, 2, 0, 'Depok', 731),
(3335, 2, 0, 'Hyderabad', 732),
(3336, 2, 0, 'Vishakhapatnam', 732),
(3337, 2, 0, 'Vijayawada', 732),
(3338, 2, 0, 'Guntur', 732),
(3339, 2, 0, 'Warangal', 732),
(3340, 2, 0, 'Rajahmundry', 732),
(3341, 2, 0, 'Nellore', 732),
(3342, 2, 0, 'Kakinada', 732),
(3343, 2, 0, 'Nizamabad', 732),
(3344, 2, 0, 'Kurnool', 732),
(3345, 2, 0, 'Ramagundam', 732),
(3346, 2, 0, 'Eluru', 732),
(3347, 2, 0, 'Kukatpalle', 732),
(3348, 2, 0, 'Anantapur', 732),
(3349, 2, 0, 'Tirupati', 732),
(3350, 2, 0, 'Secunderabad', 732),
(3351, 2, 0, 'Vizianagaram', 732),
(3352, 2, 0, 'Machilipatnam (Masulipatam)', 732),
(3353, 2, 0, 'Lalbahadur Nagar', 732),
(3354, 2, 0, 'Karimnagar', 732),
(3355, 2, 0, 'Tenali', 732),
(3356, 2, 0, 'Adoni', 732),
(3357, 2, 0, 'Proddatur', 732),
(3358, 2, 0, 'Chittoor', 732),
(3359, 2, 0, 'Khammam', 732),
(3360, 2, 0, 'Malkajgiri', 732),
(3361, 2, 0, 'Cuddapah', 732),
(3362, 2, 0, 'Bhimavaram', 732),
(3363, 2, 0, 'Nandyal', 732),
(3364, 2, 0, 'Mahbubnagar', 732),
(3365, 2, 0, 'Guntakal', 732),
(3366, 2, 0, 'Qutubullapur', 732),
(3367, 2, 0, 'Hindupur', 732),
(3368, 2, 0, 'Gudivada', 732);
INSERT INTO `tbl_geographical_location` (`location_id`, `location_type`, `is_visible`, `name`, `parent_id`) VALUES
(3369, 2, 0, 'Ongole', 732),
(3370, 2, 0, 'Guwahati (Gauhati)', 733),
(3371, 2, 0, 'Dibrugarh', 733),
(3372, 2, 0, 'Silchar', 733),
(3373, 2, 0, 'Nagaon', 733),
(3374, 2, 0, 'Patna', 734),
(3375, 2, 0, 'Gaya', 734),
(3376, 2, 0, 'Bhagalpur', 734),
(3377, 2, 0, 'Muzaffarpur', 734),
(3378, 2, 0, 'Darbhanga', 734),
(3379, 2, 0, 'Bihar Sharif', 734),
(3380, 2, 0, 'Arrah (Ara)', 734),
(3381, 2, 0, 'Katihar', 734),
(3382, 2, 0, 'Munger (Monghyr)', 734),
(3383, 2, 0, 'Chapra', 734),
(3384, 2, 0, 'Sasaram', 734),
(3385, 2, 0, 'Dehri', 734),
(3386, 2, 0, 'Bettiah', 734),
(3387, 2, 0, 'Chandigarh', 735),
(3388, 2, 0, 'Raipur', 736),
(3389, 2, 0, 'Bhilai', 736),
(3390, 2, 0, 'Bilaspur', 736),
(3391, 2, 0, 'Durg', 736),
(3392, 2, 0, 'Raj Nandgaon', 736),
(3393, 2, 0, 'Korba', 736),
(3394, 2, 0, 'Raigarh', 736),
(3395, 2, 0, 'Delhi', 737),
(3396, 2, 0, 'New Delhi', 737),
(3397, 2, 0, 'Delhi Cantonment', 737),
(3398, 2, 0, 'Ahmedabad', 738),
(3399, 2, 0, 'Surat', 738),
(3400, 2, 0, 'Vadodara (Baroda)', 738),
(3401, 2, 0, 'Rajkot', 738),
(3402, 2, 0, 'Bhavnagar', 738),
(3403, 2, 0, 'Jamnagar', 738),
(3404, 2, 0, 'Nadiad', 738),
(3405, 2, 0, 'Bharuch (Broach)', 738),
(3406, 2, 0, 'Junagadh', 738),
(3407, 2, 0, 'Navsari', 738),
(3408, 2, 0, 'Gandhinagar', 738),
(3409, 2, 0, 'Veraval', 738),
(3410, 2, 0, 'Porbandar', 738),
(3411, 2, 0, 'Anand', 738),
(3412, 2, 0, 'Surendranagar', 738),
(3413, 2, 0, 'Gandhidham', 738),
(3414, 2, 0, 'Bhuj', 738),
(3415, 2, 0, 'Godhra', 738),
(3416, 2, 0, 'Patan', 738),
(3417, 2, 0, 'Morvi', 738),
(3418, 2, 0, 'Vejalpur', 738),
(3419, 2, 0, 'Faridabad', 739),
(3420, 2, 0, 'Rohtak', 739),
(3421, 2, 0, 'Panipat', 739),
(3422, 2, 0, 'Karnal', 739),
(3423, 2, 0, 'Hisar (Hissar)', 739),
(3424, 2, 0, 'Yamuna Nagar', 739),
(3425, 2, 0, 'Sonipat (Sonepat)', 739),
(3426, 2, 0, 'Gurgaon', 739),
(3427, 2, 0, 'Sirsa', 739),
(3428, 2, 0, 'Ambala', 739),
(3429, 2, 0, 'Bhiwani', 739),
(3430, 2, 0, 'Ambala Sadar', 739),
(3431, 2, 0, 'Srinagar', 740),
(3432, 2, 0, 'Jammu', 740),
(3433, 2, 0, 'Ranchi', 741),
(3434, 2, 0, 'Jamshedpur', 741),
(3435, 2, 0, 'Bokaro Steel City', 741),
(3436, 2, 0, 'Dhanbad', 741),
(3437, 2, 0, 'Purnea (Purnia)', 741),
(3438, 2, 0, 'Mango', 741),
(3439, 2, 0, 'Hazaribag', 741),
(3440, 2, 0, 'Purulia', 741),
(3441, 2, 0, 'Bangalore', 742),
(3442, 2, 0, 'Hubli-Dharwad', 742),
(3443, 2, 0, 'Mysore', 742),
(3444, 2, 0, 'Belgaum', 742),
(3445, 2, 0, 'Gulbarga', 742),
(3446, 2, 0, 'Mangalore', 742),
(3447, 2, 0, 'Davangere', 742),
(3448, 2, 0, 'Bellary', 742),
(3449, 2, 0, 'Bijapur', 742),
(3450, 2, 0, 'Shimoga', 742),
(3451, 2, 0, 'Raichur', 742),
(3452, 2, 0, 'Timkur', 742),
(3453, 2, 0, 'Gadag Betigeri', 742),
(3454, 2, 0, 'Mandya', 742),
(3455, 2, 0, 'Bidar', 742),
(3456, 2, 0, 'Hospet', 742),
(3457, 2, 0, 'Hassan', 742),
(3458, 2, 0, 'Cochin (Kochi)', 743),
(3459, 2, 0, 'Thiruvananthapuram (Trivandrum', 743),
(3460, 2, 0, 'Calicut (Kozhikode)', 743),
(3461, 2, 0, 'Allappuzha (Alleppey)', 743),
(3462, 2, 0, 'Kollam (Quilon)', 743),
(3463, 2, 0, 'Palghat (Palakkad)', 743),
(3464, 2, 0, 'Tellicherry (Thalassery)', 743),
(3465, 2, 0, 'Indore', 744),
(3466, 2, 0, 'Bhopal', 744),
(3467, 2, 0, 'Jabalpur', 744),
(3468, 2, 0, 'Gwalior', 744),
(3469, 2, 0, 'Ujjain', 744),
(3470, 2, 0, 'Sagar', 744),
(3471, 2, 0, 'Ratlam', 744),
(3472, 2, 0, 'Burhanpur', 744),
(3473, 2, 0, 'Dewas', 744),
(3474, 2, 0, 'Murwara (Katni)', 744),
(3475, 2, 0, 'Satna', 744),
(3476, 2, 0, 'Morena', 744),
(3477, 2, 0, 'Khandwa', 744),
(3478, 2, 0, 'Rewa', 744),
(3479, 2, 0, 'Bhind', 744),
(3480, 2, 0, 'Shivapuri', 744),
(3481, 2, 0, 'Guna', 744),
(3482, 2, 0, 'Mandasor', 744),
(3483, 2, 0, 'Damoh', 744),
(3484, 2, 0, 'Chhindwara', 744),
(3485, 2, 0, 'Vidisha', 744),
(3486, 2, 0, 'Mumbai (Bombay)', 745),
(3487, 2, 0, 'Nagpur', 745),
(3488, 2, 0, 'Pune', 745),
(3489, 2, 0, 'Kalyan', 745),
(3490, 2, 0, 'Thane (Thana)', 745),
(3491, 2, 0, 'Nashik (Nasik)', 745),
(3492, 2, 0, 'Solapur (Sholapur)', 745),
(3493, 2, 0, 'Shambajinagar (Aurangabad)', 745),
(3494, 2, 0, 'Pimpri-Chinchwad', 745),
(3495, 2, 0, 'Amravati', 745),
(3496, 2, 0, 'Kolhapur', 745),
(3497, 2, 0, 'Bhiwandi', 745),
(3498, 2, 0, 'Ulhasnagar', 745),
(3499, 2, 0, 'Malegaon', 745),
(3500, 2, 0, 'Akola', 745),
(3501, 2, 0, 'New Bombay', 745),
(3502, 2, 0, 'Dhule (Dhulia)', 745),
(3503, 2, 0, 'Nanded (Nander)', 745),
(3504, 2, 0, 'Jalgaon', 745),
(3505, 2, 0, 'Chandrapur', 745),
(3506, 2, 0, 'Ichalkaranji', 745),
(3507, 2, 0, 'Latur', 745),
(3508, 2, 0, 'Sangli', 745),
(3509, 2, 0, 'Parbhani', 745),
(3510, 2, 0, 'Ahmadnagar', 745),
(3511, 2, 0, 'Mira Bhayandar', 745),
(3512, 2, 0, 'Jalna', 745),
(3513, 2, 0, 'Bhusawal', 745),
(3514, 2, 0, 'Miraj', 745),
(3515, 2, 0, 'Bhir (Bid)', 745),
(3516, 2, 0, 'Gondiya', 745),
(3517, 2, 0, 'Yeotmal (Yavatmal)', 745),
(3518, 2, 0, 'Wardha', 745),
(3519, 2, 0, 'Achalpur', 745),
(3520, 2, 0, 'Satara', 745),
(3521, 2, 0, 'Imphal', 746),
(3522, 2, 0, 'Shillong', 747),
(3523, 2, 0, 'Aizawl', 748),
(3524, 2, 0, 'Bhubaneswar', 749),
(3525, 2, 0, 'Kataka', 749),
(3526, 2, 0, 'Raurkela', 749),
(3527, 2, 0, 'Brahmapur', 749),
(3528, 2, 0, 'Raurkela Civil Township', 749),
(3529, 2, 0, 'Sambalpur', 749),
(3530, 2, 0, 'Puri', 749),
(3531, 2, 0, 'Pondicherry', 750),
(3532, 2, 0, 'Ludhiana', 751),
(3533, 2, 0, 'Amritsar', 751),
(3534, 2, 0, 'Jalandhar (Jullundur)', 751),
(3535, 2, 0, 'Patiala', 751),
(3536, 2, 0, 'Bhatinda (Bathinda)', 751),
(3537, 2, 0, 'Pathankot', 751),
(3538, 2, 0, 'Hoshiarpur', 751),
(3539, 2, 0, 'Moga', 751),
(3540, 2, 0, 'Abohar', 751),
(3541, 2, 0, 'Lahore', 751),
(3542, 2, 0, 'Faisalabad', 751),
(3543, 2, 0, 'Rawalpindi', 751),
(3544, 2, 0, 'Multan', 751),
(3545, 2, 0, 'Gujranwala', 751),
(3546, 2, 0, 'Sargodha', 751),
(3547, 2, 0, 'Sialkot', 751),
(3548, 2, 0, 'Bahawalpur', 751),
(3549, 2, 0, 'Jhang', 751),
(3550, 2, 0, 'Sheikhupura', 751),
(3551, 2, 0, 'Gujrat', 751),
(3552, 2, 0, 'Kasur', 751),
(3553, 2, 0, 'Rahim Yar Khan', 751),
(3554, 2, 0, 'Sahiwal', 751),
(3555, 2, 0, 'Okara', 751),
(3556, 2, 0, 'Wah', 751),
(3557, 2, 0, 'Dera Ghazi Khan', 751),
(3558, 2, 0, 'Chiniot', 751),
(3559, 2, 0, 'Kamoke', 751),
(3560, 2, 0, 'Mandi Burewala', 751),
(3561, 2, 0, 'Jhelum', 751),
(3562, 2, 0, 'Sadiqabad', 751),
(3563, 2, 0, 'Khanewal', 751),
(3564, 2, 0, 'Hafizabad', 751),
(3565, 2, 0, 'Muzaffargarh', 751),
(3566, 2, 0, 'Khanpur', 751),
(3567, 2, 0, 'Gojra', 751),
(3568, 2, 0, 'Bahawalnagar', 751),
(3569, 2, 0, 'Muridke', 751),
(3570, 2, 0, 'Pak Pattan', 751),
(3571, 2, 0, 'Jaranwala', 751),
(3572, 2, 0, 'Chishtian Mandi', 751),
(3573, 2, 0, 'Daska', 751),
(3574, 2, 0, 'Mandi Bahauddin', 751),
(3575, 2, 0, 'Ahmadpur East', 751),
(3576, 2, 0, 'Kamalia', 751),
(3577, 2, 0, 'Vihari', 751),
(3578, 2, 0, 'Wazirabad', 751),
(3579, 2, 0, 'Jaipur', 752),
(3580, 2, 0, 'Jodhpur', 752),
(3581, 2, 0, 'Kota', 752),
(3582, 2, 0, 'Bikaner', 752),
(3583, 2, 0, 'Ajmer', 752),
(3584, 2, 0, 'Udaipur', 752),
(3585, 2, 0, 'Alwar', 752),
(3586, 2, 0, 'Bhilwara', 752),
(3587, 2, 0, 'Ganganagar', 752),
(3588, 2, 0, 'Bharatpur', 752),
(3589, 2, 0, 'Sikar', 752),
(3590, 2, 0, 'Pali', 752),
(3591, 2, 0, 'Beawar', 752),
(3592, 2, 0, 'Tonk', 752),
(3593, 2, 0, 'Chennai', 753),
(3594, 2, 0, 'Madurai', 753),
(3595, 2, 0, 'Coimbatore', 753),
(3596, 2, 0, 'Tiruchirapalli', 753),
(3597, 2, 0, 'Salem', 753),
(3598, 2, 0, 'Tiruppur', 753),
(3599, 2, 0, 'Ambattur', 753),
(3600, 2, 0, 'Thanjavur', 753),
(3601, 2, 0, 'Tuticorin', 753),
(3602, 2, 0, 'Nagar Coil', 753),
(3603, 2, 0, 'Avadi', 753),
(3604, 2, 0, 'Dindigul', 753),
(3605, 2, 0, 'Vellore', 753),
(3606, 2, 0, 'Tiruvottiyur', 753),
(3607, 2, 0, 'Erode', 753),
(3608, 2, 0, 'Cuddalore', 753),
(3609, 2, 0, 'Kanchipuram', 753),
(3610, 2, 0, 'Kumbakonam', 753),
(3611, 2, 0, 'Tirunelveli', 753),
(3612, 2, 0, 'Alandur', 753),
(3613, 2, 0, 'Neyveli', 753),
(3614, 2, 0, 'Rajapalaiyam', 753),
(3615, 2, 0, 'Pallavaram', 753),
(3616, 2, 0, 'Tiruvannamalai', 753),
(3617, 2, 0, 'Tambaram', 753),
(3618, 2, 0, 'Valparai', 753),
(3619, 2, 0, 'Pudukkottai', 753),
(3620, 2, 0, 'Palayankottai', 753),
(3621, 2, 0, 'Agartala', 754),
(3622, 2, 0, 'Kanpur', 755),
(3623, 2, 0, 'Lucknow', 755),
(3624, 2, 0, 'Varanasi (Benares)', 755),
(3625, 2, 0, 'Agra', 755),
(3626, 2, 0, 'Allahabad', 755),
(3627, 2, 0, 'Meerut', 755),
(3628, 2, 0, 'Bareilly', 755),
(3629, 2, 0, 'Gorakhpur', 755),
(3630, 2, 0, 'Aligarh', 755),
(3631, 2, 0, 'Ghaziabad', 755),
(3632, 2, 0, 'Moradabad', 755),
(3633, 2, 0, 'Saharanpur', 755),
(3634, 2, 0, 'Jhansi', 755),
(3635, 2, 0, 'Rampur', 755),
(3636, 2, 0, 'Muzaffarnagar', 755),
(3637, 2, 0, 'Shahjahanpur', 755),
(3638, 2, 0, 'Mathura', 755),
(3639, 2, 0, 'Firozabad', 755),
(3640, 2, 0, 'Farrukhabad-cum-Fatehgarh', 755),
(3641, 2, 0, 'Mirzapur-cum-Vindhyachal', 755),
(3642, 2, 0, 'Sambhal', 755),
(3643, 2, 0, 'Noida', 755),
(3644, 2, 0, 'Hapur', 755),
(3645, 2, 0, 'Amroha', 755),
(3646, 2, 0, 'Maunath Bhanjan', 755),
(3647, 2, 0, 'Jaunpur', 755),
(3648, 2, 0, 'Bahraich', 755),
(3649, 2, 0, 'Rae Bareli', 755),
(3650, 2, 0, 'Bulandshahr', 755),
(3651, 2, 0, 'Faizabad', 755),
(3652, 2, 0, 'Etawah', 755),
(3653, 2, 0, 'Sitapur', 755),
(3654, 2, 0, 'Fatehpur', 755),
(3655, 2, 0, 'Budaun', 755),
(3656, 2, 0, 'Hathras', 755),
(3657, 2, 0, 'Unnao', 755),
(3658, 2, 0, 'Pilibhit', 755),
(3659, 2, 0, 'Gonda', 755),
(3660, 2, 0, 'Modinagar', 755),
(3661, 2, 0, 'Orai', 755),
(3662, 2, 0, 'Banda', 755),
(3663, 2, 0, 'Meerut Cantonment', 755),
(3664, 2, 0, 'Kanpur Cantonment', 755),
(3665, 2, 0, 'Dehra Dun', 756),
(3666, 2, 0, 'Hardwar (Haridwar)', 756),
(3667, 2, 0, 'Haldwani-cum-Kathgodam', 756),
(3668, 2, 0, 'Kolkata', 757),
(3669, 2, 0, 'Howrah', 757),
(3670, 2, 0, 'Durgapur', 757),
(3671, 2, 0, 'Bhatpara', 757),
(3672, 2, 0, 'Panihati', 757),
(3673, 2, 0, 'Kamarhati', 757),
(3674, 2, 0, 'Asansol', 757),
(3675, 2, 0, 'Barddhaman (Burdwan)', 757),
(3676, 2, 0, 'South Dum Dum', 757),
(3677, 2, 0, 'Barahanagar (Baranagar)', 757),
(3678, 2, 0, 'Siliguri (Shiliguri)', 757),
(3679, 2, 0, 'Bally', 757),
(3680, 2, 0, 'Kharagpur', 757),
(3681, 2, 0, 'Burnpur', 757),
(3682, 2, 0, 'Uluberia', 757),
(3683, 2, 0, 'Hugli-Chinsurah', 757),
(3684, 2, 0, 'Raiganj', 757),
(3685, 2, 0, 'North Dum Dum', 757),
(3686, 2, 0, 'Dabgram', 757),
(3687, 2, 0, 'Ingraj Bazar (English Bazar)', 757),
(3688, 2, 0, 'Serampore', 757),
(3689, 2, 0, 'Barrackpur', 757),
(3690, 2, 0, 'Naihati', 757),
(3691, 2, 0, 'Midnapore (Medinipur)', 757),
(3692, 2, 0, 'Navadwip', 757),
(3693, 2, 0, 'Krishnanagar', 757),
(3694, 2, 0, 'Chandannagar', 757),
(3695, 2, 0, 'Balurghat', 757),
(3696, 2, 0, 'Berhampore (Baharampur)', 757),
(3697, 2, 0, 'Bankura', 757),
(3698, 2, 0, 'Titagarh', 757),
(3699, 2, 0, 'Halisahar', 757),
(3700, 2, 0, 'Santipur', 757),
(3701, 2, 0, 'Kulti-Barakar', 757),
(3702, 2, 0, 'Barasat', 757),
(3703, 2, 0, 'Rishra', 757),
(3704, 2, 0, 'Basirhat', 757),
(3705, 2, 0, 'Uttarpara-Kotrung', 757),
(3706, 2, 0, 'North Barrackpur', 757),
(3707, 2, 0, 'Haldia', 757),
(3708, 2, 0, 'Habra', 757),
(3709, 2, 0, 'Kanchrapara', 757),
(3710, 2, 0, 'Champdani', 757),
(3711, 2, 0, 'Ashoknagar-Kalyangarh', 757),
(3712, 2, 0, 'Bansberia', 757),
(3713, 2, 0, 'Baidyabati', 757),
(3714, 2, 0, 'Dublin', 758),
(3715, 2, 0, 'Cork', 759),
(3716, 2, 0, 'Ardebil', 760),
(3717, 2, 0, 'Bushehr', 761),
(3718, 2, 0, 'Shahr-e Kord', 762),
(3719, 2, 0, 'Tabriz', 763),
(3720, 2, 0, 'Maragheh', 763),
(3721, 2, 0, 'Marand', 763),
(3722, 2, 0, 'Esfahan', 764),
(3723, 2, 0, 'Kashan', 764),
(3724, 2, 0, 'Najafabad', 764),
(3725, 2, 0, 'Khomeynishahr', 764),
(3726, 2, 0, 'Qomsheh', 764),
(3727, 2, 0, 'Shiraz', 765),
(3728, 2, 0, 'Marv Dasht', 765),
(3729, 2, 0, 'Jahrom', 765),
(3730, 2, 0, 'Rasht', 766),
(3731, 2, 0, 'Bandar-e Anzali', 766),
(3732, 2, 0, 'Gorgan', 767),
(3733, 2, 0, 'Hamadan', 768),
(3734, 2, 0, 'Malayer', 768),
(3735, 2, 0, 'Bandar-e-Abbas', 769),
(3736, 2, 0, 'Ilam', 770),
(3737, 2, 0, 'Kerman', 771),
(3738, 2, 0, 'Sirjan', 771),
(3739, 2, 0, 'Rafsanjan', 771),
(3740, 2, 0, 'Kermanshah', 772),
(3741, 2, 0, 'Mashhad', 773),
(3742, 2, 0, 'Sabzevar', 773),
(3743, 2, 0, 'Neyshabur', 773),
(3744, 2, 0, 'Bojnurd', 773),
(3745, 2, 0, 'Birjand', 773),
(3746, 2, 0, 'Torbat-e Heydariyeh', 773),
(3747, 2, 0, 'Ahvaz', 774),
(3748, 2, 0, 'Abadan', 774),
(3749, 2, 0, 'Dezful', 774),
(3750, 2, 0, 'Masjed-e-Soleyman', 774),
(3751, 2, 0, 'Andimeshk', 774),
(3752, 2, 0, 'Khorramshahr', 774),
(3753, 2, 0, 'Sanandaj', 775),
(3754, 2, 0, 'Saqqez', 775),
(3755, 2, 0, 'Khorramabad', 776),
(3756, 2, 0, 'Borujerd', 776),
(3757, 2, 0, 'Arak', 777),
(3758, 2, 0, 'Sari', 778),
(3759, 2, 0, 'Amol', 778),
(3760, 2, 0, 'Babol', 778),
(3761, 2, 0, 'Qaemshahr', 778),
(3762, 2, 0, 'Gonbad-e Qabus', 778),
(3763, 2, 0, 'Qazvin', 779),
(3764, 2, 0, 'Qom', 780),
(3765, 2, 0, 'Saveh', 780),
(3766, 2, 0, 'Shahrud', 781),
(3767, 2, 0, 'Semnan', 781),
(3768, 2, 0, 'Zahedan', 782),
(3769, 2, 0, 'Zabol', 782),
(3770, 2, 0, 'Teheran', 783),
(3771, 2, 0, 'Karaj', 783),
(3772, 2, 0, 'Eslamshahr', 783),
(3773, 2, 0, 'Qarchak', 783),
(3774, 2, 0, 'Qods', 783),
(3775, 2, 0, 'Varamin', 783),
(3776, 2, 0, 'Urmia', 784),
(3777, 2, 0, 'Khoy', 784),
(3778, 2, 0, 'Bukan', 784),
(3779, 2, 0, 'Mahabad', 784),
(3780, 2, 0, 'Miandoab', 784),
(3781, 2, 0, 'Yazd', 785),
(3782, 2, 0, 'Zanjan', 786),
(3783, 2, 0, 'Al-Ramadi', 787),
(3784, 2, 0, 'Al-Najaf', 788),
(3785, 2, 0, 'Al-Diwaniya', 789),
(3786, 2, 0, 'Al-Sulaymaniya', 790),
(3787, 2, 0, 'Kirkuk', 791),
(3788, 2, 0, 'Al-Hilla', 792),
(3789, 2, 0, 'Baghdad', 793),
(3790, 2, 0, 'Basra', 794),
(3791, 2, 0, 'Al-Nasiriya', 795),
(3792, 2, 0, 'Baquba', 796),
(3793, 2, 0, 'Irbil', 797),
(3794, 2, 0, 'Karbala', 798),
(3795, 2, 0, 'Al-Amara', 799),
(3796, 2, 0, 'Mosul', 800),
(3797, 2, 0, 'Al-Kut', 801),
(3798, 2, 0, 'ReykjavÃƒÂ­k', 802),
(3799, 2, 0, 'Beerseba', 803),
(3800, 2, 0, 'Ashdod', 803),
(3801, 2, 0, 'Ashqelon', 803),
(3802, 2, 0, 'Rishon Le Ziyyon', 804),
(3803, 2, 0, 'Petah Tiqwa', 804),
(3804, 2, 0, 'Netanya', 804),
(3805, 2, 0, 'Rehovot', 804),
(3806, 2, 0, 'Haifa', 805),
(3807, 2, 0, 'Jerusalem', 806),
(3808, 2, 0, 'Tel Aviv-Jaffa', 807),
(3809, 2, 0, 'Holon', 807),
(3810, 2, 0, 'Bat Yam', 807),
(3811, 2, 0, 'Bene Beraq', 807),
(3812, 2, 0, 'Ramat Gan', 807),
(3813, 2, 0, 'Pescara', 808),
(3814, 2, 0, 'Bari', 809),
(3815, 2, 0, 'Taranto', 809),
(3816, 2, 0, 'Foggia', 809),
(3817, 2, 0, 'Lecce', 809),
(3818, 2, 0, 'Andria', 809),
(3819, 2, 0, 'Brindisi', 809),
(3820, 2, 0, 'Barletta', 809),
(3821, 2, 0, 'Reggio Di Calabria', 810),
(3822, 2, 0, 'Catanzaro', 810),
(3823, 2, 0, 'Napoli', 811),
(3824, 2, 0, 'Salerno', 811),
(3825, 2, 0, 'Torre Del Greco', 811),
(3826, 2, 0, 'Giugliano In Campania', 811),
(3827, 2, 0, 'Bologna', 812),
(3828, 2, 0, 'Modena', 812),
(3829, 2, 0, 'Parma', 812),
(3830, 2, 0, 'Reggio NellÃ‚Â´ Emilia', 812),
(3831, 2, 0, 'Ravenna', 812),
(3832, 2, 0, 'Ferrara', 812),
(3833, 2, 0, 'Rimini', 812),
(3834, 2, 0, 'ForlÃƒÂ¬', 812),
(3835, 2, 0, 'Piacenza', 812),
(3836, 2, 0, 'Cesena', 812),
(3837, 2, 0, 'Trieste', 813),
(3838, 2, 0, 'Udine', 813),
(3839, 2, 0, 'Roma', 814),
(3840, 2, 0, 'Latina', 814),
(3841, 2, 0, 'Genova', 815),
(3842, 2, 0, 'La Spezia', 815),
(3843, 2, 0, 'Milano', 816),
(3844, 2, 0, 'Brescia', 816),
(3845, 2, 0, 'Monza', 816),
(3846, 2, 0, 'Bergamo', 816),
(3847, 2, 0, 'Ancona', 817),
(3848, 2, 0, 'Pesaro', 817),
(3849, 2, 0, 'Torino', 818),
(3850, 2, 0, 'Novara', 818),
(3851, 2, 0, 'Alessandria', 818),
(3852, 2, 0, 'Cagliari', 819),
(3853, 2, 0, 'Sassari', 819),
(3854, 2, 0, 'Palermo', 820),
(3855, 2, 0, 'Catania', 820),
(3856, 2, 0, 'Messina', 820),
(3857, 2, 0, 'Syrakusa', 820),
(3858, 2, 0, 'Firenze', 821),
(3859, 2, 0, 'Prato', 821),
(3860, 2, 0, 'Livorno', 821),
(3861, 2, 0, 'Pisa', 821),
(3862, 2, 0, 'Arezzo', 821),
(3863, 2, 0, 'Trento', 822),
(3864, 2, 0, 'Bolzano', 822),
(3865, 2, 0, 'Perugia', 823),
(3866, 2, 0, 'Terni', 823),
(3867, 2, 0, 'Venezia', 824),
(3868, 2, 0, 'Verona', 824),
(3869, 2, 0, 'Padova', 824),
(3870, 2, 0, 'Vicenza', 824),
(3871, 2, 0, 'Kingston', 825),
(3872, 2, 0, 'Portmore', 825),
(3873, 2, 0, 'Spanish Town', 826),
(3874, 2, 0, 'Al-Zarqa', 827),
(3875, 2, 0, 'Al-Rusayfa', 827),
(3876, 2, 0, 'Amman', 828),
(3877, 2, 0, 'Wadi Al-Sir', 828),
(3878, 2, 0, 'Irbid', 829),
(3879, 2, 0, 'Nagoya', 830),
(3880, 2, 0, 'Toyohashi', 830),
(3881, 2, 0, 'Toyota', 830),
(3882, 2, 0, 'Okazaki', 830),
(3883, 2, 0, 'Kasugai', 830),
(3884, 2, 0, 'Ichinomiya', 830),
(3885, 2, 0, 'Anjo', 830),
(3886, 2, 0, 'Komaki', 830),
(3887, 2, 0, 'Seto', 830),
(3888, 2, 0, 'Kariya', 830),
(3889, 2, 0, 'Toyokawa', 830),
(3890, 2, 0, 'Handa', 830),
(3891, 2, 0, 'Tokai', 830),
(3892, 2, 0, 'Inazawa', 830),
(3893, 2, 0, 'Konan', 830),
(3894, 2, 0, 'Akita', 831),
(3895, 2, 0, 'Aomori', 832),
(3896, 2, 0, 'Hachinohe', 832),
(3897, 2, 0, 'Hirosaki', 832),
(3898, 2, 0, 'Chiba', 833),
(3899, 2, 0, 'Funabashi', 833),
(3900, 2, 0, 'Matsudo', 833),
(3901, 2, 0, 'Ichikawa', 833),
(3902, 2, 0, 'Kashiwa', 833),
(3903, 2, 0, 'Ichihara', 833),
(3904, 2, 0, 'Sakura', 833),
(3905, 2, 0, 'Yachiyo', 833),
(3906, 2, 0, 'Narashino', 833),
(3907, 2, 0, 'Nagareyama', 833),
(3908, 2, 0, 'Urayasu', 833),
(3909, 2, 0, 'Abiko', 833),
(3910, 2, 0, 'Kisarazu', 833),
(3911, 2, 0, 'Noda', 833),
(3912, 2, 0, 'Kamagaya', 833),
(3913, 2, 0, 'Nishio', 833),
(3914, 2, 0, 'Kimitsu', 833),
(3915, 2, 0, 'Mobara', 833),
(3916, 2, 0, 'Narita', 833),
(3917, 2, 0, 'Matsuyama', 834),
(3918, 2, 0, 'Niihama', 834),
(3919, 2, 0, 'Imabari', 834),
(3920, 2, 0, 'Fukui', 835),
(3921, 2, 0, 'Fukuoka', 836),
(3922, 2, 0, 'Kitakyushu', 836),
(3923, 2, 0, 'Kurume', 836),
(3924, 2, 0, 'Omuta', 836),
(3925, 2, 0, 'Kasuga', 836),
(3926, 2, 0, 'Iwaki', 837),
(3927, 2, 0, 'Koriyama', 837),
(3928, 2, 0, 'Fukushima', 837),
(3929, 2, 0, 'Aizuwakamatsu', 837),
(3930, 2, 0, 'Gifu', 838),
(3931, 2, 0, 'Ogaki', 838),
(3932, 2, 0, 'Kakamigahara', 838),
(3933, 2, 0, 'Tajimi', 838),
(3934, 2, 0, 'Maebashi', 839),
(3935, 2, 0, 'Takasaki', 839),
(3936, 2, 0, 'Ota', 839),
(3937, 2, 0, 'Isesaki', 839),
(3938, 2, 0, 'Kiryu', 839),
(3939, 2, 0, 'Hiroshima', 840),
(3940, 2, 0, 'Fukuyama', 840),
(3941, 2, 0, 'Kure', 840),
(3942, 2, 0, 'Higashihiroshima', 840),
(3943, 2, 0, 'Onomichi', 840),
(3944, 2, 0, 'Sapporo', 841),
(3945, 2, 0, 'Asahikawa', 841),
(3946, 2, 0, 'Hakodate', 841),
(3947, 2, 0, 'Kushiro', 841),
(3948, 2, 0, 'Obihiro', 841),
(3949, 2, 0, 'Tomakomai', 841),
(3950, 2, 0, 'Otaru', 841),
(3951, 2, 0, 'Ebetsu', 841),
(3952, 2, 0, 'Kitami', 841),
(3953, 2, 0, 'Muroran', 841),
(3954, 2, 0, 'Kobe', 842),
(3955, 2, 0, 'Amagasaki', 842),
(3956, 2, 0, 'Himeji', 842),
(3957, 2, 0, 'Nishinomiya', 842),
(3958, 2, 0, 'Akashi', 842),
(3959, 2, 0, 'Kakogawa', 842),
(3960, 2, 0, 'Takarazuka', 842),
(3961, 2, 0, 'Itami', 842),
(3962, 2, 0, 'Kawanishi', 842),
(3963, 2, 0, 'Sanda', 842),
(3964, 2, 0, 'Takasago', 842),
(3965, 2, 0, 'Mito', 843),
(3966, 2, 0, 'Hitachi', 843),
(3967, 2, 0, 'Tsukuba', 843),
(3968, 2, 0, 'Tama', 843),
(3969, 2, 0, 'Tsuchiura', 843),
(3970, 2, 0, 'Kanazawa', 844),
(3971, 2, 0, 'Komatsu', 844),
(3972, 2, 0, 'Morioka', 845),
(3973, 2, 0, 'Takamatsu', 846),
(3974, 2, 0, 'Kagoshima', 847),
(3975, 2, 0, 'Jokohama [Yokohama]', 848),
(3976, 2, 0, 'Kawasaki', 848),
(3977, 2, 0, 'Sagamihara', 848),
(3978, 2, 0, 'Yokosuka', 848),
(3979, 2, 0, 'Fujisawa', 848),
(3980, 2, 0, 'Hiratsuka', 848),
(3981, 2, 0, 'Chigasaki', 848),
(3982, 2, 0, 'Atsugi', 848),
(3983, 2, 0, 'Yamato', 848),
(3984, 2, 0, 'Odawara', 848),
(3985, 2, 0, 'Kamakura', 848),
(3986, 2, 0, 'Hadano', 848),
(3987, 2, 0, 'Zama', 848),
(3988, 2, 0, 'Ebina', 848),
(3989, 2, 0, 'Isehara', 848),
(3990, 2, 0, 'Kochi', 849),
(3991, 2, 0, 'Kumamoto', 850),
(3992, 2, 0, 'Yatsushiro', 850),
(3993, 2, 0, 'Kioto', 851),
(3994, 2, 0, 'Uji', 851),
(3995, 2, 0, 'Maizuru', 851),
(3996, 2, 0, 'Kameoka', 851),
(3997, 2, 0, 'Yokkaichi', 852),
(3998, 2, 0, 'Suzuka', 852),
(3999, 2, 0, 'Tsu', 852),
(4000, 2, 0, 'Matsusaka', 852),
(4001, 2, 0, 'Kuwana', 852),
(4002, 2, 0, 'Ise', 852),
(4003, 2, 0, 'Sendai', 853),
(4004, 2, 0, 'Ishinomaki', 853),
(4005, 2, 0, 'Miyazaki', 854),
(4006, 2, 0, 'Miyakonojo', 854),
(4007, 2, 0, 'Nobeoka', 854),
(4008, 2, 0, 'Nagano', 855),
(4009, 2, 0, 'Matsumoto', 855),
(4010, 2, 0, 'Ueda', 855),
(4011, 2, 0, 'Iida', 855),
(4012, 2, 0, 'Nagasaki', 856),
(4013, 2, 0, 'Sasebo', 856),
(4014, 2, 0, 'Isahaya', 856),
(4015, 2, 0, 'Nara', 857),
(4016, 2, 0, 'Kashihara', 857),
(4017, 2, 0, 'Ikoma', 857),
(4018, 2, 0, 'Yamatokoriyama', 857),
(4019, 2, 0, 'Niigata', 858),
(4020, 2, 0, 'Nagaoka', 858),
(4021, 2, 0, 'Joetsu', 858),
(4022, 2, 0, 'Kashiwazaki', 858),
(4023, 2, 0, 'Oita', 859),
(4024, 2, 0, 'Beppu', 859),
(4025, 2, 0, 'Okayama', 860),
(4026, 2, 0, 'Kurashiki', 860),
(4027, 2, 0, 'Tsuyama', 860),
(4028, 2, 0, 'Naha', 861),
(4029, 2, 0, 'Okinawa', 861),
(4030, 2, 0, 'Urasoe', 861),
(4031, 2, 0, 'Osaka', 862),
(4032, 2, 0, 'Sakai', 862),
(4033, 2, 0, 'Higashiosaka', 862),
(4034, 2, 0, 'Hirakata', 862),
(4035, 2, 0, 'Toyonaka', 862),
(4036, 2, 0, 'Takatsuki', 862),
(4037, 2, 0, 'Suita', 862),
(4038, 2, 0, 'Yao', 862),
(4039, 2, 0, 'Ibaraki', 862),
(4040, 2, 0, 'Neyagawa', 862),
(4041, 2, 0, 'Kishiwada', 862),
(4042, 2, 0, 'Izumi', 862),
(4043, 2, 0, 'Moriguchi', 862),
(4044, 2, 0, 'Kadoma', 862),
(4045, 2, 0, 'Matsubara', 862),
(4046, 2, 0, 'Daito', 862),
(4047, 2, 0, 'Minoo', 862),
(4048, 2, 0, 'Tondabayashi', 862),
(4049, 2, 0, 'Kawachinagano', 862),
(4050, 2, 0, 'Habikino', 862),
(4051, 2, 0, 'Ikeda', 862),
(4052, 2, 0, 'Izumisano', 862),
(4053, 2, 0, 'Saga', 863),
(4054, 2, 0, 'Urawa', 864),
(4055, 2, 0, 'Kawaguchi', 864),
(4056, 2, 0, 'Omiya', 864),
(4057, 2, 0, 'Kawagoe', 864),
(4058, 2, 0, 'Tokorozawa', 864),
(4059, 2, 0, 'Koshigaya', 864),
(4060, 2, 0, 'Soka', 864),
(4061, 2, 0, 'Ageo', 864),
(4062, 2, 0, 'Kasukabe', 864),
(4063, 2, 0, 'Sayama', 864),
(4064, 2, 0, 'Kumagaya', 864),
(4065, 2, 0, 'Niiza', 864),
(4066, 2, 0, 'Iruma', 864),
(4067, 2, 0, 'Misato', 864),
(4068, 2, 0, 'Asaka', 864),
(4069, 2, 0, 'Iwatsuki', 864),
(4070, 2, 0, 'Toda', 864),
(4071, 2, 0, 'Fukaya', 864),
(4072, 2, 0, 'Sakado', 864),
(4073, 2, 0, 'Fujimi', 864),
(4074, 2, 0, 'Higashimatsuyama', 864),
(4075, 2, 0, 'Otsu', 865),
(4076, 2, 0, 'Kusatsu', 865),
(4077, 2, 0, 'Hikone', 865),
(4078, 2, 0, 'Matsue', 866),
(4079, 2, 0, 'Hamamatsu', 867),
(4080, 2, 0, 'Shizuoka', 867),
(4081, 2, 0, 'Shimizu', 867),
(4082, 2, 0, 'Fuji', 867),
(4083, 2, 0, 'Numazu', 867),
(4084, 2, 0, 'Fujieda', 867),
(4085, 2, 0, 'Fujinomiya', 867),
(4086, 2, 0, 'Yaizu', 867),
(4087, 2, 0, 'Mishima', 867),
(4088, 2, 0, 'Utsunomiya', 868),
(4089, 2, 0, 'Ashikaga', 868),
(4090, 2, 0, 'Oyama', 868),
(4091, 2, 0, 'Kanuma', 868),
(4092, 2, 0, 'Tokushima', 869),
(4093, 2, 0, 'Tokyo', 870),
(4094, 2, 0, 'Hachioji', 870),
(4095, 2, 0, 'Machida', 870),
(4096, 2, 0, 'Fuchu', 870),
(4097, 2, 0, 'Chofu', 870),
(4098, 2, 0, 'Kodaira', 870),
(4099, 2, 0, 'Mitaka', 870),
(4100, 2, 0, 'Hino', 870),
(4101, 2, 0, 'Tachikawa', 870),
(4102, 2, 0, 'Hitachinaka', 870),
(4103, 2, 0, 'Ome', 870),
(4104, 2, 0, 'Higashimurayama', 870),
(4105, 2, 0, 'Musashino', 870),
(4106, 2, 0, 'Higashikurume', 870),
(4107, 2, 0, 'Koganei', 870),
(4108, 2, 0, 'Kokubunji', 870),
(4109, 2, 0, 'Akishima', 870),
(4110, 2, 0, 'Hoya', 870),
(4111, 2, 0, 'Tottori', 871),
(4112, 2, 0, 'Yonago', 871),
(4113, 2, 0, 'Toyama', 872),
(4114, 2, 0, 'Takaoka', 872),
(4115, 2, 0, 'Wakayama', 873),
(4116, 2, 0, 'Yamagata', 874),
(4117, 2, 0, 'Sakata', 874),
(4118, 2, 0, 'Tsuruoka', 874),
(4119, 2, 0, 'Yonezawa', 874),
(4120, 2, 0, 'Shimonoseki', 875),
(4121, 2, 0, 'Ube', 875),
(4122, 2, 0, 'Yamaguchi', 875),
(4123, 2, 0, 'Hofu', 875),
(4124, 2, 0, 'Tokuyama', 875),
(4125, 2, 0, 'Iwakuni', 875),
(4126, 2, 0, 'Kofu', 876),
(4127, 2, 0, 'Taldyqorghan', 877),
(4128, 2, 0, 'Almaty', 878),
(4129, 2, 0, 'AqtÃƒÂ¶be', 879),
(4130, 2, 0, 'Astana', 880),
(4131, 2, 0, 'Atyrau', 881),
(4132, 2, 0, 'Ãƒâ€“skemen', 882),
(4133, 2, 0, 'Semey', 882),
(4134, 2, 0, 'Aqtau', 883),
(4135, 2, 0, 'Petropavl', 884),
(4136, 2, 0, 'KÃƒÂ¶kshetau', 884),
(4137, 2, 0, 'Pavlodar', 885),
(4138, 2, 0, 'Ekibastuz', 885),
(4139, 2, 0, 'Qaraghandy', 886),
(4140, 2, 0, 'Temirtau', 886),
(4141, 2, 0, 'Zhezqazghan', 886),
(4142, 2, 0, 'Qostanay', 887),
(4143, 2, 0, 'Rudnyy', 887),
(4144, 2, 0, 'Qyzylorda', 888),
(4145, 2, 0, 'Shymkent', 889),
(4146, 2, 0, 'Taraz', 890),
(4147, 2, 0, 'Oral', 891),
(4148, 2, 0, 'Suva', 892),
(4149, 2, 0, 'Nyeri', 892),
(4150, 2, 0, 'Kathmandu', 892),
(4151, 2, 0, 'Lalitapur', 892),
(4152, 2, 0, 'Birgunj', 892),
(4153, 2, 0, 'San Lorenzo', 892),
(4154, 2, 0, 'LambarÃƒÂ©', 892),
(4155, 2, 0, 'Fernando De La Mora', 892),
(4156, 2, 0, 'Kabwe', 892),
(4157, 2, 0, 'Kandy', 892),
(4158, 2, 0, 'Kampala', 892),
(4159, 2, 0, 'Mombasa', 893),
(4160, 2, 0, 'Machakos', 894),
(4161, 2, 0, 'Meru', 894),
(4162, 2, 0, 'Biratnagar', 894),
(4163, 2, 0, 'Nairobi', 895),
(4164, 2, 0, 'Kisumu', 896),
(4165, 2, 0, 'Nakuru', 897),
(4166, 2, 0, 'Eldoret', 897),
(4167, 2, 0, 'Bishkek', 898),
(4168, 2, 0, 'Osh', 899),
(4169, 2, 0, 'Battambang', 900),
(4170, 2, 0, 'Phnom Penh', 901),
(4171, 2, 0, 'Siem Reap', 902),
(4172, 2, 0, 'Bikenibeu', 903),
(4173, 2, 0, 'Bairiki', 903),
(4174, 2, 0, 'Basseterre', 904),
(4175, 2, 0, 'Cheju', 905),
(4176, 2, 0, 'Chonju', 906),
(4177, 2, 0, 'Iksan', 906),
(4178, 2, 0, 'Kunsan', 906),
(4179, 2, 0, 'Chong-up', 906),
(4180, 2, 0, 'Kimje', 906),
(4181, 2, 0, 'Namwon', 906),
(4182, 2, 0, 'Sunchon', 907),
(4183, 2, 0, 'Mokpo', 907),
(4184, 2, 0, 'Yosu', 907),
(4185, 2, 0, 'Kwang-yang', 907),
(4186, 2, 0, 'Naju', 907),
(4187, 2, 0, 'Chongju', 908),
(4188, 2, 0, 'Chungju', 908),
(4189, 2, 0, 'Chechon', 908),
(4190, 2, 0, 'Chonan', 909),
(4191, 2, 0, 'Asan', 909),
(4192, 2, 0, 'Nonsan', 909),
(4193, 2, 0, 'Sosan', 909),
(4194, 2, 0, 'Kongju', 909),
(4195, 2, 0, 'Poryong', 909),
(4196, 2, 0, 'Inchon', 910),
(4197, 2, 0, 'Wonju', 911),
(4198, 2, 0, 'Chunchon', 911),
(4199, 2, 0, 'Kangnung', 911),
(4200, 2, 0, 'Tonghae', 911),
(4201, 2, 0, 'Kwangju', 912),
(4202, 2, 0, 'Songnam', 913),
(4203, 2, 0, 'Puchon', 913),
(4204, 2, 0, 'Suwon', 913),
(4205, 2, 0, 'Anyang', 913),
(4206, 2, 0, 'Koyang', 913),
(4207, 2, 0, 'Ansan', 913),
(4208, 2, 0, 'Kwangmyong', 913),
(4209, 2, 0, 'Pyongtaek', 913),
(4210, 2, 0, 'Uijongbu', 913),
(4211, 2, 0, 'Yong-in', 913),
(4212, 2, 0, 'Kunpo', 913),
(4213, 2, 0, 'Namyangju', 913),
(4214, 2, 0, 'Paju', 913),
(4215, 2, 0, 'Ichon', 913),
(4216, 2, 0, 'Kuri', 913),
(4217, 2, 0, 'Shihung', 913),
(4218, 2, 0, 'Hanam', 913),
(4219, 2, 0, 'Uiwang', 913),
(4220, 2, 0, 'Pohang', 914),
(4221, 2, 0, 'Kumi', 914),
(4222, 2, 0, 'Kyongju', 914),
(4223, 2, 0, 'Andong', 914),
(4224, 2, 0, 'Kyongsan', 914),
(4225, 2, 0, 'Kimchon', 914),
(4226, 2, 0, 'Yongju', 914),
(4227, 2, 0, 'Sangju', 914),
(4228, 2, 0, 'Yongchon', 914),
(4229, 2, 0, 'Mun-gyong', 914),
(4230, 2, 0, 'Ulsan', 915),
(4231, 2, 0, 'Chang-won', 915),
(4232, 2, 0, 'Masan', 915),
(4233, 2, 0, 'Chinju', 915),
(4234, 2, 0, 'Kimhae', 915),
(4235, 2, 0, 'Yangsan', 915),
(4236, 2, 0, 'Koje', 915),
(4237, 2, 0, 'Tong-yong', 915),
(4238, 2, 0, 'Chinhae', 915),
(4239, 2, 0, 'Miryang', 915),
(4240, 2, 0, 'Sachon', 915),
(4241, 2, 0, 'Pusan', 916),
(4242, 2, 0, 'Seoul', 917),
(4243, 2, 0, 'Taegu', 918),
(4244, 2, 0, 'Taejon', 919),
(4245, 2, 0, 'Kuwait', 920),
(4246, 2, 0, 'Al-Salimiya', 921),
(4247, 2, 0, 'Jalib Al-Shuyukh', 921),
(4248, 2, 0, 'Savannakhet', 922),
(4249, 2, 0, 'Vientiane', 923),
(4250, 2, 0, 'Tripoli', 924),
(4251, 2, 0, 'Beirut', 925),
(4252, 2, 0, 'Monrovia', 926),
(4253, 2, 0, 'Al-Zawiya', 927),
(4254, 2, 0, 'Bengasi', 928),
(4255, 2, 0, 'Misrata', 929),
(4256, 2, 0, 'Tripoli', 930),
(4257, 2, 0, 'Castries', 931),
(4258, 2, 0, 'Schaan', 932),
(4259, 2, 0, 'Vaduz', 933),
(4260, 2, 0, 'Suva', 934),
(4261, 2, 0, 'Nyeri', 934),
(4262, 2, 0, 'Kathmandu', 934),
(4263, 2, 0, 'Lalitapur', 934),
(4264, 2, 0, 'Birgunj', 934),
(4265, 2, 0, 'San Lorenzo', 934),
(4266, 2, 0, 'LambarÃƒÂ©', 934),
(4267, 2, 0, 'Fernando De La Mora', 934),
(4268, 2, 0, 'Kabwe', 934),
(4269, 2, 0, 'Kandy', 934),
(4270, 2, 0, 'Kampala', 934),
(4271, 2, 0, 'Tamale', 935),
(4272, 2, 0, 'Jaffna', 935),
(4273, 2, 0, 'Sekondi-Takoradi', 936),
(4274, 2, 0, 'Pokhara', 936),
(4275, 2, 0, 'Freetown', 936),
(4276, 2, 0, 'Colombo', 936),
(4277, 2, 0, 'Dehiwala', 936),
(4278, 2, 0, 'Moratuwa', 936),
(4279, 2, 0, 'Sri Jayawardenepura Kotte', 936),
(4280, 2, 0, 'Negombo', 936),
(4281, 2, 0, 'Maseru', 937),
(4282, 2, 0, 'Kaunas', 938),
(4283, 2, 0, 'Klaipeda', 939),
(4284, 2, 0, 'Panevezys', 940),
(4285, 2, 0, 'Vilnius', 941),
(4286, 2, 0, 'Ã…Â iauliai', 942),
(4287, 2, 0, 'Luxembourg', 943),
(4288, 2, 0, 'Daugavpils', 944),
(4289, 2, 0, 'Liepaja', 945),
(4290, 2, 0, 'Riga', 946),
(4291, 2, 0, 'Macao', 947),
(4292, 2, 0, 'Casablanca', 948),
(4293, 2, 0, 'Mohammedia', 948),
(4294, 2, 0, 'Khouribga', 949),
(4295, 2, 0, 'Settat', 949),
(4296, 2, 0, 'Safi', 950),
(4297, 2, 0, 'El Jadida', 950),
(4298, 2, 0, 'FÃƒÂ¨s', 951),
(4299, 2, 0, 'KÃƒÂ©nitra', 952),
(4300, 2, 0, 'Marrakech', 953),
(4301, 2, 0, 'MeknÃƒÂ¨s', 954),
(4302, 2, 0, 'Oujda', 955),
(4303, 2, 0, 'Nador', 955),
(4304, 2, 0, 'Rabat', 956),
(4305, 2, 0, 'SalÃƒÂ©', 956),
(4306, 2, 0, 'TÃƒÂ©mara', 956),
(4307, 2, 0, 'Agadir', 957),
(4308, 2, 0, 'Beni-Mellal', 958),
(4309, 2, 0, 'Tanger', 959),
(4310, 2, 0, 'TÃƒÂ©touan', 959),
(4311, 2, 0, 'Ksar El Kebir', 959),
(4312, 2, 0, 'El Araich', 959),
(4313, 2, 0, 'Taza', 960),
(4314, 2, 0, 'South Hill', 961),
(4315, 2, 0, 'The Valley', 961),
(4316, 2, 0, 'Oranjestad', 961),
(4317, 2, 0, 'Douglas', 961),
(4318, 2, 0, 'Gibraltar', 961),
(4319, 2, 0, 'Tamuning', 961),
(4320, 2, 0, 'AgaÃƒÂ±a', 961),
(4321, 2, 0, 'Flying Fish Cove', 961),
(4322, 2, 0, 'Monte-Carlo', 961),
(4323, 2, 0, 'Monaco-Ville', 961),
(4324, 2, 0, 'Yangor', 961),
(4325, 2, 0, 'Yaren', 961),
(4326, 2, 0, 'Alofi', 961),
(4327, 2, 0, 'Kingston', 961),
(4328, 2, 0, 'Adamstown', 961),
(4329, 2, 0, 'Singapore', 961),
(4330, 2, 0, 'NoumÃƒÂ©a', 961),
(4331, 2, 0, 'CittÃƒÂ  Del Vaticano', 961),
(4332, 2, 0, 'Balti', 962),
(4333, 2, 0, 'Bender (TÃƒÂ®ghina)', 963),
(4334, 2, 0, 'Chisinau', 964),
(4335, 2, 0, 'Tiraspol', 965),
(4336, 2, 0, 'Antananarivo', 966),
(4337, 2, 0, 'AntsirabÃƒÂ©', 966),
(4338, 2, 0, 'Fianarantsoa', 967),
(4339, 2, 0, 'Mahajanga', 968),
(4340, 2, 0, 'Toamasina', 969),
(4341, 2, 0, 'Male', 970),
(4342, 2, 0, 'Aguascalientes', 971),
(4343, 2, 0, 'Tijuana', 972),
(4344, 2, 0, 'Mexicali', 972),
(4345, 2, 0, 'Ensenada', 972),
(4346, 2, 0, 'La Paz', 973),
(4347, 2, 0, 'Los Cabos', 973),
(4348, 2, 0, 'Campeche', 974),
(4349, 2, 0, 'Carmen', 974),
(4350, 2, 0, 'Tuxtla GutiÃƒÂ©rrez', 975),
(4351, 2, 0, 'Tapachula', 975),
(4352, 2, 0, 'Ocosingo', 975),
(4353, 2, 0, 'San CristÃƒÂ³bal De Las Casas', 975),
(4354, 2, 0, 'ComitÃƒÂ¡n De DomÃƒÂ­nguez', 975),
(4355, 2, 0, 'Las Margaritas', 975),
(4356, 2, 0, 'JuÃƒÂ¡rez', 976),
(4357, 2, 0, 'Chihuahua', 976),
(4358, 2, 0, 'CuauhtÃƒÂ©moc', 976),
(4359, 2, 0, 'Delicias', 976),
(4360, 2, 0, 'Hidalgo Del Parral', 976),
(4361, 2, 0, 'Saltillo', 977),
(4362, 2, 0, 'TorreÃƒÂ³n', 977),
(4363, 2, 0, 'Monclova', 977),
(4364, 2, 0, 'Piedras Negras', 977),
(4365, 2, 0, 'AcuÃƒÂ±a', 977),
(4366, 2, 0, 'Matamoros', 977),
(4367, 2, 0, 'Colima', 978),
(4368, 2, 0, 'Manzanillo', 978),
(4369, 2, 0, 'TecomÃƒÂ¡n', 978),
(4370, 2, 0, 'Buenos Aires', 979),
(4371, 2, 0, 'BrasÃƒÂ­lia', 979),
(4372, 2, 0, 'Ciudad De MÃƒÂ©xico', 979),
(4373, 2, 0, 'Caracas', 979),
(4374, 2, 0, 'Catia La Mar', 979),
(4375, 2, 0, 'Durango', 980),
(4376, 2, 0, 'GÃƒÂ³mez Palacio', 980),
(4377, 2, 0, 'Lerdo', 980),
(4378, 2, 0, 'LeÃƒÂ³n', 981),
(4379, 2, 0, 'Irapuato', 981),
(4380, 2, 0, 'Celaya', 981),
(4381, 2, 0, 'Salamanca', 981),
(4382, 2, 0, 'PÃƒÂ©njamo', 981),
(4383, 2, 0, 'Guanajuato', 981),
(4384, 2, 0, 'Allende', 981),
(4385, 2, 0, 'Silao', 981),
(4386, 2, 0, 'Valle De Santiago', 981),
(4387, 2, 0, 'Dolores Hidalgo', 981),
(4388, 2, 0, 'AcÃƒÂ¡mbaro', 981),
(4389, 2, 0, 'San Francisco Del RincÃƒÂ³n', 981),
(4390, 2, 0, 'San Luis De La Paz', 981),
(4391, 2, 0, 'San Felipe', 981),
(4392, 2, 0, 'Salvatierra', 981),
(4393, 2, 0, 'Acapulco De JuÃƒÂ¡rez', 982),
(4394, 2, 0, 'Chilpancingo De Los Bravo', 982),
(4395, 2, 0, 'Iguala De La Independencia', 982),
(4396, 2, 0, 'Chilapa De Alvarez', 982),
(4397, 2, 0, 'Taxco De AlarcÃƒÂ³n', 982),
(4398, 2, 0, 'JosÃƒÂ© Azueta', 982),
(4399, 2, 0, 'Pachuca De Soto', 983),
(4400, 2, 0, 'Tulancingo De Bravo', 983),
(4401, 2, 0, 'Huejutla De Reyes', 983),
(4402, 2, 0, 'Guadalajara', 984),
(4403, 2, 0, 'Zapopan', 984),
(4404, 2, 0, 'Tlaquepaque', 984),
(4405, 2, 0, 'TonalÃƒÂ¡', 984),
(4406, 2, 0, 'Puerto Vallarta', 984),
(4407, 2, 0, 'Lagos De Moreno', 984),
(4408, 2, 0, 'Tlajomulco De ZÃƒÂºÃƒÂ±iga', 984),
(4409, 2, 0, 'TepatitlÃƒÂ¡n De Morelos', 984),
(4410, 2, 0, 'Ecatepec De Morelos', 985),
(4411, 2, 0, 'NezahualcÃƒÂ³yotl', 985),
(4412, 2, 0, 'Naucalpan De JuÃƒÂ¡rez', 985),
(4413, 2, 0, 'Tlalnepantla De Baz', 985),
(4414, 2, 0, 'Toluca', 985),
(4415, 2, 0, 'ChimalhuacÃƒÂ¡n', 985),
(4416, 2, 0, 'AtizapÃƒÂ¡n De Zaragoza', 985),
(4417, 2, 0, 'CuautitlÃƒÂ¡n Izcalli', 985),
(4418, 2, 0, 'TultitlÃƒÂ¡n', 985),
(4419, 2, 0, 'Valle De Chalco Solidaridad', 985),
(4420, 2, 0, 'Ixtapaluca', 985),
(4421, 2, 0, 'NicolÃƒÂ¡s Romero', 985),
(4422, 2, 0, 'Coacalco De BerriozÃƒÂ¡bal', 985),
(4423, 2, 0, 'Chalco', 985),
(4424, 2, 0, 'La Paz', 985),
(4425, 2, 0, 'Texcoco', 985),
(4426, 2, 0, 'Metepec', 985),
(4427, 2, 0, 'Huixquilucan', 985),
(4428, 2, 0, 'San Felipe Del Progreso', 985),
(4429, 2, 0, 'TecÃƒÂ¡mac', 985),
(4430, 2, 0, 'Zinacantepec', 985),
(4431, 2, 0, 'Ixtlahuaca', 985),
(4432, 2, 0, 'Almoloya De JuÃƒÂ¡rez', 985),
(4433, 2, 0, 'Zumpango', 985),
(4434, 2, 0, 'Lerma', 985),
(4435, 2, 0, 'Tejupilco', 985),
(4436, 2, 0, 'Tultepec', 985),
(4437, 2, 0, 'Morelia', 986),
(4438, 2, 0, 'Uruapan', 986),
(4439, 2, 0, 'LÃƒÂ¡zaro CÃƒÂ¡rdenas', 986),
(4440, 2, 0, 'Zamora', 986),
(4441, 2, 0, 'ZitÃƒÂ¡cuaro', 986),
(4442, 2, 0, 'ApatzingÃƒÂ¡n', 986),
(4443, 2, 0, 'Hidalgo', 986),
(4444, 2, 0, 'Cuernavaca', 987),
(4445, 2, 0, 'Jiutepec', 987),
(4446, 2, 0, 'Cuautla', 987),
(4447, 2, 0, 'Temixco', 987),
(4448, 2, 0, 'Tepic', 988),
(4449, 2, 0, 'Santiago Ixcuintla', 988),
(4450, 2, 0, 'Monterrey', 989),
(4451, 2, 0, 'Guadalupe', 989),
(4452, 2, 0, 'San NicolÃƒÂ¡s De Los Garza', 989),
(4453, 2, 0, 'Apodaca', 989),
(4454, 2, 0, 'General Escobedo', 989),
(4455, 2, 0, 'Santa Catarina', 989),
(4456, 2, 0, 'San Pedro Garza GarcÃƒÂ­a', 989),
(4457, 2, 0, 'Oaxaca De JuÃƒÂ¡rez', 990),
(4458, 2, 0, 'San Juan Bautista Tuxtepec', 990),
(4459, 2, 0, 'Puebla', 991),
(4460, 2, 0, 'TehuacÃƒÂ¡n', 991),
(4461, 2, 0, 'San MartÃƒÂ­n Texmelucan', 991),
(4462, 2, 0, 'Atlixco', 991),
(4463, 2, 0, 'San Pedro Cholula', 991),
(4464, 2, 0, 'San Juan Del RÃƒÂ­o', 992),
(4465, 2, 0, 'QuerÃƒÂ©taro', 993),
(4466, 2, 0, 'Benito JuÃƒÂ¡rez', 994),
(4467, 2, 0, 'OthÃƒÂ³n P. Blanco (Chetumal)', 994),
(4468, 2, 0, 'San Luis PotosÃƒÂ­', 995),
(4469, 2, 0, 'Soledad De Graciano SÃƒÂ¡nchez', 995),
(4470, 2, 0, 'Ciudad Valles', 995),
(4471, 2, 0, 'CuliacÃƒÂ¡n', 996),
(4472, 2, 0, 'MazatlÃƒÂ¡n', 996),
(4473, 2, 0, 'Ahome', 996),
(4474, 2, 0, 'Guasave', 996),
(4475, 2, 0, 'Navolato', 996),
(4476, 2, 0, 'El Fuerte', 996),
(4477, 2, 0, 'Hermosillo', 997),
(4478, 2, 0, 'Cajeme', 997),
(4479, 2, 0, 'Nogales', 997),
(4480, 2, 0, 'San Luis RÃƒÂ­o Colorado', 997),
(4481, 2, 0, 'Navojoa', 997),
(4482, 2, 0, 'Guaymas', 997),
(4483, 2, 0, 'Centro (Villahermosa)', 998),
(4484, 2, 0, 'CÃƒÂ¡rdenas', 998),
(4485, 2, 0, 'Comalcalco', 998),
(4486, 2, 0, 'Huimanguillo', 998),
(4487, 2, 0, 'Macuspana', 998),
(4488, 2, 0, 'CunduacÃƒÂ¡n', 998),
(4489, 2, 0, 'Reynosa', 999),
(4490, 2, 0, 'Matamoros', 999),
(4491, 2, 0, 'Nuevo Laredo', 999),
(4492, 2, 0, 'Tampico', 999),
(4493, 2, 0, 'Victoria', 999),
(4494, 2, 0, 'Ciudad Madero', 999),
(4495, 2, 0, 'Altamira', 999),
(4496, 2, 0, 'El Mante', 999),
(4497, 2, 0, 'RÃƒÂ­o Bravo', 999),
(4498, 2, 0, 'Veracruz', 1000),
(4499, 2, 0, 'Xalapa', 1000),
(4500, 2, 0, 'Coatzacoalcos', 1000),
(4501, 2, 0, 'CÃƒÂ³rdoba', 1000),
(4502, 2, 0, 'Papantla', 1000),
(4503, 2, 0, 'MinatitlÃƒÂ¡n', 1000),
(4504, 2, 0, 'Poza Rica De Hidalgo', 1000),
(4505, 2, 0, 'San AndrÃƒÂ©s Tuxtla', 1000),
(4506, 2, 0, 'TÃƒÂºxpam', 1000),
(4507, 2, 0, 'MartÃƒÂ­nez De La Torre', 1000),
(4508, 2, 0, 'Orizaba', 1000),
(4509, 2, 0, 'Temapache', 1000),
(4510, 2, 0, 'Cosoleacaque', 1000),
(4511, 2, 0, 'Tantoyuca', 1000),
(4512, 2, 0, 'PÃƒÂ¡nuco', 1000),
(4513, 2, 0, 'Tierra Blanca', 1000),
(4514, 2, 0, 'Boca Del RÃƒÂ­o', 1001),
(4515, 2, 0, 'MÃƒÂ©rida', 1002),
(4516, 2, 0, 'Fresnillo', 1003),
(4517, 2, 0, 'Zacatecas', 1003),
(4518, 2, 0, 'Guadalupe', 1003),
(4519, 2, 0, 'Dalap-Uliga-Darrit', 1004),
(4520, 2, 0, 'Skopje', 1005),
(4521, 2, 0, 'Bamako', 1006),
(4522, 2, 0, 'Valletta', 1007),
(4523, 2, 0, 'Birkirkara', 1008),
(4524, 2, 0, 'Bassein (Pathein)', 1009),
(4525, 2, 0, 'Henzada (Hinthada)', 1009),
(4526, 2, 0, 'Pagakku (Pakokku)', 1010),
(4527, 2, 0, 'Mandalay', 1011),
(4528, 2, 0, 'Meikhtila', 1011),
(4529, 2, 0, 'Myingyan', 1011),
(4530, 2, 0, 'Moulmein (Mawlamyine)', 1012),
(4531, 2, 0, 'Pegu (Bago)', 1013),
(4532, 2, 0, 'Prome (Pyay)', 1013),
(4533, 2, 0, 'Sittwe (Akyab)', 1014),
(4534, 2, 0, 'Rangoon (Yangon)', 1015),
(4535, 2, 0, 'Monywa', 1016),
(4536, 2, 0, 'Taunggyi (Taunggye)', 1017),
(4537, 2, 0, 'Lashio (Lasho)', 1017),
(4538, 2, 0, 'Mergui (Myeik)', 1018),
(4539, 2, 0, 'Tavoy (Dawei)', 1018),
(4540, 2, 0, 'Ulan Bator', 1019),
(4541, 2, 0, 'Garapan', 1020),
(4542, 2, 0, 'Xai-Xai', 1021),
(4543, 2, 0, 'Gaza', 1021),
(4544, 2, 0, 'Maxixe', 1022),
(4545, 2, 0, 'Chimoio', 1023),
(4546, 2, 0, 'Maputo', 1024),
(4547, 2, 0, 'Matola', 1024),
(4548, 2, 0, 'Nampula', 1025),
(4549, 2, 0, 'NaÃƒÂ§ala-Porto', 1025),
(4550, 2, 0, 'Beira', 1026),
(4551, 2, 0, 'Tete', 1027),
(4552, 2, 0, 'Quelimane', 1028),
(4553, 2, 0, 'Mocuba', 1028),
(4554, 2, 0, 'Gurue', 1028),
(4555, 2, 0, 'NouÃƒÂ¢dhibou', 1029),
(4556, 2, 0, 'Nouakchott', 1030),
(4557, 2, 0, 'Plymouth', 1031),
(4558, 2, 0, 'Fort-de-France', 1032),
(4559, 2, 0, 'Beau Bassin-Rose Hill', 1033),
(4560, 2, 0, 'Vacoas-Phoenix', 1033),
(4561, 2, 0, 'Port-Louis', 1034),
(4562, 2, 0, 'Blantyre', 1035),
(4563, 2, 0, 'Lilongwe', 1036),
(4564, 2, 0, 'Johor Baharu', 1037),
(4565, 2, 0, 'Alor Setar', 1038),
(4566, 2, 0, 'Sungai Petani', 1038),
(4567, 2, 0, 'Kota Bharu', 1039),
(4568, 2, 0, 'Seremban', 1040),
(4569, 2, 0, 'Kuantan', 1041),
(4570, 2, 0, 'Ipoh', 1042),
(4571, 2, 0, 'Taiping', 1042),
(4572, 2, 0, 'Pinang', 1043),
(4573, 2, 0, 'Sandakan', 1044),
(4574, 2, 0, 'Kuching', 1045),
(4575, 2, 0, 'Sibu', 1045),
(4576, 2, 0, 'Petaling Jaya', 1046),
(4577, 2, 0, 'Kelang', 1046),
(4578, 2, 0, 'Selayang Baru', 1046),
(4579, 2, 0, 'Shah Alam', 1046),
(4580, 2, 0, 'Kuala Terengganu', 1047),
(4581, 2, 0, 'Kuala Lumpur', 1048),
(4582, 2, 0, 'Mamoutzou', 1049),
(4583, 2, 0, 'Windhoek', 1050),
(4584, 2, 0, 'South Hill', 1051),
(4585, 2, 0, 'The Valley', 1051),
(4586, 2, 0, 'Oranjestad', 1051),
(4587, 2, 0, 'Douglas', 1051),
(4588, 2, 0, 'Gibraltar', 1051),
(4589, 2, 0, 'Tamuning', 1051),
(4590, 2, 0, 'AgaÃƒÂ±a', 1051),
(4591, 2, 0, 'Flying Fish Cove', 1051),
(4592, 2, 0, 'Monte-Carlo', 1051),
(4593, 2, 0, 'Monaco-Ville', 1051),
(4594, 2, 0, 'Yangor', 1051),
(4595, 2, 0, 'Yaren', 1051),
(4596, 2, 0, 'Alofi', 1051),
(4597, 2, 0, 'Kingston', 1051),
(4598, 2, 0, 'Adamstown', 1051),
(4599, 2, 0, 'Singapore', 1051),
(4600, 2, 0, 'NoumÃƒÂ©a', 1051),
(4601, 2, 0, 'CittÃƒÂ  Del Vaticano', 1051),
(4602, 2, 0, 'Maradi', 1052),
(4603, 2, 0, 'Niamey', 1053),
(4604, 2, 0, 'Zinder', 1054),
(4605, 2, 0, 'South Hill', 1055),
(4606, 2, 0, 'The Valley', 1055),
(4607, 2, 0, 'Oranjestad', 1055),
(4608, 2, 0, 'Douglas', 1055),
(4609, 2, 0, 'Gibraltar', 1055),
(4610, 2, 0, 'Tamuning', 1055),
(4611, 2, 0, 'AgaÃƒÂ±a', 1055),
(4612, 2, 0, 'Flying Fish Cove', 1055),
(4613, 2, 0, 'Monte-Carlo', 1055),
(4614, 2, 0, 'Monaco-Ville', 1055),
(4615, 2, 0, 'Yangor', 1055),
(4616, 2, 0, 'Yaren', 1055),
(4617, 2, 0, 'Alofi', 1055),
(4618, 2, 0, 'Kingston', 1055),
(4619, 2, 0, 'Adamstown', 1055),
(4620, 2, 0, 'Singapore', 1055),
(4621, 2, 0, 'NoumÃƒÂ©a', 1055),
(4622, 2, 0, 'CittÃƒÂ  Del Vaticano', 1055),
(4623, 2, 0, 'Onitsha', 1056),
(4624, 2, 0, 'Enugu', 1056),
(4625, 2, 0, 'Awka', 1056),
(4626, 2, 0, 'Kumo', 1057),
(4627, 2, 0, 'Deba Habe', 1057),
(4628, 2, 0, 'Gombe', 1057),
(4629, 2, 0, 'Makurdi', 1058),
(4630, 2, 0, 'Maiduguri', 1059),
(4631, 2, 0, 'Calabar', 1060),
(4632, 2, 0, 'Ugep', 1060),
(4633, 2, 0, 'Benin City', 1061),
(4634, 2, 0, 'Sapele', 1061),
(4635, 2, 0, 'Warri', 1061),
(4636, 2, 0, 'Abuja', 1062),
(4637, 2, 0, 'Aba', 1063),
(4638, 2, 0, 'Zaria', 1064),
(4639, 2, 0, 'Kaduna', 1064),
(4640, 2, 0, 'Kano', 1065),
(4641, 2, 0, 'Katsina', 1066),
(4642, 2, 0, 'Ilorin', 1067),
(4643, 2, 0, 'Offa', 1067),
(4644, 2, 0, 'Lagos', 1068),
(4645, 2, 0, 'Mushin', 1068),
(4646, 2, 0, 'Ikorodu', 1068),
(4647, 2, 0, 'Shomolu', 1068),
(4648, 2, 0, 'Agege', 1068),
(4649, 2, 0, 'Epe', 1068),
(4650, 2, 0, 'Minna', 1069),
(4651, 2, 0, 'Bida', 1069),
(4652, 2, 0, 'Abeokuta', 1070),
(4653, 2, 0, 'Ijebu-Ode', 1070),
(4654, 2, 0, 'Shagamu', 1070),
(4655, 2, 0, 'Ado-Ekiti', 1071),
(4656, 2, 0, 'Ikerre', 1071),
(4657, 2, 0, 'Ilawe-Ekiti', 1071),
(4658, 2, 0, 'Owo', 1071),
(4659, 2, 0, 'Ondo', 1071),
(4660, 2, 0, 'Akure', 1071),
(4661, 2, 0, 'Oka-Akoko', 1071),
(4662, 2, 0, 'Ikare', 1071),
(4663, 2, 0, 'Ise-Ekiti', 1071),
(4664, 2, 0, 'Ibadan', 1072),
(4665, 2, 0, 'Ogbomosho', 1072),
(4666, 2, 0, 'Oshogbo', 1072),
(4667, 2, 0, 'Ilesha', 1072),
(4668, 2, 0, 'Iwo', 1072),
(4669, 2, 0, 'Ede', 1072),
(4670, 2, 0, 'Ife', 1072),
(4671, 2, 0, 'Ila', 1072),
(4672, 2, 0, 'Oyo', 1072),
(4673, 2, 0, 'Iseyin', 1072),
(4674, 2, 0, 'Ilobu', 1072),
(4675, 2, 0, 'Ikirun', 1072),
(4676, 2, 0, 'Shaki', 1072),
(4677, 2, 0, 'Effon-Alaiye', 1072),
(4678, 2, 0, 'Ikire', 1072),
(4679, 2, 0, 'Inisa', 1072),
(4680, 2, 0, 'Igboho', 1072),
(4681, 2, 0, 'Ejigbo', 1072),
(4682, 2, 0, 'Jos', 1073),
(4683, 2, 0, 'Lafia', 1073),
(4684, 2, 0, 'Port Harcourt', 1074),
(4685, 2, 0, 'Sokoto', 1075),
(4686, 2, 0, 'Gusau', 1075),
(4687, 2, 0, 'Chinandega', 1076),
(4688, 2, 0, 'LeÃƒÂ³n', 1077),
(4689, 2, 0, 'Managua', 1078),
(4690, 2, 0, 'Masaya', 1079),
(4691, 2, 0, 'South Hill', 1080),
(4692, 2, 0, 'The Valley', 1080),
(4693, 2, 0, 'Oranjestad', 1080),
(4694, 2, 0, 'Douglas', 1080),
(4695, 2, 0, 'Gibraltar', 1080),
(4696, 2, 0, 'Tamuning', 1080),
(4697, 2, 0, 'AgaÃƒÂ±a', 1080),
(4698, 2, 0, 'Flying Fish Cove', 1080),
(4699, 2, 0, 'Monte-Carlo', 1080),
(4700, 2, 0, 'Monaco-Ville', 1080),
(4701, 2, 0, 'Yangor', 1080),
(4702, 2, 0, 'Yaren', 1080),
(4703, 2, 0, 'Alofi', 1080),
(4704, 2, 0, 'Kingston', 1080),
(4705, 2, 0, 'Adamstown', 1080),
(4706, 2, 0, 'Singapore', 1080),
(4707, 2, 0, 'NoumÃƒÂ©a', 1080),
(4708, 2, 0, 'CittÃƒÂ  Del Vaticano', 1080),
(4709, 2, 0, 'Emmen', 1081),
(4710, 2, 0, 'Almere', 1082),
(4711, 2, 0, 'Apeldoorn', 1083),
(4712, 2, 0, 'Nijmegen', 1083),
(4713, 2, 0, 'Arnhem', 1083),
(4714, 2, 0, 'Ede', 1083),
(4715, 2, 0, 'Groningen', 1084),
(4716, 2, 0, 'Maastricht', 1085),
(4717, 2, 0, 'Heerlen', 1085),
(4718, 2, 0, 'Eindhoven', 1086),
(4719, 2, 0, 'Tilburg', 1086),
(4720, 2, 0, 'Breda', 1086),
(4721, 2, 0, 'Ã‚Â´s-Hertogenbosch', 1086),
(4722, 2, 0, 'Amsterdam', 1087),
(4723, 2, 0, 'Haarlem', 1087),
(4724, 2, 0, 'Zaanstad', 1087),
(4725, 2, 0, 'Haarlemmermeer', 1087),
(4726, 2, 0, 'Alkmaar', 1087),
(4727, 2, 0, 'Enschede', 1088),
(4728, 2, 0, 'Zwolle', 1088),
(4729, 2, 0, 'Utrecht', 1089),
(4730, 2, 0, 'Amersfoort', 1089),
(4731, 2, 0, 'Rotterdam', 1090),
(4732, 2, 0, 'Haag', 1090),
(4733, 2, 0, 'Dordrecht', 1090),
(4734, 2, 0, 'Leiden', 1090),
(4735, 2, 0, 'Zoetermeer', 1090),
(4736, 2, 0, 'Delft', 1090),
(4737, 2, 0, 'BÃƒÂ¦rum', 1091),
(4738, 2, 0, 'Bergen', 1092),
(4739, 2, 0, 'Oslo', 1093),
(4740, 2, 0, 'Stavanger', 1094),
(4741, 2, 0, 'Trondheim', 1095),
(4742, 2, 0, 'Suva', 1096),
(4743, 2, 0, 'Nyeri', 1096),
(4744, 2, 0, 'Kathmandu', 1096),
(4745, 2, 0, 'Lalitapur', 1096),
(4746, 2, 0, 'Birgunj', 1096),
(4747, 2, 0, 'San Lorenzo', 1096),
(4748, 2, 0, 'LambarÃƒÂ©', 1096),
(4749, 2, 0, 'Fernando De La Mora', 1096),
(4750, 2, 0, 'Kabwe', 1096),
(4751, 2, 0, 'Kandy', 1096),
(4752, 2, 0, 'Kampala', 1096),
(4753, 2, 0, 'Machakos', 1097),
(4754, 2, 0, 'Meru', 1097),
(4755, 2, 0, 'Biratnagar', 1097),
(4756, 2, 0, 'Sekondi-Takoradi', 1098),
(4757, 2, 0, 'Pokhara', 1098),
(4758, 2, 0, 'Freetown', 1098),
(4759, 2, 0, 'Colombo', 1098),
(4760, 2, 0, 'Dehiwala', 1098),
(4761, 2, 0, 'Moratuwa', 1098),
(4762, 2, 0, 'Sri Jayawardenepura Kotte', 1098),
(4763, 2, 0, 'Negombo', 1098),
(4764, 2, 0, 'South Hill', 1099),
(4765, 2, 0, 'The Valley', 1099),
(4766, 2, 0, 'Oranjestad', 1099),
(4767, 2, 0, 'Douglas', 1099),
(4768, 2, 0, 'Gibraltar', 1099),
(4769, 2, 0, 'Tamuning', 1099),
(4770, 2, 0, 'AgaÃƒÂ±a', 1099),
(4771, 2, 0, 'Flying Fish Cove', 1099),
(4772, 2, 0, 'Monte-Carlo', 1099),
(4773, 2, 0, 'Monaco-Ville', 1099),
(4774, 2, 0, 'Yangor', 1099),
(4775, 2, 0, 'Yaren', 1099),
(4776, 2, 0, 'Alofi', 1099),
(4777, 2, 0, 'Kingston', 1099),
(4778, 2, 0, 'Adamstown', 1099),
(4779, 2, 0, 'Singapore', 1099),
(4780, 2, 0, 'NoumÃƒÂ©a', 1099),
(4781, 2, 0, 'CittÃƒÂ  Del Vaticano', 1099),
(4782, 2, 0, 'Auckland', 1100),
(4783, 2, 0, 'Manukau', 1100),
(4784, 2, 0, 'North Shore', 1100),
(4785, 2, 0, 'Waitakere', 1100),
(4786, 2, 0, 'Christchurch', 1101),
(4787, 2, 0, 'Dunedin', 1102),
(4788, 2, 0, 'Hamilton', 1103),
(4789, 2, 0, 'Hamilton', 1103),
(4790, 2, 0, 'Wellington', 1104),
(4791, 2, 0, 'Lower Hutt', 1104),
(4792, 2, 0, 'Suhar', 1105),
(4793, 2, 0, 'Al-Sib', 1106),
(4794, 2, 0, 'Bawshar', 1106),
(4795, 2, 0, 'Masqat', 1106),
(4796, 2, 0, 'Salala', 1107),
(4797, 2, 0, 'Quetta', 1108),
(4798, 2, 0, 'Khuzdar', 1108),
(4799, 2, 0, 'Islamabad', 1109),
(4800, 2, 0, 'Peshawar', 1110),
(4801, 2, 0, 'Mardan', 1110),
(4802, 2, 0, 'Mingora', 1110),
(4803, 2, 0, 'Kohat', 1110),
(4804, 2, 0, 'Abottabad', 1110),
(4805, 2, 0, 'Dera Ismail Khan', 1110),
(4806, 2, 0, 'Nowshera', 1110),
(4807, 2, 0, 'Ludhiana', 1111),
(4808, 2, 0, 'Amritsar', 1111),
(4809, 2, 0, 'Jalandhar (Jullundur)', 1111),
(4810, 2, 0, 'Patiala', 1111),
(4811, 2, 0, 'Bhatinda (Bathinda)', 1111),
(4812, 2, 0, 'Pathankot', 1111),
(4813, 2, 0, 'Hoshiarpur', 1111),
(4814, 2, 0, 'Moga', 1111),
(4815, 2, 0, 'Abohar', 1111),
(4816, 2, 0, 'Lahore', 1111),
(4817, 2, 0, 'Faisalabad', 1111),
(4818, 2, 0, 'Rawalpindi', 1111),
(4819, 2, 0, 'Multan', 1111),
(4820, 2, 0, 'Gujranwala', 1111),
(4821, 2, 0, 'Sargodha', 1111),
(4822, 2, 0, 'Sialkot', 1111),
(4823, 2, 0, 'Bahawalpur', 1111),
(4824, 2, 0, 'Jhang', 1111),
(4825, 2, 0, 'Sheikhupura', 1111),
(4826, 2, 0, 'Gujrat', 1111),
(4827, 2, 0, 'Kasur', 1111),
(4828, 2, 0, 'Rahim Yar Khan', 1111),
(4829, 2, 0, 'Sahiwal', 1111),
(4830, 2, 0, 'Okara', 1111),
(4831, 2, 0, 'Wah', 1111),
(4832, 2, 0, 'Dera Ghazi Khan', 1111),
(4833, 2, 0, 'Chiniot', 1111),
(4834, 2, 0, 'Kamoke', 1111),
(4835, 2, 0, 'Mandi Burewala', 1111),
(4836, 2, 0, 'Jhelum', 1111),
(4837, 2, 0, 'Sadiqabad', 1111),
(4838, 2, 0, 'Khanewal', 1111),
(4839, 2, 0, 'Hafizabad', 1111),
(4840, 2, 0, 'Muzaffargarh', 1111),
(4841, 2, 0, 'Khanpur', 1111),
(4842, 2, 0, 'Gojra', 1111),
(4843, 2, 0, 'Bahawalnagar', 1111),
(4844, 2, 0, 'Muridke', 1111),
(4845, 2, 0, 'Pak Pattan', 1111),
(4846, 2, 0, 'Jaranwala', 1111),
(4847, 2, 0, 'Chishtian Mandi', 1111),
(4848, 2, 0, 'Daska', 1111),
(4849, 2, 0, 'Mandi Bahauddin', 1111),
(4850, 2, 0, 'Ahmadpur East', 1111),
(4851, 2, 0, 'Kamalia', 1111),
(4852, 2, 0, 'Vihari', 1111),
(4853, 2, 0, 'Wazirabad', 1111),
(4854, 2, 0, 'Mirpur Khas', 1112),
(4855, 2, 0, 'Nawabshah', 1112),
(4856, 2, 0, 'Jacobabad', 1112),
(4857, 2, 0, 'Shikarpur', 1112),
(4858, 2, 0, 'Tando Adam', 1112),
(4859, 2, 0, 'Khairpur', 1112),
(4860, 2, 0, 'Dadu', 1112),
(4861, 2, 0, 'Karachi', 1113),
(4862, 2, 0, 'Hyderabad', 1113),
(4863, 2, 0, 'Sukkur', 1113),
(4864, 2, 0, 'Larkana', 1113),
(4865, 2, 0, 'Ciudad De PanamÃƒÂ¡', 1114),
(4866, 2, 0, 'San Miguelito', 1115),
(4867, 2, 0, 'South Hill', 1116),
(4868, 2, 0, 'The Valley', 1116),
(4869, 2, 0, 'Oranjestad', 1116),
(4870, 2, 0, 'Douglas', 1116),
(4871, 2, 0, 'Gibraltar', 1116),
(4872, 2, 0, 'Tamuning', 1116),
(4873, 2, 0, 'AgaÃƒÂ±a', 1116),
(4874, 2, 0, 'Flying Fish Cove', 1116),
(4875, 2, 0, 'Monte-Carlo', 1116),
(4876, 2, 0, 'Monaco-Ville', 1116),
(4877, 2, 0, 'Yangor', 1116),
(4878, 2, 0, 'Yaren', 1116),
(4879, 2, 0, 'Alofi', 1116),
(4880, 2, 0, 'Kingston', 1116),
(4881, 2, 0, 'Adamstown', 1116),
(4882, 2, 0, 'Singapore', 1116),
(4883, 2, 0, 'NoumÃƒÂ©a', 1116),
(4884, 2, 0, 'CittÃƒÂ  Del Vaticano', 1116),
(4885, 2, 0, 'Chimbote', 1117),
(4886, 2, 0, 'Arequipa', 1118),
(4887, 2, 0, 'Ayacucho', 1119),
(4888, 2, 0, 'Cajamarca', 1120),
(4889, 2, 0, 'Callao', 1121),
(4890, 2, 0, 'Ventanilla', 1121),
(4891, 2, 0, 'Cusco', 1122),
(4892, 2, 0, 'HuÃƒÂ¡nuco', 1123),
(4893, 2, 0, 'Ica', 1124),
(4894, 2, 0, 'Chincha Alta', 1124),
(4895, 2, 0, 'Huancayo', 1125),
(4896, 2, 0, 'Nueva San Salvador', 1126),
(4897, 2, 0, 'Trujillo', 1126),
(4898, 2, 0, 'Chiclayo', 1127),
(4899, 2, 0, 'Lima', 1128),
(4900, 2, 0, 'Iquitos', 1129),
(4901, 2, 0, 'Piura', 1130),
(4902, 2, 0, 'Sullana', 1130),
(4903, 2, 0, 'Castilla', 1130),
(4904, 2, 0, 'Juliaca', 1131),
(4905, 2, 0, 'Puno', 1131),
(4906, 2, 0, 'Tacna', 1132),
(4907, 2, 0, 'Pucallpa', 1133),
(4908, 2, 0, 'Sultan Kudarat', 1134),
(4909, 2, 0, 'Legazpi', 1135),
(4910, 2, 0, 'Naga', 1135),
(4911, 2, 0, 'Tabaco', 1135),
(4912, 2, 0, 'Daraga (Locsin)', 1135),
(4913, 2, 0, 'Sorsogon', 1135),
(4914, 2, 0, 'Ligao', 1135),
(4915, 2, 0, 'Tuguegarao', 1136),
(4916, 2, 0, 'Ilagan', 1136),
(4917, 2, 0, 'Santiago', 1136),
(4918, 2, 0, 'Cauayan', 1136),
(4919, 2, 0, 'Baguio', 1137),
(4920, 2, 0, 'Butuan', 1138),
(4921, 2, 0, 'Surigao', 1138),
(4922, 2, 0, 'Bislig', 1138),
(4923, 2, 0, 'Bayugan', 1138),
(4924, 2, 0, 'San JosÃƒÂ© Del Monte', 1139),
(4925, 2, 0, 'Angeles', 1139),
(4926, 2, 0, 'Tarlac', 1139),
(4927, 2, 0, 'Cabanatuan', 1139),
(4928, 2, 0, 'San Fernando', 1139),
(4929, 2, 0, 'Olongapo', 1139),
(4930, 2, 0, 'Malolos', 1139),
(4931, 2, 0, 'Mabalacat', 1139),
(4932, 2, 0, 'Meycauayan', 1139),
(4933, 2, 0, 'Santa Maria', 1139),
(4934, 2, 0, 'Lubao', 1139),
(4935, 2, 0, 'San Miguel', 1139),
(4936, 2, 0, 'Baliuag', 1139),
(4937, 2, 0, 'Concepcion', 1139),
(4938, 2, 0, 'Hagonoy', 1139),
(4939, 2, 0, 'Mexico', 1139),
(4940, 2, 0, 'San Jose', 1139),
(4941, 2, 0, 'Arayat', 1139),
(4942, 2, 0, 'Marilao', 1139),
(4943, 2, 0, 'Talavera', 1139),
(4944, 2, 0, 'Guagua', 1139),
(4945, 2, 0, 'Capas', 1139),
(4946, 2, 0, 'Iligan', 1140),
(4947, 2, 0, 'Cotabato', 1140),
(4948, 2, 0, 'Marawi', 1140),
(4949, 2, 0, 'Midsayap', 1140),
(4950, 2, 0, 'Kidapawan', 1140),
(4951, 2, 0, 'Cebu', 1141),
(4952, 2, 0, 'Mandaue', 1141),
(4953, 2, 0, 'Lapu-Lapu', 1141),
(4954, 2, 0, 'Talisay', 1141),
(4955, 2, 0, 'Toledo', 1141),
(4956, 2, 0, 'Dumaguete', 1141),
(4957, 2, 0, 'Bayawan (Tulong)', 1141),
(4958, 2, 0, 'Danao', 1141),
(4959, 2, 0, 'Tacloban', 1142),
(4960, 2, 0, 'Ormoc', 1142),
(4961, 2, 0, 'Calbayog', 1142),
(4962, 2, 0, 'Baybay', 1142),
(4963, 2, 0, 'San Carlos', 1143),
(4964, 2, 0, 'Dagupan', 1143),
(4965, 2, 0, 'Malasiqui', 1143),
(4966, 2, 0, 'Urdaneta', 1143),
(4967, 2, 0, 'San Fernando', 1143),
(4968, 2, 0, 'Bayambang', 1143),
(4969, 2, 0, 'Laoag', 1143),
(4970, 2, 0, 'Quezon', 1144),
(4971, 2, 0, 'Manila', 1144),
(4972, 2, 0, 'Kalookan', 1144),
(4973, 2, 0, 'Pasig', 1144),
(4974, 2, 0, 'Valenzuela', 1144),
(4975, 2, 0, 'Las PiÃƒÂ±as', 1144),
(4976, 2, 0, 'Taguig', 1144),
(4977, 2, 0, 'ParaÃƒÂ±aque', 1144),
(4978, 2, 0, 'Makati', 1144),
(4979, 2, 0, 'Marikina', 1144),
(4980, 2, 0, 'Muntinlupa', 1144),
(4981, 2, 0, 'Pasay', 1144),
(4982, 2, 0, 'Malabon', 1144),
(4983, 2, 0, 'Mandaluyong', 1144),
(4984, 2, 0, 'Navotas', 1144),
(4985, 2, 0, 'San Juan Del Monte', 1144),
(4986, 2, 0, 'Cagayan De Oro', 1145),
(4987, 2, 0, 'Valencia', 1145),
(4988, 2, 0, 'Malaybalay', 1145),
(4989, 2, 0, 'Ozamis', 1145),
(4990, 2, 0, 'Gingoog', 1145),
(4991, 2, 0, 'Davao', 1146),
(4992, 2, 0, 'General Santos', 1146),
(4993, 2, 0, 'Tagum', 1146),
(4994, 2, 0, 'Panabo', 1146),
(4995, 2, 0, 'Koronadal', 1146),
(4996, 2, 0, 'Digos', 1146),
(4997, 2, 0, 'Polomolok', 1146),
(4998, 2, 0, 'Mati', 1146),
(4999, 2, 0, 'Malita', 1146),
(5000, 2, 0, 'Malungon', 1146),
(5001, 2, 0, 'Antipolo', 1147),
(5002, 2, 0, 'DasmariÃƒÂ±as', 1147),
(5003, 2, 0, 'Bacoor', 1147),
(5004, 2, 0, 'Calamba', 1147),
(5005, 2, 0, 'Batangas', 1147),
(5006, 2, 0, 'Cainta', 1147),
(5007, 2, 0, 'San Pedro', 1147),
(5008, 2, 0, 'Lipa', 1147),
(5009, 2, 0, 'San Pablo', 1147),
(5010, 2, 0, 'BiÃƒÂ±an', 1147),
(5011, 2, 0, 'Taytay', 1147),
(5012, 2, 0, 'Lucena', 1147),
(5013, 2, 0, 'Imus', 1147),
(5014, 2, 0, 'Binangonan', 1147),
(5015, 2, 0, 'Santa Rosa', 1147),
(5016, 2, 0, 'Puerto Princesa', 1147),
(5017, 2, 0, 'Silang', 1147),
(5018, 2, 0, 'San Mateo', 1147),
(5019, 2, 0, 'Tanauan', 1147),
(5020, 2, 0, 'Rodriguez (Montalban)', 1147),
(5021, 2, 0, 'Sariaya', 1147),
(5022, 2, 0, 'General Mariano Alvarez', 1147),
(5023, 2, 0, 'San Jose', 1147),
(5024, 2, 0, 'Tanza', 1147),
(5025, 2, 0, 'General Trias', 1147),
(5026, 2, 0, 'Cabuyao', 1147),
(5027, 2, 0, 'Calapan', 1147),
(5028, 2, 0, 'Cavite', 1147),
(5029, 2, 0, 'Nasugbu', 1147),
(5030, 2, 0, 'Santa Cruz', 1147);
INSERT INTO `tbl_geographical_location` (`location_id`, `location_type`, `is_visible`, `name`, `parent_id`) VALUES
(5031, 2, 0, 'Candelaria', 1147),
(5032, 2, 0, 'Zamboanga', 1148),
(5033, 2, 0, 'Pagadian', 1148),
(5034, 2, 0, 'Dipolog', 1148),
(5035, 2, 0, 'Bacolod', 1149),
(5036, 2, 0, 'Iloilo', 1149),
(5037, 2, 0, 'Kabankalan', 1149),
(5038, 2, 0, 'Cadiz', 1149),
(5039, 2, 0, 'Bago', 1149),
(5040, 2, 0, 'Sagay', 1149),
(5041, 2, 0, 'Roxas', 1149),
(5042, 2, 0, 'San Carlos', 1149),
(5043, 2, 0, 'Silay', 1149),
(5044, 2, 0, 'Koror', 1150),
(5045, 2, 0, 'Port Moresby', 1151),
(5046, 2, 0, 'Wroclaw', 1152),
(5047, 2, 0, 'Walbrzych', 1152),
(5048, 2, 0, 'Legnica', 1152),
(5049, 2, 0, 'Jelenia GÃƒÂ³ra', 1152),
(5050, 2, 0, 'Bydgoszcz', 1153),
(5051, 2, 0, 'Torun', 1153),
(5052, 2, 0, 'Wloclawek', 1153),
(5053, 2, 0, 'Grudziadz', 1153),
(5054, 2, 0, 'LÃƒÂ³dz', 1154),
(5055, 2, 0, 'Lublin', 1155),
(5056, 2, 0, 'GorzÃƒÂ³w Wielkopolski', 1156),
(5057, 2, 0, 'Zielona GÃƒÂ³ra', 1156),
(5058, 2, 0, 'KrakÃƒÂ³w', 1157),
(5059, 2, 0, 'TarnÃƒÂ³w', 1157),
(5060, 2, 0, 'Warszawa', 1158),
(5061, 2, 0, 'Radom', 1158),
(5062, 2, 0, 'Plock', 1158),
(5063, 2, 0, 'Opole', 1159),
(5064, 2, 0, 'RzeszÃƒÂ³w', 1160),
(5065, 2, 0, 'Bialystok', 1161),
(5066, 2, 0, 'Gdansk', 1162),
(5067, 2, 0, 'Gdynia', 1162),
(5068, 2, 0, 'Slupsk', 1162),
(5069, 2, 0, 'Katowice', 1163),
(5070, 2, 0, 'Czestochowa', 1163),
(5071, 2, 0, 'Sosnowiec', 1163),
(5072, 2, 0, 'Gliwice', 1163),
(5073, 2, 0, 'Bytom', 1163),
(5074, 2, 0, 'Zabrze', 1163),
(5075, 2, 0, 'Bielsko-Biala', 1163),
(5076, 2, 0, 'Ruda Slaska', 1163),
(5077, 2, 0, 'Rybnik', 1163),
(5078, 2, 0, 'Tychy', 1163),
(5079, 2, 0, 'Dabrowa GÃƒÂ³rnicza', 1163),
(5080, 2, 0, 'ChorzÃƒÂ³w', 1163),
(5081, 2, 0, 'Jastrzebie-ZdrÃƒÂ³j', 1163),
(5082, 2, 0, 'Jaworzno', 1163),
(5083, 2, 0, 'Kielce', 1164),
(5084, 2, 0, 'Olsztyn', 1165),
(5085, 2, 0, 'Elblag', 1165),
(5086, 2, 0, 'Poznan', 1166),
(5087, 2, 0, 'Kalisz', 1166),
(5088, 2, 0, 'Szczecin', 1167),
(5089, 2, 0, 'Koszalin', 1167),
(5090, 2, 0, 'Arecibo', 1168),
(5091, 2, 0, 'BayamÃƒÂ³n', 1169),
(5092, 2, 0, 'Caguas', 1170),
(5093, 2, 0, 'Carolina', 1171),
(5094, 2, 0, 'Guaynabo', 1172),
(5095, 2, 0, 'MayagÃƒÂ¼ez', 1173),
(5096, 2, 0, 'Ponce', 1174),
(5097, 2, 0, 'San Juan', 1175),
(5098, 2, 0, 'San Juan', 1175),
(5099, 2, 0, 'Toa Baja', 1176),
(5100, 2, 0, 'Kanggye', 1177),
(5101, 2, 0, 'Hamhung', 1178),
(5102, 2, 0, 'Chongjin', 1179),
(5103, 2, 0, 'Kimchaek', 1179),
(5104, 2, 0, 'Haeju', 1180),
(5105, 2, 0, 'Sariwon', 1181),
(5106, 2, 0, 'Kaesong', 1182),
(5107, 2, 0, 'Wonsan', 1183),
(5108, 2, 0, 'Nampo', 1184),
(5109, 2, 0, 'Phyongsong', 1185),
(5110, 2, 0, 'Sinuiju', 1186),
(5111, 2, 0, 'Pyongyang', 1187),
(5112, 2, 0, 'Hyesan', 1188),
(5113, 2, 0, 'Braga', 1189),
(5114, 2, 0, 'CoÃƒÂ­mbra', 1190),
(5115, 2, 0, 'Lisboa', 1191),
(5116, 2, 0, 'Amadora', 1191),
(5117, 2, 0, 'Stockholm', 1191),
(5118, 2, 0, 'Porto', 1192),
(5119, 2, 0, 'Ciudad Del Este', 1193),
(5120, 2, 0, 'AsunciÃƒÂ³n', 1194),
(5121, 2, 0, 'Suva', 1195),
(5122, 2, 0, 'Nyeri', 1195),
(5123, 2, 0, 'Kathmandu', 1195),
(5124, 2, 0, 'Lalitapur', 1195),
(5125, 2, 0, 'Birgunj', 1195),
(5126, 2, 0, 'San Lorenzo', 1195),
(5127, 2, 0, 'LambarÃƒÂ©', 1195),
(5128, 2, 0, 'Fernando De La Mora', 1195),
(5129, 2, 0, 'Kabwe', 1195),
(5130, 2, 0, 'Kandy', 1195),
(5131, 2, 0, 'Kampala', 1195),
(5132, 2, 0, 'Xai-Xai', 1196),
(5133, 2, 0, 'Gaza', 1196),
(5134, 2, 0, 'Hebron', 1197),
(5135, 2, 0, 'Khan Yunis', 1198),
(5136, 2, 0, 'Nablus', 1199),
(5137, 2, 0, 'Jabaliya', 1200),
(5138, 2, 0, 'Rafah', 1201),
(5139, 2, 0, 'Faaa', 1202),
(5140, 2, 0, 'Papeete', 1202),
(5141, 2, 0, 'Doha', 1203),
(5142, 2, 0, 'Saint-Denis', 1204),
(5143, 2, 0, 'Arad', 1205),
(5144, 2, 0, 'Pitesti', 1206),
(5145, 2, 0, 'Bacau', 1207),
(5146, 2, 0, 'Oradea', 1208),
(5147, 2, 0, 'Botosani', 1209),
(5148, 2, 0, 'Braila', 1210),
(5149, 2, 0, 'Brasov', 1211),
(5150, 2, 0, 'Bucuresti', 1212),
(5151, 2, 0, 'Buzau', 1213),
(5152, 2, 0, 'Resita', 1214),
(5153, 2, 0, 'Cluj-Napoca', 1215),
(5154, 2, 0, 'Constanta', 1216),
(5155, 2, 0, 'TÃƒÂ¢rgoviste', 1217),
(5156, 2, 0, 'Craiova', 1218),
(5157, 2, 0, 'Galati', 1219),
(5158, 2, 0, 'TÃƒÂ¢rgu Jiu', 1220),
(5159, 2, 0, 'Iasi', 1221),
(5160, 2, 0, 'Baia Mare', 1222),
(5161, 2, 0, 'Drobeta-Turnu Severin', 1223),
(5162, 2, 0, 'TÃƒÂ¢rgu Mures', 1224),
(5163, 2, 0, 'Piatra Neamt', 1225),
(5164, 2, 0, 'Ploiesti', 1226),
(5165, 2, 0, 'Satu Mare', 1227),
(5166, 2, 0, 'Sibiu', 1228),
(5167, 2, 0, 'Suceava', 1229),
(5168, 2, 0, 'Timisoara', 1230),
(5169, 2, 0, 'Tulcea', 1231),
(5170, 2, 0, 'RÃƒÂ¢mnicu VÃƒÂ¢lcea', 1232),
(5171, 2, 0, 'Focsani', 1233),
(5172, 2, 0, 'Maikop', 1234),
(5173, 2, 0, 'Barnaul', 1235),
(5174, 2, 0, 'Bijsk', 1235),
(5175, 2, 0, 'Rubtsovsk', 1235),
(5176, 2, 0, 'BlagoveÃ…Â¡tÃ…Â¡ensk', 1236),
(5177, 2, 0, 'Arkangeli', 1237),
(5178, 2, 0, 'Severodvinsk', 1237),
(5179, 2, 0, 'Astrahan', 1238),
(5180, 2, 0, 'Ufa', 1239),
(5181, 2, 0, 'Sterlitamak', 1239),
(5182, 2, 0, 'Salavat', 1239),
(5183, 2, 0, 'Neftekamsk', 1239),
(5184, 2, 0, 'Oktjabrski', 1239),
(5185, 2, 0, 'Belgorod', 1240),
(5186, 2, 0, 'Staryi Oskol', 1240),
(5187, 2, 0, 'Brjansk', 1241),
(5188, 2, 0, 'Ulan-Ude', 1242),
(5189, 2, 0, 'MahatÃ…Â¡kala', 1243),
(5190, 2, 0, 'Derbent', 1243),
(5191, 2, 0, 'Habarovsk', 1244),
(5192, 2, 0, 'Komsomolsk-na-Amure', 1244),
(5193, 2, 0, 'Abakan', 1245),
(5194, 2, 0, 'Surgut', 1246),
(5195, 2, 0, 'Niznevartovsk', 1246),
(5196, 2, 0, 'Neftejugansk', 1246),
(5197, 2, 0, 'Irkutsk', 1247),
(5198, 2, 0, 'Bratsk', 1247),
(5199, 2, 0, 'Angarsk', 1247),
(5200, 2, 0, 'Ust-Ilimsk', 1247),
(5201, 2, 0, 'Usolje-Sibirskoje', 1247),
(5202, 2, 0, 'Ivanovo', 1248),
(5203, 2, 0, 'KineÃ…Â¡ma', 1248),
(5204, 2, 0, 'Jaroslavl', 1249),
(5205, 2, 0, 'Rybinsk', 1249),
(5206, 2, 0, 'NaltÃ…Â¡ik', 1250),
(5207, 2, 0, 'Kaliningrad', 1251),
(5208, 2, 0, 'Elista', 1252),
(5209, 2, 0, 'Kaluga', 1253),
(5210, 2, 0, 'Obninsk', 1253),
(5211, 2, 0, 'Petropavlovsk-KamtÃ…Â¡atski', 1254),
(5212, 2, 0, 'TÃ…Â¡erkessk', 1255),
(5213, 2, 0, 'Petroskoi', 1256),
(5214, 2, 0, 'Novokuznetsk', 1257),
(5215, 2, 0, 'Kemerovo', 1257),
(5216, 2, 0, 'Prokopjevsk', 1257),
(5217, 2, 0, 'Leninsk-Kuznetski', 1257),
(5218, 2, 0, 'Kiseljovsk', 1257),
(5219, 2, 0, 'MezduretÃ…Â¡ensk', 1257),
(5220, 2, 0, 'Anzero-Sudzensk', 1257),
(5221, 2, 0, 'Kirov', 1258),
(5222, 2, 0, 'Kirovo-TÃ…Â¡epetsk', 1258),
(5223, 2, 0, 'Syktyvkar', 1259),
(5224, 2, 0, 'Uhta', 1259),
(5225, 2, 0, 'Vorkuta', 1259),
(5226, 2, 0, 'Kostroma', 1260),
(5227, 2, 0, 'Krasnodar', 1261),
(5228, 2, 0, 'SotÃ…Â¡i', 1261),
(5229, 2, 0, 'Novorossijsk', 1261),
(5230, 2, 0, 'Armavir', 1261),
(5231, 2, 0, 'Krasnojarsk', 1262),
(5232, 2, 0, 'Norilsk', 1262),
(5233, 2, 0, 'AtÃ…Â¡insk', 1262),
(5234, 2, 0, 'Kansk', 1262),
(5235, 2, 0, 'Zeleznogorsk', 1262),
(5236, 2, 0, 'Kurgan', 1263),
(5237, 2, 0, 'Kursk', 1264),
(5238, 2, 0, 'Zeleznogorsk', 1264),
(5239, 2, 0, 'Lipetsk', 1265),
(5240, 2, 0, 'Jelets', 1265),
(5241, 2, 0, 'Magadan', 1266),
(5242, 2, 0, 'JoÃ…Â¡kar-Ola', 1267),
(5243, 2, 0, 'Saransk', 1268),
(5244, 2, 0, 'Moscow', 1269),
(5245, 2, 0, 'Zelenograd', 1269),
(5246, 2, 0, 'Podolsk', 1270),
(5247, 2, 0, 'Ljubertsy', 1270),
(5248, 2, 0, 'MytiÃ…Â¡tÃ…Â¡i', 1270),
(5249, 2, 0, 'Kolomna', 1270),
(5250, 2, 0, 'Elektrostal', 1270),
(5251, 2, 0, 'Himki', 1270),
(5252, 2, 0, 'BalaÃ…Â¡iha', 1270),
(5253, 2, 0, 'Korolev', 1270),
(5254, 2, 0, 'Serpuhov', 1270),
(5255, 2, 0, 'Odintsovo', 1270),
(5256, 2, 0, 'Orehovo-Zujevo', 1270),
(5257, 2, 0, 'Noginsk', 1270),
(5258, 2, 0, 'Sergijev Posad', 1270),
(5259, 2, 0, 'Ã…Â tÃ…Â¡olkovo', 1270),
(5260, 2, 0, 'Zeleznodoroznyi', 1270),
(5261, 2, 0, 'Zukovski', 1270),
(5262, 2, 0, 'Krasnogorsk', 1270),
(5263, 2, 0, 'Klin', 1270),
(5264, 2, 0, 'Murmansk', 1271),
(5265, 2, 0, 'Nizni Novgorod', 1272),
(5266, 2, 0, 'Dzerzinsk', 1272),
(5267, 2, 0, 'Arzamas', 1272),
(5268, 2, 0, 'Vladikavkaz', 1273),
(5269, 2, 0, 'Veliki Novgorod', 1274),
(5270, 2, 0, 'Novosibirsk', 1275),
(5271, 2, 0, 'Omsk', 1276),
(5272, 2, 0, 'Orenburg', 1277),
(5273, 2, 0, 'Orsk', 1277),
(5274, 2, 0, 'Novotroitsk', 1277),
(5275, 2, 0, 'Orjol', 1278),
(5276, 2, 0, 'Penza', 1279),
(5277, 2, 0, 'Kuznetsk', 1279),
(5278, 2, 0, 'Perm', 1280),
(5279, 2, 0, 'Berezniki', 1280),
(5280, 2, 0, 'Solikamsk', 1280),
(5281, 2, 0, 'TÃ…Â¡aikovski', 1280),
(5282, 2, 0, 'St Petersburg', 1281),
(5283, 2, 0, 'Kolpino', 1281),
(5284, 2, 0, 'PuÃ…Â¡kin', 1281),
(5285, 2, 0, 'Pihkova', 1282),
(5286, 2, 0, 'Velikije Luki', 1282),
(5287, 2, 0, 'Vladivostok', 1283),
(5288, 2, 0, 'Nahodka', 1283),
(5289, 2, 0, 'Ussurijsk', 1283),
(5290, 2, 0, 'Rjazan', 1284),
(5291, 2, 0, 'Rostov-na-Donu', 1285),
(5292, 2, 0, 'Taganrog', 1285),
(5293, 2, 0, 'Ã…Â ahty', 1285),
(5294, 2, 0, 'NovotÃ…Â¡erkassk', 1285),
(5295, 2, 0, 'Volgodonsk', 1285),
(5296, 2, 0, 'NovoÃ…Â¡ahtinsk', 1285),
(5297, 2, 0, 'Bataisk', 1285),
(5298, 2, 0, 'Jakutsk', 1286),
(5299, 2, 0, 'Juzno-Sahalinsk', 1287),
(5300, 2, 0, 'Samara', 1288),
(5301, 2, 0, 'Toljatti', 1288),
(5302, 2, 0, 'Syzran', 1288),
(5303, 2, 0, 'NovokuibyÃ…Â¡evsk', 1288),
(5304, 2, 0, 'Saratov', 1289),
(5305, 2, 0, 'Balakovo', 1289),
(5306, 2, 0, 'Engels', 1289),
(5307, 2, 0, 'BalaÃ…Â¡ov', 1289),
(5308, 2, 0, 'Smolensk', 1290),
(5309, 2, 0, 'Stavropol', 1291),
(5310, 2, 0, 'Nevinnomyssk', 1291),
(5311, 2, 0, 'Pjatigorsk', 1291),
(5312, 2, 0, 'Kislovodsk', 1291),
(5313, 2, 0, 'Jessentuki', 1291),
(5314, 2, 0, 'Jekaterinburg', 1292),
(5315, 2, 0, 'Nizni Tagil', 1292),
(5316, 2, 0, 'Kamensk-Uralski', 1292),
(5317, 2, 0, 'Pervouralsk', 1292),
(5318, 2, 0, 'Serov', 1292),
(5319, 2, 0, 'Novouralsk', 1292),
(5320, 2, 0, 'Tambov', 1293),
(5321, 2, 0, 'MitÃ…Â¡urinsk', 1293),
(5322, 2, 0, 'Kazan', 1294),
(5323, 2, 0, 'Nabereznyje TÃ…Â¡elny', 1294),
(5324, 2, 0, 'Niznekamsk', 1294),
(5325, 2, 0, 'Almetjevsk', 1294),
(5326, 2, 0, 'Zelenodolsk', 1294),
(5327, 2, 0, 'Bugulma', 1294),
(5328, 2, 0, 'Tjumen', 1295),
(5329, 2, 0, 'Tobolsk', 1295),
(5330, 2, 0, 'Tomsk', 1296),
(5331, 2, 0, 'Seversk', 1296),
(5332, 2, 0, 'Tula', 1297),
(5333, 2, 0, 'Novomoskovsk', 1297),
(5334, 2, 0, 'Tver', 1298),
(5335, 2, 0, 'Kyzyl', 1299),
(5336, 2, 0, 'TÃ…Â¡eljabinsk', 1300),
(5337, 2, 0, 'Magnitogorsk', 1300),
(5338, 2, 0, 'Zlatoust', 1300),
(5339, 2, 0, 'Miass', 1300),
(5340, 2, 0, 'Grozny', 1301),
(5341, 2, 0, 'TÃ…Â¡ita', 1302),
(5342, 2, 0, 'TÃ…Â¡eboksary', 1303),
(5343, 2, 0, 'NovotÃ…Â¡eboksarsk', 1303),
(5344, 2, 0, 'Izevsk', 1304),
(5345, 2, 0, 'Glazov', 1304),
(5346, 2, 0, 'Sarapul', 1304),
(5347, 2, 0, 'Votkinsk', 1304),
(5348, 2, 0, 'Uljanovsk', 1305),
(5349, 2, 0, 'Dimitrovgrad', 1305),
(5350, 2, 0, 'Vladimir', 1306),
(5351, 2, 0, 'Kovrov', 1306),
(5352, 2, 0, 'Murom', 1306),
(5353, 2, 0, 'Volgograd', 1307),
(5354, 2, 0, 'Volzski', 1307),
(5355, 2, 0, 'KamyÃ…Â¡in', 1307),
(5356, 2, 0, 'TÃ…Â¡erepovets', 1308),
(5357, 2, 0, 'Vologda', 1308),
(5358, 2, 0, 'Voronez', 1309),
(5359, 2, 0, 'Nojabrsk', 1310),
(5360, 2, 0, 'Novyi Urengoi', 1310),
(5361, 2, 0, 'Kigali', 1311),
(5362, 2, 0, 'AraÃ‚Â´ar', 1312),
(5363, 2, 0, 'Burayda', 1313),
(5364, 2, 0, 'Zagazig', 1314),
(5365, 2, 0, 'Bilbays', 1314),
(5366, 2, 0, 'Al-Dammam', 1314),
(5367, 2, 0, 'Al-Hufuf', 1314),
(5368, 2, 0, 'Al-Mubarraz', 1314),
(5369, 2, 0, 'Al-Khubar', 1314),
(5370, 2, 0, 'Jubayl', 1314),
(5371, 2, 0, 'Hafar Al-Batin', 1314),
(5372, 2, 0, 'Al-Tuqba', 1314),
(5373, 2, 0, 'Al-Qatif', 1314),
(5374, 2, 0, 'Khamis Mushayt', 1315),
(5375, 2, 0, 'Abha', 1315),
(5376, 2, 0, 'Hail', 1316),
(5377, 2, 0, 'Medina', 1317),
(5378, 2, 0, 'Yanbu', 1317),
(5379, 2, 0, 'Jedda', 1318),
(5380, 2, 0, 'Mekka', 1318),
(5381, 2, 0, 'Al-Taif', 1318),
(5382, 2, 0, 'Al-Hawiya', 1318),
(5383, 2, 0, 'Najran', 1319),
(5384, 2, 0, 'Unayza', 1320),
(5385, 2, 0, 'Al-Kharj', 1321),
(5386, 2, 0, 'Riyadh', 1322),
(5387, 2, 0, 'Tabuk', 1323),
(5388, 2, 0, 'Kusti', 1324),
(5389, 2, 0, 'Port Sudan', 1325),
(5390, 2, 0, 'Wad Madani', 1326),
(5391, 2, 0, 'Al-Qadarif', 1327),
(5392, 2, 0, 'Juba', 1328),
(5393, 2, 0, 'Nyala', 1329),
(5394, 2, 0, 'Al-Fashir', 1330),
(5395, 2, 0, 'Kassala', 1331),
(5396, 2, 0, 'Omdurman', 1332),
(5397, 2, 0, 'Khartum', 1332),
(5398, 2, 0, 'Sharq Al-Nil', 1332),
(5399, 2, 0, 'Obeid', 1333),
(5400, 2, 0, 'Pikine', 1334),
(5401, 2, 0, 'Dakar', 1334),
(5402, 2, 0, 'Rufisque', 1334),
(5403, 2, 0, 'Diourbel', 1335),
(5404, 2, 0, 'Kaolack', 1336),
(5405, 2, 0, 'Saint-Louis', 1337),
(5406, 2, 0, 'ThiÃƒÂ¨s', 1338),
(5407, 2, 0, 'Mbour', 1338),
(5408, 2, 0, 'Ziguinchor', 1339),
(5409, 2, 0, 'South Hill', 1340),
(5410, 2, 0, 'The Valley', 1340),
(5411, 2, 0, 'Oranjestad', 1340),
(5412, 2, 0, 'Douglas', 1340),
(5413, 2, 0, 'Gibraltar', 1340),
(5414, 2, 0, 'Tamuning', 1340),
(5415, 2, 0, 'AgaÃƒÂ±a', 1340),
(5416, 2, 0, 'Flying Fish Cove', 1340),
(5417, 2, 0, 'Monte-Carlo', 1340),
(5418, 2, 0, 'Monaco-Ville', 1340),
(5419, 2, 0, 'Yangor', 1340),
(5420, 2, 0, 'Yaren', 1340),
(5421, 2, 0, 'Alofi', 1340),
(5422, 2, 0, 'Kingston', 1340),
(5423, 2, 0, 'Adamstown', 1340),
(5424, 2, 0, 'Singapore', 1340),
(5425, 2, 0, 'NoumÃƒÂ©a', 1340),
(5426, 2, 0, 'CittÃƒÂ  Del Vaticano', 1340),
(5427, 2, 0, 'Jamestown', 1341),
(5428, 2, 0, 'Longyearbyen', 1342),
(5429, 2, 0, 'Honiara', 1343),
(5430, 2, 0, 'Sekondi-Takoradi', 1344),
(5431, 2, 0, 'Pokhara', 1344),
(5432, 2, 0, 'Freetown', 1344),
(5433, 2, 0, 'Colombo', 1344),
(5434, 2, 0, 'Dehiwala', 1344),
(5435, 2, 0, 'Moratuwa', 1344),
(5436, 2, 0, 'Sri Jayawardenepura Kotte', 1344),
(5437, 2, 0, 'Negombo', 1344),
(5438, 2, 0, 'Nueva San Salvador', 1345),
(5439, 2, 0, 'Trujillo', 1345),
(5440, 2, 0, 'San Miguel', 1346),
(5441, 2, 0, 'San Salvador', 1347),
(5442, 2, 0, 'Mejicanos', 1347),
(5443, 2, 0, 'Soyapango', 1347),
(5444, 2, 0, 'Apopa', 1347),
(5445, 2, 0, 'Santa Ana', 1348),
(5446, 2, 0, 'San Marino', 1349),
(5447, 2, 0, 'Serravalle', 1350),
(5448, 2, 0, 'Mogadishu', 1351),
(5449, 2, 0, 'Kismaayo', 1352),
(5450, 2, 0, 'Hargeysa', 1353),
(5451, 2, 0, 'Saint-Pierre', 1354),
(5452, 2, 0, 'SÃƒÂ£o TomÃƒÂ©', 1355),
(5453, 2, 0, 'Paramaribo', 1356),
(5454, 2, 0, 'Bratislava', 1357),
(5455, 2, 0, 'KoÃ…Â¡ice', 1358),
(5456, 2, 0, 'PreÃ…Â¡ov', 1358),
(5457, 2, 0, 'Ljubljana', 1359),
(5458, 2, 0, 'Maribor', 1360),
(5459, 2, 0, 'Ãƒâ€“rebro', 1361),
(5460, 2, 0, 'LinkÃƒÂ¶ping', 1362),
(5461, 2, 0, 'NorrkÃƒÂ¶ping', 1362),
(5462, 2, 0, 'GÃƒÂ¤vle', 1363),
(5463, 2, 0, 'JÃƒÂ¶nkÃƒÂ¶ping', 1364),
(5464, 2, 0, 'Lisboa', 1365),
(5465, 2, 0, 'Amadora', 1365),
(5466, 2, 0, 'Stockholm', 1365),
(5467, 2, 0, 'MalmÃƒÂ¶', 1366),
(5468, 2, 0, 'Helsingborg', 1366),
(5469, 2, 0, 'Lund', 1366),
(5470, 2, 0, 'Uppsala', 1367),
(5471, 2, 0, 'UmeÃƒÂ¥', 1368),
(5472, 2, 0, 'Sundsvall', 1369),
(5473, 2, 0, 'VÃƒÂ¤sterÃƒÂ¥s', 1370),
(5474, 2, 0, 'Gothenburg [GÃƒÂ¶teborg]', 1371),
(5475, 2, 0, 'BorÃƒÂ¥s', 1371),
(5476, 2, 0, 'Mbabane', 1372),
(5477, 2, 0, 'Victoria', 1373),
(5478, 2, 0, 'Al-Qamishliya', 1374),
(5479, 2, 0, 'Al-Raqqa', 1375),
(5480, 2, 0, 'Aleppo', 1376),
(5481, 2, 0, 'Damascus', 1377),
(5482, 2, 0, 'Jaramana', 1378),
(5483, 2, 0, 'Duma', 1378),
(5484, 2, 0, 'Dayr Al-Zawr', 1379),
(5485, 2, 0, 'Hama', 1380),
(5486, 2, 0, 'Hims', 1381),
(5487, 2, 0, 'Idlib', 1382),
(5488, 2, 0, 'Latakia', 1383),
(5489, 2, 0, 'Cockburn Town', 1384),
(5490, 2, 0, 'NÃ‚Â´DjamÃƒÂ©na', 1385),
(5491, 2, 0, 'Moundou', 1386),
(5492, 2, 0, 'LomÃƒÂ©', 1387),
(5493, 2, 0, 'Bangkok', 1388),
(5494, 2, 0, 'Chiang Mai', 1389),
(5495, 2, 0, 'Khon Kaen', 1390),
(5496, 2, 0, 'Nakhon Pathom', 1391),
(5497, 2, 0, 'Nakhon Ratchasima', 1392),
(5498, 2, 0, 'Nakhon Sawan', 1393),
(5499, 2, 0, 'Nonthaburi', 1394),
(5500, 2, 0, 'Pak Kret', 1394),
(5501, 2, 0, 'Hat Yai', 1395),
(5502, 2, 0, 'Songkhla', 1395),
(5503, 2, 0, 'Ubon Ratchathani', 1396),
(5504, 2, 0, 'Udon Thani', 1397),
(5505, 2, 0, 'Dushanbe', 1398),
(5506, 2, 0, 'Khujand', 1399),
(5507, 2, 0, 'Fakaofo', 1400),
(5508, 2, 0, 'Ashgabat', 1401),
(5509, 2, 0, 'Dashhowuz', 1402),
(5510, 2, 0, 'ChÃƒÂ¤rjew', 1403),
(5511, 2, 0, 'Mary', 1404),
(5512, 2, 0, 'Dili', 1405),
(5513, 2, 0, 'NukuÃ‚Â´alofa', 1406),
(5514, 2, 0, 'Chaguanas', 1407),
(5515, 2, 0, 'Port-of-Spain', 1408),
(5516, 2, 0, 'Ariana', 1409),
(5517, 2, 0, 'Ettadhamen', 1409),
(5518, 2, 0, 'Biserta', 1410),
(5519, 2, 0, 'GabÃƒÂ¨s', 1411),
(5520, 2, 0, 'Kairouan', 1412),
(5521, 2, 0, 'Sfax', 1413),
(5522, 2, 0, 'Sousse', 1414),
(5523, 2, 0, 'Tunis', 1415),
(5524, 2, 0, 'Adana', 1416),
(5525, 2, 0, 'Tarsus', 1416),
(5526, 2, 0, 'Ceyhan', 1416),
(5527, 2, 0, 'Adiyaman', 1417),
(5528, 2, 0, 'Afyon', 1418),
(5529, 2, 0, 'Aksaray', 1419),
(5530, 2, 0, 'Ankara', 1420),
(5531, 2, 0, 'Antalya', 1421),
(5532, 2, 0, 'Alanya', 1421),
(5533, 2, 0, 'Aydin', 1422),
(5534, 2, 0, 'Nazilli', 1422),
(5535, 2, 0, 'Ãƒâ€¡orum', 1423),
(5536, 2, 0, 'Balikesir', 1424),
(5537, 2, 0, 'Bandirma', 1424),
(5538, 2, 0, 'Batman', 1425),
(5539, 2, 0, 'Bursa', 1426),
(5540, 2, 0, 'InegÃƒÂ¶l', 1426),
(5541, 2, 0, 'Denizli', 1427),
(5542, 2, 0, 'Diyarbakir', 1428),
(5543, 2, 0, 'Bismil', 1428),
(5544, 2, 0, 'Edirne', 1429),
(5545, 2, 0, 'ElÃƒÂ¢zig', 1430),
(5546, 2, 0, 'Erzincan', 1431),
(5547, 2, 0, 'Erzurum', 1432),
(5548, 2, 0, 'Eskisehir', 1433),
(5549, 2, 0, 'Gaziantep', 1434),
(5550, 2, 0, 'Iskenderun', 1435),
(5551, 2, 0, 'Hatay (Antakya)', 1435),
(5552, 2, 0, 'Mersin (IÃƒÂ§el)', 1436),
(5553, 2, 0, 'Isparta', 1437),
(5554, 2, 0, 'Istanbul', 1438),
(5555, 2, 0, 'Sultanbeyli', 1438),
(5556, 2, 0, 'Izmir', 1439),
(5557, 2, 0, 'Kahramanmaras', 1440),
(5558, 2, 0, 'KarabÃƒÂ¼k', 1441),
(5559, 2, 0, 'Karaman', 1442),
(5560, 2, 0, 'Kars', 1443),
(5561, 2, 0, 'Kayseri', 1444),
(5562, 2, 0, 'KÃƒÂ¼tahya', 1445),
(5563, 2, 0, 'Kilis', 1446),
(5564, 2, 0, 'Kirikkale', 1447),
(5565, 2, 0, 'Gebze', 1448),
(5566, 2, 0, 'Izmit (Kocaeli)', 1448),
(5567, 2, 0, 'Konya', 1449),
(5568, 2, 0, 'Malatya', 1450),
(5569, 2, 0, 'Manisa', 1451),
(5570, 2, 0, 'Kiziltepe', 1452),
(5571, 2, 0, 'Ordu', 1453),
(5572, 2, 0, 'Osmaniye', 1454),
(5573, 2, 0, 'Sakarya (Adapazari)', 1455),
(5574, 2, 0, 'Samsun', 1456),
(5575, 2, 0, 'Sanliurfa', 1457),
(5576, 2, 0, 'Viransehir', 1457),
(5577, 2, 0, 'Siirt', 1458),
(5578, 2, 0, 'Sivas', 1459),
(5579, 2, 0, 'Ãƒâ€¡orlu', 1460),
(5580, 2, 0, 'Tekirdag', 1460),
(5581, 2, 0, 'Tokat', 1461),
(5582, 2, 0, 'Trabzon', 1462),
(5583, 2, 0, 'Usak', 1463),
(5584, 2, 0, 'Van', 1464),
(5585, 2, 0, 'Zonguldak', 1465),
(5586, 2, 0, 'Funafuti', 1466),
(5587, 2, 0, 'Taiping', 1467),
(5588, 2, 0, 'Taliao', 1467),
(5589, 2, 0, 'Kueishan', 1467),
(5590, 2, 0, 'Ciudad Losada', 1467),
(5591, 2, 0, 'Changhwa', 1468),
(5592, 2, 0, 'Yuanlin', 1468),
(5593, 2, 0, 'Chiayi', 1469),
(5594, 2, 0, 'Hsinchu', 1470),
(5595, 2, 0, 'Hualien', 1471),
(5596, 2, 0, 'Ilan', 1472),
(5597, 2, 0, 'Kaohsiung', 1473),
(5598, 2, 0, 'Fengshan', 1473),
(5599, 2, 0, 'Kangshan', 1473),
(5600, 2, 0, 'Keelung (Chilung)', 1474),
(5601, 2, 0, 'Miaoli', 1475),
(5602, 2, 0, 'Nantou', 1476),
(5603, 2, 0, 'Tsaotun', 1476),
(5604, 2, 0, 'Pingtung', 1477),
(5605, 2, 0, 'Taichung', 1478),
(5606, 2, 0, 'Tali', 1478),
(5607, 2, 0, 'Fengyuan', 1478),
(5608, 2, 0, 'Tainan', 1479),
(5609, 2, 0, 'Yungkang', 1479),
(5610, 2, 0, 'Taipei', 1480),
(5611, 2, 0, 'Panchiao', 1480),
(5612, 2, 0, 'Chungho', 1480),
(5613, 2, 0, 'Sanchung', 1480),
(5614, 2, 0, 'Hsinchuang', 1480),
(5615, 2, 0, 'Hsintien', 1480),
(5616, 2, 0, 'Yungho', 1480),
(5617, 2, 0, 'Tucheng', 1480),
(5618, 2, 0, 'Luchou', 1480),
(5619, 2, 0, 'Hsichuh', 1480),
(5620, 2, 0, 'Shulin', 1480),
(5621, 2, 0, 'Tanshui', 1480),
(5622, 2, 0, 'Lungtan', 1480),
(5623, 2, 0, 'Taitung', 1481),
(5624, 2, 0, 'Chungli', 1482),
(5625, 2, 0, 'Taoyuan', 1482),
(5626, 2, 0, 'Pingchen', 1482),
(5627, 2, 0, 'Pate', 1482),
(5628, 2, 0, 'Yangmei', 1482),
(5629, 2, 0, 'Touliu', 1483),
(5630, 2, 0, 'Arusha', 1484),
(5631, 2, 0, 'Dar Es Salaam', 1485),
(5632, 2, 0, 'Dodoma', 1486),
(5633, 2, 0, 'Moshi', 1487),
(5634, 2, 0, 'Mbeya', 1488),
(5635, 2, 0, 'Morogoro', 1489),
(5636, 2, 0, 'Mwanza', 1490),
(5637, 2, 0, 'Tabora', 1491),
(5638, 2, 0, 'Tanga', 1492),
(5639, 2, 0, 'Zanzibar', 1493),
(5640, 2, 0, 'Suva', 1494),
(5641, 2, 0, 'Nyeri', 1494),
(5642, 2, 0, 'Kathmandu', 1494),
(5643, 2, 0, 'Lalitapur', 1494),
(5644, 2, 0, 'Birgunj', 1494),
(5645, 2, 0, 'San Lorenzo', 1494),
(5646, 2, 0, 'LambarÃƒÂ©', 1494),
(5647, 2, 0, 'Fernando De La Mora', 1494),
(5648, 2, 0, 'Kabwe', 1494),
(5649, 2, 0, 'Kandy', 1494),
(5650, 2, 0, 'Kampala', 1494),
(5651, 2, 0, 'Dnipropetrovsk', 1495),
(5652, 2, 0, 'Kryvyi Rig', 1495),
(5653, 2, 0, 'Dniprodzerzynsk', 1495),
(5654, 2, 0, 'Nikopol', 1495),
(5655, 2, 0, 'Pavlograd', 1495),
(5656, 2, 0, 'Donetsk', 1496),
(5657, 2, 0, 'Mariupol', 1496),
(5658, 2, 0, 'Makijivka', 1496),
(5659, 2, 0, 'Gorlivka', 1496),
(5660, 2, 0, 'Kramatorsk', 1496),
(5661, 2, 0, 'Slovjansk', 1496),
(5662, 2, 0, 'Jenakijeve', 1496),
(5663, 2, 0, 'Kostjantynivka', 1496),
(5664, 2, 0, 'Harkova [Harkiv]', 1497),
(5665, 2, 0, 'Herson', 1498),
(5666, 2, 0, 'Hmelnytskyi', 1499),
(5667, 2, 0, 'Kamjanets-Podilskyi', 1499),
(5668, 2, 0, 'Ivano-Frankivsk', 1500),
(5669, 2, 0, 'Kyiv', 1501),
(5670, 2, 0, 'Bila Tserkva', 1501),
(5671, 2, 0, 'Brovary', 1501),
(5672, 2, 0, 'Kirovograd', 1502),
(5673, 2, 0, 'Oleksandrija', 1502),
(5674, 2, 0, 'Sevastopol', 1503),
(5675, 2, 0, 'Simferopol', 1503),
(5676, 2, 0, 'KertÃ…Â¡', 1503),
(5677, 2, 0, 'Jevpatorija', 1503),
(5678, 2, 0, 'Lugansk', 1504),
(5679, 2, 0, 'Sjeverodonetsk', 1504),
(5680, 2, 0, 'AltÃ…Â¡evsk', 1504),
(5681, 2, 0, 'LysytÃ…Â¡ansk', 1504),
(5682, 2, 0, 'Krasnyi LutÃ…Â¡', 1504),
(5683, 2, 0, 'Stahanov', 1504),
(5684, 2, 0, 'Lviv', 1505),
(5685, 2, 0, 'Mykolajiv', 1506),
(5686, 2, 0, 'Odesa', 1507),
(5687, 2, 0, 'Izmajil', 1507),
(5688, 2, 0, 'Pultava [Poltava]', 1508),
(5689, 2, 0, 'KrementÃ…Â¡uk', 1508),
(5690, 2, 0, 'Rivne', 1509),
(5691, 2, 0, 'Sumy', 1510),
(5692, 2, 0, 'Konotop', 1510),
(5693, 2, 0, 'Ã…Â ostka', 1510),
(5694, 2, 0, 'Uzgorod', 1511),
(5695, 2, 0, 'MukatÃ…Â¡eve', 1511),
(5696, 2, 0, 'Ternopil', 1512),
(5697, 2, 0, 'TÃ…Â¡erkasy', 1513),
(5698, 2, 0, 'Uman', 1513),
(5699, 2, 0, 'TÃ…Â¡ernigiv', 1514),
(5700, 2, 0, 'TÃ…Â¡ernivtsi', 1515),
(5701, 2, 0, 'Vinnytsja', 1516),
(5702, 2, 0, 'Lutsk', 1517),
(5703, 2, 0, 'Zaporizzja', 1518),
(5704, 2, 0, 'Melitopol', 1518),
(5705, 2, 0, 'Berdjansk', 1518),
(5706, 2, 0, 'Zytomyr', 1519),
(5707, 2, 0, 'BerdytÃ…Â¡iv', 1519),
(5708, 2, 0, 'Montevideo', 1520),
(5709, 2, 0, 'Birmingham', 1521),
(5710, 2, 0, 'Montgomery', 1521),
(5711, 2, 0, 'Mobile', 1521),
(5712, 2, 0, 'Huntsville', 1521),
(5713, 2, 0, 'Anchorage', 1522),
(5714, 2, 0, 'Phoenix', 1523),
(5715, 2, 0, 'Tucson', 1523),
(5716, 2, 0, 'Mesa', 1523),
(5717, 2, 0, 'Glendale', 1523),
(5718, 2, 0, 'Scottsdale', 1523),
(5719, 2, 0, 'Chandler', 1523),
(5720, 2, 0, 'Tempe', 1523),
(5721, 2, 0, 'Gilbert', 1523),
(5722, 2, 0, 'Peoria', 1523),
(5723, 2, 0, 'Little Rock', 1524),
(5724, 2, 0, 'Los Angeles', 1525),
(5725, 2, 0, 'San Diego', 1525),
(5726, 2, 0, 'San Jose', 1525),
(5727, 2, 0, 'San Francisco', 1525),
(5728, 2, 0, 'Long Beach', 1525),
(5729, 2, 0, 'Fresno', 1525),
(5730, 2, 0, 'Sacramento', 1525),
(5731, 2, 0, 'Oakland', 1525),
(5732, 2, 0, 'Santa Ana', 1525),
(5733, 2, 0, 'Anaheim', 1525),
(5734, 2, 0, 'Riverside', 1525),
(5735, 2, 0, 'Bakersfield', 1525),
(5736, 2, 0, 'Stockton', 1525),
(5737, 2, 0, 'Fremont', 1525),
(5738, 2, 0, 'Glendale', 1525),
(5739, 2, 0, 'Huntington Beach', 1525),
(5740, 2, 0, 'Modesto', 1525),
(5741, 2, 0, 'San Bernardino', 1525),
(5742, 2, 0, 'Chula Vista', 1525),
(5743, 2, 0, 'Oxnard', 1525),
(5744, 2, 0, 'Garden Grove', 1525),
(5745, 2, 0, 'Oceanside', 1525),
(5746, 2, 0, 'Ontario', 1525),
(5747, 2, 0, 'Santa Clarita', 1525),
(5748, 2, 0, 'Salinas', 1525),
(5749, 2, 0, 'Pomona', 1525),
(5750, 2, 0, 'Santa Rosa', 1525),
(5751, 2, 0, 'Irvine', 1525),
(5752, 2, 0, 'Moreno Valley', 1525),
(5753, 2, 0, 'Pasadena', 1525),
(5754, 2, 0, 'Hayward', 1525),
(5755, 2, 0, 'Torrance', 1525),
(5756, 2, 0, 'Escondido', 1525),
(5757, 2, 0, 'Sunnyvale', 1525),
(5758, 2, 0, 'Fontana', 1525),
(5759, 2, 0, 'Orange', 1525),
(5760, 2, 0, 'Rancho Cucamonga', 1525),
(5761, 2, 0, 'East Los Angeles', 1525),
(5762, 2, 0, 'Fullerton', 1525),
(5763, 2, 0, 'Corona', 1525),
(5764, 2, 0, 'Concord', 1525),
(5765, 2, 0, 'Lancaster', 1525),
(5766, 2, 0, 'Thousand Oaks', 1525),
(5767, 2, 0, 'Vallejo', 1525),
(5768, 2, 0, 'Palmdale', 1525),
(5769, 2, 0, 'El Monte', 1525),
(5770, 2, 0, 'Inglewood', 1525),
(5771, 2, 0, 'Simi Valley', 1525),
(5772, 2, 0, 'Costa Mesa', 1525),
(5773, 2, 0, 'Downey', 1525),
(5774, 2, 0, 'West Covina', 1525),
(5775, 2, 0, 'Daly City', 1525),
(5776, 2, 0, 'Citrus Heights', 1525),
(5777, 2, 0, 'Norwalk', 1525),
(5778, 2, 0, 'Berkeley', 1525),
(5779, 2, 0, 'Santa Clara', 1525),
(5780, 2, 0, 'San Buenaventura', 1525),
(5781, 2, 0, 'Burbank', 1525),
(5782, 2, 0, 'Mission Viejo', 1525),
(5783, 2, 0, 'El Cajon', 1525),
(5784, 2, 0, 'Richmond', 1525),
(5785, 2, 0, 'Compton', 1525),
(5786, 2, 0, 'Fairfield', 1525),
(5787, 2, 0, 'Arden-Arcade', 1525),
(5788, 2, 0, 'San Mateo', 1525),
(5789, 2, 0, 'Visalia', 1525),
(5790, 2, 0, 'Santa Monica', 1525),
(5791, 2, 0, 'Carson', 1525),
(5792, 2, 0, 'Denver', 1526),
(5793, 2, 0, 'Colorado Springs', 1526),
(5794, 2, 0, 'Aurora', 1526),
(5795, 2, 0, 'Lakewood', 1526),
(5796, 2, 0, 'Fort Collins', 1526),
(5797, 2, 0, 'Arvada', 1526),
(5798, 2, 0, 'Pueblo', 1526),
(5799, 2, 0, 'Westminster', 1526),
(5800, 2, 0, 'Boulder', 1526),
(5801, 2, 0, 'Bridgeport', 1527),
(5802, 2, 0, 'New Haven', 1527),
(5803, 2, 0, 'Hartford', 1527),
(5804, 2, 0, 'Stamford', 1527),
(5805, 2, 0, 'Waterbury', 1527),
(5806, 2, 0, 'Washington', 1528),
(5807, 2, 0, 'Jacksonville', 1529),
(5808, 2, 0, 'Miami', 1529),
(5809, 2, 0, 'Tampa', 1529),
(5810, 2, 0, 'Saint Petersburg', 1529),
(5811, 2, 0, 'Hialeah', 1529),
(5812, 2, 0, 'Orlando', 1529),
(5813, 2, 0, 'Fort Lauderdale', 1529),
(5814, 2, 0, 'Tallahassee', 1529),
(5815, 2, 0, 'Hollywood', 1529),
(5816, 2, 0, 'Pembroke Pines', 1529),
(5817, 2, 0, 'Coral Springs', 1529),
(5818, 2, 0, 'Cape Coral', 1529),
(5819, 2, 0, 'Clearwater', 1529),
(5820, 2, 0, 'Miami Beach', 1529),
(5821, 2, 0, 'Gainesville', 1529),
(5822, 2, 0, 'Atlanta', 1530),
(5823, 2, 0, 'Augusta-Richmond County', 1530),
(5824, 2, 0, 'Columbus', 1530),
(5825, 2, 0, 'Savannah', 1530),
(5826, 2, 0, 'Macon', 1530),
(5827, 2, 0, 'Athens-Clarke County', 1530),
(5828, 2, 0, 'Honolulu', 1531),
(5829, 2, 0, 'Boise City', 1532),
(5830, 2, 0, 'Chicago', 1533),
(5831, 2, 0, 'Rockford', 1533),
(5832, 2, 0, 'Aurora', 1533),
(5833, 2, 0, 'Naperville', 1533),
(5834, 2, 0, 'Peoria', 1533),
(5835, 2, 0, 'Springfield', 1533),
(5836, 2, 0, 'Joliet', 1533),
(5837, 2, 0, 'Elgin', 1533),
(5838, 2, 0, 'Indianapolis', 1534),
(5839, 2, 0, 'Fort Wayne', 1534),
(5840, 2, 0, 'Evansville', 1534),
(5841, 2, 0, 'South Bend', 1534),
(5842, 2, 0, 'Gary', 1534),
(5843, 2, 0, 'Des Moines', 1535),
(5844, 2, 0, 'Cedar Rapids', 1535),
(5845, 2, 0, 'Davenport', 1535),
(5846, 2, 0, 'Wichita', 1536),
(5847, 2, 0, 'Overland Park', 1536),
(5848, 2, 0, 'Kansas City', 1536),
(5849, 2, 0, 'Topeka', 1536),
(5850, 2, 0, 'Lexington-Fayette', 1537),
(5851, 2, 0, 'Louisville', 1537),
(5852, 2, 0, 'New Orleans', 1538),
(5853, 2, 0, 'Baton Rouge', 1538),
(5854, 2, 0, 'Shreveport', 1538),
(5855, 2, 0, 'Metairie', 1538),
(5856, 2, 0, 'Lafayette', 1538),
(5857, 2, 0, 'Baltimore', 1539),
(5858, 2, 0, 'Boston', 1540),
(5859, 2, 0, 'Worcester', 1540),
(5860, 2, 0, 'Springfield', 1540),
(5861, 2, 0, 'Lowell', 1540),
(5862, 2, 0, 'Cambridge', 1540),
(5863, 2, 0, 'New Bedford', 1540),
(5864, 2, 0, 'Brockton', 1540),
(5865, 2, 0, 'Fall River', 1540),
(5866, 2, 0, 'Detroit', 1541),
(5867, 2, 0, 'Grand Rapids', 1541),
(5868, 2, 0, 'Warren', 1541),
(5869, 2, 0, 'Flint', 1541),
(5870, 2, 0, 'Sterling Heights', 1541),
(5871, 2, 0, 'Lansing', 1541),
(5872, 2, 0, 'Ann Arbor', 1541),
(5873, 2, 0, 'Livonia', 1541),
(5874, 2, 0, 'Minneapolis', 1542),
(5875, 2, 0, 'Saint Paul', 1542),
(5876, 2, 0, 'Jackson', 1543),
(5877, 2, 0, 'Kansas City', 1544),
(5878, 2, 0, 'Saint Louis', 1544),
(5879, 2, 0, 'Springfield', 1544),
(5880, 2, 0, 'Independence', 1544),
(5881, 2, 0, 'Billings', 1545),
(5882, 2, 0, 'Omaha', 1546),
(5883, 2, 0, 'Lincoln', 1546),
(5884, 2, 0, 'Las Vegas', 1547),
(5885, 2, 0, 'Reno', 1547),
(5886, 2, 0, 'Henderson', 1547),
(5887, 2, 0, 'Paradise', 1547),
(5888, 2, 0, 'North Las Vegas', 1547),
(5889, 2, 0, 'Sunrise Manor', 1547),
(5890, 2, 0, 'Manchester', 1548),
(5891, 2, 0, 'Newark', 1549),
(5892, 2, 0, 'Jersey City', 1549),
(5893, 2, 0, 'Paterson', 1549),
(5894, 2, 0, 'Elizabeth', 1549),
(5895, 2, 0, 'Albuquerque', 1550),
(5896, 2, 0, 'New York', 1551),
(5897, 2, 0, 'Buffalo', 1551),
(5898, 2, 0, 'Rochester', 1551),
(5899, 2, 0, 'Yonkers', 1551),
(5900, 2, 0, 'Syracuse', 1551),
(5901, 2, 0, 'Albany', 1551),
(5902, 2, 0, 'Charlotte', 1552),
(5903, 2, 0, 'Raleigh', 1552),
(5904, 2, 0, 'Greensboro', 1552),
(5905, 2, 0, 'Durham', 1552),
(5906, 2, 0, 'Winston-Salem', 1552),
(5907, 2, 0, 'Fayetteville', 1552),
(5908, 2, 0, 'Cary', 1552),
(5909, 2, 0, 'Columbus', 1553),
(5910, 2, 0, 'Cleveland', 1553),
(5911, 2, 0, 'Cincinnati', 1553),
(5912, 2, 0, 'Toledo', 1553),
(5913, 2, 0, 'Akron', 1553),
(5914, 2, 0, 'Dayton', 1553),
(5915, 2, 0, 'Oklahoma City', 1554),
(5916, 2, 0, 'Tulsa', 1554),
(5917, 2, 0, 'Norman', 1554),
(5918, 2, 0, 'Portland', 1555),
(5919, 2, 0, 'Eugene', 1555),
(5920, 2, 0, 'Salem', 1555),
(5921, 2, 0, 'Philadelphia', 1556),
(5922, 2, 0, 'Pittsburgh', 1556),
(5923, 2, 0, 'Allentown', 1556),
(5924, 2, 0, 'Erie', 1556),
(5925, 2, 0, 'Providence', 1557),
(5926, 2, 0, 'Columbia', 1558),
(5927, 2, 0, 'Charleston', 1558),
(5928, 2, 0, 'Sioux Falls', 1559),
(5929, 2, 0, 'Memphis', 1560),
(5930, 2, 0, 'Nashville-Davidson', 1560),
(5931, 2, 0, 'Knoxville', 1560),
(5932, 2, 0, 'Chattanooga', 1560),
(5933, 2, 0, 'Clarksville', 1560),
(5934, 2, 0, 'Houston', 1561),
(5935, 2, 0, 'Dallas', 1561),
(5936, 2, 0, 'San Antonio', 1561),
(5937, 2, 0, 'Austin', 1561),
(5938, 2, 0, 'El Paso', 1561),
(5939, 2, 0, 'Fort Worth', 1561),
(5940, 2, 0, 'Arlington', 1561),
(5941, 2, 0, 'Corpus Christi', 1561),
(5942, 2, 0, 'Plano', 1561),
(5943, 2, 0, 'Garland', 1561),
(5944, 2, 0, 'Lubbock', 1561),
(5945, 2, 0, 'Irving', 1561),
(5946, 2, 0, 'Laredo', 1561),
(5947, 2, 0, 'Amarillo', 1561),
(5948, 2, 0, 'Brownsville', 1561),
(5949, 2, 0, 'Pasadena', 1561),
(5950, 2, 0, 'Grand Prairie', 1561),
(5951, 2, 0, 'Mesquite', 1561),
(5952, 2, 0, 'Abilene', 1561),
(5953, 2, 0, 'Beaumont', 1561),
(5954, 2, 0, 'Waco', 1561),
(5955, 2, 0, 'Carrollton', 1561),
(5956, 2, 0, 'McAllen', 1561),
(5957, 2, 0, 'Wichita Falls', 1561),
(5958, 2, 0, 'Midland', 1561),
(5959, 2, 0, 'Odessa', 1561),
(5960, 2, 0, 'Salt Lake City', 1562),
(5961, 2, 0, 'West Valley City', 1562),
(5962, 2, 0, 'Provo', 1562),
(5963, 2, 0, 'Sandy', 1562),
(5964, 2, 0, 'Virginia Beach', 1563),
(5965, 2, 0, 'Norfolk', 1563),
(5966, 2, 0, 'Chesapeake', 1563),
(5967, 2, 0, 'Richmond', 1563),
(5968, 2, 0, 'Newport News', 1563),
(5969, 2, 0, 'Arlington', 1563),
(5970, 2, 0, 'Hampton', 1563),
(5971, 2, 0, 'Alexandria', 1563),
(5972, 2, 0, 'Portsmouth', 1563),
(5973, 2, 0, 'Roanoke', 1563),
(5974, 2, 0, 'Seattle', 1564),
(5975, 2, 0, 'Spokane', 1564),
(5976, 2, 0, 'Tacoma', 1564),
(5977, 2, 0, 'Vancouver', 1564),
(5978, 2, 0, 'Bellevue', 1564),
(5979, 2, 0, 'Milwaukee', 1565),
(5980, 2, 0, 'Madison', 1565),
(5981, 2, 0, 'Green Bay', 1565),
(5982, 2, 0, 'Kenosha', 1565),
(5983, 2, 0, 'Andijon', 1566),
(5984, 2, 0, 'Buhoro', 1567),
(5985, 2, 0, 'Cizah', 1568),
(5986, 2, 0, 'KÃƒÂ¼kon', 1569),
(5987, 2, 0, 'Fargona', 1569),
(5988, 2, 0, 'Margilon', 1569),
(5989, 2, 0, 'Nukus', 1570),
(5990, 2, 0, 'ÃƒÅ“rgenc', 1571),
(5991, 2, 0, 'Namangan', 1572),
(5992, 2, 0, 'Navoi', 1573),
(5993, 2, 0, 'Karsi', 1574),
(5994, 2, 0, 'Samarkand', 1575),
(5995, 2, 0, 'Termiz', 1576),
(5996, 2, 0, 'Circik', 1577),
(5997, 2, 0, 'Angren', 1577),
(5998, 2, 0, 'Olmalik', 1577),
(5999, 2, 0, 'Toskent', 1578),
(6000, 2, 0, 'South Hill', 1579),
(6001, 2, 0, 'The Valley', 1579),
(6002, 2, 0, 'Oranjestad', 1579),
(6003, 2, 0, 'Douglas', 1579),
(6004, 2, 0, 'Gibraltar', 1579),
(6005, 2, 0, 'Tamuning', 1579),
(6006, 2, 0, 'AgaÃƒÂ±a', 1579),
(6007, 2, 0, 'Flying Fish Cove', 1579),
(6008, 2, 0, 'Monte-Carlo', 1579),
(6009, 2, 0, 'Monaco-Ville', 1579),
(6010, 2, 0, 'Yangor', 1579),
(6011, 2, 0, 'Yaren', 1579),
(6012, 2, 0, 'Alofi', 1579),
(6013, 2, 0, 'Kingston', 1579),
(6014, 2, 0, 'Adamstown', 1579),
(6015, 2, 0, 'Singapore', 1579),
(6016, 2, 0, 'NoumÃƒÂ©a', 1579),
(6017, 2, 0, 'CittÃƒÂ  Del Vaticano', 1579),
(6018, 2, 0, 'Roseau', 1580),
(6019, 2, 0, 'Saint GeorgeÃ‚Â´s', 1580),
(6020, 2, 0, 'Kingstown', 1580),
(6021, 2, 0, 'Taiping', 1581),
(6022, 2, 0, 'Taliao', 1581),
(6023, 2, 0, 'Kueishan', 1581),
(6024, 2, 0, 'Ciudad Losada', 1581),
(6025, 2, 0, 'Barcelona', 1582),
(6026, 2, 0, 'Puerto La Cruz', 1582),
(6027, 2, 0, 'El Tigre', 1582),
(6028, 2, 0, 'Pozuelos', 1582),
(6029, 2, 0, 'San Fernando De Apure', 1583),
(6030, 2, 0, 'Maracay', 1584),
(6031, 2, 0, 'Turmero', 1584),
(6032, 2, 0, 'El LimÃƒÂ³n', 1584),
(6033, 2, 0, 'Barinas', 1585),
(6034, 2, 0, 'Cartagena', 1586),
(6035, 2, 0, 'Ciudad Guayana', 1586),
(6036, 2, 0, 'Ciudad BolÃƒÂ­var', 1586),
(6037, 2, 0, 'Valencia', 1587),
(6038, 2, 0, 'Puerto Cabello', 1587),
(6039, 2, 0, 'Guacara', 1587),
(6040, 2, 0, 'Buenos Aires', 1588),
(6041, 2, 0, 'BrasÃƒÂ­lia', 1588),
(6042, 2, 0, 'Ciudad De MÃƒÂ©xico', 1588),
(6043, 2, 0, 'Caracas', 1588),
(6044, 2, 0, 'Catia La Mar', 1588),
(6045, 2, 0, 'Santa Ana De Coro', 1589),
(6046, 2, 0, 'Punto Fijo', 1589),
(6047, 2, 0, 'Calabozo', 1590),
(6048, 2, 0, 'Valle De La Pascua', 1590),
(6049, 2, 0, 'Barquisimeto', 1591),
(6050, 2, 0, 'MÃƒÂ©rida', 1592),
(6051, 2, 0, 'Petare', 1593),
(6052, 2, 0, 'Baruta', 1593),
(6053, 2, 0, 'Los Teques', 1593),
(6054, 2, 0, 'Guarenas', 1593),
(6055, 2, 0, 'Guatire', 1593),
(6056, 2, 0, 'Ocumare Del Tuy', 1593),
(6057, 2, 0, 'MaturÃƒÂ­n', 1594),
(6058, 2, 0, 'Acarigua', 1595),
(6059, 2, 0, 'Guanare', 1595),
(6060, 2, 0, 'Araure', 1595),
(6061, 2, 0, 'Sincelejo', 1596),
(6062, 2, 0, 'CumanÃƒÂ¡', 1596),
(6063, 2, 0, 'CarÃƒÂºpano', 1596),
(6064, 2, 0, 'San CristÃƒÂ³bal', 1597),
(6065, 2, 0, 'Valera', 1598),
(6066, 2, 0, 'San Felipe', 1599),
(6067, 2, 0, 'MaracaÃƒÂ­bo', 1600),
(6068, 2, 0, 'Cabimas', 1600),
(6069, 2, 0, 'Ciudad Ojeda', 1600),
(6070, 2, 0, 'Road Town', 1601),
(6071, 2, 0, 'Charlotte Amalie', 1602),
(6072, 2, 0, 'Long Xuyen', 1603),
(6073, 2, 0, 'Vung Tau', 1604),
(6074, 2, 0, 'Thai Nguyen', 1605),
(6075, 2, 0, 'Quy Nhon', 1606),
(6076, 2, 0, 'Phan ThiÃƒÂªt', 1607),
(6077, 2, 0, 'Can Tho', 1608),
(6078, 2, 0, 'Buon Ma Thuot', 1609),
(6079, 2, 0, 'BiÃƒÂªn Hoa', 1610),
(6080, 2, 0, 'Haiphong', 1611),
(6081, 2, 0, 'Hanoi', 1612),
(6082, 2, 0, 'Ho Chi Minh City', 1613),
(6083, 2, 0, 'Nha Trang', 1614),
(6084, 2, 0, 'Cam Ranh', 1614),
(6085, 2, 0, 'Rach Gia', 1615),
(6086, 2, 0, 'Da Lat', 1616),
(6087, 2, 0, 'Nam Dinh', 1617),
(6088, 2, 0, 'Vinh', 1618),
(6089, 2, 0, 'Cam Pha', 1619),
(6090, 2, 0, 'Da Nang', 1620),
(6091, 2, 0, 'Hong Gai', 1621),
(6092, 2, 0, 'Hue', 1622),
(6093, 2, 0, 'My Tho', 1623),
(6094, 2, 0, 'Port-Vila', 1624),
(6095, 2, 0, 'Mata-Utu', 1625),
(6096, 2, 0, 'Apia', 1626),
(6097, 2, 0, 'Aden', 1627),
(6098, 2, 0, 'Al-Mukalla', 1628),
(6099, 2, 0, 'Hodeida', 1629),
(6100, 2, 0, 'Ibb', 1630),
(6101, 2, 0, 'Sanaa', 1631),
(6102, 2, 0, 'Taizz', 1632),
(6103, 2, 0, 'Beograd', 1633),
(6104, 2, 0, 'NiÃ…Â¡', 1633),
(6105, 2, 0, 'Kragujevac', 1633),
(6106, 2, 0, 'PriÃ…Â¡tina', 1634),
(6107, 2, 0, 'Prizren', 1634),
(6108, 2, 0, 'Podgorica', 1635),
(6109, 2, 0, 'Novi Sad', 1636),
(6110, 2, 0, 'Subotica', 1636),
(6111, 2, 0, 'Port Elizabeth', 1637),
(6112, 2, 0, 'East London', 1637),
(6113, 2, 0, 'Uitenhage', 1637),
(6114, 2, 0, 'Mdantsane', 1637),
(6115, 2, 0, 'Bloemfontein', 1638),
(6116, 2, 0, 'Welkom', 1638),
(6117, 2, 0, 'Botshabelo', 1638),
(6118, 2, 0, 'Soweto', 1639),
(6119, 2, 0, 'Johannesburg', 1639),
(6120, 2, 0, 'Pretoria', 1639),
(6121, 2, 0, 'Vanderbijlpark', 1639),
(6122, 2, 0, 'Kempton Park', 1639),
(6123, 2, 0, 'Alberton', 1639),
(6124, 2, 0, 'Benoni', 1639),
(6125, 2, 0, 'Randburg', 1639),
(6126, 2, 0, 'Vereeniging', 1639),
(6127, 2, 0, 'Wonderboom', 1639),
(6128, 2, 0, 'Roodepoort', 1639),
(6129, 2, 0, 'Boksburg', 1639),
(6130, 2, 0, 'Soshanguve', 1639),
(6131, 2, 0, 'Krugersdorp', 1639),
(6132, 2, 0, 'Brakpan', 1639),
(6133, 2, 0, 'Oberholzer', 1639),
(6134, 2, 0, 'Germiston', 1639),
(6135, 2, 0, 'Springs', 1639),
(6136, 2, 0, 'Westonaria', 1639),
(6137, 2, 0, 'Randfontein', 1639),
(6138, 2, 0, 'Nigel', 1639),
(6139, 2, 0, 'Inanda', 1640),
(6140, 2, 0, 'Durban', 1640),
(6141, 2, 0, 'Pinetown', 1640),
(6142, 2, 0, 'Pietermaritzburg', 1640),
(6143, 2, 0, 'Umlazi', 1640),
(6144, 2, 0, 'Newcastle', 1640),
(6145, 2, 0, 'Chatsworth', 1640),
(6146, 2, 0, 'Ladysmith', 1640),
(6147, 2, 0, 'Witbank', 1641),
(6148, 2, 0, 'Klerksdorp', 1642),
(6149, 2, 0, 'Potchefstroom', 1642),
(6150, 2, 0, 'Rustenburg', 1642),
(6151, 2, 0, 'Kimberley', 1643),
(6152, 2, 0, 'Cape Town', 1644),
(6153, 2, 0, 'Paarl', 1644),
(6154, 2, 0, 'George', 1644),
(6155, 2, 0, 'Suva', 1645),
(6156, 2, 0, 'Nyeri', 1645),
(6157, 2, 0, 'Kathmandu', 1645),
(6158, 2, 0, 'Lalitapur', 1645),
(6159, 2, 0, 'Birgunj', 1645),
(6160, 2, 0, 'San Lorenzo', 1645),
(6161, 2, 0, 'LambarÃƒÂ©', 1645),
(6162, 2, 0, 'Fernando De La Mora', 1645),
(6163, 2, 0, 'Kabwe', 1645),
(6164, 2, 0, 'Kandy', 1645),
(6165, 2, 0, 'Kampala', 1645),
(6166, 2, 0, 'Ndola', 1646),
(6167, 2, 0, 'Kitwe', 1646),
(6168, 2, 0, 'Chingola', 1646),
(6169, 2, 0, 'Mufulira', 1646),
(6170, 2, 0, 'Luanshya', 1646),
(6171, 2, 0, 'Lusaka', 1647),
(6172, 2, 0, 'Bulawayo', 1648),
(6173, 2, 0, 'Harare', 1649),
(6174, 2, 0, 'Chitungwiza', 1649),
(6175, 2, 0, 'Mount Darwin', 1649),
(6176, 2, 0, 'Mutare', 1650),
(6177, 2, 0, 'Gweru', 1651);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_grade_system`
--

CREATE TABLE `tbl_grade_system` (
  `grade_system_id` bigint(20) NOT NULL,
  `grade_system_name` varchar(100) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_grade_system`
--

INSERT INTO `tbl_grade_system` (`grade_system_id`, `grade_system_name`, `institution_id`) VALUES
(1, 'Nine Point Scale', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_grade_system_detail`
--

CREATE TABLE `tbl_grade_system_detail` (
  `grade_system_detail_id` bigint(20) NOT NULL,
  `from_mark` double NOT NULL,
  `grade_point` double NOT NULL,
  `grade_title` varchar(10) NOT NULL,
  `to_marks` double NOT NULL,
  `grade_system_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_grade_system_detail`
--

INSERT INTO `tbl_grade_system_detail` (`grade_system_detail_id`, `from_mark`, `grade_point`, `grade_title`, `to_marks`, `grade_system_id`) VALUES
(1, 91, 10, 'S', 100, 1),
(2, 81, 9, 'A', 90, 1),
(3, 71, 8, 'B', 80, 1),
(4, 61, 7, 'C', 70, 1),
(5, 51, 6, 'D', 60, 1),
(6, 41, 5, 'E', 50, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_heared_us`
--

CREATE TABLE `tbl_heared_us` (
  `hearedus_id` bigint(20) NOT NULL,
  `hearedus_title` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_heared_us`
--

INSERT INTO `tbl_heared_us` (`hearedus_id`, `hearedus_title`) VALUES
(6, 'Family'),
(4, 'Friends'),
(3, 'News Paper'),
(5, 'Others'),
(2, 'Social Media'),
(1, 'Website');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_houses`
--

CREATE TABLE `tbl_houses` (
  `house_id` bigint(20) NOT NULL,
  `house_name` varchar(40) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_houses`
--

INSERT INTO `tbl_houses` (`house_id`, `house_name`, `institution_id`) VALUES
(1, 'Blue House', 1),
(4, 'Green House', 1),
(2, 'Red House', 1),
(3, 'Yellow House', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_institution`
--

CREATE TABLE `tbl_institution` (
  `institution_id` bigint(20) NOT NULL,
  `collect_receipt_in_order` tinyint(1) NOT NULL,
  `institution_currencyCode` varchar(3) NOT NULL,
  `institution_addressline1` varchar(255) NOT NULL,
  `institution_addressline2` varchar(255) NOT NULL,
  `institution_alias_name` varchar(100) NOT NULL,
  `institution_city` varchar(100) NOT NULL,
  `institution_contact` varchar(20) NOT NULL,
  `institution_country` varchar(100) NOT NULL,
  `institution_email` varchar(100) NOT NULL,
  `institution_logo` varchar(255) NOT NULL,
  `institution_name` varchar(255) NOT NULL,
  `institution_postcode` varchar(10) NOT NULL,
  `institution_state` varchar(100) NOT NULL,
  `institution_status` int(11) NOT NULL,
  `institution_authorized_signature` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_institution`
--

INSERT INTO `tbl_institution` (`institution_id`, `collect_receipt_in_order`, `institution_currencyCode`, `institution_addressline1`, `institution_addressline2`, `institution_alias_name`, `institution_city`, `institution_contact`, `institution_country`, `institution_email`, `institution_logo`, `institution_name`, `institution_postcode`, `institution_state`, `institution_status`, `institution_authorized_signature`) VALUES
(1, 1, 'INR', 'Line1', 'Line2', 'alias', 'Tiruchirapalli', '1234567890', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', 1, '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_institution_ledger_account`
--

CREATE TABLE `tbl_institution_ledger_account` (
  `ledger_account_id` bigint(20) NOT NULL,
  `ledger_account_name` varchar(100) NOT NULL,
  `ledger_reference_number` varchar(100) NOT NULL,
  `institution_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_institution_ledger_account`
--

INSERT INTO `tbl_institution_ledger_account` (`ledger_account_id`, `ledger_account_name`, `ledger_reference_number`, `institution_id`) VALUES
(1, 'School', 'SC344', 1),
(2, 'Management', 'MGMT23', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_inventory_category`
--

CREATE TABLE `tbl_inventory_category` (
  `inventory_category_id` bigint(20) NOT NULL,
  `inventory_category_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_inventory_category`
--

INSERT INTO `tbl_inventory_category` (`inventory_category_id`, `inventory_category_name`) VALUES
(2, 'Hardware'),
(3, 'Theoretical Management Models'),
(4, 'Audit Systems'),
(5, 'Software'),
(6, 'Vehicle'),
(7, 'Non-Academic Equipment');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_inventory_item_master`
--

CREATE TABLE `tbl_inventory_item_master` (
  `item_id` bigint(20) NOT NULL,
  `is_asset_category` tinyint(1) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `is_discount_Available` tinyint(1) NOT NULL,
  `is_Inventory_item` tinyint(1) DEFAULT NULL,
  `issue_created_date` datetime DEFAULT NULL,
  `issue_by` varchar(100) DEFAULT NULL,
  `issue_item_modified_by` varchar(100) DEFAULT NULL,
  `issue_item_modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `item_bar_code` varchar(255) NOT NULL,
  `item_bar_image` varchar(255) NOT NULL,
  `item_code` varchar(50) NOT NULL,
  `item_description` varchar(255) DEFAULT NULL,
  `item_issue_date` date DEFAULT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_return_date` date DEFAULT NULL,
  `location` varchar(255) NOT NULL,
  `min_reorder_level` int(11) DEFAULT NULL,
  `last_modified_by` varchar(100) NOT NULL,
  `last_modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `no_of_qty_issue` double DEFAULT NULL,
  `no_of_qty_return` double DEFAULT NULL,
  `price_per_unit` double DEFAULT NULL,
  `is_purchase_item` tinyint(1) DEFAULT NULL,
  `purchase_rate` double DEFAULT NULL,
  `is_Sales_item` tinyint(1) DEFAULT NULL,
  `sales_rate` double DEFAULT NULL,
  `total_qty_in_stock` double NOT NULL,
  `unit_of_measure` int(11) DEFAULT NULL,
  `in_charge_user_id` bigint(20) DEFAULT NULL,
  `inventory_category_id` bigint(20) NOT NULL,
  `inventory_type_id` bigint(20) NOT NULL,
  `issue_to_user_id` bigint(20) DEFAULT NULL,
  `tax_class_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_inventory_item_master`
--

INSERT INTO `tbl_inventory_item_master` (`item_id`, `is_asset_category`, `created_by`, `created_date`, `is_discount_Available`, `is_Inventory_item`, `issue_created_date`, `issue_by`, `issue_item_modified_by`, `issue_item_modified_date`, `item_bar_code`, `item_bar_image`, `item_code`, `item_description`, `item_issue_date`, `item_name`, `item_return_date`, `location`, `min_reorder_level`, `last_modified_by`, `last_modified_date`, `no_of_qty_issue`, `no_of_qty_return`, `price_per_unit`, `is_purchase_item`, `purchase_rate`, `is_Sales_item`, `sales_rate`, `total_qty_in_stock`, `unit_of_measure`, `in_charge_user_id`, `inventory_category_id`, `inventory_type_id`, `issue_to_user_id`, `tax_class_id`) VALUES
(1, 1, 'admin@jdsoft.in', '2017-05-19 18:07:42', 1, 1, NULL, NULL, NULL, '2017-05-19 12:37:43', 'ITEM1495197462972', '/resources/themes/images/inventory-item-barcode-image/Pencil1495197462972.jpg', 'ITEM1495197462972', 'Writing Purpose', NULL, 'Pencil', NULL, 'Main Building', 1, 'admin@jdsoft.in', '2017-05-19 12:37:43', NULL, NULL, 0, 1, 0, 1, 0, 100, 1, NULL, 3, 3, NULL, 2),
(2, 1, 'admin@jdsoft.in', '2017-05-19 18:14:15', 1, 1, NULL, NULL, NULL, '2017-05-19 12:44:16', 'ITEM1495197855906', '/resources/themes/images/inventory-item-barcode-image/Mouse1495197855907.jpg', 'ITEM1495197855906', 'Operate on system', NULL, 'Mouse', NULL, 'Computer Lab', 1, 'admin@jdsoft.in', '2017-05-19 12:44:16', NULL, NULL, 0, 1, 0, 1, 0, 56, 1, NULL, 2, 7, NULL, 2),
(4, 0, 'admin@jdsoft.in', '2017-05-25 12:34:52', 1, 1, NULL, NULL, NULL, '2017-05-25 07:04:53', 'ITEM1495695892399', '/resources/themes/images/inventory-item-barcode-image/KeyBoard1495695892491.jpg', 'ITEM1495695892399', 'typing purpose', NULL, 'KeyBoard', NULL, 'Server Room', 1, 'admin@jdsoft.in', '2017-05-25 07:04:53', NULL, NULL, 0, 1, 100, 0, 0, 35, 1, NULL, 2, 7, NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_inventory_purchase_order`
--

CREATE TABLE `tbl_inventory_purchase_order` (
  `purchase_order_id` bigint(20) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `purchase_order_date` date NOT NULL,
  `purchase_order_no` varchar(100) NOT NULL,
  `purchase_order_status` int(11) NOT NULL,
  `is_purchased` tinyint(1) NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `inventoryReceipt_inventory_receipt_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) NOT NULL,
  `total_quantity` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_inventory_purchase_order`
--

INSERT INTO `tbl_inventory_purchase_order` (`purchase_order_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `purchase_order_date`, `purchase_order_no`, `purchase_order_status`, `is_purchased`, `academic_year_id`, `institution_id`, `inventoryReceipt_inventory_receipt_id`, `supplier_id`, `total_quantity`) VALUES
(2, 'admin@jdsoft.in', '2017-05-30 13:59:31', 'admin@jdsoft.in', '2017-05-30 08:29:33', '2017-05-30', '2', 0, 0, 1, 1, NULL, 1, 10),
(3, 'admin@jdsoft.in', '2017-05-30 13:59:51', 'admin@jdsoft.in', '2017-05-30 08:29:51', '2017-05-30', '3', 1, 0, 1, 1, NULL, 2, 10),
(4, 'admin@jdsoft.in', '2017-05-30 14:00:05', 'admin@jdsoft.in', '2017-05-30 08:30:05', '2017-05-30', '4', 2, 0, 1, 1, NULL, 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_inventory_purchase_order_details`
--

CREATE TABLE `tbl_inventory_purchase_order_details` (
  `purchase_order_detail_id` bigint(20) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `total_qty` double NOT NULL,
  `inventory_item_master_id` bigint(20) NOT NULL,
  `purchase_order_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_inventory_purchase_order_details`
--

INSERT INTO `tbl_inventory_purchase_order_details` (`purchase_order_detail_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `total_qty`, `inventory_item_master_id`, `purchase_order_id`) VALUES
(4, 'admin@jdsoft.in', '2017-05-30 13:59:31', 'admin@jdsoft.in', '2017-05-30 08:29:32', 10, 1, 2),
(5, 'admin@jdsoft.in', '2017-05-30 13:59:51', 'admin@jdsoft.in', '2017-05-30 08:29:51', 10, 2, 3),
(6, 'admin@jdsoft.in', '2017-05-30 14:00:05', 'admin@jdsoft.in', '2017-05-30 08:30:05', 10, 4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_inventory_receipt`
--

CREATE TABLE `tbl_inventory_receipt` (
  `inventory_receipt_id` bigint(20) NOT NULL,
  `total_amount` double NOT NULL,
  `cheque_bank_name` varchar(100) DEFAULT NULL,
  `cheque_branch_name` varchar(100) DEFAULT NULL,
  `cheque_date` date DEFAULT NULL,
  `cheque_number` varchar(100) DEFAULT NULL,
  `inv_receipt_comments` varchar(100) DEFAULT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `dd_bank_name` varchar(100) DEFAULT NULL,
  `dd_branch_name` varchar(100) DEFAULT NULL,
  `dd_date` date DEFAULT NULL,
  `dd_number` varchar(100) DEFAULT NULL,
  `inv_receipt_cleared_by` varchar(100) DEFAULT NULL,
  `inventory_receipt_cleared_date` date DEFAULT NULL,
  `generate_date` date NOT NULL,
  `inventory_receipt_status` int(11) NOT NULL,
  `invoice_number` varchar(100) NOT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `narration` varchar(255) DEFAULT NULL,
  `payment_gateway` varchar(100) DEFAULT NULL,
  `payment_gateway_mode` varchar(100) DEFAULT NULL,
  `total_qty` double NOT NULL,
  `receipt_number` varchar(100) NOT NULL,
  `tally_ref_number` varchar(100) NOT NULL,
  `transaction_no` varchar(100) NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `inventory_master_id` bigint(20) NOT NULL,
  `inventory_purchase_order_id` bigint(20) NOT NULL,
  `payment_mode_id` bigint(20) NOT NULL,
  `supplier_id` bigint(20) NOT NULL,
  `tax_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_inventory_requisition`
--

CREATE TABLE `tbl_inventory_requisition` (
  `inventory_requisition_id` bigint(20) NOT NULL,
  `approval_status` varchar(255) NOT NULL,
  `approval_by` varchar(255) DEFAULT NULL,
  `approver_comments` varchar(255) DEFAULT NULL,
  `created_date` date NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `inventory_requisition_reason` varchar(255) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `quantity` double NOT NULL,
  `inventory_item_id` bigint(20) NOT NULL,
  `inventory_requistion_approver_user_id` bigint(20) NOT NULL,
  `inventory_requistion_user_id` bigint(20) NOT NULL,
  `portal_task_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_inventory_requisition`
--

INSERT INTO `tbl_inventory_requisition` (`inventory_requisition_id`, `approval_status`, `approval_by`, `approver_comments`, `created_date`, `description`, `inventory_requisition_reason`, `modified_date`, `quantity`, `inventory_item_id`, `inventory_requistion_approver_user_id`, `inventory_requistion_user_id`, `portal_task_id`) VALUES
(1, 'Approved', 'admin@jdsoft.in', 'collect your goods from stationary', '2017-05-25', 'Nothing', 'My mouse not working', '2017-05-25 13:21:54', 5, 2, 1, 7, 59),
(2, 'Cancelled', NULL, NULL, '2017-05-25', 'Testing', 'Purchase', '2017-05-25 14:24:13', 700, 4, 1, 7, 60),
(3, 'Rejected', 'admin@jdsoft.in', 'Resource not available', '2017-05-26', 'Typing purpose', 'Typing purpose', '2017-05-26 05:25:55', 750, 4, 1, 2, 62),
(4, 'Pending', NULL, NULL, '2017-05-26', 'Nothing', 'Writing purpose', '2017-05-26 05:30:32', 23, 1, 1, 7, 64);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_inventory_type`
--

CREATE TABLE `tbl_inventory_type` (
  `inventory_type_id` bigint(20) NOT NULL,
  `inventory_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_inventory_type`
--

INSERT INTO `tbl_inventory_type` (`inventory_type_id`, `inventory_type`) VALUES
(3, 'Finished Goods'),
(8, 'Fixed Asset'),
(7, 'Office Equipment'),
(1, 'Raw Materials'),
(4, 'Service Inventory'),
(5, 'Transportation'),
(6, 'Work in Progress');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_license`
--

CREATE TABLE `tbl_license` (
  `license_id` bigint(20) NOT NULL,
  `customer_code` varchar(255) NOT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `license_code` varchar(255) NOT NULL,
  `mac_address` varchar(255) DEFAULT NULL,
  `mother_board_serial_number` varchar(255) DEFAULT NULL,
  `license_status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_license`
--

INSERT INTO `tbl_license` (`license_id`, `customer_code`, `ip_address`, `license_code`, `mac_address`, `mother_board_serial_number`, `license_status`) VALUES
(1, 'K4/sA88mZZzBqRfB+tzkTA==', '192.168.2.126', 'l9/wjb1ynGrvPH6LaS80rbcppmlrbH+BfbD3J/Xx3RJ/z3JA64zToY00UvMiPO+W', '04-7D-7B-09-D3-44', 'PCHNR014J124AA', 'fIPCHhEycFewY6ZJocHokQ==');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_module`
--

CREATE TABLE `tbl_module` (
  `module_id` bigint(20) NOT NULL,
  `module_code` varchar(100) NOT NULL,
  `module_name` varchar(50) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `module_total_no_of_hours` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_module`
--

INSERT INTO `tbl_module` (`module_id`, `module_code`, `module_name`, `institution_id`, `module_total_no_of_hours`) VALUES
(1, 'E123', 'English', 1, 30),
(2, 'M342', 'Mathematics', 1, 45),
(3, 'L123', 'Language', 1, 30),
(4, 'S234', 'Science', 1, 40),
(5, 'SC2321', 'Social Science', 1, 30);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_module_plan`
--

CREATE TABLE `tbl_module_plan` (
  `module_plan_id` bigint(20) NOT NULL,
  `module_plan_about_assignments` varchar(150) DEFAULT NULL,
  `module_plan_assessment` varchar(150) NOT NULL,
  `module_plan_objectives` varchar(255) NOT NULL,
  `module_plan_student_activities` varchar(255) NOT NULL,
  `module_plan_teacher_procedure` varchar(255) NOT NULL,
  `module_plan_purpose` varchar(255) NOT NULL,
  `module_plan_reference_framework` varchar(120) DEFAULT NULL,
  `module_plan_reference_handout` varchar(120) DEFAULT NULL,
  `module_plan_reference_material` varchar(120) DEFAULT NULL,
  `module_plan_reference_questions` varchar(120) DEFAULT NULL,
  `module_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_module_plan_schedule`
--

CREATE TABLE `tbl_module_plan_schedule` (
  `module_plan_schedule_id` bigint(20) NOT NULL,
  `module_plan_schedule_end_date` datetime NOT NULL,
  `module_plan_schedule_hours_required` int(11) NOT NULL,
  `module_plan_schedule_remarks` varchar(255) DEFAULT NULL,
  `module_plan_schedule_start_date` datetime NOT NULL,
  `module_plan_schedule_status` varchar(255) NOT NULL,
  `module_plan_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_module_skill`
--

CREATE TABLE `tbl_module_skill` (
  `module_skill_id` bigint(20) NOT NULL,
  `module_skill_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_module_skill`
--

INSERT INTO `tbl_module_skill` (`module_skill_id`, `module_skill_name`) VALUES
(5, 'Extra Reading'),
(4, 'Listening Skill'),
(1, 'Reading Skill'),
(3, 'Speaking Skill'),
(2, 'Writing Skill');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_module_skill_indicator`
--

CREATE TABLE `tbl_module_skill_indicator` (
  `module_skill_indicator_id` bigint(20) NOT NULL,
  `module_skill_indicator_name` varchar(100) NOT NULL,
  `module_skill_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_module_skill_indicator`
--

INSERT INTO `tbl_module_skill_indicator` (`module_skill_indicator_id`, `module_skill_indicator_name`, `module_skill_id`) VALUES
(3, 'Comprehension', 1),
(2, 'Fluency', 1),
(1, 'Pronunciation', 1),
(4, 'Creative Writing', 2),
(6, 'Grammer', 2),
(5, 'Handwriting', 2),
(7, 'Spellings', 2),
(8, 'Vocabulary', 2),
(9, 'Conversation', 3),
(10, 'Reaitation', 3),
(11, 'Comprehension', 4),
(12, 'Extra Reading', 5);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_moment_requisition`
--

CREATE TABLE `tbl_moment_requisition` (
  `moment_requisition_id` bigint(20) NOT NULL,
  `approval_status` varchar(255) NOT NULL,
  `approval_by` varchar(255) NOT NULL,
  `approver_comments` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` date NOT NULL,
  `end_time` time NOT NULL,
  `modified_by` varchar(255) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `moment_requisition_date` date NOT NULL,
  `request_reason` varchar(255) NOT NULL,
  `start_time` time NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `tc_approver_id` bigint(20) NOT NULL,
  `portal_task_id` bigint(20) NOT NULL,
  `requisition_type_id` bigint(20) NOT NULL,
  `section_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `class_id` bigint(20) NOT NULL,
  `moment_approver_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_moment_requisition`
--

INSERT INTO `tbl_moment_requisition` (`moment_requisition_id`, `approval_status`, `approval_by`, `approver_comments`, `created_by`, `created_date`, `end_time`, `modified_by`, `modified_date`, `moment_requisition_date`, `request_reason`, `start_time`, `academic_year_id`, `institution_id`, `tc_approver_id`, `portal_task_id`, `requisition_type_id`, `section_id`, `student_id`, `class_id`, `moment_approver_id`) VALUES
(1, 'Cancelled', 'Pending', NULL, 'anand@jdsoft.in', '2017-05-16', '16:43:00', 'anand@jdsoft.in', '2017-05-16 11:13:26', '2017-05-16', 'Sports Event', '10:43:00', 1, 1, 2, 38, 2, 1, 1, 1, 0),
(2, 'Approved', 'dineshponrajdpr@gmail.com', 'Ok permission granted', 'anand@jdsoft.in', '2017-05-16', '17:03:00', 'anand@jdsoft.in', '2017-05-16 11:33:45', '2017-05-20', 'Sports Event', '10:03:00', 1, 1, 2, 39, 2, 1, 1, 1, 0),
(3, 'Rejected', 'dineshponrajdpr@gmail.com', 'Not Ok', 'anand@jdsoft.in', '2017-05-16', '12:38:00', 'anand@jdsoft.in', '2017-05-16 12:08:38', '2017-05-22', 'Seminar', '10:38:00', 1, 1, 2, 41, 2, 1, 1, 1, 0),
(4, 'Cancelled', 'Pending', NULL, 'anand@jdsoft.in', '2017-05-16', '17:42:00', 'anand@jdsoft.in', '2017-05-16 12:12:19', '2017-05-16', 'Sports Event', '17:42:00', 1, 1, 2, 43, 2, 1, 1, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_payment_mode`
--

CREATE TABLE `tbl_payment_mode` (
  `payment_mode_id` bigint(20) NOT NULL,
  `payment_mode_title` varchar(100) NOT NULL,
  `payment_mode_visibility` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_payment_mode`
--

INSERT INTO `tbl_payment_mode` (`payment_mode_id`, `payment_mode_title`, `payment_mode_visibility`) VALUES
(1, 'Cash', 1),
(2, 'Cheque', 1),
(3, 'DD', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_payment_mode_and_payment_status_mapping`
--

CREATE TABLE `tbl_payment_mode_and_payment_status_mapping` (
  `payment_mode_id` bigint(20) NOT NULL,
  `payment_status_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_payment_mode_and_payment_status_mapping`
--

INSERT INTO `tbl_payment_mode_and_payment_status_mapping` (`payment_mode_id`, `payment_status_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(2, 3),
(3, 1),
(3, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_payment_status`
--

CREATE TABLE `tbl_payment_status` (
  `payment_status_id` bigint(20) NOT NULL,
  `payment_status_title` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_payment_status`
--

INSERT INTO `tbl_payment_status` (`payment_status_id`, `payment_status_title`) VALUES
(1, 'Pending'),
(2, 'Cleared'),
(3, 'Bounced');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_portal_message`
--

CREATE TABLE `tbl_portal_message` (
  `portal_message_id` bigint(20) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `portal_message` varchar(255) NOT NULL,
  `portal_message_link` varchar(255) NOT NULL,
  `portal_message_status` int(11) NOT NULL,
  `portal_message_subject` varchar(100) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_portal_message_users`
--

CREATE TABLE `tbl_portal_message_users` (
  `portal_message_id` bigint(20) NOT NULL,
  `target_user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_portal_notification`
--

CREATE TABLE `tbl_portal_notification` (
  `portal_notification_id` bigint(20) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `portal_notification_link` varchar(255) NOT NULL,
  `portal_notification_message` varchar(255) NOT NULL,
  `portal_notification_status` int(11) NOT NULL,
  `portal_notification_subject` varchar(100) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_portal_notification`
--

INSERT INTO `tbl_portal_notification` (`portal_notification_id`, `created_by`, `created_date`, `portal_notification_link`, `portal_notification_message`, `portal_notification_status`, `portal_notification_subject`, `institution_id`) VALUES
(1, 'admin@jdsoft.in', '2017-04-04 10:48:43', '/communication', 'Hi', 1, 'General Message', 1),
(2, 'admin@jdsoft.in', '2017-04-10 12:57:16', '/admissions/candidate/applyforadmission', 'Application Status Updated', 1, 'Application Status Updated', 1),
(3, 'admin@jdsoft.in', '2017-04-11 10:21:31', '/admissions/candidate/applyforadmission', 'Application Status Updated', 1, 'Application Status Updated', 1),
(4, 'admin@jdsoft.in', '2017-04-11 12:01:24', '/admissions/candidate/applyforadmission', 'Application Status Updated', 1, 'Application Status Updated', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_portal_notification_users`
--

CREATE TABLE `tbl_portal_notification_users` (
  `portal_notification_id` bigint(20) NOT NULL,
  `target_user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_portal_notification_users`
--

INSERT INTO `tbl_portal_notification_users` (`portal_notification_id`, `target_user_id`) VALUES
(2, 9),
(3, 9);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_portal_reply_message`
--

CREATE TABLE `tbl_portal_reply_message` (
  `portal_reply_message_id` bigint(20) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `portal_reply_message` varchar(255) NOT NULL,
  `portal_reply_message_link` varchar(255) NOT NULL,
  `portal_reply_message_status` int(11) NOT NULL,
  `portal_reply_message_subject` varchar(100) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_portal_reply_message_users`
--

CREATE TABLE `tbl_portal_reply_message_users` (
  `portal_message_id` bigint(20) NOT NULL,
  `target_user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_portal_task`
--

CREATE TABLE `tbl_portal_task` (
  `portal_task_id` bigint(20) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `portal_task_link` varchar(255) NOT NULL,
  `portal_task_message` varchar(255) NOT NULL,
  `portal_task_status` int(11) NOT NULL,
  `portal_task_subject` varchar(100) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_portal_task`
--

INSERT INTO `tbl_portal_task` (`portal_task_id`, `created_by`, `created_date`, `portal_task_link`, `portal_task_message`, `portal_task_status`, `portal_task_subject`, `institution_id`) VALUES
(1, 'dineshponrajdpr@gmail.com', '2017-04-19 13:20:53', '/staff/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(2, 'anand@jdsoft.in', '2017-05-05 15:38:30', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(3, 'anand@jdsoft.in', '2017-05-05 15:56:37', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(4, 'anand@jdsoft.in', '2017-05-05 16:03:55', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(5, 'anand@jdsoft.in', '2017-05-05 16:06:45', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(6, 'anand@jdsoft.in', '2017-05-05 16:20:56', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(7, 'anand@jdsoft.in', '2017-05-05 17:06:52', '/student/leave/requisition', 'Leave Approved', 1, 'Leave Approved', 1),
(8, 'anand@jdsoft.in', '2017-05-05 17:12:53', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(9, 'anand@jdsoft.in', '2017-05-05 17:13:30', '/student/leave/requisition', 'Leave Rejected', 1, 'Leave Rejected', 1),
(10, 'dineshponrajdpr@gmail.com', '2017-05-10 13:15:29', '/staff/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(11, 'dineshponrajdpr@gmail.com', '2017-05-10 13:16:03', '/staff/requisition', 'Leave Approved', 1, 'Leave Approved', 1),
(12, 'dineshponrajdpr@gmail.com', '2017-05-10 17:04:04', '/staff/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(13, 'dineshponrajdpr@gmail.com', '2017-05-10 17:04:24', '/staff/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(14, 'dineshponrajdpr@gmail.com', '2017-05-10 17:18:38', '/staff/requisition', 'Leave Approved', 1, 'Leave Approved', 1),
(15, 'anand@jdsoft.in', '2017-05-10 17:35:49', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(16, 'anand@jdsoft.in', '2017-05-10 17:36:07', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(17, 'anand@jdsoft.in', '2017-05-10 17:36:58', '/student/leave/requisition', 'Leave Approved', 1, 'Leave Approved', 1),
(18, 'dineshponrajdpr@gmail.com', '2017-05-10 18:51:40', '/staff/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(19, 'anand@jdsoft.in', '2017-05-10 18:53:18', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(20, 'dineshponrajdpr@gmail.com', '2017-05-10 19:22:01', '/staff/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(21, 'anand@jdsoft.in', '2017-05-10 19:24:53', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(23, 'anand@jdsoft.in', '2017-05-15 13:41:12', '/student/leave/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(24, 'anand@jdsoft.in', '2017-05-15 15:08:40', '/student/leave/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(25, 'anand@jdsoft.in', '2017-05-15 15:10:10', '/student/leave/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(26, 'anand@jdsoft.in', '2017-05-15 15:14:40', '/staff/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(27, 'Aachman@gmail.com', '2017-05-15 16:08:14', '/staff/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(28, 'anand@jdsoft.in', '2017-05-15 16:21:14', '/student/transfercertificate/requisition', 'TC Approved', 1, 'TC Approved', 1),
(29, 'Aachman@gmail.com', '2017-05-15 17:07:19', '/student/transfercertificate/requisition', 'TC Rejected', 1, 'TC Rejected', 1),
(30, 'Aachman@gmail.com', '2017-05-15 17:12:25', '/staff/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(31, 'Aachman@gmail.com', '2017-05-15 17:13:03', '/student/transfercertificate/requisition', 'TC Approved', 1, 'TC Approved', 1),
(32, 'Aachman@gmail.com', '2017-05-15 17:20:13', '/staff/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(33, 'parent.Aachman@gmail.com', '2017-05-15 17:20:45', '/student/transfercertificate/requisition', 'TC Approved', 1, 'TC Approved', 1),
(34, 'anand@jdsoft.in', '2017-05-15 17:22:15', '/staff/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(35, 'parent.anand@jdsoft.in', '2017-05-15 17:22:46', '/student/transfercertificate/requisition', 'TC Rejected', 1, 'TC Rejected', 1),
(36, 'anand@jdsoft.in', '2017-05-15 17:27:51', '/staff/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(37, 'parent.anand@jdsoft.in', '2017-05-15 17:28:29', '/student/transfercertificate/requisition', 'TC Approved', 1, 'TC Approved', 1),
(38, 'anand@jdsoft.in', '2017-05-16 16:43:26', '/staff/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(39, 'anand@jdsoft.in', '2017-05-16 17:03:45', '/staff/approvals', 'TC Approvals', 1, 'TC Approvals', 1),
(40, 'anand@jdsoft.in', '2017-05-16 17:32:35', '/student/leave/requisition', 'Moment Approved', 1, 'Moment Approved', 1),
(41, 'anand@jdsoft.in', '2017-05-16 17:38:38', '/student/leave/approvals', 'Moment Approvals', 1, 'Moment Approvals', 1),
(42, 'anand@jdsoft.in', '2017-05-16 17:40:53', '/student/leave/requisition', 'Moment Rejected', 1, 'Moment Rejected', 1),
(43, 'anand@jdsoft.in', '2017-05-16 17:42:19', '/student/leave/approvals', 'Moment Approvals', 1, 'Moment Approvals', 1),
(44, 'dineshponrajdpr@gmail.com', '2017-05-16 19:37:34', '/staff/approvals', 'Staff Moment Approvals', 1, 'Staff Moment Approvals', 1),
(45, 'dineshponrajdpr@gmail.com', '2017-05-16 19:45:34', '/staff/approvals', 'Staff Moment Approvals', 1, 'Staff Moment Approvals', 1),
(46, 'dineshponrajdpr@gmail.com', '2017-05-16 19:45:59', '/staff/approvals', 'Staff Moment Approvals', 1, 'Staff Moment Approvals', 1),
(47, 'dineshponrajdpr@gmail.com', '2017-05-16 19:48:45', '/staff/requisition', 'Staff Moment Approved', 1, 'Staff Moment Approved', 1),
(48, 'dineshponrajdpr@gmail.com', '2017-05-16 19:50:26', '/staff/approvals', 'Staff Moment Approvals', 1, 'Staff Moment Approvals', 1),
(49, 'dineshponrajdpr@gmail.com', '2017-05-16 19:52:29', '/staff/requisition', 'Staff Moment Rejected', 1, 'Staff Moment Rejected', 1),
(50, 'anand@jdsoft.in', '2017-05-17 15:32:35', '/student/leave/approvals', 'Leave Approvals', 1, 'Leave Approvals', 1),
(51, 'anand@jdsoft.in', '2017-05-18 11:46:02', '/staff/sickroom/approvals', 'Sick Room Approval', 1, 'Sick Room Approval', 1),
(52, 'anand@jdsoft.in', '2017-05-18 11:47:57', '/staff/sickroom/approvals', 'Sick Room Approval', 1, 'Sick Room Approval', 1),
(53, 'arunbalaji@gmail.com', '2017-05-18 11:51:40', '/staff/sickroom/requisition', 'Sick Room Approved', 1, 'Sick Room Approved', 1),
(54, 'arunbalaji@gmail.com', '2017-05-18 11:54:44', '/staff/sickroom/approvals', 'Sick Room Approval', 1, 'Sick Room Approval', 1),
(55, 'admin@jdsoft.in', '2017-05-18 11:56:20', '/staff/sickroom/requisition', 'Sick Room Rejected', 1, 'Sick Room Rejected', 1),
(56, 'anand@jdsoft.in', '2017-05-19 18:54:35', '/staff/sickroom/approvals', 'Sick Room Approval', 1, 'Sick Room Approval', 1),
(59, 'anand@jdsoft.in', '2017-05-25 18:51:54', '/inventoryandpurchase/approvals', 'Inventory Requisition Approval', 1, 'Inventory Requisition Approval', 1),
(60, 'anand@jdsoft.in', '2017-05-25 19:54:12', '/inventoryandpurchase/approvals', 'Inventory Requisition Approval', 1, 'Inventory Requisition Approval', 1),
(61, 'admin@jdsoft.in', '2017-05-26 10:35:00', '/inventoryandpurchase/requisition', 'Inventory Requisition Approved', 1, 'Inventory Requisition Approved', 1),
(62, 'dineshponrajdpr@gmail.com', '2017-05-26 10:55:55', '/inventoryandpurchase/approvals', 'Inventory Requisition Approval', 1, 'Inventory Requisition Approval', 1),
(63, 'admin@jdsoft.in', '2017-05-26 10:57:46', '/inventoryandpurchase/requisition', 'Inventory Requisition Rejected', 1, 'Inventory Requisition Rejected', 1),
(64, 'anand@jdsoft.in', '2017-05-26 11:00:32', '/inventoryandpurchase/approvals', 'Inventory Requisition Approval', 1, 'Inventory Requisition Approval', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_portal_task_users`
--

CREATE TABLE `tbl_portal_task_users` (
  `portal_task_id` bigint(20) NOT NULL,
  `target_user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_portal_task_users`
--

INSERT INTO `tbl_portal_task_users` (`portal_task_id`, `target_user_id`) VALUES
(1, 1),
(9, 7),
(10, 1),
(11, 2),
(12, 1),
(13, 1),
(14, 2),
(15, 2),
(18, 1),
(26, 1),
(29, 11),
(31, 11),
(37, 8),
(56, 3),
(63, 2),
(64, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_privilege`
--

CREATE TABLE `tbl_privilege` (
  `privilege_id` bigint(20) NOT NULL,
  `privilege_name` varchar(100) DEFAULT NULL,
  `target_type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_privilege`
--

INSERT INTO `tbl_privilege` (`privilege_id`, `privilege_name`, `target_type`) VALUES
(1, 'section', 'admin'),
(2, 'section/add', 'admin'),
(3, 'section/view', 'admin'),
(4, 'section/update', 'admin'),
(5, 'section/delete', 'admin'),
(6, 'section/viewlist', 'admin'),
(7, 'module', 'admin'),
(8, 'module/add', 'admin'),
(9, 'module/view', 'admin'),
(10, 'module/update', 'admin'),
(11, 'module/delete', 'admin'),
(12, 'module/viewlist', 'admin'),
(13, 'staffdesignation', 'admin'),
(14, 'staffdesignation/add', 'admin'),
(15, 'staffdesignation/view', 'admin'),
(16, 'staffdesignation/update', 'admin'),
(17, 'staffdesignation/delete', 'admin'),
(18, 'staffdesignation/viewlist', 'admin'),
(19, 'specialcategory', 'admin'),
(20, 'specialcategory/add', 'admin'),
(21, 'specialcategory/view', 'admin'),
(22, 'specialcategory/update', 'admin'),
(23, 'specialcategory/delete', 'admin'),
(24, 'specialcategory/viewlist', 'admin'),
(25, 'staff', 'admin'),
(26, 'staff/add', 'admin'),
(27, 'staff/view', 'admin'),
(28, 'staff/update', 'admin'),
(29, 'staff/delete', 'admin'),
(30, 'staff/viewlist', 'admin'),
(31, 'examtemplate', 'admin'),
(32, 'examtemplate/add', 'admin'),
(33, 'examtemplate/view', 'admin'),
(34, 'examtemplate/viewlist', 'admin'),
(35, 'examtemplate/delete', 'admin'),
(36, 'examtemplate/update', 'admin'),
(37, 'gradetemplate', 'admin'),
(38, 'gradetemplate/add', 'admin'),
(39, 'gradetemplate/view', 'admin'),
(40, 'gradetemplate/viewlist', 'admin'),
(41, 'gradetemplate/delete', 'admin'),
(42, 'gradetemplate/update', 'admin'),
(43, 'timetabletemplate', 'admin'),
(44, 'timetabletemplate/add', 'admin'),
(45, 'timetabletemplate/view', 'admin'),
(46, 'timetabletemplate/viewlist', 'admin'),
(47, 'timetabletemplate/delete', 'admin'),
(48, 'timetabletemplate/update', 'admin'),
(49, 'timetable', 'admin'),
(50, 'rolemanagement', 'admin'),
(51, 'rolemanagement/add', 'admin'),
(52, 'rolemanagement/view', 'admin'),
(53, 'rolemanagement/viewlist', 'admin'),
(54, 'rolemanagement/delete', 'admin'),
(55, 'rolemanagement/update', 'admin'),
(56, 'feesitem', 'admin'),
(57, 'feesitem/add', 'admin'),
(58, 'feesitem/view', 'admin'),
(59, 'feesitem/viewlist', 'admin'),
(60, 'feesitem/delete', 'admin'),
(61, 'feesitem/update', 'admin'),
(62, 'feesstructure', 'admin'),
(63, 'feesstructure/add', 'admin'),
(64, 'feesstructure/view', 'admin'),
(65, 'feesstructure/viewlist', 'admin'),
(66, 'feesstructure/delete', 'admin'),
(67, 'feesstructure/update', 'admin'),
(68, 'academicyear', 'admin'),
(69, 'academicyear/add', 'admin'),
(70, 'academicyear/view', 'admin'),
(71, 'academicyear/viewlist', 'admin'),
(72, 'academicyear/delete', 'admin'),
(73, 'academicyear/update', 'admin'),
(74, 'feesterm', 'admin'),
(75, 'feesterm/add', 'admin'),
(76, 'feesterm/view', 'admin'),
(77, 'feesterm/viewlist', 'admin'),
(78, 'feesterm/delete', 'admin'),
(79, 'feesterm/update', 'admin'),
(80, 'dashboard/admin', 'admin'),
(81, 'student', 'admin'),
(82, 'student/studentdetails', 'admin'),
(83, 'student/newstudent', 'admin'),
(84, 'institution', 'admin'),
(85, 'feesManagement', 'admin'),
(86, 'reports', 'admin'),
(87, 'backup', 'admin'),
(88, 'class', 'admin'),
(89, 'institution/specialCategory', 'admin'),
(90, 'feesManagment/generateFees', 'admin'),
(91, 'feesManagement/collectFees', 'admin'),
(92, 'feesManagement/reconcillation', 'admin'),
(93, 'feesManagement/manageInvoices', 'admin'),
(94, 'feesManagement/manageReceipts', 'admin'),
(95, 'reports/termFeesReport', 'admin'),
(96, 'reports/invoiceFCR', 'admin'),
(97, 'exam', 'admin'),
(98, 'attendanceManagement', 'admin'),
(99, 'humanresource', 'admin'),
(100, 'manageinstitution', 'admin'),
(101, 'manageinstitution/add', 'admin'),
(102, 'manageinstitution/view', 'admin'),
(103, 'manageinstitution/viewlist', 'admin'),
(104, 'manageinstitution/delete', 'admin'),
(105, 'manageinstitution/update', 'admin'),
(106, 'editinstitution', 'admin'),
(107, 'editinstitution/view', 'admin'),
(108, 'editinstitution/update', 'admin'),
(109, 'managestudent', 'admin'),
(110, 'managestudent/add', 'admin'),
(111, 'managestudent/view', 'admin'),
(112, 'managestudent/viewlist', 'admin'),
(113, 'managestudent/delete', 'admin'),
(114, 'managestudent/update', 'admin'),
(115, 'staff/profile', 'staff'),
(116, 'staff/moduleattendance', 'staff'),
(117, 'staff/timetable', 'staff'),
(118, 'staff/moduleplan', 'staff'),
(119, 'user/view', 'admin'),
(120, 'classsection/view', 'admin'),
(121, 'timetablegenerator', 'admin'),
(122, 'timetablegenerator/add', 'admin'),
(123, 'timetablegenerator/view', 'admin'),
(124, 'timetablegenerator/viewlist', 'admin'),
(125, 'timetablegenerator/delete', 'admin'),
(126, 'timetablegenerator/update', 'admin'),
(127, 'student/profile', 'student'),
(128, 'student/timetable', 'student'),
(129, 'class/add', 'admin'),
(130, 'class/view', 'admin'),
(131, 'class/update', 'admin'),
(132, 'class/delete', 'admin'),
(133, 'class/viewlist', 'admin'),
(134, 'communication/parent', 'parent'),
(135, 'communication/staff', 'staff'),
(136, 'communication/student', 'student'),
(137, 'dashboard/admin/attendancepercentage', 'admin'),
(138, 'dashboard/student', 'student'),
(139, 'dashboard/staff', 'staff'),
(140, 'dashboard/parent', 'parent'),
(141, 'communication/parent/add', 'parent'),
(142, 'communication/parent/view', 'parent'),
(143, 'communication/parent/delete', 'parent'),
(144, 'communication/staff/add', 'staff'),
(145, 'communication/staff/view', 'staff'),
(146, 'communication/staff/delete', 'staff'),
(147, 'communication/student/add', 'student'),
(148, 'communication/student/view', 'student'),
(149, 'communication/student/delete', 'student'),
(150, 'communication/admin/add', 'admin'),
(151, 'communication/admin/view', 'admin'),
(152, 'communication/admin/delete', 'admin'),
(153, 'communication/admin/adminsentnotification', 'admin'),
(154, 'communication/admin', 'admin'),
(155, 'communication/staff/adminsentnotification', 'staff'),
(156, 'parent/timetable', 'parent'),
(157, 'staff/staffattendancedetails', 'staff'),
(158, 'student/studentattendancedetails', 'student'),
(159, 'parent/studentattendancedetails', 'parent'),
(160, 'approvals/admin', 'admin'),
(161, 'approvals/staff', 'staff'),
(162, 'requisition/admin', 'admin'),
(163, 'requisition/staff', 'staff'),
(164, 'requisition/student', 'student'),
(165, 'admin/studentattendancedetails', 'admin'),
(166, 'admissionmanagement', 'admin'),
(167, 'admission/dashboard', 'admin'),
(168, 'admission/configuration', 'admin'),
(169, 'admission/finalization', 'admin'),
(170, 'admission/newstudentregistration', 'admin'),
(171, 'admission/candidatedetails', 'admin'),
(172, 'admissioncandidate', 'admissioncandidate'),
(173, 'admission/universityprofile', 'admissioncandidate'),
(174, 'admission/applyforadmission', 'admissioncandidate'),
(175, 'admission/admissioncourses', 'admissioncandidate'),
(176, 'admission/statusandcommunication', 'admissioncandidate'),
(177, 'dashboard/admissioncandidate', 'admissioncandidate');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_purchase_requisition`
--

CREATE TABLE `tbl_purchase_requisition` (
  `purchase_requisition_id` bigint(20) NOT NULL,
  `approval_status` varchar(255) NOT NULL,
  `approval_by` varchar(255) NOT NULL,
  `approver_comments` varchar(255) DEFAULT NULL,
  `created_date` date NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `expected_date` date NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `purchase_reason` varchar(255) NOT NULL,
  `quantity` double NOT NULL,
  `portal_task_id` bigint(20) NOT NULL,
  `purchase_approver_user_id` bigint(20) NOT NULL,
  `purchase_requistion_user_id` bigint(20) NOT NULL,
  `requisition_type_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_religion`
--

CREATE TABLE `tbl_religion` (
  `religion_id` bigint(20) NOT NULL,
  `religion_name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_religion`
--

INSERT INTO `tbl_religion` (`religion_id`, `religion_name`) VALUES
(6, 'Buddhism'),
(3, 'Christians'),
(1, 'Hindu'),
(4, 'Jainism'),
(2, 'Muslims'),
(5, 'Sikhs');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_report_card_generator`
--

CREATE TABLE `tbl_report_card_generator` (
  `report_card_generator_id` bigint(20) NOT NULL,
  `cgpa_grade_obtained` varchar(255) DEFAULT NULL,
  `cgpa_percentage_obtained` double DEFAULT NULL,
  `cgpa_grade_point_obtained` double DEFAULT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `class_section_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_report_card_generator`
--

INSERT INTO `tbl_report_card_generator` (`report_card_generator_id`, `cgpa_grade_obtained`, `cgpa_percentage_obtained`, `cgpa_grade_point_obtained`, `academic_year_id`, `class_section_id`, `institution_id`, `student_id`) VALUES
(1, 'GNG', 144.23726851851856, 15.182870370370374, 1, 4, 1, 113);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_report_card_generator_detail`
--

CREATE TABLE `tbl_report_card_generator_detail` (
  `type` varchar(255) NOT NULL,
  `report_card_detail_id` bigint(20) NOT NULL,
  `formative_assessment_grade_Obtained` varchar(255) NOT NULL,
  `formative_assessment_grade_point_obtained` double NOT NULL,
  `overall_grade_point_in_grade` varchar(255) NOT NULL,
  `overall_grade_point_in_point` double NOT NULL,
  `summative_assessment_grade_Obtained` varchar(255) NOT NULL,
  `summative_assessment_grade_point_obtained` double NOT NULL,
  `report_card_generator_id` bigint(20) NOT NULL,
  `class_section_module_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_report_card_generator_detail`
--

INSERT INTO `tbl_report_card_generator_detail` (`type`, `report_card_detail_id`, `formative_assessment_grade_Obtained`, `formative_assessment_grade_point_obtained`, `overall_grade_point_in_grade`, `overall_grade_point_in_point`, `summative_assessment_grade_Obtained`, `summative_assessment_grade_point_obtained`, `report_card_generator_id`, `class_section_module_id`) VALUES
('reportcardgeneratordetailwithmodulebased', 1, 'GNG', 156.1666666666667, 'GNG', 91.09722222222224, 'GNG', 26.027777777777768, 1, 16);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_requisition_type`
--

CREATE TABLE `tbl_requisition_type` (
  `requisition_type_id` bigint(20) NOT NULL,
  `requisition_type` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_requisition_type`
--

INSERT INTO `tbl_requisition_type` (`requisition_type_id`, `requisition_type`) VALUES
(1, 'Leave Requisition'),
(2, 'Moment Requisition'),
(3, 'TransferCertificate Requisition'),
(4, 'SickRoom Requisition'),
(5, 'Inventory Requisition'),
(6, 'Purchase Requisition');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_role_privilege_mapping`
--

CREATE TABLE `tbl_role_privilege_mapping` (
  `user_role_id` bigint(20) NOT NULL,
  `privilege_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_role_privilege_mapping`
--

INSERT INTO `tbl_role_privilege_mapping` (`user_role_id`, `privilege_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),
(1, 21),
(1, 22),
(1, 23),
(1, 24),
(1, 25),
(1, 26),
(1, 27),
(1, 28),
(1, 29),
(1, 30),
(1, 31),
(1, 32),
(1, 33),
(1, 34),
(1, 35),
(1, 36),
(1, 37),
(1, 38),
(1, 39),
(1, 40),
(1, 41),
(1, 42),
(1, 43),
(1, 44),
(1, 45),
(1, 46),
(1, 47),
(1, 48),
(1, 49),
(1, 50),
(1, 51),
(1, 52),
(1, 53),
(1, 54),
(1, 55),
(1, 56),
(1, 57),
(1, 58),
(1, 59),
(1, 60),
(1, 61),
(1, 62),
(1, 63),
(1, 64),
(1, 65),
(1, 66),
(1, 67),
(1, 68),
(1, 69),
(1, 70),
(1, 71),
(1, 72),
(1, 73),
(1, 74),
(1, 75),
(1, 76),
(1, 77),
(1, 78),
(1, 79),
(1, 80),
(1, 81),
(1, 82),
(1, 83),
(1, 84),
(1, 85),
(1, 86),
(1, 87),
(1, 88),
(1, 89),
(1, 90),
(1, 91),
(1, 92),
(1, 93),
(1, 94),
(1, 95),
(1, 96),
(1, 97),
(1, 98),
(1, 99),
(1, 100),
(1, 101),
(1, 102),
(1, 103),
(1, 104),
(1, 105),
(1, 106),
(1, 107),
(1, 108),
(1, 109),
(1, 110),
(1, 111),
(1, 112),
(1, 113),
(1, 114),
(1, 119),
(1, 120),
(1, 121),
(1, 122),
(1, 123),
(1, 124),
(1, 125),
(1, 126),
(1, 129),
(1, 130),
(1, 131),
(1, 132),
(1, 133),
(1, 137),
(1, 150),
(1, 151),
(1, 152),
(1, 153),
(1, 154),
(1, 160),
(1, 162),
(1, 165),
(1, 166),
(1, 167),
(1, 168),
(1, 169),
(1, 170),
(1, 171),
(2, 115),
(2, 116),
(2, 117),
(2, 118),
(2, 135),
(2, 139),
(2, 144),
(2, 145),
(2, 146),
(2, 155),
(2, 157),
(2, 161),
(2, 163),
(3, 127),
(3, 128),
(3, 136),
(3, 138),
(3, 147),
(3, 148),
(3, 149),
(3, 158),
(3, 164),
(4, 134),
(4, 140),
(4, 141),
(4, 142),
(4, 143),
(4, 156),
(4, 159),
(5, 172),
(5, 173),
(5, 174),
(5, 175),
(5, 176),
(5, 177);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_section`
--

CREATE TABLE `tbl_section` (
  `section_id` bigint(20) NOT NULL,
  `section_name` varchar(50) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_section`
--

INSERT INTO `tbl_section` (`section_id`, `section_name`, `institution_id`) VALUES
(2, 'Average', 1),
(3, 'High', 1),
(1, 'Middle', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sick_room_requisition`
--

CREATE TABLE `tbl_sick_room_requisition` (
  `sick_room_requisition_id` bigint(20) NOT NULL,
  `approval_status` varchar(255) NOT NULL,
  `approval_by` varchar(255) NOT NULL,
  `approver_comments` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` date NOT NULL,
  `end_time` time NOT NULL,
  `modified_by` varchar(255) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `request_reason` varchar(255) NOT NULL,
  `sick_room_requisition_date` date NOT NULL,
  `start_time` time NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `portal_task_id` bigint(20) NOT NULL,
  `requisition_type_id` bigint(20) NOT NULL,
  `section_id` bigint(20) DEFAULT NULL,
  `sick_room_approver_id` bigint(20) NOT NULL,
  `sick_room_requester_id` bigint(20) NOT NULL,
  `class_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_sick_room_requisition`
--

INSERT INTO `tbl_sick_room_requisition` (`sick_room_requisition_id`, `approval_status`, `approval_by`, `approver_comments`, `created_by`, `created_date`, `end_time`, `modified_by`, `modified_date`, `request_reason`, `sick_room_requisition_date`, `start_time`, `academic_year_id`, `institution_id`, `portal_task_id`, `requisition_type_id`, `section_id`, `sick_room_approver_id`, `sick_room_requester_id`, `class_id`) VALUES
(1, 'Cancelled', 'Pending', NULL, 'anand@jdsoft.in', '2017-05-18', '12:45:00', 'anand@jdsoft.in', '2017-05-18 06:16:02', 'Fever', '2017-05-18', '10:45:00', 1, 1, 51, 4, NULL, 3, 7, NULL),
(2, 'Approved', 'arunbalaji@gmail.com', 'Ok', 'anand@jdsoft.in', '2017-05-18', '15:30:00', 'arunbalaji@gmail.com', '2017-05-18 06:17:57', 'Fever', '2017-05-18', '10:30:00', 1, 1, 52, 4, NULL, 3, 7, NULL),
(3, 'Rejected', 'admin@jdsoft.in', 'Not Ok', 'arunbalaji@gmail.com', '2017-05-18', '22:30:00', 'admin@jdsoft.in', '2017-05-18 06:24:44', 'Headache', '2017-05-18', '10:50:00', 1, 1, 54, 4, NULL, 1, 3, NULL),
(4, 'Pending', 'Pending', NULL, 'anand@jdsoft.in', '2017-05-19', '13:54:00', 'anand@jdsoft.in', '2017-05-19 13:24:35', 'Headache', '2017-05-19', '12:54:00', 1, 1, 56, 4, NULL, 3, 7, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_special_category`
--

CREATE TABLE `tbl_special_category` (
  `special_category_id` bigint(20) NOT NULL,
  `special_category_name` varchar(40) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_special_category`
--

INSERT INTO `tbl_special_category` (`special_category_id`, `special_category_name`, `institution_id`) VALUES
(1, 'Management Quota', 1),
(2, 'Non-Management Quota', 1),
(3, 'Sports Quota', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sponser`
--

CREATE TABLE `tbl_sponser` (
  `sponser_id` bigint(20) NOT NULL,
  `sponser_title` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_sponser`
--

INSERT INTO `tbl_sponser` (`sponser_id`, `sponser_title`) VALUES
(4, 'Employer'),
(3, 'Family Members'),
(5, 'Others'),
(2, 'Parents'),
(1, 'Self');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff`
--

CREATE TABLE `tbl_staff` (
  `staff_id` bigint(20) NOT NULL,
  `staff_access_no` varchar(50) NOT NULL,
  `city` varchar(100) NOT NULL,
  `staff_contact` varchar(20) NOT NULL,
  `country` varchar(100) NOT NULL,
  `staff_created_by` varchar(100) NOT NULL,
  `staff_created_date` datetime NOT NULL,
  `staff_date_of_birth` date NOT NULL,
  `staff_email` varchar(100) NOT NULL,
  `staff_first_name` varchar(100) NOT NULL,
  `staff_gender` varchar(15) NOT NULL,
  `date_of_joining` date DEFAULT NULL,
  `staff_last_name` varchar(100) DEFAULT NULL,
  `staff_last_modified_by` varchar(100) NOT NULL,
  `staff_last_modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `parent_guardian_first_name` varchar(100) NOT NULL,
  `parent_guardian_last_name` varchar(100) DEFAULT NULL,
  `post_code` varchar(10) NOT NULL,
  `staff_address_line_one` varchar(255) NOT NULL,
  `staff_address_line_two` varchar(255) NOT NULL,
  `staff_code` varchar(50) NOT NULL,
  `staff_pan_no` varchar(50) DEFAULT NULL,
  `staff_pf_no` varchar(50) DEFAULT NULL,
  `state` varchar(100) NOT NULL,
  `staff_status` int(11) NOT NULL,
  `approver_id` bigint(20) NOT NULL,
  `blood_group_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `staff_designation_id` bigint(20) NOT NULL,
  `staff_type_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff`
--

INSERT INTO `tbl_staff` (`staff_id`, `staff_access_no`, `city`, `staff_contact`, `country`, `staff_created_by`, `staff_created_date`, `staff_date_of_birth`, `staff_email`, `staff_first_name`, `staff_gender`, `date_of_joining`, `staff_last_name`, `staff_last_modified_by`, `staff_last_modified_date`, `parent_guardian_first_name`, `parent_guardian_last_name`, `post_code`, `staff_address_line_one`, `staff_address_line_two`, `staff_code`, `staff_pan_no`, `staff_pf_no`, `state`, `staff_status`, `approver_id`, `blood_group_id`, `category_id`, `institution_id`, `staff_designation_id`, `staff_type_id`, `user_id`) VALUES
(1, '43422231', 'Chennai', '1234667890', 'India', 'default', '2017-04-03 11:46:39', '2017-04-03', 'admin@jdsoft.in', 'Jo', 'Male', '2017-04-03', 'Anand', 'admin@jdsoft.in', '2017-04-03 06:16:40', 'Jo', 'Anand', '123456', 'Line1', 'Line2', 'NT123', '', '', 'Tamil Nadu', 1, 1, 4, 5, 1, 1, 2, 1),
(2, '434222315', 'Tiruchirapalli', '1234567890', 'India', 'admin@jdsoft.in', '2017-04-03 11:53:23', '2017-04-03', 'dineshponrajdpr@gmail.com', 'Dinesh', 'Male', '2017-04-03', 'Ponraj', 'admin@jdsoft.in', '2017-04-03 06:23:23', 'FN', 'LN', '123456', 'Line1', 'Line2', 'TAP123', '', '', 'Tamil Nadu', 1, 1, 4, 5, 1, 3, 1, 2),
(3, '69874', 'Tiruchirapalli', '123654890', 'India', 'admin@jdsoft.in', '2017-04-03 11:55:42', '2017-04-03', 'arunbalaji@gmail.com', 'Arun', 'Male', '2017-04-03', 'Balaji', 'admin@jdsoft.in', '2017-04-03 06:25:42', 'Fn', 'Ln', '123456', 'Line1', 'Line2', 'TAP124', '', '', 'Tamil Nadu', 1, 1, NULL, 5, 1, 3, 1, 3),
(4, '3254786', 'Tiruchirapalli', '123345634', 'India', 'admin@jdsoft.in', '2017-04-03 11:58:23', '2017-04-03', 'mohammeddhanveer@gmail.com', 'Mohammed', 'Male', '2017-04-03', 'Dhanveer', 'admin@jdsoft.in', '2017-04-03 06:28:23', 'Fn', 'Ln', '123456', 'Line1', 'Line2', 'TAP125', '', '', 'Tamil Nadu', 1, 1, NULL, 5, 1, 2, 1, 4),
(5, '698573', 'Tiruchirapalli', '365479210', 'India', 'admin@jdsoft.in', '2017-04-03 12:03:09', '2017-04-03', 'anandraj@gmail.com', 'Anand', 'Male', '2017-04-04', 'Raj', 'admin@jdsoft.in', '2017-04-03 06:33:09', 'Fn', 'Ln', '123456', 'Line1', 'Line2', 'TAP126', '', '', 'Tamil Nadu', 1, 1, NULL, 5, 1, 2, 1, 5),
(6, '325478656', 'Tiruchirapalli', '1234245324', 'India', 'admin@jdsoft.in', '2017-04-03 12:04:48', '2017-04-03', 'praveenkumar@gmail.com', 'Praveen', 'Male', '2017-04-03', 'Kumar', 'admin@jdsoft.in', '2017-04-03 06:34:48', 'Fn', 'Ln', '123456', 'Line1', 'Lin2', 'TAP127', '', '', 'Tamil Nadu', 1, 1, NULL, 5, 1, 3, 1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_attendance`
--

CREATE TABLE `tbl_staff_attendance` (
  `staff_attendance_id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `work_end_time` time NOT NULL,
  `work_start_time` time NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `staff_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff_attendance`
--

INSERT INTO `tbl_staff_attendance` (`staff_attendance_id`, `date`, `work_end_time`, `work_start_time`, `academic_year_id`, `institution_id`, `staff_id`) VALUES
(1, '2017-05-10', '19:30:00', '09:30:00', 1, 1, 2),
(2, '2017-05-01', '19:30:00', '09:30:00', 1, 1, 1),
(3, '2017-05-02', '19:30:00', '09:30:00', 1, 1, 1),
(4, '2017-05-03', '19:30:00', '09:30:00', 1, 1, 1),
(5, '2017-05-04', '19:30:00', '09:30:00', 1, 1, 1),
(6, '2017-05-05', '19:30:00', '09:30:00', 1, 1, 1),
(7, '2017-05-06', '19:30:00', '09:30:00', 1, 1, 1),
(8, '2017-05-07', '19:30:00', '09:30:00', 1, 1, 1),
(9, '2017-05-08', '19:30:00', '09:30:00', 1, 1, 1),
(10, '2017-05-09', '19:30:00', '09:30:00', 1, 1, 1),
(11, '2017-05-10', '19:30:00', '09:30:00', 1, 1, 1),
(12, '2017-05-11', '19:30:00', '09:30:00', 1, 1, 1),
(13, '2017-05-12', '19:30:00', '09:30:00', 1, 1, 1),
(14, '2017-05-13', '19:30:00', '09:30:00', 1, 1, 1),
(15, '2017-05-14', '19:30:00', '09:30:00', 1, 1, 1),
(16, '2017-05-15', '19:30:00', '09:30:00', 1, 1, 1),
(17, '2017-05-16', '19:30:00', '09:30:00', 1, 1, 1),
(18, '2017-05-17', '19:30:00', '09:30:00', 1, 1, 1),
(19, '2017-05-18', '19:30:00', '09:30:00', 1, 1, 1),
(20, '2017-05-19', '19:30:00', '09:30:00', 1, 1, 1),
(21, '2017-05-20', '19:30:00', '09:30:00', 1, 1, 1),
(22, '2017-05-21', '19:30:00', '09:30:00', 1, 1, 1),
(23, '2017-05-22', '19:30:00', '09:30:00', 1, 1, 1),
(24, '2017-05-23', '19:30:00', '09:30:00', 1, 1, 1),
(25, '2017-05-24', '19:30:00', '09:30:00', 1, 1, 1),
(26, '2017-05-25', '19:30:00', '09:30:00', 1, 1, 1),
(27, '2017-05-26', '19:30:00', '09:30:00', 1, 1, 1),
(28, '2017-05-27', '19:30:00', '09:30:00', 1, 1, 1),
(29, '2017-05-28', '19:30:00', '09:30:00', 1, 1, 1),
(30, '2017-05-29', '19:30:00', '09:30:00', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_attendance_configuration`
--

CREATE TABLE `tbl_staff_attendance_configuration` (
  `staff_attendance_configuration` bigint(20) NOT NULL,
  `work_end_time` time DEFAULT NULL,
  `enable_leave_days` tinyint(1) NOT NULL,
  `enable_permission_hours` tinyint(1) NOT NULL,
  `leave_carry_forward` tinyint(1) DEFAULT NULL,
  `monthly_permission_hours` double DEFAULT NULL,
  `monthly_leave_days` double DEFAULT NULL,
  `permission_carry_forward` tinyint(1) DEFAULT NULL,
  `work_start_time` time DEFAULT NULL,
  `institution_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff_attendance_configuration`
--

INSERT INTO `tbl_staff_attendance_configuration` (`staff_attendance_configuration`, `work_end_time`, `enable_leave_days`, `enable_permission_hours`, `leave_carry_forward`, `monthly_permission_hours`, `monthly_leave_days`, `permission_carry_forward`, `work_start_time`, `institution_id`) VALUES
(1, '19:30:00', 0, 0, 0, 0, 0, 0, '09:30:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_attendance_punch`
--

CREATE TABLE `tbl_staff_attendance_punch` (
  `staff_attendance_punch_id` bigint(20) NOT NULL,
  `punch_time` time NOT NULL,
  `staff_attendance_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff_attendance_punch`
--

INSERT INTO `tbl_staff_attendance_punch` (`staff_attendance_punch_id`, `punch_time`, `staff_attendance_id`) VALUES
(1, '15:09:00', 1),
(2, '15:10:00', 1),
(3, '09:31:00', 2),
(4, '21:30:00', 2),
(5, '09:31:00', 3),
(6, '20:35:00', 3),
(7, '09:31:00', 4),
(8, '20:35:00', 4),
(9, '09:31:00', 5),
(10, '20:35:00', 5),
(11, '09:31:00', 6),
(12, '20:35:00', 6),
(13, '09:31:00', 7),
(14, '20:35:00', 7),
(15, '09:31:00', 8),
(16, '20:35:00', 8),
(17, '09:31:00', 9),
(18, '20:35:00', 9),
(19, '09:31:00', 10),
(20, '20:35:00', 10),
(21, '09:31:00', 11),
(22, '20:35:00', 11),
(23, '09:31:00', 12),
(24, '20:35:00', 12),
(25, '09:31:00', 13),
(26, '20:35:00', 13),
(27, '09:31:00', 14),
(28, '20:35:00', 14),
(29, '09:31:00', 15),
(30, '20:35:00', 15),
(31, '09:31:00', 16),
(32, '20:35:00', 16),
(33, '09:31:00', 17),
(34, '20:35:00', 17),
(35, '09:31:00', 18),
(36, '20:35:00', 18),
(37, '09:31:00', 19),
(38, '20:35:00', 19),
(39, '09:31:00', 20),
(40, '20:35:00', 20),
(41, '09:31:00', 21),
(42, '20:35:00', 21),
(43, '09:31:00', 22),
(44, '20:35:00', 22),
(45, '09:31:00', 23),
(46, '20:35:00', 23),
(47, '09:31:00', 24),
(48, '20:35:00', 24),
(49, '09:31:00', 25),
(50, '20:35:00', 25),
(51, '09:31:00', 26),
(52, '20:35:00', 26),
(53, '09:31:00', 27),
(54, '20:35:00', 27),
(55, '09:31:00', 28),
(56, '20:35:00', 28),
(57, '09:31:00', 29),
(58, '20:35:00', 29),
(59, '09:31:00', 30),
(60, '20:35:00', 30),
(61, '15:15:00', 11);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_bank_detail`
--

CREATE TABLE `tbl_staff_bank_detail` (
  `staff_bank_detail_id` bigint(20) NOT NULL,
  `staff_bank_account_no` varchar(100) DEFAULT NULL,
  `staff_bank_ifsc_code` varchar(100) DEFAULT NULL,
  `staff_bank_name` varchar(100) DEFAULT NULL,
  `staff_bank_detail_createdBy` varchar(100) NOT NULL,
  `staff_bank_detail_created_date` datetime NOT NULL,
  `staff_bank_detail_modifiedBy` varchar(100) NOT NULL,
  `staff_bank_detail_last_modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `staff_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff_bank_detail`
--

INSERT INTO `tbl_staff_bank_detail` (`staff_bank_detail_id`, `staff_bank_account_no`, `staff_bank_ifsc_code`, `staff_bank_name`, `staff_bank_detail_createdBy`, `staff_bank_detail_created_date`, `staff_bank_detail_modifiedBy`, `staff_bank_detail_last_modified_date`, `staff_id`) VALUES
(1, '', '', '', 'default', '2017-04-03 11:46:39', 'default', '2017-04-03 06:16:40', 1),
(2, '', '', '', 'admin@jdsoft.in', '2017-04-03 11:53:23', 'admin@jdsoft.in', '2017-04-03 06:23:23', 2),
(3, '', '', '', 'admin@jdsoft.in', '2017-04-03 11:55:42', 'admin@jdsoft.in', '2017-04-03 06:25:42', 3),
(4, '', '', '', 'admin@jdsoft.in', '2017-04-03 11:58:23', 'admin@jdsoft.in', '2017-04-03 06:28:23', 4),
(5, '', '', '', 'admin@jdsoft.in', '2017-04-03 12:03:09', 'admin@jdsoft.in', '2017-04-03 06:33:09', 5),
(6, '', '', '', 'admin@jdsoft.in', '2017-04-03 12:04:48', 'admin@jdsoft.in', '2017-04-03 06:34:48', 6);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_designation`
--

CREATE TABLE `tbl_staff_designation` (
  `staff_designation_id` bigint(20) NOT NULL,
  `staff_designation_createdBy` varchar(100) NOT NULL,
  `staff_designation_created_date` datetime NOT NULL,
  `staff_designation_modifiedBy` varchar(100) NOT NULL,
  `staff_designation_last_modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `staff_designation_name` varchar(150) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `staff_type_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff_designation`
--

INSERT INTO `tbl_staff_designation` (`staff_designation_id`, `staff_designation_createdBy`, `staff_designation_created_date`, `staff_designation_modifiedBy`, `staff_designation_last_modified_date`, `staff_designation_name`, `institution_id`, `staff_type_id`) VALUES
(1, 'default', '2017-04-03 11:46:39', 'default', '2017-04-03 06:16:40', 'Administrator', 1, 2),
(2, 'admin@jdsoft.in', '2017-04-03 11:50:49', 'admin@jdsoft.in', '2017-04-03 06:20:49', 'Assistant Professor', 1, 1),
(3, 'admin@jdsoft.in', '2017-04-03 11:51:00', 'admin@jdsoft.in', '2017-04-03 06:21:00', 'Associate Professor', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_experience_detail`
--

CREATE TABLE `tbl_staff_experience_detail` (
  `staff_experience_detail_id` bigint(20) NOT NULL,
  `staff_experience_detail_createdBy` varchar(100) NOT NULL,
  `staff_experience_detail_created_date` datetime NOT NULL,
  `staff_experience_detail_end_date` datetime DEFAULT NULL,
  `staff_previous_experience` double DEFAULT NULL,
  `staff_experience_detail_modifiedBy` varchar(100) NOT NULL,
  `staff_experience_detail_last_modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `staff_previous_designation` varchar(200) DEFAULT NULL,
  `staff_experience_detail_start_date` datetime DEFAULT NULL,
  `staff_worked_organisation_name` varchar(255) DEFAULT NULL,
  `staff_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_leave_requisition`
--

CREATE TABLE `tbl_staff_leave_requisition` (
  `staff_leave_requisition_id` bigint(20) NOT NULL,
  `approval_status` varchar(255) NOT NULL,
  `approval_by` varchar(255) NOT NULL,
  `created_date` date NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `leave_end_date` date NOT NULL,
  `staff_leave_reason` varchar(255) NOT NULL,
  `leave_start_date` date NOT NULL,
  `approver_id` bigint(20) NOT NULL,
  `portal_task_id` bigint(20) NOT NULL,
  `staff_id` bigint(20) NOT NULL,
  `staff_leave_type_id` bigint(20) NOT NULL,
  `partially_leave_end_date` date DEFAULT NULL,
  `partially_leave_start_date` date DEFAULT NULL,
  `approver_comments` varchar(255) DEFAULT NULL,
  `requisition_type_id` bigint(20) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `modified_by` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff_leave_requisition`
--

INSERT INTO `tbl_staff_leave_requisition` (`staff_leave_requisition_id`, `approval_status`, `approval_by`, `created_date`, `modified_date`, `leave_end_date`, `staff_leave_reason`, `leave_start_date`, `approver_id`, `portal_task_id`, `staff_id`, `staff_leave_type_id`, `partially_leave_end_date`, `partially_leave_start_date`, `approver_comments`, `requisition_type_id`, `created_by`, `modified_by`) VALUES
(1, 'Pending', 'Pending', '2017-05-10', '2017-05-10 13:52:01', '2017-05-10', 'Fever', '2017-05-10', 1, 20, 2, 1, NULL, NULL, NULL, 1, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_leave_type`
--

CREATE TABLE `tbl_staff_leave_type` (
  `staff_leave_type_id` bigint(20) NOT NULL,
  `staff_leave_type` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff_leave_type`
--

INSERT INTO `tbl_staff_leave_type` (`staff_leave_type_id`, `staff_leave_type`) VALUES
(1, 'Sick Leave'),
(2, 'Paid Leave'),
(3, 'Casual Leave'),
(4, 'Medical Leave'),
(5, 'Personal Leave'),
(6, 'Annual Leave');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_module_attendance`
--

CREATE TABLE `tbl_staff_module_attendance` (
  `staff_module_attendance_id` bigint(20) NOT NULL,
  `attendance_date` date NOT NULL,
  `attendance_time` time NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `class_section_module_id` bigint(20) NOT NULL,
  `section_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `student_attendance_type_id` bigint(20) NOT NULL,
  `class_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff_module_attendance`
--

INSERT INTO `tbl_staff_module_attendance` (`staff_module_attendance_id`, `attendance_date`, `attendance_time`, `academic_year_id`, `class_section_module_id`, `section_id`, `student_id`, `student_attendance_type_id`, `class_id`) VALUES
(223, '2017-04-19', '19:22:00', 1, 1, 1, 1, 1, 1),
(224, '2017-04-19', '19:22:00', 1, 1, 1, 2, 1, 1),
(225, '2017-04-19', '19:22:00', 1, 1, 1, 3, 1, 1),
(226, '2017-04-19', '19:22:00', 1, 1, 1, 4, 1, 1),
(227, '2017-04-19', '19:22:00', 1, 1, 1, 5, 2, 1),
(228, '2017-04-19', '19:22:00', 1, 1, 1, 6, 1, 1),
(229, '2017-04-19', '19:22:00', 1, 1, 1, 7, 1, 1),
(230, '2017-04-19', '19:22:00', 1, 1, 1, 8, 1, 1),
(231, '2017-04-19', '19:22:00', 1, 1, 1, 9, 3, 1),
(232, '2017-04-19', '19:22:00', 1, 1, 1, 10, 3, 1),
(233, '2017-04-19', '19:22:00', 1, 1, 1, 11, 1, 1),
(234, '2017-04-19', '19:22:00', 1, 1, 1, 12, 1, 1),
(235, '2017-04-19', '19:22:00', 1, 1, 1, 13, 1, 1),
(236, '2017-04-19', '19:22:00', 1, 1, 1, 14, 3, 1),
(237, '2017-04-19', '19:22:00', 1, 1, 1, 15, 3, 1),
(238, '2017-04-19', '19:22:00', 1, 1, 1, 16, 1, 1),
(239, '2017-04-19', '19:22:00', 1, 1, 1, 17, 1, 1),
(240, '2017-04-19', '19:22:00', 1, 1, 1, 18, 1, 1),
(241, '2017-04-19', '19:22:00', 1, 1, 1, 19, 1, 1),
(242, '2017-04-19', '19:22:00', 1, 1, 1, 20, 1, 1),
(243, '2017-04-19', '19:22:00', 1, 1, 1, 21, 1, 1),
(244, '2017-04-19', '19:22:00', 1, 1, 1, 22, 1, 1),
(245, '2017-04-19', '19:22:00', 1, 1, 1, 23, 1, 1),
(246, '2017-04-19', '19:22:00', 1, 1, 1, 24, 2, 1),
(247, '2017-04-19', '19:22:00', 1, 1, 1, 25, 2, 1),
(248, '2017-04-19', '19:22:00', 1, 1, 1, 26, 1, 1),
(249, '2017-04-19', '19:22:00', 1, 1, 1, 27, 1, 1),
(250, '2017-04-19', '19:22:00', 1, 1, 1, 28, 1, 1),
(251, '2017-04-19', '19:22:00', 1, 1, 1, 29, 3, 1),
(252, '2017-04-19', '19:22:00', 1, 1, 1, 30, 1, 1),
(253, '2017-04-19', '19:22:00', 1, 1, 1, 31, 1, 1),
(254, '2017-04-19', '19:22:00', 1, 1, 1, 32, 1, 1),
(255, '2017-04-19', '19:22:00', 1, 1, 1, 33, 1, 1),
(256, '2017-04-19', '19:22:00', 1, 1, 1, 34, 1, 1),
(257, '2017-04-19', '19:22:00', 1, 1, 1, 35, 2, 1),
(258, '2017-04-19', '19:22:00', 1, 1, 1, 36, 2, 1),
(259, '2017-04-19', '19:22:00', 1, 1, 1, 37, 1, 1),
(260, '2017-04-19', '19:22:00', 1, 1, 1, 38, 1, 1),
(261, '2017-04-19', '19:22:00', 1, 1, 1, 39, 1, 1),
(262, '2017-04-19', '19:22:00', 1, 1, 1, 40, 1, 1),
(263, '2017-04-19', '19:22:00', 1, 1, 1, 41, 1, 1),
(264, '2017-04-19', '19:22:00', 1, 1, 1, 42, 1, 1),
(265, '2017-04-19', '19:22:00', 1, 1, 1, 43, 1, 1),
(266, '2017-04-19', '19:22:00', 1, 1, 1, 44, 1, 1),
(267, '2017-04-19', '19:22:00', 1, 1, 1, 45, 1, 1),
(268, '2017-04-19', '19:22:00', 1, 1, 1, 46, 1, 1),
(269, '2017-04-19', '19:22:00', 1, 1, 1, 47, 1, 1),
(270, '2017-04-19', '19:22:00', 1, 1, 1, 48, 3, 1),
(271, '2017-04-19', '19:22:00', 1, 1, 1, 49, 3, 1),
(272, '2017-04-19', '19:22:00', 1, 1, 1, 50, 1, 1),
(273, '2017-04-19', '19:22:00', 1, 1, 1, 51, 3, 1),
(274, '2017-04-19', '19:22:00', 1, 1, 1, 52, 1, 1),
(275, '2017-04-19', '19:22:00', 1, 1, 1, 53, 1, 1),
(276, '2017-04-19', '19:22:00', 1, 1, 1, 54, 1, 1),
(277, '2017-04-19', '19:22:00', 1, 1, 1, 55, 1, 1),
(278, '2017-04-19', '19:22:00', 1, 1, 1, 56, 1, 1),
(279, '2017-04-19', '19:22:00', 1, 1, 1, 57, 2, 1),
(280, '2017-04-19', '19:22:00', 1, 1, 1, 58, 1, 1),
(281, '2017-04-19', '19:22:00', 1, 1, 1, 59, 1, 1),
(282, '2017-04-19', '19:22:00', 1, 1, 1, 60, 3, 1),
(283, '2017-04-19', '19:22:00', 1, 1, 1, 61, 3, 1),
(284, '2017-04-19', '19:22:00', 1, 1, 1, 62, 1, 1),
(285, '2017-04-19', '19:22:00', 1, 1, 1, 63, 1, 1),
(286, '2017-04-19', '19:22:00', 1, 1, 1, 64, 1, 1),
(287, '2017-04-19', '19:22:00', 1, 1, 1, 65, 1, 1),
(288, '2017-04-19', '19:22:00', 1, 1, 1, 66, 1, 1),
(289, '2017-04-19', '19:22:00', 1, 1, 1, 67, 1, 1),
(290, '2017-04-19', '19:22:00', 1, 1, 1, 68, 1, 1),
(291, '2017-04-19', '19:22:00', 1, 1, 1, 69, 1, 1),
(292, '2017-04-19', '19:22:00', 1, 1, 1, 70, 1, 1),
(293, '2017-04-19', '19:22:00', 1, 1, 1, 71, 1, 1),
(294, '2017-04-19', '19:22:00', 1, 1, 1, 72, 1, 1),
(295, '2017-04-19', '19:22:00', 1, 1, 1, 73, 1, 1),
(296, '2017-04-19', '19:22:00', 1, 1, 1, 74, 1, 1),
(297, '2017-04-19', '19:22:00', 1, 1, 1, 75, 1, 1),
(298, '2017-04-19', '19:22:00', 1, 1, 1, 76, 1, 1),
(299, '2017-04-19', '19:22:00', 1, 1, 1, 77, 1, 1),
(300, '2017-04-19', '19:22:00', 1, 1, 1, 78, 1, 1),
(301, '2017-04-19', '19:22:00', 1, 1, 1, 79, 1, 1),
(302, '2017-04-19', '19:22:00', 1, 1, 1, 80, 1, 1),
(303, '2017-04-19', '19:22:00', 1, 1, 1, 81, 1, 1),
(304, '2017-04-19', '19:22:00', 1, 1, 1, 82, 1, 1),
(305, '2017-04-19', '19:22:00', 1, 1, 1, 83, 1, 1),
(306, '2017-04-19', '19:22:00', 1, 1, 1, 84, 1, 1),
(307, '2017-04-19', '19:22:00', 1, 1, 1, 85, 1, 1),
(308, '2017-04-19', '19:22:00', 1, 1, 1, 86, 1, 1),
(309, '2017-04-19', '19:22:00', 1, 1, 1, 87, 1, 1),
(310, '2017-04-19', '19:22:00', 1, 1, 1, 88, 1, 1),
(311, '2017-04-19', '19:22:00', 1, 1, 1, 89, 1, 1),
(312, '2017-04-19', '19:22:00', 1, 1, 1, 90, 1, 1),
(313, '2017-04-19', '19:22:00', 1, 1, 1, 91, 1, 1),
(314, '2017-04-19', '19:22:00', 1, 1, 1, 92, 1, 1),
(315, '2017-04-19', '19:22:00', 1, 1, 1, 93, 1, 1),
(316, '2017-04-19', '19:22:00', 1, 1, 1, 94, 1, 1),
(317, '2017-04-19', '19:22:00', 1, 1, 1, 95, 1, 1),
(318, '2017-04-19', '19:22:00', 1, 1, 1, 96, 1, 1),
(319, '2017-04-19', '19:22:00', 1, 1, 1, 97, 1, 1),
(320, '2017-04-19', '19:22:00', 1, 1, 1, 98, 1, 1),
(321, '2017-04-19', '19:22:00', 1, 1, 1, 99, 1, 1),
(322, '2017-04-19', '19:22:00', 1, 1, 1, 100, 1, 1),
(323, '2017-04-19', '19:22:00', 1, 1, 1, 101, 1, 1),
(324, '2017-04-19', '19:22:00', 1, 1, 1, 102, 1, 1),
(325, '2017-04-19', '19:22:00', 1, 1, 1, 103, 1, 1),
(326, '2017-04-19', '19:22:00', 1, 1, 1, 104, 1, 1),
(327, '2017-04-19', '19:22:00', 1, 1, 1, 105, 1, 1),
(328, '2017-04-19', '19:22:00', 1, 1, 1, 106, 1, 1),
(329, '2017-04-19', '19:22:00', 1, 1, 1, 107, 1, 1),
(330, '2017-04-19', '19:22:00', 1, 1, 1, 108, 1, 1),
(331, '2017-04-19', '19:22:00', 1, 1, 1, 109, 1, 1),
(332, '2017-04-19', '19:22:00', 1, 1, 1, 110, 1, 1),
(333, '2017-04-19', '19:22:00', 1, 1, 1, 111, 1, 1),
(334, '2017-04-24', '12:06:00', 1, 2, 1, 1, 1, 1),
(335, '2017-04-24', '12:06:00', 1, 2, 1, 2, 1, 1),
(336, '2017-04-24', '12:06:00', 1, 2, 1, 3, 2, 1),
(337, '2017-04-24', '12:06:00', 1, 2, 1, 4, 1, 1),
(338, '2017-04-24', '12:06:00', 1, 2, 1, 5, 1, 1),
(339, '2017-04-24', '12:06:00', 1, 2, 1, 6, 1, 1),
(340, '2017-04-24', '12:06:00', 1, 2, 1, 7, 1, 1),
(341, '2017-04-24', '12:06:00', 1, 2, 1, 8, 2, 1),
(342, '2017-04-24', '12:06:00', 1, 2, 1, 9, 1, 1),
(343, '2017-04-24', '12:06:00', 1, 2, 1, 10, 1, 1),
(344, '2017-04-24', '12:06:00', 1, 2, 1, 11, 1, 1),
(345, '2017-04-24', '12:06:00', 1, 2, 1, 12, 1, 1),
(346, '2017-04-24', '12:06:00', 1, 2, 1, 13, 1, 1),
(347, '2017-04-24', '12:06:00', 1, 2, 1, 14, 2, 1),
(348, '2017-04-24', '12:06:00', 1, 2, 1, 15, 1, 1),
(349, '2017-04-24', '12:06:00', 1, 2, 1, 16, 1, 1),
(350, '2017-04-24', '12:06:00', 1, 2, 1, 17, 1, 1),
(351, '2017-04-24', '12:06:00', 1, 2, 1, 18, 1, 1),
(352, '2017-04-24', '12:06:00', 1, 2, 1, 19, 1, 1),
(353, '2017-04-24', '12:06:00', 1, 2, 1, 20, 2, 1),
(354, '2017-04-24', '12:06:00', 1, 2, 1, 21, 1, 1),
(355, '2017-04-24', '12:06:00', 1, 2, 1, 22, 1, 1),
(356, '2017-04-24', '12:06:00', 1, 2, 1, 23, 1, 1),
(357, '2017-04-24', '12:06:00', 1, 2, 1, 24, 1, 1),
(358, '2017-04-24', '12:06:00', 1, 2, 1, 25, 3, 1),
(359, '2017-04-24', '12:06:00', 1, 2, 1, 26, 1, 1),
(360, '2017-04-24', '12:06:00', 1, 2, 1, 27, 3, 1),
(361, '2017-04-24', '12:06:00', 1, 2, 1, 28, 3, 1),
(362, '2017-04-24', '12:06:00', 1, 2, 1, 29, 1, 1),
(363, '2017-04-24', '12:06:00', 1, 2, 1, 30, 1, 1),
(364, '2017-04-24', '12:06:00', 1, 2, 1, 31, 1, 1),
(365, '2017-04-24', '12:06:00', 1, 2, 1, 32, 3, 1),
(366, '2017-04-24', '12:06:00', 1, 2, 1, 33, 1, 1),
(367, '2017-04-24', '12:06:00', 1, 2, 1, 34, 1, 1),
(368, '2017-04-24', '12:06:00', 1, 2, 1, 35, 1, 1),
(369, '2017-04-24', '12:06:00', 1, 2, 1, 36, 1, 1),
(370, '2017-04-24', '12:06:00', 1, 2, 1, 37, 1, 1),
(371, '2017-04-24', '12:06:00', 1, 2, 1, 38, 1, 1),
(372, '2017-04-24', '12:06:00', 1, 2, 1, 39, 1, 1),
(373, '2017-04-24', '12:06:00', 1, 2, 1, 40, 1, 1),
(374, '2017-04-24', '12:06:00', 1, 2, 1, 41, 1, 1),
(375, '2017-04-24', '12:06:00', 1, 2, 1, 42, 1, 1),
(376, '2017-04-24', '12:06:00', 1, 2, 1, 43, 2, 1),
(377, '2017-04-24', '12:06:00', 1, 2, 1, 44, 1, 1),
(378, '2017-04-24', '12:06:00', 1, 2, 1, 45, 1, 1),
(379, '2017-04-24', '12:06:00', 1, 2, 1, 46, 1, 1),
(380, '2017-04-24', '12:06:00', 1, 2, 1, 47, 2, 1),
(381, '2017-04-24', '12:06:00', 1, 2, 1, 48, 1, 1),
(382, '2017-04-24', '12:06:00', 1, 2, 1, 49, 1, 1),
(383, '2017-04-24', '12:06:00', 1, 2, 1, 50, 2, 1),
(384, '2017-04-24', '12:06:00', 1, 2, 1, 51, 1, 1),
(385, '2017-04-24', '12:06:00', 1, 2, 1, 52, 1, 1),
(386, '2017-04-24', '12:06:00', 1, 2, 1, 53, 1, 1),
(387, '2017-04-24', '12:06:00', 1, 2, 1, 54, 1, 1),
(388, '2017-04-24', '12:06:00', 1, 2, 1, 55, 1, 1),
(389, '2017-04-24', '12:06:00', 1, 2, 1, 56, 1, 1),
(390, '2017-04-24', '12:06:00', 1, 2, 1, 57, 1, 1),
(391, '2017-04-24', '12:06:00', 1, 2, 1, 58, 1, 1),
(392, '2017-04-24', '12:06:00', 1, 2, 1, 59, 1, 1),
(393, '2017-04-24', '12:06:00', 1, 2, 1, 60, 1, 1),
(394, '2017-04-24', '12:06:00', 1, 2, 1, 61, 2, 1),
(395, '2017-04-24', '12:06:00', 1, 2, 1, 62, 1, 1),
(396, '2017-04-24', '12:06:00', 1, 2, 1, 63, 1, 1),
(397, '2017-04-24', '12:06:00', 1, 2, 1, 64, 1, 1),
(398, '2017-04-24', '12:06:00', 1, 2, 1, 65, 1, 1),
(399, '2017-04-24', '12:06:00', 1, 2, 1, 66, 1, 1),
(400, '2017-04-24', '12:06:00', 1, 2, 1, 67, 1, 1),
(401, '2017-04-24', '12:06:00', 1, 2, 1, 68, 1, 1),
(402, '2017-04-24', '12:06:00', 1, 2, 1, 69, 1, 1),
(403, '2017-04-24', '12:06:00', 1, 2, 1, 70, 1, 1),
(404, '2017-04-24', '12:06:00', 1, 2, 1, 71, 1, 1),
(405, '2017-04-24', '12:06:00', 1, 2, 1, 72, 2, 1),
(406, '2017-04-24', '12:06:00', 1, 2, 1, 73, 1, 1),
(407, '2017-04-24', '12:06:00', 1, 2, 1, 74, 2, 1),
(408, '2017-04-24', '12:06:00', 1, 2, 1, 75, 1, 1),
(409, '2017-04-24', '12:06:00', 1, 2, 1, 76, 1, 1),
(410, '2017-04-24', '12:06:00', 1, 2, 1, 77, 1, 1),
(411, '2017-04-24', '12:06:00', 1, 2, 1, 78, 1, 1),
(412, '2017-04-24', '12:06:00', 1, 2, 1, 79, 1, 1),
(413, '2017-04-24', '12:06:00', 1, 2, 1, 80, 1, 1),
(414, '2017-04-24', '12:06:00', 1, 2, 1, 81, 1, 1),
(415, '2017-04-24', '12:06:00', 1, 2, 1, 82, 1, 1),
(416, '2017-04-24', '12:06:00', 1, 2, 1, 83, 1, 1),
(417, '2017-04-24', '12:06:00', 1, 2, 1, 84, 1, 1),
(418, '2017-04-24', '12:06:00', 1, 2, 1, 85, 1, 1),
(419, '2017-04-24', '12:06:00', 1, 2, 1, 86, 1, 1),
(420, '2017-04-24', '12:06:00', 1, 2, 1, 87, 1, 1),
(421, '2017-04-24', '12:06:00', 1, 2, 1, 88, 1, 1),
(422, '2017-04-24', '12:06:00', 1, 2, 1, 89, 1, 1),
(423, '2017-04-24', '12:06:00', 1, 2, 1, 90, 1, 1),
(424, '2017-04-24', '12:06:00', 1, 2, 1, 91, 1, 1),
(425, '2017-04-24', '12:06:00', 1, 2, 1, 92, 1, 1),
(426, '2017-04-24', '12:06:00', 1, 2, 1, 93, 1, 1),
(427, '2017-04-24', '12:06:00', 1, 2, 1, 94, 1, 1),
(428, '2017-04-24', '12:06:00', 1, 2, 1, 95, 1, 1),
(429, '2017-04-24', '12:06:00', 1, 2, 1, 96, 1, 1),
(430, '2017-04-24', '12:06:00', 1, 2, 1, 97, 1, 1),
(431, '2017-04-24', '12:06:00', 1, 2, 1, 98, 1, 1),
(432, '2017-04-24', '12:06:00', 1, 2, 1, 99, 1, 1),
(433, '2017-04-24', '12:06:00', 1, 2, 1, 100, 1, 1),
(434, '2017-04-24', '12:06:00', 1, 2, 1, 101, 1, 1),
(435, '2017-04-24', '12:06:00', 1, 2, 1, 102, 1, 1),
(436, '2017-04-24', '12:06:00', 1, 2, 1, 103, 1, 1),
(437, '2017-04-24', '12:06:00', 1, 2, 1, 104, 1, 1),
(438, '2017-04-24', '12:06:00', 1, 2, 1, 105, 1, 1),
(439, '2017-04-24', '12:06:00', 1, 2, 1, 106, 1, 1),
(440, '2017-04-24', '12:06:00', 1, 2, 1, 107, 1, 1),
(441, '2017-04-24', '12:06:00', 1, 2, 1, 108, 1, 1),
(442, '2017-04-24', '12:06:00', 1, 2, 1, 109, 1, 1),
(443, '2017-04-24', '12:06:00', 1, 2, 1, 110, 1, 1),
(444, '2017-04-24', '12:06:00', 1, 2, 1, 111, 1, 1),
(445, '2017-04-24', '14:11:00', 1, 1, 1, 1, 1, 1),
(446, '2017-04-24', '14:11:00', 1, 1, 1, 2, 2, 1),
(447, '2017-04-24', '14:11:00', 1, 1, 1, 3, 1, 1),
(448, '2017-04-24', '14:11:00', 1, 1, 1, 4, 1, 1),
(449, '2017-04-24', '14:11:00', 1, 1, 1, 5, 1, 1),
(450, '2017-04-24', '14:11:00', 1, 1, 1, 6, 2, 1),
(451, '2017-04-24', '14:11:00', 1, 1, 1, 7, 1, 1),
(452, '2017-04-24', '14:11:00', 1, 1, 1, 8, 3, 1),
(453, '2017-04-24', '14:11:00', 1, 1, 1, 9, 1, 1),
(454, '2017-04-24', '14:11:00', 1, 1, 1, 10, 1, 1),
(455, '2017-04-24', '14:11:00', 1, 1, 1, 11, 1, 1),
(456, '2017-04-24', '14:11:00', 1, 1, 1, 12, 1, 1),
(457, '2017-04-24', '14:11:00', 1, 1, 1, 13, 1, 1),
(458, '2017-04-24', '14:11:00', 1, 1, 1, 14, 1, 1),
(459, '2017-04-24', '14:11:00', 1, 1, 1, 15, 1, 1),
(460, '2017-04-24', '14:11:00', 1, 1, 1, 16, 1, 1),
(461, '2017-04-24', '14:11:00', 1, 1, 1, 17, 2, 1),
(462, '2017-04-24', '14:11:00', 1, 1, 1, 18, 1, 1),
(463, '2017-04-24', '14:11:00', 1, 1, 1, 19, 3, 1),
(464, '2017-04-24', '14:11:00', 1, 1, 1, 20, 1, 1),
(465, '2017-04-24', '14:11:00', 1, 1, 1, 21, 2, 1),
(466, '2017-04-24', '14:11:00', 1, 1, 1, 22, 1, 1),
(467, '2017-04-24', '14:11:00', 1, 1, 1, 23, 1, 1),
(468, '2017-04-24', '14:11:00', 1, 1, 1, 24, 1, 1),
(469, '2017-04-24', '14:11:00', 1, 1, 1, 25, 1, 1),
(470, '2017-04-24', '14:11:00', 1, 1, 1, 26, 1, 1),
(471, '2017-04-24', '14:11:00', 1, 1, 1, 27, 1, 1),
(472, '2017-04-24', '14:11:00', 1, 1, 1, 28, 3, 1),
(473, '2017-04-24', '14:11:00', 1, 1, 1, 29, 1, 1),
(474, '2017-04-24', '14:11:00', 1, 1, 1, 30, 2, 1),
(475, '2017-04-24', '14:11:00', 1, 1, 1, 31, 1, 1),
(476, '2017-04-24', '14:11:00', 1, 1, 1, 32, 3, 1),
(477, '2017-04-24', '14:11:00', 1, 1, 1, 33, 1, 1),
(478, '2017-04-24', '14:11:00', 1, 1, 1, 34, 2, 1),
(479, '2017-04-24', '14:11:00', 1, 1, 1, 35, 1, 1),
(480, '2017-04-24', '14:11:00', 1, 1, 1, 36, 1, 1),
(481, '2017-04-24', '14:11:00', 1, 1, 1, 37, 1, 1),
(482, '2017-04-24', '14:11:00', 1, 1, 1, 38, 1, 1),
(483, '2017-04-24', '14:11:00', 1, 1, 1, 39, 1, 1),
(484, '2017-04-24', '14:11:00', 1, 1, 1, 40, 1, 1),
(485, '2017-04-24', '14:11:00', 1, 1, 1, 41, 1, 1),
(486, '2017-04-24', '14:11:00', 1, 1, 1, 42, 1, 1),
(487, '2017-04-24', '14:11:00', 1, 1, 1, 43, 1, 1),
(488, '2017-04-24', '14:11:00', 1, 1, 1, 44, 2, 1),
(489, '2017-04-24', '14:11:00', 1, 1, 1, 45, 1, 1),
(490, '2017-04-24', '14:11:00', 1, 1, 1, 46, 3, 1),
(491, '2017-04-24', '14:11:00', 1, 1, 1, 47, 1, 1),
(492, '2017-04-24', '14:11:00', 1, 1, 1, 48, 1, 1),
(493, '2017-04-24', '14:11:00', 1, 1, 1, 49, 1, 1),
(494, '2017-04-24', '14:11:00', 1, 1, 1, 50, 1, 1),
(495, '2017-04-24', '14:11:00', 1, 1, 1, 51, 1, 1),
(496, '2017-04-24', '14:11:00', 1, 1, 1, 52, 1, 1),
(497, '2017-04-24', '14:11:00', 1, 1, 1, 53, 1, 1),
(498, '2017-04-24', '14:11:00', 1, 1, 1, 54, 1, 1),
(499, '2017-04-24', '14:11:00', 1, 1, 1, 55, 1, 1),
(500, '2017-04-24', '14:11:00', 1, 1, 1, 56, 1, 1),
(501, '2017-04-24', '14:11:00', 1, 1, 1, 57, 2, 1),
(502, '2017-04-24', '14:11:00', 1, 1, 1, 58, 1, 1),
(503, '2017-04-24', '14:11:00', 1, 1, 1, 59, 1, 1),
(504, '2017-04-24', '14:11:00', 1, 1, 1, 60, 3, 1),
(505, '2017-04-24', '14:11:00', 1, 1, 1, 61, 1, 1),
(506, '2017-04-24', '14:11:00', 1, 1, 1, 62, 1, 1),
(507, '2017-04-24', '14:11:00', 1, 1, 1, 63, 1, 1),
(508, '2017-04-24', '14:11:00', 1, 1, 1, 64, 1, 1),
(509, '2017-04-24', '14:11:00', 1, 1, 1, 65, 1, 1),
(510, '2017-04-24', '14:11:00', 1, 1, 1, 66, 1, 1),
(511, '2017-04-24', '14:11:00', 1, 1, 1, 67, 1, 1),
(512, '2017-04-24', '14:11:00', 1, 1, 1, 68, 1, 1),
(513, '2017-04-24', '14:11:00', 1, 1, 1, 69, 1, 1),
(514, '2017-04-24', '14:11:00', 1, 1, 1, 70, 1, 1),
(515, '2017-04-24', '14:11:00', 1, 1, 1, 71, 2, 1),
(516, '2017-04-24', '14:11:00', 1, 1, 1, 72, 1, 1),
(517, '2017-04-24', '14:11:00', 1, 1, 1, 73, 1, 1),
(518, '2017-04-24', '14:11:00', 1, 1, 1, 74, 1, 1),
(519, '2017-04-24', '14:11:00', 1, 1, 1, 75, 1, 1),
(520, '2017-04-24', '14:11:00', 1, 1, 1, 76, 1, 1),
(521, '2017-04-24', '14:11:00', 1, 1, 1, 77, 1, 1),
(522, '2017-04-24', '14:11:00', 1, 1, 1, 78, 1, 1),
(523, '2017-04-24', '14:11:00', 1, 1, 1, 79, 1, 1),
(524, '2017-04-24', '14:11:00', 1, 1, 1, 80, 1, 1),
(525, '2017-04-24', '14:11:00', 1, 1, 1, 81, 1, 1),
(526, '2017-04-24', '14:11:00', 1, 1, 1, 82, 1, 1),
(527, '2017-04-24', '14:11:00', 1, 1, 1, 83, 1, 1),
(528, '2017-04-24', '14:11:00', 1, 1, 1, 84, 1, 1),
(529, '2017-04-24', '14:11:00', 1, 1, 1, 85, 1, 1),
(530, '2017-04-24', '14:11:00', 1, 1, 1, 86, 1, 1),
(531, '2017-04-24', '14:11:00', 1, 1, 1, 87, 1, 1),
(532, '2017-04-24', '14:11:00', 1, 1, 1, 88, 1, 1),
(533, '2017-04-24', '14:11:00', 1, 1, 1, 89, 1, 1),
(534, '2017-04-24', '14:11:00', 1, 1, 1, 90, 1, 1),
(535, '2017-04-24', '14:11:00', 1, 1, 1, 91, 1, 1),
(536, '2017-04-24', '14:11:00', 1, 1, 1, 92, 1, 1),
(537, '2017-04-24', '14:11:00', 1, 1, 1, 93, 1, 1),
(538, '2017-04-24', '14:11:00', 1, 1, 1, 94, 1, 1),
(539, '2017-04-24', '14:11:00', 1, 1, 1, 95, 1, 1),
(540, '2017-04-24', '14:11:00', 1, 1, 1, 96, 1, 1),
(541, '2017-04-24', '14:11:00', 1, 1, 1, 97, 1, 1),
(542, '2017-04-24', '14:11:00', 1, 1, 1, 98, 1, 1),
(543, '2017-04-24', '14:11:00', 1, 1, 1, 99, 1, 1),
(544, '2017-04-24', '14:11:00', 1, 1, 1, 100, 1, 1),
(545, '2017-04-24', '14:11:00', 1, 1, 1, 101, 1, 1),
(546, '2017-04-24', '14:11:00', 1, 1, 1, 102, 1, 1),
(547, '2017-04-24', '14:11:00', 1, 1, 1, 103, 1, 1),
(548, '2017-04-24', '14:11:00', 1, 1, 1, 104, 1, 1),
(549, '2017-04-24', '14:11:00', 1, 1, 1, 105, 1, 1),
(550, '2017-04-24', '14:11:00', 1, 1, 1, 106, 1, 1),
(551, '2017-04-24', '14:11:00', 1, 1, 1, 107, 1, 1),
(552, '2017-04-24', '14:11:00', 1, 1, 1, 108, 1, 1),
(553, '2017-04-24', '14:11:00', 1, 1, 1, 109, 1, 1),
(554, '2017-04-24', '14:11:00', 1, 1, 1, 110, 1, 1),
(555, '2017-04-24', '14:11:00', 1, 1, 1, 111, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_moment_requisition`
--

CREATE TABLE `tbl_staff_moment_requisition` (
  `staff_moment_requisition_id` bigint(20) NOT NULL,
  `approval_status` varchar(255) NOT NULL,
  `approval_by` varchar(255) NOT NULL,
  `approver_comments` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` date NOT NULL,
  `end_time` time NOT NULL,
  `modified_by` varchar(255) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `request_reason` varchar(255) NOT NULL,
  `moment_requisition_date` date NOT NULL,
  `start_time` time NOT NULL,
  `portal_task_id` bigint(20) NOT NULL,
  `requisition_type_id` bigint(20) NOT NULL,
  `staff_id` bigint(20) NOT NULL,
  `staff_moment_approver_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff_moment_requisition`
--

INSERT INTO `tbl_staff_moment_requisition` (`staff_moment_requisition_id`, `approval_status`, `approval_by`, `approver_comments`, `created_by`, `created_date`, `end_time`, `modified_by`, `modified_date`, `request_reason`, `moment_requisition_date`, `start_time`, `portal_task_id`, `requisition_type_id`, `staff_id`, `staff_moment_approver_id`) VALUES
(1, 'Cancelled', 'Pending', NULL, 'dineshponrajdpr@gmail.com', '2017-05-16', '19:37:00', 'dineshponrajdpr@gmail.com', '2017-05-16 14:07:35', 'Sports Event', '2017-05-20', '09:37:00', 44, 2, 2, 1),
(2, 'Approved', 'admin@jdsoft.in', 'permission granted', 'dineshponrajdpr@gmail.com', '2017-05-16', '19:45:00', 'admin@jdsoft.in', '2017-05-16 14:15:34', 'Sports Event', '2017-05-22', '09:45:00', 45, 2, 2, 1),
(3, 'Pending', 'Pending', NULL, 'dineshponrajdpr@gmail.com', '2017-05-16', '19:45:00', 'dineshponrajdpr@gmail.com', '2017-05-16 14:15:59', 'Seminar', '2017-05-25', '09:45:00', 46, 2, 2, 1),
(4, 'Rejected', 'admin@jdsoft.in', 'Not Ok', 'dineshponrajdpr@gmail.com', '2017-05-16', '15:50:00', 'admin@jdsoft.in', '2017-05-16 14:20:26', 'Nothing', '2017-05-16', '11:50:00', 48, 2, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff_type`
--

CREATE TABLE `tbl_staff_type` (
  `staff_type_id` bigint(20) NOT NULL,
  `staff_type_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff_type`
--

INSERT INTO `tbl_staff_type` (`staff_type_id`, `staff_type_name`) VALUES
(2, 'Non-Teaching'),
(1, 'Teaching');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student`
--

CREATE TABLE `tbl_student` (
  `student_id` bigint(20) NOT NULL,
  `access_no` varchar(50) DEFAULT NULL,
  `address_line_1` varchar(255) DEFAULT NULL,
  `address_line_2` varchar(255) DEFAULT NULL,
  `admission_no` varchar(50) NOT NULL,
  `birth_date` date NOT NULL,
  `student_city` varchar(50) NOT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `student_country` varchar(50) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `email` varchar(100) NOT NULL,
  `fathers_income` double DEFAULT NULL,
  `first_name` varchar(100) NOT NULL,
  `joined_date` date NOT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mothers_income` double DEFAULT NULL,
  `parent_contact` varchar(20) DEFAULT NULL,
  `parent_guardian_email` varchar(100) DEFAULT NULL,
  `parent_guardian_first_name` varchar(100) NOT NULL,
  `parent_guardian_last_name` varchar(100) DEFAULT NULL,
  `passport_number` varchar(100) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  `roll_no` varchar(50) DEFAULT NULL,
  `scanned_signature` varchar(100) DEFAULT NULL,
  `sex` varchar(7) NOT NULL,
  `student_state` varchar(50) NOT NULL,
  `admission_id` bigint(20) DEFAULT NULL,
  `blood_group_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `institution_id` bigint(20) NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `joined_class_id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `section_id` bigint(20) NOT NULL,
  `student_class_id` bigint(20) NOT NULL,
  `student_status_id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `house_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student`
--

INSERT INTO `tbl_student` (`student_id`, `access_no`, `address_line_1`, `address_line_2`, `admission_no`, `birth_date`, `student_city`, `contact`, `student_country`, `created_by`, `created_date`, `email`, `fathers_income`, `first_name`, `joined_date`, `last_name`, `modified_by`, `modified_date`, `mothers_income`, `parent_contact`, `parent_guardian_email`, `parent_guardian_first_name`, `parent_guardian_last_name`, `passport_number`, `postcode`, `roll_no`, `scanned_signature`, `sex`, `student_state`, `admission_id`, `blood_group_id`, `category_id`, `institution_id`, `academic_year_id`, `joined_class_id`, `parent_id`, `section_id`, `student_class_id`, `student_status_id`, `user_id`, `house_id`) VALUES
(1, '', 'Line1', 'Line2', '123456', '2017-04-04', 'Tiruchirapalli', '8220723514', 'India', 'admin@jdsoft.in', '2017-04-04 10:28:05', 'anand@jdsoft.in', 25000, 'Jo', '2017-04-04', 'Anand', 'anand@jdsoft.in', '2017-05-17 01:34:57', 10000, '1234567890', 'parent.anand@jdsoft.in', 'FN', 'LN', '', '123131', NULL, '/resources/themes/images/student-signature/1494307729239IMG_335465.jpg', 'Male', 'Tamil Nadu', NULL, 4, 5, 1, 1, 1, 8, 1, 1, 1, 7, 1),
(2, '', 'VOC Street', 'Second Flate', '1001', '1993-08-09', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:43:54', 'Aachman@gmail.com', NULL, 'Aachman', '2012-08-09', '', 'admin@jdsoft.in', '2017-05-17 01:35:02', NULL, '3698521470', 'parent.Aachman@gmail.com', 'Aachman', '', '', '620018', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, 7, 5, 1, 1, 1, 10, 1, 1, 1, 11, 2),
(3, NULL, 'VOC Street', 'Second Flate', '1002', '1993-08-10', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:43:55', 'Aadesh@gmail.com', NULL, 'Aadesh', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-05-17 02:05:35', NULL, '3698521470', 'parent.Aadesh@gmail.com', 'Aadesh', NULL, NULL, '620019', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 12, 1, 1, 1, 13, 1),
(4, NULL, 'VOC Street', 'Second Flate', '1003', '1993-08-11', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:43:56', 'Aadi@gmail.com', NULL, 'Aadi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:03', NULL, '3698521470', 'parent.Aadi@gmail.com', 'Aadi', NULL, NULL, '620020', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 14, 1, 1, 1, 15, 1),
(5, NULL, 'VOC Street', 'Second Flate', '1004', '1993-08-12', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:43:56', 'Aafreen@gmail.com', NULL, 'Aafreen', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:03', NULL, '3698521470', 'parent.Aafreen@gmail.com', 'Aafreen', NULL, NULL, '620021', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 16, 1, 1, 1, 17, 1),
(6, NULL, 'VOC Street', 'Second Flate', '1005', '1993-08-13', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:43:57', 'Aakar@gmail.com', NULL, 'Aakar', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:03', NULL, '3698521470', 'parent.Aakar@gmail.com', 'Aakar', NULL, NULL, '620022', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 18, 1, 1, 1, 19, 1),
(7, NULL, 'VOC Street', 'Second Flate', '1006', '1993-08-14', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:43:58', 'Aakash@gmail.com', NULL, 'Aakash', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aakash@gmail.com', 'Aakash', NULL, NULL, '620023', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 20, 1, 1, 1, 21, 2),
(8, NULL, 'VOC Street', 'Second Flate', '1007', '1993-08-15', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:43:58', 'Aalap@gmail.com', NULL, 'Aalap', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aalap@gmail.com', 'Aalap', NULL, NULL, '620024', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 22, 1, 1, 1, 23, 3),
(9, NULL, 'VOC Street', 'Second Flate', '1008', '1993-08-16', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:43:59', 'Aandaleeb@gmail.com', NULL, 'Aandaleeb', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aandaleeb@gmail.com', 'Aandaleeb', NULL, NULL, '620025', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 24, 1, 1, 1, 25, 3),
(10, NULL, 'VOC Street', 'Second Flate', '1009', '1993-08-17', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:43:59', 'Aashish@gmail.com', NULL, 'Aashish', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aashish@gmail.com', 'Aashish', NULL, NULL, '620026', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 26, 1, 1, 1, 27, 3),
(11, NULL, 'VOC Street', 'Second Flate', '1010', '1993-08-18', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:00', 'Abeer@gmail.com', NULL, 'Abeer', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abeer@gmail.com', 'Abeer', NULL, NULL, '620027', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 28, 1, 1, 1, 29, 3),
(12, NULL, 'VOC Street', 'Second Flate', '1011', '1993-08-19', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:00', 'Abhay@gmail.com', NULL, 'Abhay', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhay@gmail.com', 'Abhay', NULL, NULL, '620028', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 30, 1, 1, 1, 31, 3),
(13, NULL, 'VOC Street', 'Second Flate', '1012', '1993-08-20', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:01', 'Abhayananda@gmail.com', NULL, 'Abhayananda', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhayananda@gmail.com', 'Abhayananda', NULL, NULL, '620029', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 32, 1, 1, 1, 33, 3),
(14, NULL, 'VOC Street', 'Second Flate', '1013', '1993-08-21', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:01', 'Abhayaprada@gmail.com', NULL, 'Abhayaprada', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhayaprada@gmail.com', 'Abhayaprada', NULL, NULL, '620030', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 34, 1, 1, 1, 35, 3),
(15, NULL, 'VOC Street', 'Second Flate', '1014', '1993-08-22', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:02', 'Abheek@gmail.com', NULL, 'Abheek', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abheek@gmail.com', 'Abheek', NULL, NULL, '620031', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 36, 1, 1, 1, 37, 3),
(16, NULL, 'VOC Street', 'Second Flate', '1015', '1993-08-23', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:02', 'Abhi@gmail.com', NULL, 'Abhi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhi@gmail.com', 'Abhi', NULL, NULL, '620032', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 38, 1, 1, 1, 39, 3),
(17, NULL, 'VOC Street', 'Second Flate', '1016', '1993-08-24', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:03', 'Abhibhava@gmail.com', NULL, 'Abhibhava', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhibhava@gmail.com', 'Abhibhava', NULL, NULL, '620033', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 1, 40, 1, 1, 1, 41, 3),
(18, NULL, 'VOC Street', 'Second Flate', '1017', '1993-08-25', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:04', 'Abhicandra@gmail.com', NULL, 'Abhicandra', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhicandra@gmail.com', 'Abhicandra', NULL, NULL, '620034', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 42, 1, 1, 1, 43, 3),
(19, NULL, 'VOC Street', 'Second Flate', '1018', '1993-08-26', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:04', 'Abhidi@gmail.com', NULL, 'Abhidi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhidi@gmail.com', 'Abhidi', NULL, NULL, '620035', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 44, 1, 1, 1, 45, 3),
(20, NULL, 'VOC Street', 'Second Flate', '1019', '1993-08-27', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:05', 'Abhihita@gmail.com', NULL, 'Abhihita', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhihita@gmail.com', 'Abhihita', NULL, NULL, '620036', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 46, 1, 1, 1, 47, 3),
(21, NULL, 'VOC Street', 'Second Flate', '1020', '1993-08-28', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:05', 'Abhijat@gmail.com', NULL, 'Abhijat', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhijat@gmail.com', 'Abhijat', NULL, NULL, '620037', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 48, 1, 1, 1, 49, 3),
(22, NULL, 'VOC Street', 'Second Flate', '1021', '1993-08-29', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:06', 'Abhijaya@gmail.com', NULL, 'Abhijaya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhijaya@gmail.com', 'Abhijaya', NULL, NULL, '620038', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 50, 1, 1, 1, 51, 3),
(23, NULL, 'VOC Street', 'Second Flate', '1022', '1993-08-30', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:06', 'Abhijit@gmail.com', NULL, 'Abhijit', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhijit@gmail.com', 'Abhijit', NULL, NULL, '620039', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 52, 1, 1, 1, 53, 3),
(24, NULL, 'VOC Street', 'Second Flate', '1023', '1993-08-31', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:07', 'Abhijvala@gmail.com', NULL, 'Abhijvala', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhijvala@gmail.com', 'Abhijvala', NULL, NULL, '620040', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 54, 1, 1, 1, 55, 4),
(25, NULL, 'VOC Street', 'Second Flate', '1024', '1993-09-01', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:07', 'Abhilash@gmail.com', NULL, 'Abhilash', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhilash@gmail.com', 'Abhilash', NULL, NULL, '620041', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 56, 1, 1, 1, 57, 4),
(26, NULL, 'VOC Street', 'Second Flate', '1025', '1993-09-02', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:08', 'Abhimand@gmail.com', NULL, 'Abhimand', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhimand@gmail.com', 'Abhimand', NULL, NULL, '620042', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 58, 1, 1, 1, 59, 4),
(27, NULL, 'VOC Street', 'Second Flate', '1026', '1993-09-03', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:08', 'Aashika@gmail.com', NULL, 'Aashika', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aashika@gmail.com', 'Aashika', NULL, NULL, '620043', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 60, 1, 1, 1, 61, 4),
(28, NULL, 'VOC Street', 'Second Flate', '1027', '1993-09-04', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:09', 'Abha@gmail.com', NULL, 'Abha', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abha@gmail.com', 'Abha', NULL, NULL, '620044', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 62, 1, 1, 1, 63, 4),
(29, NULL, 'VOC Street', 'Second Flate', '1028', '1993-09-05', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:09', 'Abhati@gmail.com', NULL, 'Abhati', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhati@gmail.com', 'Abhati', NULL, NULL, '620045', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 64, 1, 1, 1, 65, 4),
(30, NULL, 'VOC Street', 'Second Flate', '1029', '1993-09-06', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:10', 'Abhaya@gmail.com', NULL, 'Abhaya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhaya@gmail.com', 'Abhaya', NULL, NULL, '620046', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 66, 1, 1, 1, 67, 4),
(31, NULL, 'VOC Street', 'Second Flate', '1030', '1993-09-07', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:10', 'Abhidha@gmail.com', NULL, 'Abhidha', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhidha@gmail.com', 'Abhidha', NULL, NULL, '620047', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 68, 1, 1, 1, 69, 4),
(32, NULL, 'VOC Street', 'Second Flate', '1031', '1993-09-08', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:11', 'Abhidhya@gmail.com', NULL, 'Abhidhya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhidhya@gmail.com', 'Abhidhya', NULL, NULL, '620048', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 70, 1, 1, 1, 71, 4),
(33, NULL, 'VOC Street', 'Second Flate', '1032', '1993-09-09', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:12', 'Abhijna@gmail.com', NULL, 'Abhijna', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhijna@gmail.com', 'Abhijna', NULL, NULL, '620049', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 72, 1, 1, 1, 73, 4),
(34, NULL, 'VOC Street', 'Second Flate', '1033', '1993-09-10', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:13', 'Abhilasa@gmail.com', NULL, 'Abhilasa', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhilasa@gmail.com', 'Abhilasa', NULL, NULL, '620050', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 74, 1, 1, 1, 75, 4),
(35, NULL, 'VOC Street', 'Second Flate', '1034', '1993-09-11', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:14', 'Abhilasha@gmail.com', NULL, 'Abhilasha', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhilasha@gmail.com', 'Abhilasha', NULL, NULL, '620051', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 76, 1, 1, 1, 77, 4),
(36, NULL, 'VOC Street', 'Second Flate', '1035', '1993-09-12', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:14', 'Abhinithi@gmail.com', NULL, 'Abhinithi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhinithi@gmail.com', 'Abhinithi', NULL, NULL, '620052', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 78, 1, 1, 1, 79, 4),
(37, NULL, 'VOC Street', 'Second Flate', '1036', '1993-09-13', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:15', 'Abhiprithi@gmail.com', NULL, 'Abhiprithi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhiprithi@gmail.com', 'Abhiprithi', NULL, NULL, '620053', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 80, 1, 1, 1, 81, 4),
(38, NULL, 'VOC Street', 'Second Flate', '1037', '1993-09-14', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:15', 'Abhirathi@gmail.com', NULL, 'Abhirathi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhirathi@gmail.com', 'Abhirathi', NULL, NULL, '620054', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 82, 1, 1, 1, 83, 4),
(39, NULL, 'VOC Street', 'Second Flate', '1038', '1993-09-15', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:16', 'Abhisri@gmail.com', NULL, 'Abhisri', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhisri@gmail.com', 'Abhisri', NULL, NULL, '620055', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 84, 1, 1, 1, 85, 4),
(40, NULL, 'VOC Street', 'Second Flate', '1039', '1993-09-16', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:17', 'Abhithi@gmail.com', NULL, 'Abhithi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abhithi@gmail.com', 'Abhithi', NULL, NULL, '620056', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 86, 1, 1, 1, 87, 4),
(41, NULL, 'VOC Street', 'Second Flate', '1040', '1993-09-17', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:17', 'Abja@gmail.com', NULL, 'Abja', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Abja@gmail.com', 'Abja', NULL, NULL, '620057', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 88, 1, 1, 1, 89, 4),
(42, NULL, 'VOC Street', 'Second Flate', '1041', '1993-09-18', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:18', 'Aboil@gmail.com', NULL, 'Aboil', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aboil@gmail.com', 'Aboil', NULL, NULL, '620058', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 90, 1, 1, 1, 91, 4),
(43, NULL, 'VOC Street', 'Second Flate', '1042', '1993-09-19', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:18', 'Achala@gmail.com', NULL, 'Achala', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Achala@gmail.com', 'Achala', NULL, NULL, '620059', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 92, 1, 1, 1, 93, 4),
(44, NULL, 'VOC Street', 'Second Flate', '1043', '1993-09-20', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:19', 'Acira@gmail.com', NULL, 'Acira', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Acira@gmail.com', 'Acira', NULL, NULL, '620060', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 94, 1, 1, 1, 95, 4),
(45, NULL, 'VOC Street', 'Second Flate', '1044', '1993-09-21', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:19', 'Adarsha@gmail.com', NULL, 'Adarsha', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adarsha@gmail.com', 'Adarsha', NULL, NULL, '620061', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 96, 1, 1, 1, 97, 4),
(46, NULL, 'VOC Street', 'Second Flate', '1045', '1993-09-22', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:20', 'Adhira@gmail.com', NULL, 'Adhira', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adhira@gmail.com', 'Adhira', NULL, NULL, '620062', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 98, 1, 1, 1, 99, 4),
(47, NULL, 'VOC Street', 'Second Flate', '1046', '1993-09-23', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:20', 'Adishree@gmail.com', NULL, 'Adishree', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adishree@gmail.com', 'Adishree', NULL, NULL, '620063', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 100, 1, 1, 1, 101, 4),
(48, NULL, 'VOC Street', 'Second Flate', '1047', '1993-09-24', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:21', 'Aditha@gmail.com', NULL, 'Aditha', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aditha@gmail.com', 'Aditha', NULL, NULL, '620064', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 102, 1, 1, 1, 103, 4),
(49, NULL, 'VOC Street', 'Second Flate', '1048', '1993-09-25', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:21', 'Adithi@gmail.com', NULL, 'Adithi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adithi@gmail.com', 'Adithi', NULL, NULL, '620065', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 104, 1, 1, 1, 105, 4),
(50, NULL, 'VOC Street', 'Second Flate', '1049', '1993-09-26', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:22', 'Aditi@gmail.com', NULL, 'Aditi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aditi@gmail.com', 'Aditi', NULL, NULL, '620066', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 106, 1, 1, 1, 107, 4),
(51, NULL, 'VOC Street', 'Second Flate', '1050', '1993-09-27', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:23', 'Adrija@gmail.com', NULL, 'Adrija', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adrija@gmail.com', 'Adrija', NULL, NULL, '620067', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 108, 1, 1, 1, 109, 4),
(52, NULL, 'VOC Street', 'Second Flate', '1051', '1993-09-28', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:23', 'Adrika@gmail.com', NULL, 'Adrika', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adrika@gmail.com', 'Adrika', NULL, NULL, '620068', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 110, 1, 1, 1, 111, 4),
(53, NULL, 'VOC Street', 'Second Flate', '1052', '1993-09-29', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:24', 'Advika@gmail.com', NULL, 'Advika', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Advika@gmail.com', 'Advika', NULL, NULL, '620069', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 112, 1, 1, 1, 113, 4),
(54, NULL, 'VOC Street', 'Second Flate', '1053', '1993-09-30', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:24', 'Adya@gmail.com', NULL, 'Adya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adya@gmail.com', 'Adya', NULL, NULL, '620070', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 114, 1, 1, 1, 115, 4),
(55, NULL, 'VOC Street', 'Second Flate', '1054', '1993-10-01', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:25', 'Aghanashini@gmail.com', NULL, 'Aghanashini', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aghanashini@gmail.com', 'Aghanashini', NULL, NULL, '620071', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 116, 1, 1, 1, 117, 4),
(56, NULL, 'VOC Street', 'Second Flate', '1055', '1993-10-02', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:25', 'Agrata@gmail.com', NULL, 'Agrata', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agrata@gmail.com', 'Agrata', NULL, NULL, '620072', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 118, 1, 1, 1, 119, 4),
(57, NULL, 'VOC Street', 'Second Flate', '1056', '1993-10-03', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:26', 'Agrima@gmail.com', NULL, 'Agrima', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agrima@gmail.com', 'Agrima', NULL, NULL, '620073', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 120, 1, 1, 1, 121, 2),
(58, NULL, 'VOC Street', 'Second Flate', '1057', '1993-10-04', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:27', 'Ahalya@gmail.com', NULL, 'Ahalya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ahalya@gmail.com', 'Ahalya', NULL, NULL, '620074', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 122, 1, 1, 1, 123, 2),
(59, NULL, 'VOC Street', 'Second Flate', '1058', '1993-10-05', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:27', 'Ahilya@gmail.com', NULL, 'Ahilya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ahilya@gmail.com', 'Ahilya', NULL, NULL, '620075', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 124, 1, 1, 1, 125, 2),
(60, NULL, 'VOC Street', 'Second Flate', '1059', '1993-10-06', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:28', 'Ahladita@gmail.com', NULL, 'Ahladita', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ahladita@gmail.com', 'Ahladita', NULL, NULL, '620076', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 126, 1, 1, 1, 127, 2),
(61, NULL, 'VOC Street', 'Second Flate', '1060', '1993-10-07', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:29', 'Ahladitha@gmail.com', NULL, 'Ahladitha', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ahladitha@gmail.com', 'Ahladitha', NULL, NULL, '620077', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 128, 1, 1, 1, 129, 2),
(62, NULL, 'VOC Street', 'Second Flate', '1061', '1993-10-08', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:29', 'Achyuta@gmail.com', NULL, 'Achyuta', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Achyuta@gmail.com', 'Achyuta', NULL, NULL, '620078', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 130, 1, 1, 1, 131, 2),
(63, NULL, 'VOC Street', 'Second Flate', '1062', '1993-10-09', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:30', 'Acintya@gmail.com', NULL, 'Acintya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Acintya@gmail.com', 'Acintya', NULL, NULL, '620079', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 132, 1, 1, 1, 133, 2),
(64, NULL, 'VOC Street', 'Second Flate', '1063', '1993-10-10', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:30', 'Acyutaraya@gmail.com', NULL, 'Acyutaraya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Acyutaraya@gmail.com', 'Acyutaraya', NULL, NULL, '620080', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 134, 1, 1, 1, 135, 2),
(65, NULL, 'VOC Street', 'Second Flate', '1064', '1993-10-11', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:31', 'Adalarasu@gmail.com', NULL, 'Adalarasu', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adalarasu@gmail.com', 'Adalarasu', NULL, NULL, '620081', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 136, 1, 1, 1, 137, 2),
(66, NULL, 'VOC Street', 'Second Flate', '1065', '1993-10-12', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:31', 'Adarsh@gmail.com', NULL, 'Adarsh', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adarsh@gmail.com', 'Adarsh', NULL, NULL, '620082', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 138, 1, 1, 1, 139, 2),
(67, NULL, 'VOC Street', 'Second Flate', '1066', '1993-10-13', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:32', 'Adesh@gmail.com', NULL, 'Adesh', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adesh@gmail.com', 'Adesh', NULL, NULL, '620083', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 140, 1, 1, 1, 141, 2),
(68, NULL, 'VOC Street', 'Second Flate', '1067', '1993-10-14', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:33', 'Adhik@gmail.com', NULL, 'Adhik', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adhik@gmail.com', 'Adhik', NULL, NULL, '620084', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 142, 1, 1, 1, 143, 2),
(69, NULL, 'VOC Street', 'Second Flate', '1068', '1993-10-15', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:34', 'Adhikara@gmail.com', NULL, 'Adhikara', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adhikara@gmail.com', 'Adhikara', NULL, NULL, '620085', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 144, 1, 1, 1, 145, 2),
(70, NULL, 'VOC Street', 'Second Flate', '1069', '1993-10-16', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:35', 'Adhipa@gmail.com', NULL, 'Adhipa', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adhipa@gmail.com', 'Adhipa', NULL, NULL, '620086', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 146, 1, 1, 1, 147, 2),
(71, NULL, 'VOC Street', 'Second Flate', '1070', '1993-10-17', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:35', 'Adhita@gmail.com', NULL, 'Adhita', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adhita@gmail.com', 'Adhita', NULL, NULL, '620087', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 148, 1, 1, 1, 149, 2),
(72, NULL, 'VOC Street', 'Second Flate', '1071', '1993-10-18', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:36', 'Adikavi@gmail.com', NULL, 'Adikavi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adikavi@gmail.com', 'Adikavi', NULL, NULL, '620088', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 150, 1, 1, 1, 151, 2),
(73, NULL, 'VOC Street', 'Second Flate', '1072', '1993-10-19', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:37', 'Adil@gmail.com', NULL, 'Adil', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adil@gmail.com', 'Adil', NULL, NULL, '620089', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 152, 1, 1, 1, 153, 2),
(74, NULL, 'VOC Street', 'Second Flate', '1073', '1993-10-20', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:37', 'Adinath@gmail.com', NULL, 'Adinath', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adinath@gmail.com', 'Adinath', NULL, NULL, '620090', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 154, 1, 1, 1, 155, 2),
(75, NULL, 'VOC Street', 'Second Flate', '1074', '1993-10-21', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:38', 'Adit@gmail.com', NULL, 'Adit', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adit@gmail.com', 'Adit', NULL, NULL, '620091', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 156, 1, 1, 1, 157, 2),
(76, NULL, 'VOC Street', 'Second Flate', '1075', '1993-10-22', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:38', 'Aditeya@gmail.com', NULL, 'Aditeya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aditeya@gmail.com', 'Aditeya', NULL, NULL, '620092', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 158, 1, 1, 1, 159, 2),
(77, NULL, 'VOC Street', 'Second Flate', '1076', '1993-10-23', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:39', 'Aditya@gmail.com', NULL, 'Aditya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aditya@gmail.com', 'Aditya', NULL, NULL, '620093', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 1, 1, 1, 1, 160, 1, 1, 1, 161, 2),
(78, NULL, 'VOC Street', 'Second Flate', '1077', '1993-10-24', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:39', 'Adityanandana@gmail.com', NULL, 'Adityanandana', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adityanandana@gmail.com', 'Adityanandana', NULL, NULL, '620094', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 162, 1, 1, 1, 163, 2),
(79, NULL, 'VOC Street', 'Second Flate', '1078', '1993-10-25', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:40', 'Adityavardhana@gmail.com', NULL, 'Adityavardhana', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adityavardhana@gmail.com', 'Adityavardhana', NULL, NULL, '620095', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 164, 1, 1, 1, 165, 2),
(80, NULL, 'VOC Street', 'Second Flate', '1079', '1993-10-26', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:41', 'Adripathi@gmail.com', NULL, 'Adripathi', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adripathi@gmail.com', 'Adripathi', NULL, NULL, '620096', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 166, 1, 1, 1, 167, 2),
(81, NULL, 'VOC Street', 'Second Flate', '1080', '1993-10-27', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:41', 'Adwaita@gmail.com', NULL, 'Adwaita', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adwaita@gmail.com', 'Adwaita', NULL, NULL, '620097', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 168, 1, 1, 1, 169, 2),
(82, NULL, 'VOC Street', 'Second Flate', '1081', '1993-10-28', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:42', 'Adway@gmail.com', NULL, 'Adway', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adway@gmail.com', 'Adway', NULL, NULL, '620098', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 170, 1, 1, 1, 171, 2),
(83, NULL, 'VOC Street', 'Second Flate', '1082', '1993-10-29', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:43', 'Adwaya@gmail.com', NULL, 'Adwaya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Adwaya@gmail.com', 'Adwaya', NULL, NULL, '620099', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 172, 1, 1, 1, 173, 2),
(84, NULL, 'VOC Street', 'Second Flate', '1083', '1993-10-30', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:44', 'Aftab,Aftaab@gmail.com', NULL, 'Aftab,Aftaab', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aftab,Aftaab@gmail.com', 'Aftab,Aftaab', NULL, NULL, '620100', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 174, 1, 1, 1, 175, 2),
(85, NULL, 'VOC Street', 'Second Flate', '1084', '1993-10-31', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:44', 'Agasti, Agastya@gmail.com', NULL, 'Agasti, Agastya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agasti, Agastya@gmail.com', 'Agasti, Agastya', NULL, NULL, '620101', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 176, 1, 1, 1, 177, 2),
(86, NULL, 'VOC Street', 'Second Flate', '1085', '1993-11-01', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:45', 'Agendra@gmail.com', NULL, 'Agendra', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agendra@gmail.com', 'Agendra', NULL, NULL, '620102', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 178, 1, 1, 1, 179, 2),
(87, NULL, 'VOC Street', 'Second Flate', '1086', '1993-11-02', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:46', 'Agha@gmail.com', NULL, 'Agha', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agha@gmail.com', 'Agha', NULL, NULL, '620103', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 180, 1, 1, 1, 181, 2),
(88, NULL, 'VOC Street', 'Second Flate', '1087', '1993-11-03', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:46', 'Agharna@gmail.com', NULL, 'Agharna', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agharna@gmail.com', 'Agharna', NULL, NULL, '620104', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 182, 1, 1, 1, 183, 2),
(89, NULL, 'VOC Street', 'Second Flate', '1088', '1993-11-04', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:47', 'Aghat@gmail.com', NULL, 'Aghat', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aghat@gmail.com', 'Aghat', NULL, NULL, '620105', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 184, 1, 1, 1, 185, 2),
(90, NULL, 'VOC Street', 'Second Flate', '1089', '1993-11-05', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:47', 'Agneya@gmail.com', NULL, 'Agneya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agneya@gmail.com', 'Agneya', NULL, NULL, '620106', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 186, 1, 1, 1, 187, 2),
(91, NULL, 'VOC Street', 'Second Flate', '1090', '1993-11-06', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:48', 'Agnikumara@gmail.com', NULL, 'Agnikumara', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agnikumara@gmail.com', 'Agnikumara', NULL, NULL, '620107', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 188, 1, 1, 1, 189, 2),
(92, NULL, 'VOC Street', 'Second Flate', '1091', '1993-11-07', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:48', 'Agniprava@gmail.com', NULL, 'Agniprava', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agniprava@gmail.com', 'Agniprava', NULL, NULL, '620108', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 190, 1, 1, 1, 191, 2),
(93, NULL, 'VOC Street', 'Second Flate', '1092', '1993-11-08', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:49', 'Agrim@gmail.com', NULL, 'Agrim', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agrim@gmail.com', 'Agrim', NULL, NULL, '620109', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 192, 1, 1, 1, 193, 2),
(94, NULL, 'VOC Street', 'Second Flate', '1093', '1993-11-09', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:50', 'Agriya@gmail.com', NULL, 'Agriya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Agriya@gmail.com', 'Agriya', NULL, NULL, '620110', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 194, 1, 1, 1, 195, 2),
(95, NULL, 'VOC Street', 'Second Flate', '1094', '1993-11-10', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:50', 'Ahijit@gmail.com', NULL, 'Ahijit', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ahijit@gmail.com', 'Ahijit', NULL, NULL, '620111', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 196, 1, 1, 1, 197, 1),
(96, NULL, 'VOC Street', 'Second Flate', '1095', '1993-11-11', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:51', 'Ahilan@gmail.com', NULL, 'Ahilan', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ahilan@gmail.com', 'Ahilan', NULL, NULL, '620112', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 198, 1, 1, 1, 199, 1),
(97, NULL, 'VOC Street', 'Second Flate', '1096', '1993-11-12', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:51', 'Ahmad@gmail.com', NULL, 'Ahmad', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ahmad@gmail.com', 'Ahmad', NULL, NULL, '620113', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 200, 1, 1, 1, 201, 1),
(98, NULL, 'VOC Street', 'Second Flate', '1097', '1993-11-13', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:52', 'Ahsan@gmail.com', NULL, 'Ahsan', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ahsan@gmail.com', 'Ahsan', NULL, NULL, '620114', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 202, 1, 1, 1, 203, 1),
(99, NULL, 'VOC Street', 'Second Flate', '1098', '1993-11-14', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:52', 'Aijaz@gmail.com', NULL, 'Aijaz', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aijaz@gmail.com', 'Aijaz', NULL, NULL, '620115', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 204, 1, 1, 1, 205, 1),
(100, NULL, 'VOC Street', 'Second Flate', '1099', '1993-11-15', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:53', 'Aiman@gmail.com', NULL, 'Aiman', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Aiman@gmail.com', 'Aiman', NULL, NULL, '620116', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 2, 1, 1, 1, 206, 1, 1, 1, 207, 1),
(101, NULL, 'VOC Street', 'Second Flate', '1100', '1993-11-16', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:54', 'Ainesh@gmail.com', NULL, 'Ainesh', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ainesh@gmail.com', 'Ainesh', NULL, NULL, '620117', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 208, 1, 1, 1, 209, 1),
(102, NULL, 'VOC Street', 'Second Flate', '1101', '1993-11-17', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:54', 'Ajamil@gmail.com', NULL, 'Ajamil', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ajamil@gmail.com', 'Ajamil', NULL, NULL, '620118', NULL, '/resources/themes/images/profile-pic/a.png', 'Female', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 210, 1, 1, 1, 211, 1),
(103, NULL, 'VOC Street', 'Second Flate', '1102', '1993-11-18', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:55', 'Ajatashatru@gmail.com', NULL, 'Ajatashatru', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ajatashatru@gmail.com', 'Ajatashatru', NULL, NULL, '620119', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 212, 1, 1, 1, 213, 1),
(104, NULL, 'VOC Street', 'Second Flate', '1103', '1993-11-19', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:56', 'Ajay@gmail.com', NULL, 'Ajay', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ajay@gmail.com', 'Ajay', NULL, NULL, '620120', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 214, 1, 1, 1, 215, 1),
(105, NULL, 'VOC Street', 'Second Flate', '1104', '1993-11-20', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:56', 'Ajinkya@gmail.com', NULL, 'Ajinkya', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ajinkya@gmail.com', 'Ajinkya', NULL, NULL, '620121', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 216, 1, 1, 1, 217, 1),
(106, NULL, 'VOC Street', 'Second Flate', '1105', '1993-11-21', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:57', 'Ajit@gmail.com', NULL, 'Ajit', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ajit@gmail.com', 'Ajit', NULL, NULL, '620122', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 218, 1, 1, 1, 219, 1),
(107, NULL, 'VOC Street', 'Second Flate', '1106', '1993-11-22', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:57', 'Ajitabh@gmail.com', NULL, 'Ajitabh', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ajitabh@gmail.com', 'Ajitabh', NULL, NULL, '620123', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 220, 1, 1, 1, 221, 1),
(108, NULL, 'VOC Street', 'Second Flate', '1107', '1993-11-23', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:58', 'Ajitesh@gmail.com', NULL, 'Ajitesh', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ajitesh@gmail.com', 'Ajitesh', NULL, NULL, '620124', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 222, 1, 1, 1, 223, 1),
(109, NULL, 'VOC Street', 'Second Flate', '1108', '1993-11-24', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:59', 'Ajmal@gmail.com', NULL, 'Ajmal', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Ajmal@gmail.com', 'Ajmal', NULL, NULL, '620125', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 224, 1, 1, 1, 225, 1),
(110, NULL, 'VOC Street', 'Second Flate', '1109', '1993-11-25', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:44:59', 'Akalmash@gmail.com', NULL, 'Akalmash', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Akalmash@gmail.com', 'Akalmash', NULL, NULL, '620126', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 226, 1, 1, 1, 227, 1),
(111, NULL, 'VOC Street', 'Second Flate', '1110', '1993-11-26', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-04-06 10:45:00', 'Akalpa@gmail.com', NULL, 'Akalpa', '2012-08-09', NULL, 'admin@jdsoft.in', '2017-04-05 23:45:04', NULL, '3698521470', 'parent.Akalpa@gmail.com', 'Akalpa', NULL, NULL, '620127', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 4, 1, 1, 1, 228, 1, 1, 1, 229, 1),
(112, '', 'Line1', 'Line2', 'STU1234', '2017-04-06', 'Tiruchirapalli', '1234567890', 'India', 'admin@jdsoft.in', '2017-04-06 11:43:01', 'jeeva@jdsoft.in', NULL, 'Jeeva', '2017-04-06', 'Anand', 'admin@jdsoft.in', '2017-04-06 00:43:02', NULL, '1234567890', 'parent.jeeva@jdsoft.in', 'Fn', 'Ln', '', '123456', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, 4, 5, 1, 1, 1, 231, 2, 1, 1, 230, 3);
INSERT INTO `tbl_student` (`student_id`, `access_no`, `address_line_1`, `address_line_2`, `admission_no`, `birth_date`, `student_city`, `contact`, `student_country`, `created_by`, `created_date`, `email`, `fathers_income`, `first_name`, `joined_date`, `last_name`, `modified_by`, `modified_date`, `mothers_income`, `parent_contact`, `parent_guardian_email`, `parent_guardian_first_name`, `parent_guardian_last_name`, `passport_number`, `postcode`, `roll_no`, `scanned_signature`, `sex`, `student_state`, `admission_id`, `blood_group_id`, `category_id`, `institution_id`, `academic_year_id`, `joined_class_id`, `parent_id`, `section_id`, `student_class_id`, `student_status_id`, `user_id`, `house_id`) VALUES
(113, '', 'dsfs', 'dfsfsf', '3454353535353', '2017-04-11', 'Tiruchirapalli', '234242342432', 'India', 'admin@jdsoft.in', '2017-04-12 18:47:34', 'sdsdsd@gmail.om', NULL, 'fdf', '2017-04-12', 'sds', 'admin@jdsoft.in', '2017-05-17 07:53:27', NULL, '34242342424', 'dsd@gmail.com', 'dsdsd', 'sdsd', '', '123456', NULL, '/resources/themes/images/profile-pic/a.png', 'Male', 'Tamil Nadu', NULL, NULL, 5, 1, 1, 2, 233, 1, 2, 1, 232, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_attendance`
--

CREATE TABLE `tbl_student_attendance` (
  `student_attendance_id` bigint(20) NOT NULL,
  `attendance_time` time NOT NULL,
  `attendance_date` date NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `section_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `student_attendance_type_id` bigint(20) NOT NULL,
  `class_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_attendance`
--

INSERT INTO `tbl_student_attendance` (`student_attendance_id`, `attendance_time`, `attendance_date`, `academic_year_id`, `institution_id`, `section_id`, `student_id`, `student_attendance_type_id`, `class_id`) VALUES
(1, '14:52:00', '2017-04-10', 1, 1, 1, 1, 2, 1),
(2, '14:52:00', '2017-04-10', 1, 1, 1, 2, 3, 1),
(3, '14:52:00', '2017-04-10', 1, 1, 1, 3, 1, 1),
(4, '14:52:00', '2017-04-10', 1, 1, 1, 4, 1, 1),
(5, '14:52:00', '2017-04-10', 1, 1, 1, 5, 1, 1),
(6, '14:52:00', '2017-04-10', 1, 1, 1, 6, 1, 1),
(7, '14:52:00', '2017-04-10', 1, 1, 1, 7, 2, 1),
(8, '14:52:00', '2017-04-10', 1, 1, 1, 8, 1, 1),
(9, '14:52:00', '2017-04-10', 1, 1, 1, 9, 2, 1),
(10, '14:52:00', '2017-04-10', 1, 1, 1, 10, 1, 1),
(11, '14:52:00', '2017-04-10', 1, 1, 1, 11, 2, 1),
(12, '14:52:00', '2017-04-10', 1, 1, 1, 12, 1, 1),
(13, '14:52:00', '2017-04-10', 1, 1, 1, 13, 1, 1),
(14, '14:52:00', '2017-04-10', 1, 1, 1, 14, 1, 1),
(15, '14:52:00', '2017-04-10', 1, 1, 1, 15, 1, 1),
(16, '14:52:00', '2017-04-10', 1, 1, 1, 16, 1, 1),
(17, '14:52:00', '2017-04-10', 1, 1, 1, 17, 1, 1),
(18, '14:52:00', '2017-04-10', 1, 1, 1, 18, 1, 1),
(19, '14:52:00', '2017-04-10', 1, 1, 1, 19, 1, 1),
(20, '14:52:00', '2017-04-10', 1, 1, 1, 20, 1, 1),
(21, '14:52:00', '2017-04-10', 1, 1, 1, 21, 2, 1),
(22, '14:52:00', '2017-04-10', 1, 1, 1, 22, 1, 1),
(23, '14:52:00', '2017-04-10', 1, 1, 1, 23, 3, 1),
(24, '14:52:00', '2017-04-10', 1, 1, 1, 24, 1, 1),
(25, '14:52:00', '2017-04-10', 1, 1, 1, 25, 3, 1),
(26, '14:52:00', '2017-04-10', 1, 1, 1, 26, 1, 1),
(27, '14:52:00', '2017-04-10', 1, 1, 1, 27, 1, 1),
(28, '14:52:00', '2017-04-10', 1, 1, 1, 28, 1, 1),
(29, '14:52:00', '2017-04-10', 1, 1, 1, 29, 1, 1),
(30, '14:52:00', '2017-04-10', 1, 1, 1, 30, 1, 1),
(31, '14:52:00', '2017-04-10', 1, 1, 1, 31, 1, 1),
(32, '14:52:00', '2017-04-10', 1, 1, 1, 32, 1, 1),
(33, '14:52:00', '2017-04-10', 1, 1, 1, 33, 1, 1),
(34, '14:52:00', '2017-04-10', 1, 1, 1, 34, 1, 1),
(35, '14:52:00', '2017-04-10', 1, 1, 1, 35, 2, 1),
(36, '14:52:00', '2017-04-10', 1, 1, 1, 36, 1, 1),
(37, '14:52:00', '2017-04-10', 1, 1, 1, 37, 1, 1),
(38, '14:52:00', '2017-04-10', 1, 1, 1, 38, 2, 1),
(39, '14:52:00', '2017-04-10', 1, 1, 1, 39, 1, 1),
(40, '14:52:00', '2017-04-10', 1, 1, 1, 40, 1, 1),
(41, '14:52:00', '2017-04-10', 1, 1, 1, 41, 1, 1),
(42, '14:52:00', '2017-04-10', 1, 1, 1, 42, 1, 1),
(43, '14:52:00', '2017-04-10', 1, 1, 1, 43, 2, 1),
(44, '14:52:00', '2017-04-10', 1, 1, 1, 44, 1, 1),
(45, '14:52:00', '2017-04-10', 1, 1, 1, 45, 1, 1),
(46, '14:52:00', '2017-04-10', 1, 1, 1, 46, 2, 1),
(47, '14:52:00', '2017-04-10', 1, 1, 1, 47, 1, 1),
(48, '14:52:00', '2017-04-10', 1, 1, 1, 48, 1, 1),
(49, '14:52:00', '2017-04-10', 1, 1, 1, 49, 1, 1),
(50, '14:52:00', '2017-04-10', 1, 1, 1, 50, 1, 1),
(51, '14:52:00', '2017-04-10', 1, 1, 1, 51, 1, 1),
(52, '14:52:00', '2017-04-10', 1, 1, 1, 52, 1, 1),
(53, '14:52:00', '2017-04-10', 1, 1, 1, 53, 1, 1),
(54, '14:52:00', '2017-04-10', 1, 1, 1, 54, 1, 1),
(55, '14:52:00', '2017-04-10', 1, 1, 1, 55, 1, 1),
(56, '14:52:00', '2017-04-10', 1, 1, 1, 56, 1, 1),
(57, '14:52:00', '2017-04-10', 1, 1, 1, 57, 1, 1),
(58, '14:52:00', '2017-04-10', 1, 1, 1, 58, 1, 1),
(59, '14:52:00', '2017-04-10', 1, 1, 1, 59, 2, 1),
(60, '14:52:00', '2017-04-10', 1, 1, 1, 60, 1, 1),
(61, '14:52:00', '2017-04-10', 1, 1, 1, 61, 1, 1),
(62, '14:52:00', '2017-04-10', 1, 1, 1, 62, 1, 1),
(63, '14:52:00', '2017-04-10', 1, 1, 1, 63, 1, 1),
(64, '14:52:00', '2017-04-10', 1, 1, 1, 64, 1, 1),
(65, '14:52:00', '2017-04-10', 1, 1, 1, 65, 1, 1),
(66, '14:52:00', '2017-04-10', 1, 1, 1, 66, 1, 1),
(67, '14:52:00', '2017-04-10', 1, 1, 1, 67, 1, 1),
(68, '14:52:00', '2017-04-10', 1, 1, 1, 68, 1, 1),
(69, '14:52:00', '2017-04-10', 1, 1, 1, 69, 1, 1),
(70, '14:52:00', '2017-04-10', 1, 1, 1, 70, 1, 1),
(71, '14:52:00', '2017-04-10', 1, 1, 1, 71, 2, 1),
(72, '14:52:00', '2017-04-10', 1, 1, 1, 72, 1, 1),
(73, '14:52:00', '2017-04-10', 1, 1, 1, 73, 1, 1),
(74, '14:52:00', '2017-04-10', 1, 1, 1, 74, 1, 1),
(75, '14:52:00', '2017-04-10', 1, 1, 1, 75, 1, 1),
(76, '14:52:00', '2017-04-10', 1, 1, 1, 76, 1, 1),
(77, '14:52:00', '2017-04-10', 1, 1, 1, 77, 2, 1),
(78, '14:52:00', '2017-04-10', 1, 1, 1, 78, 1, 1),
(79, '14:52:00', '2017-04-10', 1, 1, 1, 79, 1, 1),
(80, '14:52:00', '2017-04-10', 1, 1, 1, 80, 1, 1),
(81, '14:52:00', '2017-04-10', 1, 1, 1, 81, 1, 1),
(82, '14:52:00', '2017-04-10', 1, 1, 1, 82, 1, 1),
(83, '14:52:00', '2017-04-10', 1, 1, 1, 83, 1, 1),
(84, '14:52:00', '2017-04-10', 1, 1, 1, 84, 1, 1),
(85, '14:52:00', '2017-04-10', 1, 1, 1, 85, 1, 1),
(86, '14:52:00', '2017-04-10', 1, 1, 1, 86, 1, 1),
(87, '14:52:00', '2017-04-10', 1, 1, 1, 87, 1, 1),
(88, '14:52:00', '2017-04-10', 1, 1, 1, 88, 1, 1),
(89, '14:52:00', '2017-04-10', 1, 1, 1, 89, 1, 1),
(90, '14:52:00', '2017-04-10', 1, 1, 1, 90, 1, 1),
(91, '14:52:00', '2017-04-10', 1, 1, 1, 91, 1, 1),
(92, '14:52:00', '2017-04-10', 1, 1, 1, 92, 1, 1),
(93, '14:52:00', '2017-04-10', 1, 1, 1, 93, 2, 1),
(94, '14:52:00', '2017-04-10', 1, 1, 1, 94, 1, 1),
(95, '14:52:00', '2017-04-10', 1, 1, 1, 95, 1, 1),
(96, '14:52:00', '2017-04-10', 1, 1, 1, 96, 1, 1),
(97, '14:52:00', '2017-04-10', 1, 1, 1, 97, 1, 1),
(98, '14:52:00', '2017-04-10', 1, 1, 1, 98, 1, 1),
(99, '14:52:00', '2017-04-10', 1, 1, 1, 99, 1, 1),
(100, '14:52:00', '2017-04-10', 1, 1, 1, 100, 1, 1),
(101, '14:52:00', '2017-04-10', 1, 1, 1, 101, 1, 1),
(102, '14:52:00', '2017-04-10', 1, 1, 1, 102, 1, 1),
(103, '14:52:00', '2017-04-10', 1, 1, 1, 103, 1, 1),
(104, '14:52:00', '2017-04-10', 1, 1, 1, 104, 1, 1),
(105, '14:52:00', '2017-04-10', 1, 1, 1, 105, 1, 1),
(106, '14:52:00', '2017-04-10', 1, 1, 1, 106, 1, 1),
(107, '14:52:00', '2017-04-10', 1, 1, 1, 107, 1, 1),
(108, '14:52:00', '2017-04-10', 1, 1, 1, 108, 1, 1),
(109, '14:52:00', '2017-04-10', 1, 1, 1, 109, 1, 1),
(110, '14:52:00', '2017-04-10', 1, 1, 1, 110, 1, 1),
(111, '14:52:00', '2017-04-10', 1, 1, 1, 111, 1, 1),
(112, '11:00:00', '2017-04-17', 1, 1, 1, 1, 1, 1),
(113, '11:00:00', '2017-04-17', 1, 1, 1, 2, 2, 1),
(114, '11:00:00', '2017-04-17', 1, 1, 1, 3, 1, 1),
(115, '11:00:00', '2017-04-17', 1, 1, 1, 4, 2, 1),
(116, '11:00:00', '2017-04-17', 1, 1, 1, 5, 1, 1),
(117, '11:00:00', '2017-04-17', 1, 1, 1, 6, 2, 1),
(118, '11:00:00', '2017-04-17', 1, 1, 1, 7, 2, 1),
(119, '11:00:00', '2017-04-17', 1, 1, 1, 8, 1, 1),
(120, '11:00:00', '2017-04-17', 1, 1, 1, 9, 1, 1),
(121, '11:00:00', '2017-04-17', 1, 1, 1, 10, 2, 1),
(122, '11:00:00', '2017-04-17', 1, 1, 1, 11, 1, 1),
(123, '11:00:00', '2017-04-17', 1, 1, 1, 12, 3, 1),
(124, '11:00:00', '2017-04-17', 1, 1, 1, 13, 1, 1),
(125, '11:00:00', '2017-04-17', 1, 1, 1, 14, 1, 1),
(126, '11:00:00', '2017-04-17', 1, 1, 1, 15, 3, 1),
(127, '11:00:00', '2017-04-17', 1, 1, 1, 16, 1, 1),
(128, '11:00:00', '2017-04-17', 1, 1, 1, 17, 1, 1),
(129, '11:00:00', '2017-04-17', 1, 1, 1, 18, 1, 1),
(130, '11:00:00', '2017-04-17', 1, 1, 1, 19, 1, 1),
(131, '11:00:00', '2017-04-17', 1, 1, 1, 20, 1, 1),
(132, '11:00:00', '2017-04-17', 1, 1, 1, 21, 3, 1),
(133, '11:00:00', '2017-04-17', 1, 1, 1, 22, 1, 1),
(134, '11:00:00', '2017-04-17', 1, 1, 1, 23, 1, 1),
(135, '11:00:00', '2017-04-17', 1, 1, 1, 24, 1, 1),
(136, '11:00:00', '2017-04-17', 1, 1, 1, 25, 3, 1),
(137, '11:00:00', '2017-04-17', 1, 1, 1, 26, 1, 1),
(138, '11:00:00', '2017-04-17', 1, 1, 1, 27, 1, 1),
(139, '11:00:00', '2017-04-17', 1, 1, 1, 28, 1, 1),
(140, '11:00:00', '2017-04-17', 1, 1, 1, 29, 1, 1),
(141, '11:00:00', '2017-04-17', 1, 1, 1, 30, 1, 1),
(142, '11:00:00', '2017-04-17', 1, 1, 1, 31, 1, 1),
(143, '11:00:00', '2017-04-17', 1, 1, 1, 32, 1, 1),
(144, '11:00:00', '2017-04-17', 1, 1, 1, 33, 1, 1),
(145, '11:00:00', '2017-04-17', 1, 1, 1, 34, 1, 1),
(146, '11:00:00', '2017-04-17', 1, 1, 1, 35, 1, 1),
(147, '11:00:00', '2017-04-17', 1, 1, 1, 36, 1, 1),
(148, '11:00:00', '2017-04-17', 1, 1, 1, 37, 1, 1),
(149, '11:00:00', '2017-04-17', 1, 1, 1, 38, 1, 1),
(150, '11:00:00', '2017-04-17', 1, 1, 1, 39, 2, 1),
(151, '11:00:00', '2017-04-17', 1, 1, 1, 40, 1, 1),
(152, '11:00:00', '2017-04-17', 1, 1, 1, 41, 1, 1),
(153, '11:00:00', '2017-04-17', 1, 1, 1, 42, 1, 1),
(154, '11:00:00', '2017-04-17', 1, 1, 1, 43, 3, 1),
(155, '11:00:00', '2017-04-17', 1, 1, 1, 44, 1, 1),
(156, '11:00:00', '2017-04-17', 1, 1, 1, 45, 1, 1),
(157, '11:00:00', '2017-04-17', 1, 1, 1, 46, 1, 1),
(158, '11:00:00', '2017-04-17', 1, 1, 1, 47, 1, 1),
(159, '11:00:00', '2017-04-17', 1, 1, 1, 48, 1, 1),
(160, '11:00:00', '2017-04-17', 1, 1, 1, 49, 1, 1),
(161, '11:00:00', '2017-04-17', 1, 1, 1, 50, 1, 1),
(162, '11:00:00', '2017-04-17', 1, 1, 1, 51, 1, 1),
(163, '11:00:00', '2017-04-17', 1, 1, 1, 52, 1, 1),
(164, '11:00:00', '2017-04-17', 1, 1, 1, 53, 1, 1),
(165, '11:00:00', '2017-04-17', 1, 1, 1, 54, 1, 1),
(166, '11:00:00', '2017-04-17', 1, 1, 1, 55, 1, 1),
(167, '11:00:00', '2017-04-17', 1, 1, 1, 56, 1, 1),
(168, '11:00:00', '2017-04-17', 1, 1, 1, 57, 1, 1),
(169, '11:00:00', '2017-04-17', 1, 1, 1, 58, 1, 1),
(170, '11:00:00', '2017-04-17', 1, 1, 1, 59, 1, 1),
(171, '11:00:00', '2017-04-17', 1, 1, 1, 60, 1, 1),
(172, '11:00:00', '2017-04-17', 1, 1, 1, 61, 1, 1),
(173, '11:00:00', '2017-04-17', 1, 1, 1, 62, 1, 1),
(174, '11:00:00', '2017-04-17', 1, 1, 1, 63, 1, 1),
(175, '11:00:00', '2017-04-17', 1, 1, 1, 64, 1, 1),
(176, '11:00:00', '2017-04-17', 1, 1, 1, 65, 1, 1),
(177, '11:00:00', '2017-04-17', 1, 1, 1, 66, 1, 1),
(178, '11:00:00', '2017-04-17', 1, 1, 1, 67, 1, 1),
(179, '11:00:00', '2017-04-17', 1, 1, 1, 68, 1, 1),
(180, '11:00:00', '2017-04-17', 1, 1, 1, 69, 1, 1),
(181, '11:00:00', '2017-04-17', 1, 1, 1, 70, 1, 1),
(182, '11:00:00', '2017-04-17', 1, 1, 1, 71, 1, 1),
(183, '11:00:00', '2017-04-17', 1, 1, 1, 72, 1, 1),
(184, '11:00:00', '2017-04-17', 1, 1, 1, 73, 1, 1),
(185, '11:00:00', '2017-04-17', 1, 1, 1, 74, 1, 1),
(186, '11:00:00', '2017-04-17', 1, 1, 1, 75, 1, 1),
(187, '11:00:00', '2017-04-17', 1, 1, 1, 76, 1, 1),
(188, '11:00:00', '2017-04-17', 1, 1, 1, 77, 1, 1),
(189, '11:00:00', '2017-04-17', 1, 1, 1, 78, 3, 1),
(190, '11:00:00', '2017-04-17', 1, 1, 1, 79, 1, 1),
(191, '11:00:00', '2017-04-17', 1, 1, 1, 80, 2, 1),
(192, '11:00:00', '2017-04-17', 1, 1, 1, 81, 1, 1),
(193, '11:00:00', '2017-04-17', 1, 1, 1, 82, 1, 1),
(194, '11:00:00', '2017-04-17', 1, 1, 1, 83, 1, 1),
(195, '11:00:00', '2017-04-17', 1, 1, 1, 84, 1, 1),
(196, '11:00:00', '2017-04-17', 1, 1, 1, 85, 1, 1),
(197, '11:00:00', '2017-04-17', 1, 1, 1, 86, 1, 1),
(198, '11:00:00', '2017-04-17', 1, 1, 1, 87, 1, 1),
(199, '11:00:00', '2017-04-17', 1, 1, 1, 88, 1, 1),
(200, '11:00:00', '2017-04-17', 1, 1, 1, 89, 1, 1),
(201, '11:00:00', '2017-04-17', 1, 1, 1, 90, 1, 1),
(202, '11:00:00', '2017-04-17', 1, 1, 1, 91, 2, 1),
(203, '11:00:00', '2017-04-17', 1, 1, 1, 92, 2, 1),
(204, '11:00:00', '2017-04-17', 1, 1, 1, 93, 3, 1),
(205, '11:00:00', '2017-04-17', 1, 1, 1, 94, 1, 1),
(206, '11:00:00', '2017-04-17', 1, 1, 1, 95, 1, 1),
(207, '11:00:00', '2017-04-17', 1, 1, 1, 96, 1, 1),
(208, '11:00:00', '2017-04-17', 1, 1, 1, 97, 1, 1),
(209, '11:00:00', '2017-04-17', 1, 1, 1, 98, 1, 1),
(210, '11:00:00', '2017-04-17', 1, 1, 1, 99, 1, 1),
(211, '11:00:00', '2017-04-17', 1, 1, 1, 100, 1, 1),
(212, '11:00:00', '2017-04-17', 1, 1, 1, 101, 1, 1),
(213, '11:00:00', '2017-04-17', 1, 1, 1, 102, 1, 1),
(214, '11:00:00', '2017-04-17', 1, 1, 1, 103, 1, 1),
(215, '11:00:00', '2017-04-17', 1, 1, 1, 104, 1, 1),
(216, '11:00:00', '2017-04-17', 1, 1, 1, 105, 1, 1),
(217, '11:00:00', '2017-04-17', 1, 1, 1, 106, 1, 1),
(218, '11:00:00', '2017-04-17', 1, 1, 1, 107, 1, 1),
(219, '11:00:00', '2017-04-17', 1, 1, 1, 108, 1, 1),
(220, '11:00:00', '2017-04-17', 1, 1, 1, 109, 1, 1),
(221, '11:00:00', '2017-04-17', 1, 1, 1, 110, 1, 1),
(222, '11:00:00', '2017-04-17', 1, 1, 1, 111, 1, 1),
(223, '11:03:00', '2017-04-17', 1, 1, 2, 112, 1, 1),
(335, '13:06:00', '2017-04-20', 1, 1, 1, 1, 1, 1),
(336, '13:06:00', '2017-04-20', 1, 1, 1, 2, 2, 1),
(337, '13:06:00', '2017-04-20', 1, 1, 1, 3, 1, 1),
(338, '13:06:00', '2017-04-20', 1, 1, 1, 4, 1, 1),
(339, '13:06:00', '2017-04-20', 1, 1, 1, 5, 3, 1),
(340, '13:06:00', '2017-04-20', 1, 1, 1, 6, 1, 1),
(341, '13:06:00', '2017-04-20', 1, 1, 1, 7, 1, 1),
(342, '13:06:00', '2017-04-20', 1, 1, 1, 8, 1, 1),
(343, '13:06:00', '2017-04-20', 1, 1, 1, 9, 1, 1),
(344, '13:06:00', '2017-04-20', 1, 1, 1, 10, 1, 1),
(345, '13:06:00', '2017-04-20', 1, 1, 1, 11, 2, 1),
(346, '13:06:00', '2017-04-20', 1, 1, 1, 12, 1, 1),
(347, '13:06:00', '2017-04-20', 1, 1, 1, 13, 1, 1),
(348, '13:06:00', '2017-04-20', 1, 1, 1, 14, 1, 1),
(349, '13:06:00', '2017-04-20', 1, 1, 1, 15, 2, 1),
(350, '13:06:00', '2017-04-20', 1, 1, 1, 16, 1, 1),
(351, '13:06:00', '2017-04-20', 1, 1, 1, 17, 1, 1),
(352, '13:06:00', '2017-04-20', 1, 1, 1, 18, 3, 1),
(353, '13:06:00', '2017-04-20', 1, 1, 1, 19, 1, 1),
(354, '13:06:00', '2017-04-20', 1, 1, 1, 20, 1, 1),
(355, '13:06:00', '2017-04-20', 1, 1, 1, 21, 1, 1),
(356, '13:06:00', '2017-04-20', 1, 1, 1, 22, 1, 1),
(357, '13:06:00', '2017-04-20', 1, 1, 1, 23, 1, 1),
(358, '13:06:00', '2017-04-20', 1, 1, 1, 24, 1, 1),
(359, '13:06:00', '2017-04-20', 1, 1, 1, 25, 1, 1),
(360, '13:06:00', '2017-04-20', 1, 1, 1, 26, 1, 1),
(361, '13:06:00', '2017-04-20', 1, 1, 1, 27, 2, 1),
(362, '13:06:00', '2017-04-20', 1, 1, 1, 28, 1, 1),
(363, '13:06:00', '2017-04-20', 1, 1, 1, 29, 1, 1),
(364, '13:06:00', '2017-04-20', 1, 1, 1, 30, 1, 1),
(365, '13:06:00', '2017-04-20', 1, 1, 1, 31, 2, 1),
(366, '13:06:00', '2017-04-20', 1, 1, 1, 32, 3, 1),
(367, '13:06:00', '2017-04-20', 1, 1, 1, 33, 1, 1),
(368, '13:06:00', '2017-04-20', 1, 1, 1, 34, 1, 1),
(369, '13:06:00', '2017-04-20', 1, 1, 1, 35, 3, 1),
(370, '13:06:00', '2017-04-20', 1, 1, 1, 36, 1, 1),
(371, '13:06:00', '2017-04-20', 1, 1, 1, 37, 1, 1),
(372, '13:06:00', '2017-04-20', 1, 1, 1, 38, 2, 1),
(373, '13:06:00', '2017-04-20', 1, 1, 1, 39, 1, 1),
(374, '13:06:00', '2017-04-20', 1, 1, 1, 40, 1, 1),
(375, '13:06:00', '2017-04-20', 1, 1, 1, 41, 1, 1),
(376, '13:06:00', '2017-04-20', 1, 1, 1, 42, 1, 1),
(377, '13:06:00', '2017-04-20', 1, 1, 1, 43, 3, 1),
(378, '13:06:00', '2017-04-20', 1, 1, 1, 44, 1, 1),
(379, '13:06:00', '2017-04-20', 1, 1, 1, 45, 1, 1),
(380, '13:06:00', '2017-04-20', 1, 1, 1, 46, 2, 1),
(381, '13:06:00', '2017-04-20', 1, 1, 1, 47, 1, 1),
(382, '13:06:00', '2017-04-20', 1, 1, 1, 48, 3, 1),
(383, '13:06:00', '2017-04-20', 1, 1, 1, 49, 1, 1),
(384, '13:06:00', '2017-04-20', 1, 1, 1, 50, 1, 1),
(385, '13:06:00', '2017-04-20', 1, 1, 1, 51, 1, 1),
(386, '13:06:00', '2017-04-20', 1, 1, 1, 52, 1, 1),
(387, '13:06:00', '2017-04-20', 1, 1, 1, 53, 1, 1),
(388, '13:06:00', '2017-04-20', 1, 1, 1, 54, 1, 1),
(389, '13:06:00', '2017-04-20', 1, 1, 1, 55, 1, 1),
(390, '13:06:00', '2017-04-20', 1, 1, 1, 56, 1, 1),
(391, '13:06:00', '2017-04-20', 1, 1, 1, 57, 2, 1),
(392, '13:06:00', '2017-04-20', 1, 1, 1, 58, 1, 1),
(393, '13:06:00', '2017-04-20', 1, 1, 1, 59, 1, 1),
(394, '13:06:00', '2017-04-20', 1, 1, 1, 60, 1, 1),
(395, '13:06:00', '2017-04-20', 1, 1, 1, 61, 3, 1),
(396, '13:06:00', '2017-04-20', 1, 1, 1, 62, 1, 1),
(397, '13:06:00', '2017-04-20', 1, 1, 1, 63, 1, 1),
(398, '13:06:00', '2017-04-20', 1, 1, 1, 64, 1, 1),
(399, '13:06:00', '2017-04-20', 1, 1, 1, 65, 1, 1),
(400, '13:06:00', '2017-04-20', 1, 1, 1, 66, 1, 1),
(401, '13:06:00', '2017-04-20', 1, 1, 1, 67, 1, 1),
(402, '13:06:00', '2017-04-20', 1, 1, 1, 68, 2, 1),
(403, '13:06:00', '2017-04-20', 1, 1, 1, 69, 1, 1),
(404, '13:06:00', '2017-04-20', 1, 1, 1, 70, 1, 1),
(405, '13:06:00', '2017-04-20', 1, 1, 1, 71, 3, 1),
(406, '13:06:00', '2017-04-20', 1, 1, 1, 72, 1, 1),
(407, '13:06:00', '2017-04-20', 1, 1, 1, 73, 1, 1),
(408, '13:06:00', '2017-04-20', 1, 1, 1, 74, 1, 1),
(409, '13:06:00', '2017-04-20', 1, 1, 1, 75, 1, 1),
(410, '13:06:00', '2017-04-20', 1, 1, 1, 76, 1, 1),
(411, '13:06:00', '2017-04-20', 1, 1, 1, 77, 1, 1),
(412, '13:06:00', '2017-04-20', 1, 1, 1, 78, 1, 1),
(413, '13:06:00', '2017-04-20', 1, 1, 1, 79, 1, 1),
(414, '13:06:00', '2017-04-20', 1, 1, 1, 80, 1, 1),
(415, '13:06:00', '2017-04-20', 1, 1, 1, 81, 1, 1),
(416, '13:06:00', '2017-04-20', 1, 1, 1, 82, 1, 1),
(417, '13:06:00', '2017-04-20', 1, 1, 1, 83, 2, 1),
(418, '13:06:00', '2017-04-20', 1, 1, 1, 84, 1, 1),
(419, '13:06:00', '2017-04-20', 1, 1, 1, 85, 1, 1),
(420, '13:06:00', '2017-04-20', 1, 1, 1, 86, 1, 1),
(421, '13:06:00', '2017-04-20', 1, 1, 1, 87, 1, 1),
(422, '13:06:00', '2017-04-20', 1, 1, 1, 88, 1, 1),
(423, '13:06:00', '2017-04-20', 1, 1, 1, 89, 1, 1),
(424, '13:06:00', '2017-04-20', 1, 1, 1, 90, 1, 1),
(425, '13:06:00', '2017-04-20', 1, 1, 1, 91, 1, 1),
(426, '13:06:00', '2017-04-20', 1, 1, 1, 92, 1, 1),
(427, '13:06:00', '2017-04-20', 1, 1, 1, 93, 1, 1),
(428, '13:06:00', '2017-04-20', 1, 1, 1, 94, 1, 1),
(429, '13:06:00', '2017-04-20', 1, 1, 1, 95, 1, 1),
(430, '13:06:00', '2017-04-20', 1, 1, 1, 96, 1, 1),
(431, '13:06:00', '2017-04-20', 1, 1, 1, 97, 1, 1),
(432, '13:06:00', '2017-04-20', 1, 1, 1, 98, 1, 1),
(433, '13:06:00', '2017-04-20', 1, 1, 1, 99, 1, 1),
(434, '13:06:00', '2017-04-20', 1, 1, 1, 100, 1, 1),
(435, '13:06:00', '2017-04-20', 1, 1, 1, 101, 1, 1),
(436, '13:06:00', '2017-04-20', 1, 1, 1, 102, 1, 1),
(437, '13:06:00', '2017-04-20', 1, 1, 1, 103, 1, 1),
(438, '13:06:00', '2017-04-20', 1, 1, 1, 104, 1, 1),
(439, '13:06:00', '2017-04-20', 1, 1, 1, 105, 1, 1),
(440, '13:06:00', '2017-04-20', 1, 1, 1, 106, 1, 1),
(441, '13:06:00', '2017-04-20', 1, 1, 1, 107, 1, 1),
(442, '13:06:00', '2017-04-20', 1, 1, 1, 108, 1, 1),
(443, '13:06:00', '2017-04-20', 1, 1, 1, 109, 1, 1),
(444, '13:06:00', '2017-04-20', 1, 1, 1, 110, 1, 1),
(445, '13:06:00', '2017-04-20', 1, 1, 1, 111, 3, 1),
(446, '12:04:00', '2017-04-24', 1, 1, 1, 1, 1, 1),
(447, '12:04:00', '2017-04-24', 1, 1, 1, 2, 1, 1),
(448, '12:04:00', '2017-04-24', 1, 1, 1, 3, 1, 1),
(449, '12:04:00', '2017-04-24', 1, 1, 1, 4, 1, 1),
(450, '12:04:00', '2017-04-24', 1, 1, 1, 5, 2, 1),
(451, '12:04:00', '2017-04-24', 1, 1, 1, 6, 1, 1),
(452, '12:04:00', '2017-04-24', 1, 1, 1, 7, 1, 1),
(453, '12:04:00', '2017-04-24', 1, 1, 1, 8, 1, 1),
(454, '12:04:00', '2017-04-24', 1, 1, 1, 9, 1, 1),
(455, '12:04:00', '2017-04-24', 1, 1, 1, 10, 1, 1),
(456, '12:04:00', '2017-04-24', 1, 1, 1, 11, 2, 1),
(457, '12:04:00', '2017-04-24', 1, 1, 1, 12, 1, 1),
(458, '12:04:00', '2017-04-24', 1, 1, 1, 13, 1, 1),
(459, '12:04:00', '2017-04-24', 1, 1, 1, 14, 1, 1),
(460, '12:04:00', '2017-04-24', 1, 1, 1, 15, 1, 1),
(461, '12:04:00', '2017-04-24', 1, 1, 1, 16, 1, 1),
(462, '12:04:00', '2017-04-24', 1, 1, 1, 17, 1, 1),
(463, '12:04:00', '2017-04-24', 1, 1, 1, 18, 1, 1),
(464, '12:04:00', '2017-04-24', 1, 1, 1, 19, 1, 1),
(465, '12:04:00', '2017-04-24', 1, 1, 1, 20, 1, 1),
(466, '12:04:00', '2017-04-24', 1, 1, 1, 21, 1, 1),
(467, '12:04:00', '2017-04-24', 1, 1, 1, 22, 1, 1),
(468, '12:04:00', '2017-04-24', 1, 1, 1, 23, 1, 1),
(469, '12:04:00', '2017-04-24', 1, 1, 1, 24, 2, 1),
(470, '12:04:00', '2017-04-24', 1, 1, 1, 25, 1, 1),
(471, '12:04:00', '2017-04-24', 1, 1, 1, 26, 1, 1),
(472, '12:04:00', '2017-04-24', 1, 1, 1, 27, 1, 1),
(473, '12:04:00', '2017-04-24', 1, 1, 1, 28, 1, 1),
(474, '12:04:00', '2017-04-24', 1, 1, 1, 29, 1, 1),
(475, '12:04:00', '2017-04-24', 1, 1, 1, 30, 1, 1),
(476, '12:04:00', '2017-04-24', 1, 1, 1, 31, 1, 1),
(477, '12:04:00', '2017-04-24', 1, 1, 1, 32, 1, 1),
(478, '12:04:00', '2017-04-24', 1, 1, 1, 33, 1, 1),
(479, '12:04:00', '2017-04-24', 1, 1, 1, 34, 1, 1),
(480, '12:04:00', '2017-04-24', 1, 1, 1, 35, 1, 1),
(481, '12:04:00', '2017-04-24', 1, 1, 1, 36, 1, 1),
(482, '12:04:00', '2017-04-24', 1, 1, 1, 37, 1, 1),
(483, '12:04:00', '2017-04-24', 1, 1, 1, 38, 1, 1),
(484, '12:04:00', '2017-04-24', 1, 1, 1, 39, 1, 1),
(485, '12:04:00', '2017-04-24', 1, 1, 1, 40, 2, 1),
(486, '12:04:00', '2017-04-24', 1, 1, 1, 41, 1, 1),
(487, '12:04:00', '2017-04-24', 1, 1, 1, 42, 1, 1),
(488, '12:04:00', '2017-04-24', 1, 1, 1, 43, 1, 1),
(489, '12:04:00', '2017-04-24', 1, 1, 1, 44, 1, 1),
(490, '12:04:00', '2017-04-24', 1, 1, 1, 45, 1, 1),
(491, '12:04:00', '2017-04-24', 1, 1, 1, 46, 1, 1),
(492, '12:04:00', '2017-04-24', 1, 1, 1, 47, 1, 1),
(493, '12:04:00', '2017-04-24', 1, 1, 1, 48, 1, 1),
(494, '12:04:00', '2017-04-24', 1, 1, 1, 49, 1, 1),
(495, '12:04:00', '2017-04-24', 1, 1, 1, 50, 1, 1),
(496, '12:04:00', '2017-04-24', 1, 1, 1, 51, 1, 1),
(497, '12:04:00', '2017-04-24', 1, 1, 1, 52, 1, 1),
(498, '12:04:00', '2017-04-24', 1, 1, 1, 53, 1, 1),
(499, '12:04:00', '2017-04-24', 1, 1, 1, 54, 1, 1),
(500, '12:04:00', '2017-04-24', 1, 1, 1, 55, 1, 1),
(501, '12:04:00', '2017-04-24', 1, 1, 1, 56, 2, 1),
(502, '12:04:00', '2017-04-24', 1, 1, 1, 57, 1, 1),
(503, '12:04:00', '2017-04-24', 1, 1, 1, 58, 1, 1),
(504, '12:04:00', '2017-04-24', 1, 1, 1, 59, 1, 1),
(505, '12:04:00', '2017-04-24', 1, 1, 1, 60, 1, 1),
(506, '12:04:00', '2017-04-24', 1, 1, 1, 61, 1, 1),
(507, '12:04:00', '2017-04-24', 1, 1, 1, 62, 1, 1),
(508, '12:04:00', '2017-04-24', 1, 1, 1, 63, 1, 1),
(509, '12:04:00', '2017-04-24', 1, 1, 1, 64, 1, 1),
(510, '12:04:00', '2017-04-24', 1, 1, 1, 65, 1, 1),
(511, '12:04:00', '2017-04-24', 1, 1, 1, 66, 1, 1),
(512, '12:04:00', '2017-04-24', 1, 1, 1, 67, 1, 1),
(513, '12:04:00', '2017-04-24', 1, 1, 1, 68, 1, 1),
(514, '12:04:00', '2017-04-24', 1, 1, 1, 69, 1, 1),
(515, '12:04:00', '2017-04-24', 1, 1, 1, 70, 1, 1),
(516, '12:04:00', '2017-04-24', 1, 1, 1, 71, 3, 1),
(517, '12:04:00', '2017-04-24', 1, 1, 1, 72, 1, 1),
(518, '12:04:00', '2017-04-24', 1, 1, 1, 73, 1, 1),
(519, '12:04:00', '2017-04-24', 1, 1, 1, 74, 1, 1),
(520, '12:04:00', '2017-04-24', 1, 1, 1, 75, 1, 1),
(521, '12:04:00', '2017-04-24', 1, 1, 1, 76, 1, 1),
(522, '12:04:00', '2017-04-24', 1, 1, 1, 77, 1, 1),
(523, '12:04:00', '2017-04-24', 1, 1, 1, 78, 1, 1),
(524, '12:04:00', '2017-04-24', 1, 1, 1, 79, 1, 1),
(525, '12:04:00', '2017-04-24', 1, 1, 1, 80, 1, 1),
(526, '12:04:00', '2017-04-24', 1, 1, 1, 81, 1, 1),
(527, '12:04:00', '2017-04-24', 1, 1, 1, 82, 3, 1),
(528, '12:04:00', '2017-04-24', 1, 1, 1, 83, 1, 1),
(529, '12:04:00', '2017-04-24', 1, 1, 1, 84, 1, 1),
(530, '12:04:00', '2017-04-24', 1, 1, 1, 85, 1, 1),
(531, '12:04:00', '2017-04-24', 1, 1, 1, 86, 1, 1),
(532, '12:04:00', '2017-04-24', 1, 1, 1, 87, 1, 1),
(533, '12:04:00', '2017-04-24', 1, 1, 1, 88, 1, 1),
(534, '12:04:00', '2017-04-24', 1, 1, 1, 89, 1, 1),
(535, '12:04:00', '2017-04-24', 1, 1, 1, 90, 1, 1),
(536, '12:04:00', '2017-04-24', 1, 1, 1, 91, 1, 1),
(537, '12:04:00', '2017-04-24', 1, 1, 1, 92, 1, 1),
(538, '12:04:00', '2017-04-24', 1, 1, 1, 93, 1, 1),
(539, '12:04:00', '2017-04-24', 1, 1, 1, 94, 1, 1),
(540, '12:04:00', '2017-04-24', 1, 1, 1, 95, 1, 1),
(541, '12:04:00', '2017-04-24', 1, 1, 1, 96, 3, 1),
(542, '12:04:00', '2017-04-24', 1, 1, 1, 97, 1, 1),
(543, '12:04:00', '2017-04-24', 1, 1, 1, 98, 1, 1),
(544, '12:04:00', '2017-04-24', 1, 1, 1, 99, 1, 1),
(545, '12:04:00', '2017-04-24', 1, 1, 1, 100, 1, 1),
(546, '12:04:00', '2017-04-24', 1, 1, 1, 101, 1, 1),
(547, '12:04:00', '2017-04-24', 1, 1, 1, 102, 1, 1),
(548, '12:04:00', '2017-04-24', 1, 1, 1, 103, 1, 1),
(549, '12:04:00', '2017-04-24', 1, 1, 1, 104, 1, 1),
(550, '12:04:00', '2017-04-24', 1, 1, 1, 105, 1, 1),
(551, '12:04:00', '2017-04-24', 1, 1, 1, 106, 1, 1),
(552, '12:04:00', '2017-04-24', 1, 1, 1, 107, 3, 1),
(553, '12:04:00', '2017-04-24', 1, 1, 1, 108, 1, 1),
(554, '12:04:00', '2017-04-24', 1, 1, 1, 109, 2, 1),
(555, '12:04:00', '2017-04-24', 1, 1, 1, 110, 1, 1),
(556, '12:04:00', '2017-04-24', 1, 1, 1, 111, 1, 1),
(668, '11:00:00', '2017-04-25', 1, 1, 1, 113, 1, 2),
(780, '18:33:00', '2017-04-25', 1, 1, 1, 1, 1, 1),
(781, '18:33:00', '2017-04-25', 1, 1, 1, 2, 1, 1),
(782, '18:33:00', '2017-04-25', 1, 1, 1, 3, 2, 1),
(783, '18:33:00', '2017-04-25', 1, 1, 1, 4, 3, 1),
(784, '18:33:00', '2017-04-25', 1, 1, 1, 5, 1, 1),
(785, '18:33:00', '2017-04-25', 1, 1, 1, 6, 3, 1),
(786, '18:33:00', '2017-04-25', 1, 1, 1, 7, 1, 1),
(787, '18:33:00', '2017-04-25', 1, 1, 1, 8, 1, 1),
(788, '18:33:00', '2017-04-25', 1, 1, 1, 9, 1, 1),
(789, '18:33:00', '2017-04-25', 1, 1, 1, 10, 1, 1),
(790, '18:33:00', '2017-04-25', 1, 1, 1, 11, 1, 1),
(791, '18:33:00', '2017-04-25', 1, 1, 1, 12, 2, 1),
(792, '18:33:00', '2017-04-25', 1, 1, 1, 13, 1, 1),
(793, '18:33:00', '2017-04-25', 1, 1, 1, 14, 3, 1),
(794, '18:33:00', '2017-04-25', 1, 1, 1, 15, 2, 1),
(795, '18:33:00', '2017-04-25', 1, 1, 1, 16, 1, 1),
(796, '18:33:00', '2017-04-25', 1, 1, 1, 17, 1, 1),
(797, '18:33:00', '2017-04-25', 1, 1, 1, 18, 1, 1),
(798, '18:33:00', '2017-04-25', 1, 1, 1, 19, 1, 1),
(799, '18:33:00', '2017-04-25', 1, 1, 1, 20, 1, 1),
(800, '18:33:00', '2017-04-25', 1, 1, 1, 21, 1, 1),
(801, '18:33:00', '2017-04-25', 1, 1, 1, 22, 1, 1),
(802, '18:33:00', '2017-04-25', 1, 1, 1, 23, 2, 1),
(803, '18:33:00', '2017-04-25', 1, 1, 1, 24, 1, 1),
(804, '18:33:00', '2017-04-25', 1, 1, 1, 25, 1, 1),
(805, '18:33:00', '2017-04-25', 1, 1, 1, 26, 1, 1),
(806, '18:33:00', '2017-04-25', 1, 1, 1, 27, 1, 1),
(807, '18:33:00', '2017-04-25', 1, 1, 1, 28, 3, 1),
(808, '18:33:00', '2017-04-25', 1, 1, 1, 29, 1, 1),
(809, '18:33:00', '2017-04-25', 1, 1, 1, 30, 1, 1),
(810, '18:33:00', '2017-04-25', 1, 1, 1, 31, 1, 1),
(811, '18:33:00', '2017-04-25', 1, 1, 1, 32, 1, 1),
(812, '18:33:00', '2017-04-25', 1, 1, 1, 33, 2, 1),
(813, '18:33:00', '2017-04-25', 1, 1, 1, 34, 1, 1),
(814, '18:33:00', '2017-04-25', 1, 1, 1, 35, 1, 1),
(815, '18:33:00', '2017-04-25', 1, 1, 1, 36, 3, 1),
(816, '18:33:00', '2017-04-25', 1, 1, 1, 37, 1, 1),
(817, '18:33:00', '2017-04-25', 1, 1, 1, 38, 1, 1),
(818, '18:33:00', '2017-04-25', 1, 1, 1, 39, 1, 1),
(819, '18:33:00', '2017-04-25', 1, 1, 1, 40, 1, 1),
(820, '18:33:00', '2017-04-25', 1, 1, 1, 41, 1, 1),
(821, '18:33:00', '2017-04-25', 1, 1, 1, 42, 2, 1),
(822, '18:33:00', '2017-04-25', 1, 1, 1, 43, 1, 1),
(823, '18:33:00', '2017-04-25', 1, 1, 1, 44, 1, 1),
(824, '18:33:00', '2017-04-25', 1, 1, 1, 45, 1, 1),
(825, '18:33:00', '2017-04-25', 1, 1, 1, 46, 3, 1),
(826, '18:33:00', '2017-04-25', 1, 1, 1, 47, 1, 1),
(827, '18:33:00', '2017-04-25', 1, 1, 1, 48, 1, 1),
(828, '18:33:00', '2017-04-25', 1, 1, 1, 49, 1, 1),
(829, '18:33:00', '2017-04-25', 1, 1, 1, 50, 1, 1),
(830, '18:33:00', '2017-04-25', 1, 1, 1, 51, 1, 1),
(831, '18:33:00', '2017-04-25', 1, 1, 1, 52, 2, 1),
(832, '18:33:00', '2017-04-25', 1, 1, 1, 53, 1, 1),
(833, '18:33:00', '2017-04-25', 1, 1, 1, 54, 1, 1),
(834, '18:33:00', '2017-04-25', 1, 1, 1, 55, 3, 1),
(835, '18:33:00', '2017-04-25', 1, 1, 1, 56, 1, 1),
(836, '18:33:00', '2017-04-25', 1, 1, 1, 57, 1, 1),
(837, '18:33:00', '2017-04-25', 1, 1, 1, 58, 1, 1),
(838, '18:33:00', '2017-04-25', 1, 1, 1, 59, 1, 1),
(839, '18:33:00', '2017-04-25', 1, 1, 1, 60, 2, 1),
(840, '18:33:00', '2017-04-25', 1, 1, 1, 61, 1, 1),
(841, '18:33:00', '2017-04-25', 1, 1, 1, 62, 3, 1),
(842, '18:33:00', '2017-04-25', 1, 1, 1, 63, 1, 1),
(843, '18:33:00', '2017-04-25', 1, 1, 1, 64, 1, 1),
(844, '18:33:00', '2017-04-25', 1, 1, 1, 65, 1, 1),
(845, '18:33:00', '2017-04-25', 1, 1, 1, 66, 1, 1),
(846, '18:33:00', '2017-04-25', 1, 1, 1, 67, 1, 1),
(847, '18:33:00', '2017-04-25', 1, 1, 1, 68, 1, 1),
(848, '18:33:00', '2017-04-25', 1, 1, 1, 69, 1, 1),
(849, '18:33:00', '2017-04-25', 1, 1, 1, 70, 2, 1),
(850, '18:33:00', '2017-04-25', 1, 1, 1, 71, 1, 1),
(851, '18:33:00', '2017-04-25', 1, 1, 1, 72, 1, 1),
(852, '18:33:00', '2017-04-25', 1, 1, 1, 73, 3, 1),
(853, '18:33:00', '2017-04-25', 1, 1, 1, 74, 1, 1),
(854, '18:33:00', '2017-04-25', 1, 1, 1, 75, 1, 1),
(855, '18:33:00', '2017-04-25', 1, 1, 1, 76, 1, 1),
(856, '18:33:00', '2017-04-25', 1, 1, 1, 77, 1, 1),
(857, '18:33:00', '2017-04-25', 1, 1, 1, 78, 1, 1),
(858, '18:33:00', '2017-04-25', 1, 1, 1, 79, 1, 1),
(859, '18:33:00', '2017-04-25', 1, 1, 1, 80, 1, 1),
(860, '18:33:00', '2017-04-25', 1, 1, 1, 81, 2, 1),
(861, '18:33:00', '2017-04-25', 1, 1, 1, 82, 1, 1),
(862, '18:33:00', '2017-04-25', 1, 1, 1, 83, 1, 1),
(863, '18:33:00', '2017-04-25', 1, 1, 1, 84, 1, 1),
(864, '18:33:00', '2017-04-25', 1, 1, 1, 85, 3, 1),
(865, '18:33:00', '2017-04-25', 1, 1, 1, 86, 1, 1),
(866, '18:33:00', '2017-04-25', 1, 1, 1, 87, 1, 1),
(867, '18:33:00', '2017-04-25', 1, 1, 1, 88, 1, 1),
(868, '18:33:00', '2017-04-25', 1, 1, 1, 89, 1, 1),
(869, '18:33:00', '2017-04-25', 1, 1, 1, 90, 1, 1),
(870, '18:33:00', '2017-04-25', 1, 1, 1, 91, 1, 1),
(871, '18:33:00', '2017-04-25', 1, 1, 1, 92, 1, 1),
(872, '18:33:00', '2017-04-25', 1, 1, 1, 93, 1, 1),
(873, '18:33:00', '2017-04-25', 1, 1, 1, 94, 2, 1),
(874, '18:33:00', '2017-04-25', 1, 1, 1, 95, 1, 1),
(875, '18:33:00', '2017-04-25', 1, 1, 1, 96, 1, 1),
(876, '18:33:00', '2017-04-25', 1, 1, 1, 97, 3, 1),
(877, '18:33:00', '2017-04-25', 1, 1, 1, 98, 1, 1),
(878, '18:33:00', '2017-04-25', 1, 1, 1, 99, 1, 1),
(879, '18:33:00', '2017-04-25', 1, 1, 1, 100, 1, 1),
(880, '18:33:00', '2017-04-25', 1, 1, 1, 101, 1, 1),
(881, '18:33:00', '2017-04-25', 1, 1, 1, 102, 1, 1),
(882, '18:33:00', '2017-04-25', 1, 1, 1, 103, 2, 1),
(883, '18:33:00', '2017-04-25', 1, 1, 1, 104, 1, 1),
(884, '18:33:00', '2017-04-25', 1, 1, 1, 105, 1, 1),
(885, '18:33:00', '2017-04-25', 1, 1, 1, 106, 1, 1),
(886, '18:33:00', '2017-04-25', 1, 1, 1, 107, 1, 1),
(887, '18:33:00', '2017-04-25', 1, 1, 1, 108, 3, 1),
(888, '18:33:00', '2017-04-25', 1, 1, 1, 109, 1, 1),
(889, '18:33:00', '2017-04-25', 1, 1, 1, 110, 1, 1),
(890, '18:33:00', '2017-04-25', 1, 1, 1, 111, 1, 1),
(891, '11:26:00', '2017-05-16', 1, 1, 1, 1, 2, 1),
(892, '11:26:00', '2017-05-16', 1, 1, 1, 2, 2, 1),
(893, '11:26:00', '2017-05-16', 1, 1, 1, 3, 1, 1),
(894, '11:26:00', '2017-05-16', 1, 1, 1, 4, 1, 1),
(895, '11:26:00', '2017-05-16', 1, 1, 1, 5, 1, 1),
(896, '11:26:00', '2017-05-16', 1, 1, 1, 6, 1, 1),
(897, '11:26:00', '2017-05-16', 1, 1, 1, 7, 1, 1),
(898, '11:26:00', '2017-05-16', 1, 1, 1, 8, 1, 1),
(899, '11:26:00', '2017-05-16', 1, 1, 1, 9, 1, 1),
(900, '11:26:00', '2017-05-16', 1, 1, 1, 10, 1, 1),
(901, '11:26:00', '2017-05-16', 1, 1, 1, 11, 2, 1),
(902, '11:26:00', '2017-05-16', 1, 1, 1, 12, 1, 1),
(903, '11:26:00', '2017-05-16', 1, 1, 1, 13, 2, 1),
(904, '11:26:00', '2017-05-16', 1, 1, 1, 14, 1, 1),
(905, '11:26:00', '2017-05-16', 1, 1, 1, 15, 1, 1),
(906, '11:26:00', '2017-05-16', 1, 1, 1, 16, 2, 1),
(907, '11:26:00', '2017-05-16', 1, 1, 1, 17, 1, 1),
(908, '11:26:00', '2017-05-16', 1, 1, 1, 18, 1, 1),
(909, '11:26:00', '2017-05-16', 1, 1, 1, 19, 1, 1),
(910, '11:26:00', '2017-05-16', 1, 1, 1, 20, 1, 1),
(911, '11:26:00', '2017-05-16', 1, 1, 1, 21, 1, 1),
(912, '11:26:00', '2017-05-16', 1, 1, 1, 22, 1, 1),
(913, '11:26:00', '2017-05-16', 1, 1, 1, 23, 1, 1),
(914, '11:26:00', '2017-05-16', 1, 1, 1, 24, 1, 1),
(915, '11:26:00', '2017-05-16', 1, 1, 1, 25, 1, 1),
(916, '11:26:00', '2017-05-16', 1, 1, 1, 26, 1, 1),
(917, '11:26:00', '2017-05-16', 1, 1, 1, 27, 1, 1),
(918, '11:26:00', '2017-05-16', 1, 1, 1, 28, 1, 1),
(919, '11:26:00', '2017-05-16', 1, 1, 1, 29, 1, 1),
(920, '11:26:00', '2017-05-16', 1, 1, 1, 30, 1, 1),
(921, '11:26:00', '2017-05-16', 1, 1, 1, 31, 2, 1),
(922, '11:26:00', '2017-05-16', 1, 1, 1, 32, 1, 1),
(923, '11:26:00', '2017-05-16', 1, 1, 1, 33, 1, 1),
(924, '11:26:00', '2017-05-16', 1, 1, 1, 34, 1, 1),
(925, '11:26:00', '2017-05-16', 1, 1, 1, 35, 1, 1),
(926, '11:26:00', '2017-05-16', 1, 1, 1, 36, 1, 1),
(927, '11:26:00', '2017-05-16', 1, 1, 1, 37, 1, 1),
(928, '11:26:00', '2017-05-16', 1, 1, 1, 38, 1, 1),
(929, '11:26:00', '2017-05-16', 1, 1, 1, 39, 1, 1),
(930, '11:26:00', '2017-05-16', 1, 1, 1, 40, 1, 1),
(931, '11:26:00', '2017-05-16', 1, 1, 1, 41, 1, 1),
(932, '11:26:00', '2017-05-16', 1, 1, 1, 42, 1, 1),
(933, '11:26:00', '2017-05-16', 1, 1, 1, 43, 1, 1),
(934, '11:26:00', '2017-05-16', 1, 1, 1, 44, 3, 1),
(935, '11:26:00', '2017-05-16', 1, 1, 1, 45, 1, 1),
(936, '11:26:00', '2017-05-16', 1, 1, 1, 46, 1, 1),
(937, '11:26:00', '2017-05-16', 1, 1, 1, 47, 1, 1),
(938, '11:26:00', '2017-05-16', 1, 1, 1, 48, 1, 1),
(939, '11:26:00', '2017-05-16', 1, 1, 1, 49, 1, 1),
(940, '11:26:00', '2017-05-16', 1, 1, 1, 50, 1, 1),
(941, '11:26:00', '2017-05-16', 1, 1, 1, 51, 1, 1),
(942, '11:26:00', '2017-05-16', 1, 1, 1, 52, 1, 1),
(943, '11:26:00', '2017-05-16', 1, 1, 1, 53, 1, 1),
(944, '11:26:00', '2017-05-16', 1, 1, 1, 54, 1, 1),
(945, '11:26:00', '2017-05-16', 1, 1, 1, 55, 3, 1),
(946, '11:26:00', '2017-05-16', 1, 1, 1, 56, 1, 1),
(947, '11:26:00', '2017-05-16', 1, 1, 1, 57, 1, 1),
(948, '11:26:00', '2017-05-16', 1, 1, 1, 58, 1, 1),
(949, '11:26:00', '2017-05-16', 1, 1, 1, 59, 1, 1),
(950, '11:26:00', '2017-05-16', 1, 1, 1, 60, 1, 1),
(951, '11:26:00', '2017-05-16', 1, 1, 1, 61, 1, 1),
(952, '11:26:00', '2017-05-16', 1, 1, 1, 62, 1, 1),
(953, '11:26:00', '2017-05-16', 1, 1, 1, 63, 1, 1),
(954, '11:26:00', '2017-05-16', 1, 1, 1, 64, 1, 1),
(955, '11:26:00', '2017-05-16', 1, 1, 1, 65, 1, 1),
(956, '11:26:00', '2017-05-16', 1, 1, 1, 66, 1, 1),
(957, '11:26:00', '2017-05-16', 1, 1, 1, 67, 1, 1),
(958, '11:26:00', '2017-05-16', 1, 1, 1, 68, 1, 1),
(959, '11:26:00', '2017-05-16', 1, 1, 1, 69, 1, 1),
(960, '11:26:00', '2017-05-16', 1, 1, 1, 70, 1, 1),
(961, '11:26:00', '2017-05-16', 1, 1, 1, 71, 1, 1),
(962, '11:26:00', '2017-05-16', 1, 1, 1, 72, 1, 1),
(963, '11:26:00', '2017-05-16', 1, 1, 1, 73, 1, 1),
(964, '11:26:00', '2017-05-16', 1, 1, 1, 74, 1, 1),
(965, '11:26:00', '2017-05-16', 1, 1, 1, 75, 1, 1),
(966, '11:26:00', '2017-05-16', 1, 1, 1, 76, 1, 1),
(967, '11:26:00', '2017-05-16', 1, 1, 1, 77, 1, 1),
(968, '11:26:00', '2017-05-16', 1, 1, 1, 78, 1, 1),
(969, '11:26:00', '2017-05-16', 1, 1, 1, 79, 1, 1),
(970, '11:26:00', '2017-05-16', 1, 1, 1, 80, 1, 1),
(971, '11:26:00', '2017-05-16', 1, 1, 1, 81, 1, 1),
(972, '11:26:00', '2017-05-16', 1, 1, 1, 82, 1, 1),
(973, '11:26:00', '2017-05-16', 1, 1, 1, 83, 1, 1),
(974, '11:26:00', '2017-05-16', 1, 1, 1, 84, 1, 1),
(975, '11:26:00', '2017-05-16', 1, 1, 1, 85, 1, 1),
(976, '11:26:00', '2017-05-16', 1, 1, 1, 86, 1, 1),
(977, '11:26:00', '2017-05-16', 1, 1, 1, 87, 1, 1),
(978, '11:26:00', '2017-05-16', 1, 1, 1, 88, 1, 1),
(979, '11:26:00', '2017-05-16', 1, 1, 1, 89, 1, 1),
(980, '11:26:00', '2017-05-16', 1, 1, 1, 90, 1, 1),
(981, '11:26:00', '2017-05-16', 1, 1, 1, 91, 1, 1),
(982, '11:26:00', '2017-05-16', 1, 1, 1, 92, 1, 1),
(983, '11:26:00', '2017-05-16', 1, 1, 1, 93, 1, 1),
(984, '11:26:00', '2017-05-16', 1, 1, 1, 94, 1, 1),
(985, '11:26:00', '2017-05-16', 1, 1, 1, 95, 1, 1),
(986, '11:26:00', '2017-05-16', 1, 1, 1, 96, 1, 1),
(987, '11:26:00', '2017-05-16', 1, 1, 1, 97, 1, 1),
(988, '11:26:00', '2017-05-16', 1, 1, 1, 98, 1, 1),
(989, '11:26:00', '2017-05-16', 1, 1, 1, 99, 1, 1),
(990, '11:26:00', '2017-05-16', 1, 1, 1, 100, 1, 1),
(991, '11:26:00', '2017-05-16', 1, 1, 1, 101, 1, 1),
(992, '11:26:00', '2017-05-16', 1, 1, 1, 102, 1, 1),
(993, '11:26:00', '2017-05-16', 1, 1, 1, 103, 1, 1),
(994, '11:26:00', '2017-05-16', 1, 1, 1, 104, 1, 1),
(995, '11:26:00', '2017-05-16', 1, 1, 1, 105, 1, 1),
(996, '11:26:00', '2017-05-16', 1, 1, 1, 106, 1, 1),
(997, '11:26:00', '2017-05-16', 1, 1, 1, 107, 1, 1),
(998, '11:26:00', '2017-05-16', 1, 1, 1, 108, 1, 1),
(999, '11:26:00', '2017-05-16', 1, 1, 1, 109, 1, 1),
(1000, '11:26:00', '2017-05-16', 1, 1, 1, 110, 1, 1),
(1001, '11:26:00', '2017-05-16', 1, 1, 1, 111, 1, 1),
(1002, '11:27:00', '2017-05-15', 1, 1, 1, 1, 2, 1),
(1003, '11:27:00', '2017-05-15', 1, 1, 1, 2, 2, 1),
(1004, '11:27:00', '2017-05-15', 1, 1, 1, 3, 3, 1),
(1005, '11:27:00', '2017-05-15', 1, 1, 1, 4, 1, 1),
(1006, '11:27:00', '2017-05-15', 1, 1, 1, 5, 2, 1),
(1007, '11:27:00', '2017-05-15', 1, 1, 1, 6, 3, 1),
(1008, '11:27:00', '2017-05-15', 1, 1, 1, 7, 1, 1),
(1009, '11:27:00', '2017-05-15', 1, 1, 1, 8, 1, 1),
(1010, '11:27:00', '2017-05-15', 1, 1, 1, 9, 1, 1),
(1011, '11:27:00', '2017-05-15', 1, 1, 1, 10, 1, 1),
(1012, '11:27:00', '2017-05-15', 1, 1, 1, 11, 1, 1),
(1013, '11:27:00', '2017-05-15', 1, 1, 1, 12, 1, 1),
(1014, '11:27:00', '2017-05-15', 1, 1, 1, 13, 1, 1),
(1015, '11:27:00', '2017-05-15', 1, 1, 1, 14, 1, 1),
(1016, '11:27:00', '2017-05-15', 1, 1, 1, 15, 1, 1),
(1017, '11:27:00', '2017-05-15', 1, 1, 1, 16, 3, 1),
(1018, '11:27:00', '2017-05-15', 1, 1, 1, 17, 1, 1),
(1019, '11:27:00', '2017-05-15', 1, 1, 1, 18, 1, 1),
(1020, '11:27:00', '2017-05-15', 1, 1, 1, 19, 3, 1),
(1021, '11:27:00', '2017-05-15', 1, 1, 1, 20, 1, 1),
(1022, '11:27:00', '2017-05-15', 1, 1, 1, 21, 1, 1),
(1023, '11:27:00', '2017-05-15', 1, 1, 1, 22, 1, 1),
(1024, '11:27:00', '2017-05-15', 1, 1, 1, 23, 1, 1),
(1025, '11:27:00', '2017-05-15', 1, 1, 1, 24, 1, 1),
(1026, '11:27:00', '2017-05-15', 1, 1, 1, 25, 1, 1),
(1027, '11:27:00', '2017-05-15', 1, 1, 1, 26, 1, 1),
(1028, '11:27:00', '2017-05-15', 1, 1, 1, 27, 1, 1),
(1029, '11:27:00', '2017-05-15', 1, 1, 1, 28, 2, 1),
(1030, '11:27:00', '2017-05-15', 1, 1, 1, 29, 1, 1),
(1031, '11:27:00', '2017-05-15', 1, 1, 1, 30, 1, 1),
(1032, '11:27:00', '2017-05-15', 1, 1, 1, 31, 2, 1),
(1033, '11:27:00', '2017-05-15', 1, 1, 1, 32, 1, 1),
(1034, '11:27:00', '2017-05-15', 1, 1, 1, 33, 1, 1),
(1035, '11:27:00', '2017-05-15', 1, 1, 1, 34, 1, 1),
(1036, '11:27:00', '2017-05-15', 1, 1, 1, 35, 1, 1),
(1037, '11:27:00', '2017-05-15', 1, 1, 1, 36, 1, 1),
(1038, '11:27:00', '2017-05-15', 1, 1, 1, 37, 1, 1),
(1039, '11:27:00', '2017-05-15', 1, 1, 1, 38, 1, 1),
(1040, '11:27:00', '2017-05-15', 1, 1, 1, 39, 1, 1),
(1041, '11:27:00', '2017-05-15', 1, 1, 1, 40, 2, 1),
(1042, '11:27:00', '2017-05-15', 1, 1, 1, 41, 1, 1),
(1043, '11:27:00', '2017-05-15', 1, 1, 1, 42, 2, 1),
(1044, '11:27:00', '2017-05-15', 1, 1, 1, 43, 1, 1),
(1045, '11:27:00', '2017-05-15', 1, 1, 1, 44, 1, 1),
(1046, '11:27:00', '2017-05-15', 1, 1, 1, 45, 1, 1),
(1047, '11:27:00', '2017-05-15', 1, 1, 1, 46, 1, 1),
(1048, '11:27:00', '2017-05-15', 1, 1, 1, 47, 1, 1),
(1049, '11:27:00', '2017-05-15', 1, 1, 1, 48, 1, 1),
(1050, '11:27:00', '2017-05-15', 1, 1, 1, 49, 1, 1),
(1051, '11:27:00', '2017-05-15', 1, 1, 1, 50, 2, 1),
(1052, '11:27:00', '2017-05-15', 1, 1, 1, 51, 1, 1),
(1053, '11:27:00', '2017-05-15', 1, 1, 1, 52, 3, 1),
(1054, '11:27:00', '2017-05-15', 1, 1, 1, 53, 1, 1),
(1055, '11:27:00', '2017-05-15', 1, 1, 1, 54, 1, 1),
(1056, '11:27:00', '2017-05-15', 1, 1, 1, 55, 1, 1),
(1057, '11:27:00', '2017-05-15', 1, 1, 1, 56, 1, 1),
(1058, '11:27:00', '2017-05-15', 1, 1, 1, 57, 1, 1),
(1059, '11:27:00', '2017-05-15', 1, 1, 1, 58, 1, 1),
(1060, '11:27:00', '2017-05-15', 1, 1, 1, 59, 1, 1),
(1061, '11:27:00', '2017-05-15', 1, 1, 1, 60, 1, 1),
(1062, '11:27:00', '2017-05-15', 1, 1, 1, 61, 1, 1),
(1063, '11:27:00', '2017-05-15', 1, 1, 1, 62, 1, 1),
(1064, '11:27:00', '2017-05-15', 1, 1, 1, 63, 1, 1),
(1065, '11:27:00', '2017-05-15', 1, 1, 1, 64, 1, 1),
(1066, '11:27:00', '2017-05-15', 1, 1, 1, 65, 1, 1),
(1067, '11:27:00', '2017-05-15', 1, 1, 1, 66, 2, 1),
(1068, '11:27:00', '2017-05-15', 1, 1, 1, 67, 1, 1),
(1069, '11:27:00', '2017-05-15', 1, 1, 1, 68, 2, 1),
(1070, '11:27:00', '2017-05-15', 1, 1, 1, 69, 1, 1),
(1071, '11:27:00', '2017-05-15', 1, 1, 1, 70, 1, 1),
(1072, '11:27:00', '2017-05-15', 1, 1, 1, 71, 1, 1),
(1073, '11:27:00', '2017-05-15', 1, 1, 1, 72, 1, 1),
(1074, '11:27:00', '2017-05-15', 1, 1, 1, 73, 1, 1),
(1075, '11:27:00', '2017-05-15', 1, 1, 1, 74, 1, 1),
(1076, '11:27:00', '2017-05-15', 1, 1, 1, 75, 1, 1),
(1077, '11:27:00', '2017-05-15', 1, 1, 1, 76, 1, 1),
(1078, '11:27:00', '2017-05-15', 1, 1, 1, 77, 1, 1),
(1079, '11:27:00', '2017-05-15', 1, 1, 1, 78, 1, 1),
(1080, '11:27:00', '2017-05-15', 1, 1, 1, 79, 3, 1),
(1081, '11:27:00', '2017-05-15', 1, 1, 1, 80, 1, 1),
(1082, '11:27:00', '2017-05-15', 1, 1, 1, 81, 1, 1),
(1083, '11:27:00', '2017-05-15', 1, 1, 1, 82, 2, 1),
(1084, '11:27:00', '2017-05-15', 1, 1, 1, 83, 1, 1),
(1085, '11:27:00', '2017-05-15', 1, 1, 1, 84, 1, 1),
(1086, '11:27:00', '2017-05-15', 1, 1, 1, 85, 1, 1),
(1087, '11:27:00', '2017-05-15', 1, 1, 1, 86, 1, 1),
(1088, '11:27:00', '2017-05-15', 1, 1, 1, 87, 1, 1),
(1089, '11:27:00', '2017-05-15', 1, 1, 1, 88, 1, 1),
(1090, '11:27:00', '2017-05-15', 1, 1, 1, 89, 1, 1),
(1091, '11:27:00', '2017-05-15', 1, 1, 1, 90, 1, 1),
(1092, '11:27:00', '2017-05-15', 1, 1, 1, 91, 1, 1),
(1093, '11:27:00', '2017-05-15', 1, 1, 1, 92, 1, 1),
(1094, '11:27:00', '2017-05-15', 1, 1, 1, 93, 1, 1),
(1095, '11:27:00', '2017-05-15', 1, 1, 1, 94, 1, 1),
(1096, '11:27:00', '2017-05-15', 1, 1, 1, 95, 1, 1),
(1097, '11:27:00', '2017-05-15', 1, 1, 1, 96, 1, 1),
(1098, '11:27:00', '2017-05-15', 1, 1, 1, 97, 1, 1),
(1099, '11:27:00', '2017-05-15', 1, 1, 1, 98, 1, 1),
(1100, '11:27:00', '2017-05-15', 1, 1, 1, 99, 1, 1),
(1101, '11:27:00', '2017-05-15', 1, 1, 1, 100, 1, 1),
(1102, '11:27:00', '2017-05-15', 1, 1, 1, 101, 1, 1),
(1103, '11:27:00', '2017-05-15', 1, 1, 1, 102, 1, 1),
(1104, '11:27:00', '2017-05-15', 1, 1, 1, 103, 1, 1),
(1105, '11:27:00', '2017-05-15', 1, 1, 1, 104, 1, 1),
(1106, '11:27:00', '2017-05-15', 1, 1, 1, 105, 1, 1),
(1107, '11:27:00', '2017-05-15', 1, 1, 1, 106, 1, 1),
(1108, '11:27:00', '2017-05-15', 1, 1, 1, 107, 1, 1),
(1109, '11:27:00', '2017-05-15', 1, 1, 1, 108, 1, 1),
(1110, '11:27:00', '2017-05-15', 1, 1, 1, 109, 1, 1),
(1111, '11:27:00', '2017-05-15', 1, 1, 1, 110, 1, 1),
(1112, '11:27:00', '2017-05-15', 1, 1, 1, 111, 1, 1),
(1113, '11:39:00', '2017-05-17', 1, 1, 1, 1, 2, 1),
(1114, '11:39:00', '2017-05-17', 1, 1, 1, 2, 2, 1),
(1115, '11:39:00', '2017-05-17', 1, 1, 1, 3, 2, 1),
(1116, '11:39:00', '2017-05-17', 1, 1, 1, 4, 1, 1),
(1117, '11:39:00', '2017-05-17', 1, 1, 1, 5, 1, 1),
(1118, '11:39:00', '2017-05-17', 1, 1, 1, 6, 2, 1),
(1119, '11:39:00', '2017-05-17', 1, 1, 1, 7, 1, 1),
(1120, '11:39:00', '2017-05-17', 1, 1, 1, 8, 1, 1),
(1121, '11:39:00', '2017-05-17', 1, 1, 1, 9, 3, 1),
(1122, '11:39:00', '2017-05-17', 1, 1, 1, 10, 1, 1),
(1123, '11:39:00', '2017-05-17', 1, 1, 1, 11, 1, 1),
(1124, '11:39:00', '2017-05-17', 1, 1, 1, 12, 1, 1),
(1125, '11:39:00', '2017-05-17', 1, 1, 1, 13, 1, 1),
(1126, '11:39:00', '2017-05-17', 1, 1, 1, 14, 1, 1),
(1127, '11:39:00', '2017-05-17', 1, 1, 1, 15, 2, 1),
(1128, '11:39:00', '2017-05-17', 1, 1, 1, 16, 1, 1),
(1129, '11:39:00', '2017-05-17', 1, 1, 1, 17, 1, 1),
(1130, '11:39:00', '2017-05-17', 1, 1, 1, 18, 2, 1),
(1131, '11:39:00', '2017-05-17', 1, 1, 1, 19, 1, 1),
(1132, '11:39:00', '2017-05-17', 1, 1, 1, 20, 1, 1),
(1133, '11:39:00', '2017-05-17', 1, 1, 1, 21, 1, 1),
(1134, '11:39:00', '2017-05-17', 1, 1, 1, 22, 3, 1),
(1135, '11:39:00', '2017-05-17', 1, 1, 1, 23, 1, 1),
(1136, '11:39:00', '2017-05-17', 1, 1, 1, 24, 1, 1),
(1137, '11:39:00', '2017-05-17', 1, 1, 1, 25, 3, 1),
(1138, '11:39:00', '2017-05-17', 1, 1, 1, 26, 1, 1),
(1139, '11:39:00', '2017-05-17', 1, 1, 1, 27, 1, 1),
(1140, '11:39:00', '2017-05-17', 1, 1, 1, 28, 1, 1),
(1141, '11:39:00', '2017-05-17', 1, 1, 1, 29, 1, 1),
(1142, '11:39:00', '2017-05-17', 1, 1, 1, 30, 1, 1),
(1143, '11:39:00', '2017-05-17', 1, 1, 1, 31, 1, 1),
(1144, '11:39:00', '2017-05-17', 1, 1, 1, 32, 1, 1),
(1145, '11:39:00', '2017-05-17', 1, 1, 1, 33, 1, 1),
(1146, '11:39:00', '2017-05-17', 1, 1, 1, 34, 1, 1),
(1147, '11:39:00', '2017-05-17', 1, 1, 1, 35, 1, 1),
(1148, '11:39:00', '2017-05-17', 1, 1, 1, 36, 3, 1),
(1149, '11:39:00', '2017-05-17', 1, 1, 1, 37, 1, 1),
(1150, '11:39:00', '2017-05-17', 1, 1, 1, 38, 1, 1),
(1151, '11:39:00', '2017-05-17', 1, 1, 1, 39, 1, 1),
(1152, '11:39:00', '2017-05-17', 1, 1, 1, 40, 1, 1),
(1153, '11:39:00', '2017-05-17', 1, 1, 1, 41, 1, 1),
(1154, '11:39:00', '2017-05-17', 1, 1, 1, 42, 1, 1),
(1155, '11:39:00', '2017-05-17', 1, 1, 1, 43, 1, 1),
(1156, '11:39:00', '2017-05-17', 1, 1, 1, 44, 1, 1),
(1157, '11:39:00', '2017-05-17', 1, 1, 1, 45, 1, 1),
(1158, '11:39:00', '2017-05-17', 1, 1, 1, 46, 1, 1),
(1159, '11:39:00', '2017-05-17', 1, 1, 1, 47, 1, 1),
(1160, '11:39:00', '2017-05-17', 1, 1, 1, 48, 1, 1),
(1161, '11:39:00', '2017-05-17', 1, 1, 1, 49, 1, 1),
(1162, '11:39:00', '2017-05-17', 1, 1, 1, 50, 1, 1),
(1163, '11:39:00', '2017-05-17', 1, 1, 1, 51, 1, 1),
(1164, '11:39:00', '2017-05-17', 1, 1, 1, 52, 1, 1),
(1165, '11:39:00', '2017-05-17', 1, 1, 1, 53, 1, 1),
(1166, '11:39:00', '2017-05-17', 1, 1, 1, 54, 1, 1),
(1167, '11:39:00', '2017-05-17', 1, 1, 1, 55, 1, 1),
(1168, '11:39:00', '2017-05-17', 1, 1, 1, 56, 1, 1),
(1169, '11:39:00', '2017-05-17', 1, 1, 1, 57, 1, 1),
(1170, '11:39:00', '2017-05-17', 1, 1, 1, 58, 1, 1),
(1171, '11:39:00', '2017-05-17', 1, 1, 1, 59, 1, 1),
(1172, '11:39:00', '2017-05-17', 1, 1, 1, 60, 1, 1),
(1173, '11:39:00', '2017-05-17', 1, 1, 1, 61, 1, 1),
(1174, '11:39:00', '2017-05-17', 1, 1, 1, 62, 1, 1),
(1175, '11:39:00', '2017-05-17', 1, 1, 1, 63, 1, 1),
(1176, '11:39:00', '2017-05-17', 1, 1, 1, 64, 1, 1),
(1177, '11:39:00', '2017-05-17', 1, 1, 1, 65, 1, 1),
(1178, '11:39:00', '2017-05-17', 1, 1, 1, 66, 1, 1),
(1179, '11:39:00', '2017-05-17', 1, 1, 1, 67, 1, 1),
(1180, '11:39:00', '2017-05-17', 1, 1, 1, 68, 1, 1),
(1181, '11:39:00', '2017-05-17', 1, 1, 1, 69, 1, 1),
(1182, '11:39:00', '2017-05-17', 1, 1, 1, 70, 1, 1),
(1183, '11:39:00', '2017-05-17', 1, 1, 1, 71, 1, 1),
(1184, '11:39:00', '2017-05-17', 1, 1, 1, 72, 1, 1),
(1185, '11:39:00', '2017-05-17', 1, 1, 1, 73, 1, 1),
(1186, '11:39:00', '2017-05-17', 1, 1, 1, 74, 1, 1),
(1187, '11:39:00', '2017-05-17', 1, 1, 1, 75, 1, 1),
(1188, '11:39:00', '2017-05-17', 1, 1, 1, 76, 1, 1),
(1189, '11:39:00', '2017-05-17', 1, 1, 1, 77, 1, 1),
(1190, '11:39:00', '2017-05-17', 1, 1, 1, 78, 1, 1),
(1191, '11:39:00', '2017-05-17', 1, 1, 1, 79, 1, 1),
(1192, '11:39:00', '2017-05-17', 1, 1, 1, 80, 1, 1),
(1193, '11:39:00', '2017-05-17', 1, 1, 1, 81, 1, 1),
(1194, '11:39:00', '2017-05-17', 1, 1, 1, 82, 1, 1),
(1195, '11:39:00', '2017-05-17', 1, 1, 1, 83, 1, 1),
(1196, '11:39:00', '2017-05-17', 1, 1, 1, 84, 1, 1),
(1197, '11:39:00', '2017-05-17', 1, 1, 1, 85, 1, 1),
(1198, '11:39:00', '2017-05-17', 1, 1, 1, 86, 1, 1),
(1199, '11:39:00', '2017-05-17', 1, 1, 1, 87, 1, 1),
(1200, '11:39:00', '2017-05-17', 1, 1, 1, 88, 1, 1),
(1201, '11:39:00', '2017-05-17', 1, 1, 1, 89, 1, 1),
(1202, '11:39:00', '2017-05-17', 1, 1, 1, 90, 1, 1),
(1203, '11:39:00', '2017-05-17', 1, 1, 1, 91, 1, 1),
(1204, '11:39:00', '2017-05-17', 1, 1, 1, 92, 1, 1),
(1205, '11:39:00', '2017-05-17', 1, 1, 1, 93, 1, 1),
(1206, '11:39:00', '2017-05-17', 1, 1, 1, 94, 1, 1),
(1207, '11:39:00', '2017-05-17', 1, 1, 1, 95, 1, 1),
(1208, '11:39:00', '2017-05-17', 1, 1, 1, 96, 1, 1),
(1209, '11:39:00', '2017-05-17', 1, 1, 1, 97, 1, 1),
(1210, '11:39:00', '2017-05-17', 1, 1, 1, 98, 1, 1),
(1211, '11:39:00', '2017-05-17', 1, 1, 1, 99, 1, 1),
(1212, '11:39:00', '2017-05-17', 1, 1, 1, 100, 1, 1),
(1213, '11:39:00', '2017-05-17', 1, 1, 1, 101, 1, 1),
(1214, '11:39:00', '2017-05-17', 1, 1, 1, 102, 1, 1),
(1215, '11:39:00', '2017-05-17', 1, 1, 1, 103, 1, 1),
(1216, '11:39:00', '2017-05-17', 1, 1, 1, 104, 1, 1),
(1217, '11:39:00', '2017-05-17', 1, 1, 1, 105, 1, 1),
(1218, '11:39:00', '2017-05-17', 1, 1, 1, 106, 1, 1),
(1219, '11:39:00', '2017-05-17', 1, 1, 1, 107, 1, 1),
(1220, '11:39:00', '2017-05-17', 1, 1, 1, 108, 1, 1),
(1221, '11:39:00', '2017-05-17', 1, 1, 1, 109, 1, 1),
(1222, '11:39:00', '2017-05-17', 1, 1, 1, 110, 1, 1),
(1223, '11:39:00', '2017-05-17', 1, 1, 1, 111, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_attendance_type`
--

CREATE TABLE `tbl_student_attendance_type` (
  `student_attendance_type_id` bigint(20) NOT NULL,
  `default_selected` tinyint(1) NOT NULL,
  `student_attendance_type_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_attendance_type`
--

INSERT INTO `tbl_student_attendance_type` (`student_attendance_type_id`, `default_selected`, `student_attendance_type_name`) VALUES
(1, 1, 'Present'),
(2, 0, 'Absent'),
(3, 0, 'On Duty');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_id_card_generation`
--

CREATE TABLE `tbl_student_id_card_generation` (
  `student_id_card_generation_id` bigint(20) NOT NULL,
  `address_line_1` varchar(255) DEFAULT NULL,
  `address_line_2` varchar(255) DEFAULT NULL,
  `admission_no` varchar(50) NOT NULL,
  `authorized_signature` varchar(100) DEFAULT NULL,
  `bar_Code` varchar(255) NOT NULL,
  `bar_Code_Image` varchar(255) NOT NULL,
  `birth_date` date NOT NULL,
  `student_city` varchar(50) NOT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `student_country` varchar(50) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `instituition_addressline1` varchar(255) NOT NULL,
  `instituition_addressline2` varchar(255) NOT NULL,
  `instituition_city` varchar(255) NOT NULL,
  `instituition_contact` varchar(255) DEFAULT NULL,
  `instituition_country` varchar(255) NOT NULL,
  `instituition_email` varchar(255) NOT NULL,
  `instituition_logo` varchar(255) DEFAULT NULL,
  `instituition_name` varchar(255) NOT NULL,
  `instituition_postcode` varchar(255) NOT NULL,
  `instituition_state` varchar(255) NOT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `parent_contact` varchar(20) DEFAULT NULL,
  `parent_guardian_email` varchar(100) DEFAULT NULL,
  `parent_guardian_first_name` varchar(100) NOT NULL,
  `parent_guardian_last_name` varchar(100) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  `roll_no` varchar(50) DEFAULT NULL,
  `sex` varchar(7) NOT NULL,
  `student_state` varchar(50) NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `blood_group_id` bigint(20) DEFAULT NULL,
  `institution_id` bigint(20) NOT NULL,
  `section_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `student_class_id` bigint(20) NOT NULL,
  `student_status_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_id_card_generation`
--

INSERT INTO `tbl_student_id_card_generation` (`student_id_card_generation_id`, `address_line_1`, `address_line_2`, `admission_no`, `authorized_signature`, `bar_Code`, `bar_Code_Image`, `birth_date`, `student_city`, `contact`, `student_country`, `created_by`, `created_date`, `email`, `first_name`, `instituition_addressline1`, `instituition_addressline2`, `instituition_city`, `instituition_contact`, `instituition_country`, `instituition_email`, `instituition_logo`, `instituition_name`, `instituition_postcode`, `instituition_state`, `last_name`, `modified_by`, `modified_date`, `parent_contact`, `parent_guardian_email`, `parent_guardian_first_name`, `parent_guardian_last_name`, `postcode`, `roll_no`, `sex`, `student_state`, `academic_year_id`, `blood_group_id`, `institution_id`, `section_id`, `student_id`, `student_class_id`, `student_status_id`) VALUES
(225, 'Line1', 'Line2', '123456', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238764446', '/resources/themes/images/student-barcode-image/Class-I/Middle/Jo1494238764489.jpg', '2017-04-04', 'Tiruchirapalli', '8220723514', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'anand@jdsoft.in', 'Jo', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', 'Anand', 'admin@jdsoft.in', '2017-05-08 10:19:28', '1234567890', 'parent.anand@jdsoft.in', 'FN', 'LN', '123131', NULL, 'Male', 'Tamil Nadu', 1, 4, 1, 1, 1, 1, 1),
(226, 'VOC Street', 'Second Flate', '1001', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769142', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aachman1494238769142.jpg', '1993-08-09', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aachman@gmail.com', 'Aachman', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', '', 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Aachman@gmail.com', 'Aachman', '', '620018', NULL, 'Male', 'Tamil Nadu', 1, 7, 1, 1, 2, 1, 1),
(227, 'VOC Street', 'Second Flate', '1002', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769208', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aadesh1494238769208.jpg', '1993-08-10', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aadesh@gmail.com', 'Aadesh', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Aadesh@gmail.com', 'Aadesh', NULL, '620019', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 3, 1, 1),
(228, 'VOC Street', 'Second Flate', '1003', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769248', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aadi1494238769248.jpg', '1993-08-11', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aadi@gmail.com', 'Aadi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Aadi@gmail.com', 'Aadi', NULL, '620020', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 4, 1, 1),
(229, 'VOC Street', 'Second Flate', '1004', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769300', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aafreen1494238769300.jpg', '1993-08-12', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aafreen@gmail.com', 'Aafreen', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Aafreen@gmail.com', 'Aafreen', NULL, '620021', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 5, 1, 1),
(230, 'VOC Street', 'Second Flate', '1005', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769356', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aakar1494238769357.jpg', '1993-08-13', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aakar@gmail.com', 'Aakar', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Aakar@gmail.com', 'Aakar', NULL, '620022', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 6, 1, 1),
(231, 'VOC Street', 'Second Flate', '1006', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769391', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aakash1494238769391.jpg', '1993-08-14', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aakash@gmail.com', 'Aakash', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Aakash@gmail.com', 'Aakash', NULL, '620023', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 7, 1, 1),
(232, 'VOC Street', 'Second Flate', '1007', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769420', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aalap1494238769420.jpg', '1993-08-15', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aalap@gmail.com', 'Aalap', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Aalap@gmail.com', 'Aalap', NULL, '620024', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 8, 1, 1),
(233, 'VOC Street', 'Second Flate', '1008', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769443', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aandaleeb1494238769443.jpg', '1993-08-16', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aandaleeb@gmail.com', 'Aandaleeb', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Aandaleeb@gmail.com', 'Aandaleeb', NULL, '620025', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 9, 1, 1),
(234, 'VOC Street', 'Second Flate', '1009', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769458', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aashish1494238769458.jpg', '1993-08-17', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aashish@gmail.com', 'Aashish', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Aashish@gmail.com', 'Aashish', NULL, '620026', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 10, 1, 1),
(235, 'VOC Street', 'Second Flate', '1010', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769480', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abeer1494238769480.jpg', '1993-08-18', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abeer@gmail.com', 'Abeer', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abeer@gmail.com', 'Abeer', NULL, '620027', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 11, 1, 1),
(236, 'VOC Street', 'Second Flate', '1011', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769534', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhay1494238769534.jpg', '1993-08-19', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhay@gmail.com', 'Abhay', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhay@gmail.com', 'Abhay', NULL, '620028', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 12, 1, 1),
(237, 'VOC Street', 'Second Flate', '1012', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769545', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhayananda1494238769545.jpg', '1993-08-20', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhayananda@gmail.com', 'Abhayananda', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhayananda@gmail.com', 'Abhayananda', NULL, '620029', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 13, 1, 1),
(238, 'VOC Street', 'Second Flate', '1013', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769555', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhayaprada1494238769555.jpg', '1993-08-21', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhayaprada@gmail.com', 'Abhayaprada', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhayaprada@gmail.com', 'Abhayaprada', NULL, '620030', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 14, 1, 1),
(239, 'VOC Street', 'Second Flate', '1014', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769591', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abheek1494238769591.jpg', '1993-08-22', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abheek@gmail.com', 'Abheek', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abheek@gmail.com', 'Abheek', NULL, '620031', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 15, 1, 1),
(240, 'VOC Street', 'Second Flate', '1015', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769613', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhi1494238769613.jpg', '1993-08-23', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhi@gmail.com', 'Abhi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhi@gmail.com', 'Abhi', NULL, '620032', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 16, 1, 1),
(241, 'VOC Street', 'Second Flate', '1016', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769633', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhibhava1494238769633.jpg', '1993-08-24', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhibhava@gmail.com', 'Abhibhava', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhibhava@gmail.com', 'Abhibhava', NULL, '620033', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 17, 1, 1),
(242, 'VOC Street', 'Second Flate', '1017', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769646', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhicandra1494238769646.jpg', '1993-08-25', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhicandra@gmail.com', 'Abhicandra', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhicandra@gmail.com', 'Abhicandra', NULL, '620034', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 18, 1, 1),
(243, 'VOC Street', 'Second Flate', '1018', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769659', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhidi1494238769659.jpg', '1993-08-26', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhidi@gmail.com', 'Abhidi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhidi@gmail.com', 'Abhidi', NULL, '620035', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 19, 1, 1),
(244, 'VOC Street', 'Second Flate', '1019', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769690', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhihita1494238769690.jpg', '1993-08-27', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhihita@gmail.com', 'Abhihita', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhihita@gmail.com', 'Abhihita', NULL, '620036', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 20, 1, 1),
(245, 'VOC Street', 'Second Flate', '1020', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769853', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhijat1494238769853.jpg', '1993-08-28', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhijat@gmail.com', 'Abhijat', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhijat@gmail.com', 'Abhijat', NULL, '620037', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 21, 1, 1),
(246, 'VOC Street', 'Second Flate', '1021', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769867', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhijaya1494238769867.jpg', '1993-08-29', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhijaya@gmail.com', 'Abhijaya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhijaya@gmail.com', 'Abhijaya', NULL, '620038', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 22, 1, 1),
(247, 'VOC Street', 'Second Flate', '1022', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769899', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhijit1494238769899.jpg', '1993-08-30', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhijit@gmail.com', 'Abhijit', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhijit@gmail.com', 'Abhijit', NULL, '620039', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 23, 1, 1),
(248, 'VOC Street', 'Second Flate', '1023', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769909', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhijvala1494238769910.jpg', '1993-08-31', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhijvala@gmail.com', 'Abhijvala', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhijvala@gmail.com', 'Abhijvala', NULL, '620040', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 24, 1, 1),
(249, 'VOC Street', 'Second Flate', '1024', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769919', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhilash1494238769919.jpg', '1993-09-01', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhilash@gmail.com', 'Abhilash', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhilash@gmail.com', 'Abhilash', NULL, '620041', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 25, 1, 1),
(250, 'VOC Street', 'Second Flate', '1025', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769959', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhimand1494238769959.jpg', '1993-09-02', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhimand@gmail.com', 'Abhimand', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:29', '3698521470', 'parent.Abhimand@gmail.com', 'Abhimand', NULL, '620042', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 26, 1, 1),
(251, 'VOC Street', 'Second Flate', '1026', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238769998', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aashika1494238769998.jpg', '1993-09-03', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aashika@gmail.com', 'Aashika', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Aashika@gmail.com', 'Aashika', NULL, '620043', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 27, 1, 1),
(252, 'VOC Street', 'Second Flate', '1027', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770009', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abha1494238770009.jpg', '1993-09-04', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abha@gmail.com', 'Abha', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abha@gmail.com', 'Abha', NULL, '620044', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 28, 1, 1),
(253, 'VOC Street', 'Second Flate', '1028', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770021', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhati1494238770022.jpg', '1993-09-05', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhati@gmail.com', 'Abhati', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhati@gmail.com', 'Abhati', NULL, '620045', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 29, 1, 1),
(254, 'VOC Street', 'Second Flate', '1029', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770045', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhaya1494238770045.jpg', '1993-09-06', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhaya@gmail.com', 'Abhaya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhaya@gmail.com', 'Abhaya', NULL, '620046', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 30, 1, 1),
(255, 'VOC Street', 'Second Flate', '1030', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770056', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhidha1494238770056.jpg', '1993-09-07', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhidha@gmail.com', 'Abhidha', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhidha@gmail.com', 'Abhidha', NULL, '620047', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 31, 1, 1),
(256, 'VOC Street', 'Second Flate', '1031', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770071', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhidhya1494238770071.jpg', '1993-09-08', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhidhya@gmail.com', 'Abhidhya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhidhya@gmail.com', 'Abhidhya', NULL, '620048', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 32, 1, 1),
(257, 'VOC Street', 'Second Flate', '1032', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770085', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhijna1494238770085.jpg', '1993-09-09', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhijna@gmail.com', 'Abhijna', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhijna@gmail.com', 'Abhijna', NULL, '620049', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 33, 1, 1),
(258, 'VOC Street', 'Second Flate', '1033', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770111', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhilasa1494238770111.jpg', '1993-09-10', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhilasa@gmail.com', 'Abhilasa', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhilasa@gmail.com', 'Abhilasa', NULL, '620050', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 34, 1, 1),
(259, 'VOC Street', 'Second Flate', '1034', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770134', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhilasha1494238770135.jpg', '1993-09-11', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhilasha@gmail.com', 'Abhilasha', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhilasha@gmail.com', 'Abhilasha', NULL, '620051', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 35, 1, 1),
(260, 'VOC Street', 'Second Flate', '1035', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770146', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhinithi1494238770146.jpg', '1993-09-12', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhinithi@gmail.com', 'Abhinithi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhinithi@gmail.com', 'Abhinithi', NULL, '620052', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 36, 1, 1),
(261, 'VOC Street', 'Second Flate', '1036', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770159', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhiprithi1494238770159.jpg', '1993-09-13', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhiprithi@gmail.com', 'Abhiprithi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhiprithi@gmail.com', 'Abhiprithi', NULL, '620053', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 37, 1, 1),
(262, 'VOC Street', 'Second Flate', '1037', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770173', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhirathi1494238770173.jpg', '1993-09-14', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhirathi@gmail.com', 'Abhirathi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhirathi@gmail.com', 'Abhirathi', NULL, '620054', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 38, 1, 1),
(263, 'VOC Street', 'Second Flate', '1038', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770183', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhisri1494238770183.jpg', '1993-09-15', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhisri@gmail.com', 'Abhisri', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhisri@gmail.com', 'Abhisri', NULL, '620055', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 39, 1, 1),
(264, 'VOC Street', 'Second Flate', '1039', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770194', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abhithi1494238770195.jpg', '1993-09-16', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abhithi@gmail.com', 'Abhithi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abhithi@gmail.com', 'Abhithi', NULL, '620056', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 40, 1, 1),
(265, 'VOC Street', 'Second Flate', '1040', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770209', '/resources/themes/images/student-barcode-image/Class-I/Middle/Abja1494238770209.jpg', '1993-09-17', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Abja@gmail.com', 'Abja', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Abja@gmail.com', 'Abja', NULL, '620057', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 41, 1, 1),
(266, 'VOC Street', 'Second Flate', '1041', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770220', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aboil1494238770220.jpg', '1993-09-18', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aboil@gmail.com', 'Aboil', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Aboil@gmail.com', 'Aboil', NULL, '620058', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 42, 1, 1),
(267, 'VOC Street', 'Second Flate', '1042', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770230', '/resources/themes/images/student-barcode-image/Class-I/Middle/Achala1494238770230.jpg', '1993-09-19', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Achala@gmail.com', 'Achala', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Achala@gmail.com', 'Achala', NULL, '620059', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 43, 1, 1),
(268, 'VOC Street', 'Second Flate', '1043', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770251', '/resources/themes/images/student-barcode-image/Class-I/Middle/Acira1494238770252.jpg', '1993-09-20', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Acira@gmail.com', 'Acira', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Acira@gmail.com', 'Acira', NULL, '620060', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 44, 1, 1),
(269, 'VOC Street', 'Second Flate', '1044', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770269', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adarsha1494238770269.jpg', '1993-09-21', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adarsha@gmail.com', 'Adarsha', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adarsha@gmail.com', 'Adarsha', NULL, '620061', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 45, 1, 1),
(270, 'VOC Street', 'Second Flate', '1045', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770280', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adhira1494238770280.jpg', '1993-09-22', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adhira@gmail.com', 'Adhira', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adhira@gmail.com', 'Adhira', NULL, '620062', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 46, 1, 1),
(271, 'VOC Street', 'Second Flate', '1046', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770291', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adishree1494238770291.jpg', '1993-09-23', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adishree@gmail.com', 'Adishree', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adishree@gmail.com', 'Adishree', NULL, '620063', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 47, 1, 1),
(272, 'VOC Street', 'Second Flate', '1047', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770301', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aditha1494238770301.jpg', '1993-09-24', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aditha@gmail.com', 'Aditha', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Aditha@gmail.com', 'Aditha', NULL, '620064', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 48, 1, 1),
(273, 'VOC Street', 'Second Flate', '1048', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770318', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adithi1494238770318.jpg', '1993-09-25', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adithi@gmail.com', 'Adithi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adithi@gmail.com', 'Adithi', NULL, '620065', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 49, 1, 1),
(274, 'VOC Street', 'Second Flate', '1049', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770329', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aditi1494238770329.jpg', '1993-09-26', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aditi@gmail.com', 'Aditi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Aditi@gmail.com', 'Aditi', NULL, '620066', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 50, 1, 1),
(275, 'VOC Street', 'Second Flate', '1050', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770339', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adrija1494238770339.jpg', '1993-09-27', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adrija@gmail.com', 'Adrija', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adrija@gmail.com', 'Adrija', NULL, '620067', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 51, 1, 1),
(276, 'VOC Street', 'Second Flate', '1051', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770350', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adrika1494238770350.jpg', '1993-09-28', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adrika@gmail.com', 'Adrika', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adrika@gmail.com', 'Adrika', NULL, '620068', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 52, 1, 1),
(277, 'VOC Street', 'Second Flate', '1052', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770363', '/resources/themes/images/student-barcode-image/Class-I/Middle/Advika1494238770363.jpg', '1993-09-29', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Advika@gmail.com', 'Advika', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Advika@gmail.com', 'Advika', NULL, '620069', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 53, 1, 1),
(278, 'VOC Street', 'Second Flate', '1053', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770385', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adya1494238770385.jpg', '1993-09-30', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adya@gmail.com', 'Adya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adya@gmail.com', 'Adya', NULL, '620070', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 54, 1, 1),
(279, 'VOC Street', 'Second Flate', '1054', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770405', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aghanashini1494238770405.jpg', '1993-10-01', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aghanashini@gmail.com', 'Aghanashini', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Aghanashini@gmail.com', 'Aghanashini', NULL, '620071', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 55, 1, 1),
(280, 'VOC Street', 'Second Flate', '1055', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770429', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agrata1494238770429.jpg', '1993-10-02', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agrata@gmail.com', 'Agrata', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Agrata@gmail.com', 'Agrata', NULL, '620072', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 56, 1, 1),
(281, 'VOC Street', 'Second Flate', '1056', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770447', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agrima1494238770447.jpg', '1993-10-03', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agrima@gmail.com', 'Agrima', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Agrima@gmail.com', 'Agrima', NULL, '620073', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 57, 1, 1),
(282, 'VOC Street', 'Second Flate', '1057', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770469', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ahalya1494238770469.jpg', '1993-10-04', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ahalya@gmail.com', 'Ahalya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Ahalya@gmail.com', 'Ahalya', NULL, '620074', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 58, 1, 1),
(283, 'VOC Street', 'Second Flate', '1058', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770482', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ahilya1494238770482.jpg', '1993-10-05', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ahilya@gmail.com', 'Ahilya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Ahilya@gmail.com', 'Ahilya', NULL, '620075', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 59, 1, 1),
(284, 'VOC Street', 'Second Flate', '1059', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770507', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ahladita1494238770507.jpg', '1993-10-06', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ahladita@gmail.com', 'Ahladita', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Ahladita@gmail.com', 'Ahladita', NULL, '620076', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 60, 1, 1),
(285, 'VOC Street', 'Second Flate', '1060', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770522', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ahladitha1494238770522.jpg', '1993-10-07', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ahladitha@gmail.com', 'Ahladitha', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Ahladitha@gmail.com', 'Ahladitha', NULL, '620077', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 61, 1, 1),
(286, 'VOC Street', 'Second Flate', '1061', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770546', '/resources/themes/images/student-barcode-image/Class-I/Middle/Achyuta1494238770546.jpg', '1993-10-08', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Achyuta@gmail.com', 'Achyuta', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Achyuta@gmail.com', 'Achyuta', NULL, '620078', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 62, 1, 1),
(287, 'VOC Street', 'Second Flate', '1062', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770615', '/resources/themes/images/student-barcode-image/Class-I/Middle/Acintya1494238770615.jpg', '1993-10-09', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Acintya@gmail.com', 'Acintya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Acintya@gmail.com', 'Acintya', NULL, '620079', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 63, 1, 1),
(288, 'VOC Street', 'Second Flate', '1063', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770662', '/resources/themes/images/student-barcode-image/Class-I/Middle/Acyutaraya1494238770662.jpg', '1993-10-10', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Acyutaraya@gmail.com', 'Acyutaraya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Acyutaraya@gmail.com', 'Acyutaraya', NULL, '620080', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 64, 1, 1),
(289, 'VOC Street', 'Second Flate', '1064', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770696', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adalarasu1494238770696.jpg', '1993-10-11', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adalarasu@gmail.com', 'Adalarasu', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adalarasu@gmail.com', 'Adalarasu', NULL, '620081', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 65, 1, 1),
(290, 'VOC Street', 'Second Flate', '1065', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770826', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adarsh1494238770826.jpg', '1993-10-12', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adarsh@gmail.com', 'Adarsh', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adarsh@gmail.com', 'Adarsh', NULL, '620082', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 66, 1, 1);
INSERT INTO `tbl_student_id_card_generation` (`student_id_card_generation_id`, `address_line_1`, `address_line_2`, `admission_no`, `authorized_signature`, `bar_Code`, `bar_Code_Image`, `birth_date`, `student_city`, `contact`, `student_country`, `created_by`, `created_date`, `email`, `first_name`, `instituition_addressline1`, `instituition_addressline2`, `instituition_city`, `instituition_contact`, `instituition_country`, `instituition_email`, `instituition_logo`, `instituition_name`, `instituition_postcode`, `instituition_state`, `last_name`, `modified_by`, `modified_date`, `parent_contact`, `parent_guardian_email`, `parent_guardian_first_name`, `parent_guardian_last_name`, `postcode`, `roll_no`, `sex`, `student_state`, `academic_year_id`, `blood_group_id`, `institution_id`, `section_id`, `student_id`, `student_class_id`, `student_status_id`) VALUES
(291, 'VOC Street', 'Second Flate', '1066', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770854', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adesh1494238770855.jpg', '1993-10-13', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adesh@gmail.com', 'Adesh', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adesh@gmail.com', 'Adesh', NULL, '620083', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 67, 1, 1),
(292, 'VOC Street', 'Second Flate', '1067', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770873', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adhik1494238770873.jpg', '1993-10-14', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adhik@gmail.com', 'Adhik', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adhik@gmail.com', 'Adhik', NULL, '620084', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 68, 1, 1),
(293, 'VOC Street', 'Second Flate', '1068', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770884', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adhikara1494238770884.jpg', '1993-10-15', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adhikara@gmail.com', 'Adhikara', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:30', '3698521470', 'parent.Adhikara@gmail.com', 'Adhikara', NULL, '620085', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 69, 1, 1),
(294, 'VOC Street', 'Second Flate', '1069', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238770986', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adhipa1494238770986.jpg', '1993-10-16', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adhipa@gmail.com', 'Adhipa', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adhipa@gmail.com', 'Adhipa', NULL, '620086', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 70, 1, 1),
(295, 'VOC Street', 'Second Flate', '1070', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771007', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adhita1494238771007.jpg', '1993-10-17', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adhita@gmail.com', 'Adhita', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adhita@gmail.com', 'Adhita', NULL, '620087', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 71, 1, 1),
(296, 'VOC Street', 'Second Flate', '1071', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771021', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adikavi1494238771021.jpg', '1993-10-18', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adikavi@gmail.com', 'Adikavi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adikavi@gmail.com', 'Adikavi', NULL, '620088', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 72, 1, 1),
(297, 'VOC Street', 'Second Flate', '1072', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771046', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adil1494238771046.jpg', '1993-10-19', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adil@gmail.com', 'Adil', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adil@gmail.com', 'Adil', NULL, '620089', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 73, 1, 1),
(298, 'VOC Street', 'Second Flate', '1073', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771087', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adinath1494238771087.jpg', '1993-10-20', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adinath@gmail.com', 'Adinath', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adinath@gmail.com', 'Adinath', NULL, '620090', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 74, 1, 1),
(299, 'VOC Street', 'Second Flate', '1074', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771100', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adit1494238771100.jpg', '1993-10-21', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adit@gmail.com', 'Adit', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adit@gmail.com', 'Adit', NULL, '620091', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 75, 1, 1),
(300, 'VOC Street', 'Second Flate', '1075', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771114', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aditeya1494238771114.jpg', '1993-10-22', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aditeya@gmail.com', 'Aditeya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Aditeya@gmail.com', 'Aditeya', NULL, '620092', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 76, 1, 1),
(301, 'VOC Street', 'Second Flate', '1076', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771145', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aditya1494238771145.jpg', '1993-10-23', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aditya@gmail.com', 'Aditya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Aditya@gmail.com', 'Aditya', NULL, '620093', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 77, 1, 1),
(302, 'VOC Street', 'Second Flate', '1077', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771180', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adityanandana1494238771180.jpg', '1993-10-24', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adityanandana@gmail.com', 'Adityanandana', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adityanandana@gmail.com', 'Adityanandana', NULL, '620094', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 78, 1, 1),
(303, 'VOC Street', 'Second Flate', '1078', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771195', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adityavardhana1494238771195.jpg', '1993-10-25', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adityavardhana@gmail.com', 'Adityavardhana', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adityavardhana@gmail.com', 'Adityavardhana', NULL, '620095', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 79, 1, 1),
(304, 'VOC Street', 'Second Flate', '1079', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771233', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adripathi1494238771233.jpg', '1993-10-26', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adripathi@gmail.com', 'Adripathi', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adripathi@gmail.com', 'Adripathi', NULL, '620096', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 80, 1, 1),
(305, 'VOC Street', 'Second Flate', '1080', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771271', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adwaita1494238771271.jpg', '1993-10-27', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adwaita@gmail.com', 'Adwaita', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adwaita@gmail.com', 'Adwaita', NULL, '620097', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 81, 1, 1),
(306, 'VOC Street', 'Second Flate', '1081', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771281', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adway1494238771281.jpg', '1993-10-28', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adway@gmail.com', 'Adway', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adway@gmail.com', 'Adway', NULL, '620098', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 82, 1, 1),
(307, 'VOC Street', 'Second Flate', '1082', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771313', '/resources/themes/images/student-barcode-image/Class-I/Middle/Adwaya1494238771313.jpg', '1993-10-29', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Adwaya@gmail.com', 'Adwaya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Adwaya@gmail.com', 'Adwaya', NULL, '620099', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 83, 1, 1),
(308, 'VOC Street', 'Second Flate', '1083', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771335', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aftab,Aftaab1494238771335.jpg', '1993-10-30', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aftab,Aftaab@gmail.com', 'Aftab,Aftaab', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Aftab,Aftaab@gmail.com', 'Aftab,Aftaab', NULL, '620100', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 84, 1, 1),
(309, 'VOC Street', 'Second Flate', '1084', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771358', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agasti, Agastya1494238771358.jpg', '1993-10-31', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agasti, Agastya@gmail.com', 'Agasti, Agastya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Agasti, Agastya@gmail.com', 'Agasti, Agastya', NULL, '620101', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 85, 1, 1),
(310, 'VOC Street', 'Second Flate', '1085', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771377', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agendra1494238771377.jpg', '1993-11-01', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agendra@gmail.com', 'Agendra', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Agendra@gmail.com', 'Agendra', NULL, '620102', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 86, 1, 1),
(311, 'VOC Street', 'Second Flate', '1086', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771416', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agha1494238771417.jpg', '1993-11-02', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agha@gmail.com', 'Agha', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Agha@gmail.com', 'Agha', NULL, '620103', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 87, 1, 1),
(312, 'VOC Street', 'Second Flate', '1087', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771445', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agharna1494238771445.jpg', '1993-11-03', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agharna@gmail.com', 'Agharna', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Agharna@gmail.com', 'Agharna', NULL, '620104', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 88, 1, 1),
(313, 'VOC Street', 'Second Flate', '1088', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771456', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aghat1494238771456.jpg', '1993-11-04', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aghat@gmail.com', 'Aghat', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Aghat@gmail.com', 'Aghat', NULL, '620105', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 89, 1, 1),
(314, 'VOC Street', 'Second Flate', '1089', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771467', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agneya1494238771467.jpg', '1993-11-05', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agneya@gmail.com', 'Agneya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Agneya@gmail.com', 'Agneya', NULL, '620106', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 90, 1, 1),
(315, 'VOC Street', 'Second Flate', '1090', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771476', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agnikumara1494238771476.jpg', '1993-11-06', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agnikumara@gmail.com', 'Agnikumara', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Agnikumara@gmail.com', 'Agnikumara', NULL, '620107', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 91, 1, 1),
(316, 'VOC Street', 'Second Flate', '1091', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771484', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agniprava1494238771484.jpg', '1993-11-07', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agniprava@gmail.com', 'Agniprava', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Agniprava@gmail.com', 'Agniprava', NULL, '620108', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 92, 1, 1),
(317, 'VOC Street', 'Second Flate', '1092', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771499', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agrim1494238771499.jpg', '1993-11-08', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agrim@gmail.com', 'Agrim', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Agrim@gmail.com', 'Agrim', NULL, '620109', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 93, 1, 1),
(318, 'VOC Street', 'Second Flate', '1093', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771511', '/resources/themes/images/student-barcode-image/Class-I/Middle/Agriya1494238771511.jpg', '1993-11-09', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Agriya@gmail.com', 'Agriya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Agriya@gmail.com', 'Agriya', NULL, '620110', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 94, 1, 1),
(319, 'VOC Street', 'Second Flate', '1094', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771521', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ahijit1494238771521.jpg', '1993-11-10', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ahijit@gmail.com', 'Ahijit', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ahijit@gmail.com', 'Ahijit', NULL, '620111', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 95, 1, 1),
(320, 'VOC Street', 'Second Flate', '1095', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771545', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ahilan1494238771545.jpg', '1993-11-11', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ahilan@gmail.com', 'Ahilan', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ahilan@gmail.com', 'Ahilan', NULL, '620112', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 96, 1, 1),
(321, 'VOC Street', 'Second Flate', '1096', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771565', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ahmad1494238771565.jpg', '1993-11-12', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ahmad@gmail.com', 'Ahmad', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ahmad@gmail.com', 'Ahmad', NULL, '620113', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 97, 1, 1),
(322, 'VOC Street', 'Second Flate', '1097', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771574', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ahsan1494238771574.jpg', '1993-11-13', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ahsan@gmail.com', 'Ahsan', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ahsan@gmail.com', 'Ahsan', NULL, '620114', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 98, 1, 1),
(323, 'VOC Street', 'Second Flate', '1098', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771603', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aijaz1494238771603.jpg', '1993-11-14', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aijaz@gmail.com', 'Aijaz', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Aijaz@gmail.com', 'Aijaz', NULL, '620115', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 99, 1, 1),
(324, 'VOC Street', 'Second Flate', '1099', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771614', '/resources/themes/images/student-barcode-image/Class-I/Middle/Aiman1494238771614.jpg', '1993-11-15', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Aiman@gmail.com', 'Aiman', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Aiman@gmail.com', 'Aiman', NULL, '620116', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 100, 1, 1),
(325, 'VOC Street', 'Second Flate', '1100', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771655', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ainesh1494238771656.jpg', '1993-11-16', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ainesh@gmail.com', 'Ainesh', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ainesh@gmail.com', 'Ainesh', NULL, '620117', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 101, 1, 1),
(326, 'VOC Street', 'Second Flate', '1101', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771788', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ajamil1494238771788.jpg', '1993-11-17', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ajamil@gmail.com', 'Ajamil', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ajamil@gmail.com', 'Ajamil', NULL, '620118', NULL, 'Female', 'Tamil Nadu', 1, NULL, 1, 1, 102, 1, 1),
(327, 'VOC Street', 'Second Flate', '1102', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771798', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ajatashatru1494238771798.jpg', '1993-11-18', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ajatashatru@gmail.com', 'Ajatashatru', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ajatashatru@gmail.com', 'Ajatashatru', NULL, '620119', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 103, 1, 1),
(328, 'VOC Street', 'Second Flate', '1103', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771812', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ajay1494238771813.jpg', '1993-11-19', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ajay@gmail.com', 'Ajay', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ajay@gmail.com', 'Ajay', NULL, '620120', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 104, 1, 1),
(329, 'VOC Street', 'Second Flate', '1104', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771823', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ajinkya1494238771823.jpg', '1993-11-20', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ajinkya@gmail.com', 'Ajinkya', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ajinkya@gmail.com', 'Ajinkya', NULL, '620121', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 105, 1, 1),
(330, 'VOC Street', 'Second Flate', '1105', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771834', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ajit1494238771834.jpg', '1993-11-21', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ajit@gmail.com', 'Ajit', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ajit@gmail.com', 'Ajit', NULL, '620122', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 106, 1, 1),
(331, 'VOC Street', 'Second Flate', '1106', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771866', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ajitabh1494238771866.jpg', '1993-11-22', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ajitabh@gmail.com', 'Ajitabh', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ajitabh@gmail.com', 'Ajitabh', NULL, '620123', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 107, 1, 1),
(332, 'VOC Street', 'Second Flate', '1107', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771911', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ajitesh1494238771911.jpg', '1993-11-23', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ajitesh@gmail.com', 'Ajitesh', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ajitesh@gmail.com', 'Ajitesh', NULL, '620124', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 108, 1, 1),
(333, 'VOC Street', 'Second Flate', '1108', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771927', '/resources/themes/images/student-barcode-image/Class-I/Middle/Ajmal1494238771927.jpg', '1993-11-24', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Ajmal@gmail.com', 'Ajmal', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Ajmal@gmail.com', 'Ajmal', NULL, '620125', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 109, 1, 1),
(334, 'VOC Street', 'Second Flate', '1109', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771942', '/resources/themes/images/student-barcode-image/Class-I/Middle/Akalmash1494238771942.jpg', '1993-11-25', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Akalmash@gmail.com', 'Akalmash', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Akalmash@gmail.com', 'Akalmash', NULL, '620126', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 110, 1, 1),
(335, 'VOC Street', 'Second Flate', '1110', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494238771952', '/resources/themes/images/student-barcode-image/Class-I/Middle/Akalpa1494238771952.jpg', '1993-11-26', 'Chennai', '6578748910', 'India', 'admin@jdsoft.in', '2017-05-08 15:49:24', 'Akalpa@gmail.com', 'Akalpa', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', NULL, 'admin@jdsoft.in', '2017-05-08 10:19:31', '3698521470', 'parent.Akalpa@gmail.com', 'Akalpa', NULL, '620127', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 111, 1, 1),
(336, 'dsfs', 'dfsfsf', '3454353535353', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494239950751', '/resources/themes/images/student-barcode-image/Class-II/Middle/fdf1494239950751.jpg', '2017-04-11', 'Tiruchirapalli', '234242342432', 'India', 'admin@jdsoft.in', '2017-05-08 16:09:10', 'sdsdsd@gmail.om', 'fdf', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', 'sds', 'admin@jdsoft.in', '2017-05-08 10:39:10', '34242342424', 'dsd@gmail.com', 'dsdsd', 'sdsd', '123456', NULL, 'Male', 'Tamil Nadu', 1, NULL, 1, 1, 113, 2, 1),
(337, 'dsfs', 'dfsfsf', '3454353535353', '/resources/themes/images/institute-authorized-signature/14942251282671329594885445507040517.png', 'CBSE1494246410636', '/resources/themes/images/student-barcode-image/Class-II/Middle/fdf1494246410668.jpg', '2017-04-11', 'Tiruchirapalli', '234242342432', 'India', 'admin@jdsoft.in', '2017-05-08 17:56:50', 'sdsdsd@gmail.om', 'fdf', 'Line1', 'Line2', 'Tiruchirapalli', '123456', 'India', 'test@test.com', '/resources/themes/images/institute-logo/1494225128265IMG_335465.jpg', 'Government Arts College', '123456', 'Tamil Nadu', 'sds', 'admin@jdsoft.in', '2017-05-08 12:26:51', '34242342424', 'dsd@gmail.com', 'dsdsd', 'sdsd', '123456', NULL, 'Male', 'Tamil Nadu', 3, NULL, 1, 1, 113, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_invoice`
--

CREATE TABLE `tbl_student_invoice` (
  `student_invoice_id` bigint(20) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `discount_applicable` tinyint(1) NOT NULL,
  `generated_date` date NOT NULL,
  `invoice_amount` double NOT NULL,
  `invoice_no` varchar(100) NOT NULL,
  `invoice_status` int(11) NOT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `academic_year_id` bigint(20) NOT NULL,
  `fees_term_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `studentReceipt_student_receipt_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_invoice`
--

INSERT INTO `tbl_student_invoice` (`student_invoice_id`, `created_by`, `created_date`, `discount_applicable`, `generated_date`, `invoice_amount`, `invoice_no`, `invoice_status`, `modified_by`, `modified_date`, `academic_year_id`, `fees_term_id`, `institution_id`, `student_id`, `studentReceipt_student_receipt_id`) VALUES
(1, 'admin@jdsoft.in', '2017-04-06 12:49:00', 1, '2017-04-06', 7350, '1', 0, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 1, NULL),
(2, 'admin@jdsoft.in', '2017-04-06 12:49:00', 1, '2017-04-06', 7350, '2', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 2, NULL),
(3, 'admin@jdsoft.in', '2017-04-06 12:49:00', 1, '2017-04-06', 7350, '3', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 3, NULL),
(4, 'admin@jdsoft.in', '2017-04-06 12:49:00', 1, '2017-04-06', 7350, '4', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 4, NULL),
(5, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '5', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 5, NULL),
(6, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '6', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 6, NULL),
(7, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '7', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 7, NULL),
(8, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '8', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 8, NULL),
(9, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '9', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 9, NULL),
(10, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '10', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 10, NULL),
(11, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '11', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 11, NULL),
(12, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '12', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 12, NULL),
(13, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '13', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 13, NULL),
(14, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '14', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 14, NULL),
(15, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '15', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 15, NULL),
(16, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '16', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 16, NULL),
(17, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '17', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 17, NULL),
(18, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '18', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 18, NULL),
(19, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '19', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 19, NULL),
(20, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '20', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 20, NULL),
(21, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '21', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 21, NULL),
(22, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '22', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 22, NULL),
(23, 'admin@jdsoft.in', '2017-04-06 12:49:01', 1, '2017-04-06', 7350, '23', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 23, NULL),
(24, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '24', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 24, NULL),
(25, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '25', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 25, NULL),
(26, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '26', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 26, NULL),
(27, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '27', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 27, NULL),
(28, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '28', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 28, NULL),
(29, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '29', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 29, NULL),
(30, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '30', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 30, NULL),
(31, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '31', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 31, NULL),
(32, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '32', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 32, NULL),
(33, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '33', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 33, NULL),
(34, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '34', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 34, NULL),
(35, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '35', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 35, NULL),
(36, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '36', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 36, NULL),
(37, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '37', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 37, NULL),
(38, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '38', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 38, NULL),
(39, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '39', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 39, NULL),
(40, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '40', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 40, NULL),
(41, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '41', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 41, NULL),
(42, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '42', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 42, NULL),
(43, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '43', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 43, NULL),
(44, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '44', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 44, NULL),
(45, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '45', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 45, NULL),
(46, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '46', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 46, NULL),
(47, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '47', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 47, NULL),
(48, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '48', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 48, NULL),
(49, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '49', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 49, NULL),
(50, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '50', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 50, NULL),
(51, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '51', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 51, NULL),
(52, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '52', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 52, NULL),
(53, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '53', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 53, NULL),
(54, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '54', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 54, NULL),
(55, 'admin@jdsoft.in', '2017-04-06 12:49:02', 1, '2017-04-06', 7350, '55', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 55, NULL),
(56, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '56', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 56, NULL),
(57, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '57', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 57, NULL),
(58, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '58', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 58, NULL),
(59, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '59', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 59, NULL),
(60, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '60', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 60, NULL),
(61, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '61', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 61, NULL),
(62, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '62', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 62, NULL),
(63, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '63', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 63, NULL),
(64, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '64', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 64, NULL),
(65, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '65', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 65, NULL),
(66, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '66', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 66, NULL),
(67, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '67', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 67, NULL),
(68, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '68', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 68, NULL),
(69, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '69', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 69, NULL),
(70, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '70', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 70, NULL),
(71, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '71', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 71, NULL),
(72, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '72', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 72, NULL),
(73, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '73', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 73, NULL),
(74, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '74', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 74, NULL),
(75, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '75', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 75, NULL),
(76, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '76', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 76, NULL),
(77, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '77', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 77, NULL),
(78, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '78', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 78, NULL),
(79, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '79', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 79, NULL),
(80, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '80', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 80, NULL),
(81, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '81', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 81, NULL),
(82, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '82', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 82, NULL),
(83, 'admin@jdsoft.in', '2017-04-06 12:49:03', 1, '2017-04-06', 7350, '83', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 83, NULL),
(84, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '84', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 84, NULL),
(85, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '85', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 85, NULL),
(86, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '86', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 86, NULL),
(87, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '87', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 87, NULL),
(88, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '88', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 88, NULL),
(89, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '89', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 89, NULL),
(90, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '90', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 90, NULL),
(91, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '91', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 91, NULL),
(92, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '92', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 92, NULL),
(93, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '93', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 93, NULL),
(94, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '94', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 94, NULL),
(95, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '95', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 95, NULL),
(96, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '96', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 96, NULL),
(97, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '97', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 97, NULL),
(98, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '98', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 98, NULL),
(99, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '99', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 99, NULL),
(100, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '100', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 100, NULL),
(101, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '101', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 101, NULL),
(102, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '102', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 102, NULL),
(103, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '103', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 103, NULL),
(104, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '104', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 104, NULL),
(105, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '105', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 105, NULL),
(106, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '106', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 106, NULL),
(107, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '107', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 107, NULL),
(108, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '108', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 108, NULL),
(109, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '109', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 109, NULL),
(110, 'admin@jdsoft.in', '2017-04-06 12:49:04', 1, '2017-04-06', 7350, '110', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 110, NULL),
(111, 'admin@jdsoft.in', '2017-04-06 12:49:05', 1, '2017-04-06', 7350, '111', 1, 'admin@jdsoft.in', '2017-04-06 07:19:05', 1, 1, 1, 111, NULL),
(113, 'admin@jdsoft.in', '2017-04-06 18:10:44', 0, '2017-04-06', 7350, '113', 0, 'admin@jdsoft.in', '2017-04-06 12:40:44', 1, 1, 1, 112, NULL),
(114, 'admin@jdsoft.in', '2017-04-25 19:21:21', 0, '2017-04-25', 7350, '114', 1, 'admin@jdsoft.in', '2017-04-25 13:51:22', 1, 1, 1, 113, NULL),
(115, 'admin@jdsoft.in', '2017-04-25 19:21:22', 1, '2017-04-25', 7350, '115', 1, 'admin@jdsoft.in', '2017-04-25 13:51:22', 1, 2, 1, 113, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_invoice_details`
--

CREATE TABLE `tbl_student_invoice_details` (
  `student_invoice_detail_id` bigint(20) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `generated_date` date NOT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `student_invoice_element_amount` double NOT NULL,
  `student_invoice_element_payment_status` int(11) NOT NULL,
  `student_invoice_element_tax_amount` double NOT NULL,
  `student_invoice_element_total_amount` double NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `fees_item_id` bigint(20) NOT NULL,
  `student_invoice_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_invoice_details`
--

INSERT INTO `tbl_student_invoice_details` (`student_invoice_detail_id`, `created_by`, `created_date`, `generated_date`, `modified_by`, `modified_date`, `student_invoice_element_amount`, `student_invoice_element_payment_status`, `student_invoice_element_tax_amount`, `student_invoice_element_total_amount`, `academic_year_id`, `fees_item_id`, `student_invoice_id`) VALUES
(1, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 200, 0, 0, 200, 1, 6, 1),
(2, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 1000, 0, 0, 1000, 1, 4, 1),
(3, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 5000, 0, 0, 5000, 1, 5, 1),
(4, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 500, 0, 0, 500, 1, 2, 1),
(5, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 400, 0, 0, 400, 1, 3, 1),
(6, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 250, 0, 0, 250, 1, 1, 1),
(7, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 200, 1, 0, 200, 1, 6, 2),
(8, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 400, 1, 0, 400, 1, 3, 2),
(9, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 250, 1, 0, 250, 1, 1, 2),
(10, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 5000, 1, 0, 5000, 1, 5, 2),
(11, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 1000, 1, 0, 1000, 1, 4, 2),
(12, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 500, 1, 0, 500, 1, 2, 2),
(13, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 200, 1, 0, 200, 1, 6, 3),
(14, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 1000, 1, 0, 1000, 1, 4, 3),
(15, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 500, 1, 0, 500, 1, 2, 3),
(16, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 5000, 1, 0, 5000, 1, 5, 3),
(17, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 400, 1, 0, 400, 1, 3, 3),
(18, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 250, 1, 0, 250, 1, 1, 3),
(19, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:00', 200, 1, 0, 200, 1, 6, 4),
(20, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 4),
(21, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 4),
(22, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 4),
(23, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 4),
(24, 'admin@jdsoft.in', '2017-04-06 12:49:00', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 4),
(25, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 5),
(26, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 5),
(27, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 5),
(28, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 5),
(29, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 5),
(30, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 5),
(31, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 6),
(32, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 6),
(33, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 6),
(34, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 6),
(35, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 6),
(36, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 6),
(37, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 7),
(38, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 7),
(39, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 7),
(40, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 7),
(41, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 7),
(42, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 7),
(43, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 8),
(44, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 8),
(45, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 8),
(46, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 8),
(47, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 8),
(48, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 8),
(49, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 9),
(50, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 9),
(51, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 9),
(52, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 9),
(53, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 9),
(54, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 9),
(55, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 10),
(56, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 10),
(57, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 10),
(58, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 10),
(59, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 10),
(60, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 10),
(61, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 11),
(62, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 11),
(63, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 11),
(64, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 11),
(65, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 11),
(66, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 11),
(67, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 12),
(68, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 12),
(69, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 12),
(70, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 12),
(71, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 12),
(72, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 12),
(73, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 13),
(74, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 13),
(75, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 13),
(76, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 13),
(77, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 13),
(78, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 13),
(79, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 14),
(80, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 14),
(81, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 14),
(82, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 14),
(83, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 14),
(84, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 14),
(85, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 15),
(86, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 15),
(87, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 15),
(88, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 15),
(89, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 15),
(90, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 15),
(91, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 16),
(92, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 16),
(93, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 16),
(94, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 16),
(95, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 16),
(96, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 16),
(97, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 17),
(98, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 17),
(99, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 17),
(100, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 17),
(101, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 17),
(102, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 17),
(103, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 18),
(104, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 18),
(105, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 18),
(106, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 18),
(107, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 18),
(108, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 18),
(109, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 19),
(110, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 19),
(111, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 19),
(112, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 19),
(113, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 19),
(114, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 19),
(115, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 20),
(116, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 20),
(117, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 20),
(118, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 20),
(119, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 20),
(120, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 20),
(121, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 21),
(122, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 21),
(123, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 21),
(124, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 21),
(125, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 21),
(126, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 21),
(127, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 22),
(128, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 22),
(129, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 1000, 1, 0, 1000, 1, 4, 22),
(130, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 22),
(131, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 22),
(132, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 200, 1, 0, 200, 1, 6, 22),
(133, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 400, 1, 0, 400, 1, 3, 23),
(134, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 500, 1, 0, 500, 1, 2, 23),
(135, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 5000, 1, 0, 5000, 1, 5, 23),
(136, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:01', 250, 1, 0, 250, 1, 1, 23),
(137, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 23),
(138, 'admin@jdsoft.in', '2017-04-06 12:49:01', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 23),
(139, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 24),
(140, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 24),
(141, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 24),
(142, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 24),
(143, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 24),
(144, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 24),
(145, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 25),
(146, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 25),
(147, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 25),
(148, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 25),
(149, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 25),
(150, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 25),
(151, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 26),
(152, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 26),
(153, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 26),
(154, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 26),
(155, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 26),
(156, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 26),
(157, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 27),
(158, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 27),
(159, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 27),
(160, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 27),
(161, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 27),
(162, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 27),
(163, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 28),
(164, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 28),
(165, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 28),
(166, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 28),
(167, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 28),
(168, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 28),
(169, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 29),
(170, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 29),
(171, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 29),
(172, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 29),
(173, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 29),
(174, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 29),
(175, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 30),
(176, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 30),
(177, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 30),
(178, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 30),
(179, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 30),
(180, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 30),
(181, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 31),
(182, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 31),
(183, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 31),
(184, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 31),
(185, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 31),
(186, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 31),
(187, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 32),
(188, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 32),
(189, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 32),
(190, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 32),
(191, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 32),
(192, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 32),
(193, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 33),
(194, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 33),
(195, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 33),
(196, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 33),
(197, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 33),
(198, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 33),
(199, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 34),
(200, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 34),
(201, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 34),
(202, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 34),
(203, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 34),
(204, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 34),
(205, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 35),
(206, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 35),
(207, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 35),
(208, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 35),
(209, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 35),
(210, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 35),
(211, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 36),
(212, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 36),
(213, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 36),
(214, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 36),
(215, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 36),
(216, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 36),
(217, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 37),
(218, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 37),
(219, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 37),
(220, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 37),
(221, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 37),
(222, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 37),
(223, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 38),
(224, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 38),
(225, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 38),
(226, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 38),
(227, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 38),
(228, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 38),
(229, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 39),
(230, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 39),
(231, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 39),
(232, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 39),
(233, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 39),
(234, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 39),
(235, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 40),
(236, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 40),
(237, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 40),
(238, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 40),
(239, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 40),
(240, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 40),
(241, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 41),
(242, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 41),
(243, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 41),
(244, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 41),
(245, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 41),
(246, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 41),
(247, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 42),
(248, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 42),
(249, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 42),
(250, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 42),
(251, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 42),
(252, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 42),
(253, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 43),
(254, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 43),
(255, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 43),
(256, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 43),
(257, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 43),
(258, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 43),
(259, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 44),
(260, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 44),
(261, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 44),
(262, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 44),
(263, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 44),
(264, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 44),
(265, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 45),
(266, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 45),
(267, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 45),
(268, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 45),
(269, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 45),
(270, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 45),
(271, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 46),
(272, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 46),
(273, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 46),
(274, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 46),
(275, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 46),
(276, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 46),
(277, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 47),
(278, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 47),
(279, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 47),
(280, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 47),
(281, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 47),
(282, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 47),
(283, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 48),
(284, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 48),
(285, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 48),
(286, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 48),
(287, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 48),
(288, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 48),
(289, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 49),
(290, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 49),
(291, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 49),
(292, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 49),
(293, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 49),
(294, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 49),
(295, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 50),
(296, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 50),
(297, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 50),
(298, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 50),
(299, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 50),
(300, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 50),
(301, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 51),
(302, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 51),
(303, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 51),
(304, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 51),
(305, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 51),
(306, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 51),
(307, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 52),
(308, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 52),
(309, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 52),
(310, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 52),
(311, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 52),
(312, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 52),
(313, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 53),
(314, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 53),
(315, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 53),
(316, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 53),
(317, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 53),
(318, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 53),
(319, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 54),
(320, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 54),
(321, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 54),
(322, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 54),
(323, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 54),
(324, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 54),
(325, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 250, 1, 0, 250, 1, 1, 55),
(326, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 200, 1, 0, 200, 1, 6, 55),
(327, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 400, 1, 0, 400, 1, 3, 55),
(328, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 1000, 1, 0, 1000, 1, 4, 55),
(329, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 500, 1, 0, 500, 1, 2, 55),
(330, 'admin@jdsoft.in', '2017-04-06 12:49:02', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:02', 5000, 1, 0, 5000, 1, 5, 55),
(331, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 56),
(332, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 56),
(333, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 56),
(334, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 56),
(335, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 56),
(336, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 56),
(337, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 57),
(338, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 57),
(339, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 57),
(340, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 57),
(341, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 57),
(342, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 57),
(343, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 58),
(344, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 58),
(345, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 58),
(346, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 58),
(347, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 58),
(348, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 58),
(349, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 59),
(350, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 59),
(351, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 59),
(352, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 59),
(353, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 59),
(354, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 59),
(355, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 60),
(356, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 60),
(357, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 60),
(358, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 60),
(359, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 60),
(360, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 60),
(361, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 61),
(362, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 61),
(363, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 61),
(364, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 61),
(365, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 61),
(366, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 61),
(367, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 62),
(368, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 62),
(369, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 62),
(370, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 62),
(371, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 62),
(372, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 62),
(373, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 63),
(374, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 63),
(375, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 63),
(376, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 63),
(377, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 63),
(378, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 63),
(379, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 64),
(380, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 64),
(381, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 64),
(382, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 64),
(383, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 64);
INSERT INTO `tbl_student_invoice_details` (`student_invoice_detail_id`, `created_by`, `created_date`, `generated_date`, `modified_by`, `modified_date`, `student_invoice_element_amount`, `student_invoice_element_payment_status`, `student_invoice_element_tax_amount`, `student_invoice_element_total_amount`, `academic_year_id`, `fees_item_id`, `student_invoice_id`) VALUES
(384, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 64),
(385, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 65),
(386, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 65),
(387, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 65),
(388, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 65),
(389, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 65),
(390, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 65),
(391, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 66),
(392, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 66),
(393, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 66),
(394, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 66),
(395, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 66),
(396, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 66),
(397, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 67),
(398, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 67),
(399, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 67),
(400, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 67),
(401, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 67),
(402, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 67),
(403, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 68),
(404, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 68),
(405, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 68),
(406, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 68),
(407, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 68),
(408, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 68),
(409, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 69),
(410, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 69),
(411, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 69),
(412, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 69),
(413, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 69),
(414, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 69),
(415, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 70),
(416, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 70),
(417, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 70),
(418, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 70),
(419, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 70),
(420, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 70),
(421, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 71),
(422, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 71),
(423, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 71),
(424, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 71),
(425, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 71),
(426, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 71),
(427, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 72),
(428, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 72),
(429, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 72),
(430, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 72),
(431, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 72),
(432, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 72),
(433, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 73),
(434, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 73),
(435, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 73),
(436, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 73),
(437, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 73),
(438, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 73),
(439, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 74),
(440, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 74),
(441, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 74),
(442, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 74),
(443, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 74),
(444, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 74),
(445, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 75),
(446, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 75),
(447, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 75),
(448, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 75),
(449, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 75),
(450, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 75),
(451, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 76),
(452, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 76),
(453, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 76),
(454, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 76),
(455, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 76),
(456, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 76),
(457, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 77),
(458, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 77),
(459, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 77),
(460, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 77),
(461, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 77),
(462, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 77),
(463, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 78),
(464, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 78),
(465, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 78),
(466, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 78),
(467, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 78),
(468, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 78),
(469, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 79),
(470, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 79),
(471, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 79),
(472, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 79),
(473, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 79),
(474, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 79),
(475, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 80),
(476, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 80),
(477, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 80),
(478, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 80),
(479, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 80),
(480, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 80),
(481, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 81),
(482, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 81),
(483, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 81),
(484, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 81),
(485, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 81),
(486, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 81),
(487, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 82),
(488, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 82),
(489, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 82),
(490, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 5000, 1, 0, 5000, 1, 5, 82),
(491, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 200, 1, 0, 200, 1, 6, 82),
(492, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 400, 1, 0, 400, 1, 3, 82),
(493, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 1000, 1, 0, 1000, 1, 4, 83),
(494, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 500, 1, 0, 500, 1, 2, 83),
(495, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:03', 250, 1, 0, 250, 1, 1, 83),
(496, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 83),
(497, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 83),
(498, 'admin@jdsoft.in', '2017-04-06 12:49:03', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 83),
(499, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 84),
(500, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 84),
(501, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 84),
(502, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 84),
(503, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 84),
(504, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 84),
(505, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 85),
(506, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 85),
(507, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 85),
(508, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 85),
(509, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 85),
(510, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 85),
(511, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 86),
(512, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 86),
(513, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 86),
(514, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 86),
(515, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 86),
(516, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 86),
(517, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 87),
(518, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 87),
(519, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 87),
(520, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 87),
(521, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 87),
(522, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 87),
(523, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 88),
(524, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 88),
(525, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 88),
(526, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 88),
(527, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 88),
(528, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 88),
(529, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 89),
(530, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 89),
(531, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 89),
(532, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 89),
(533, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 89),
(534, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 89),
(535, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 90),
(536, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 90),
(537, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 90),
(538, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 90),
(539, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 90),
(540, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 90),
(541, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 91),
(542, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 91),
(543, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 91),
(544, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 91),
(545, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 91),
(546, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 91),
(547, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 92),
(548, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 92),
(549, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 92),
(550, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 92),
(551, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 92),
(552, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 92),
(553, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 93),
(554, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 93),
(555, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 93),
(556, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 93),
(557, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 93),
(558, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 93),
(559, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 94),
(560, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 94),
(561, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 94),
(562, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 94),
(563, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 94),
(564, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 94),
(565, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 95),
(566, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 95),
(567, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 95),
(568, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 95),
(569, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 95),
(570, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 95),
(571, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 96),
(572, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 96),
(573, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 96),
(574, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 96),
(575, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 96),
(576, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 96),
(577, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 97),
(578, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 97),
(579, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 97),
(580, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 97),
(581, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 97),
(582, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 97),
(583, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 98),
(584, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 98),
(585, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 98),
(586, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 98),
(587, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 98),
(588, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 98),
(589, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 99),
(590, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 99),
(591, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 99),
(592, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 99),
(593, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 99),
(594, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 99),
(595, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 100),
(596, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 100),
(597, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 100),
(598, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 100),
(599, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 100),
(600, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 100),
(601, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 101),
(602, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 101),
(603, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 101),
(604, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 101),
(605, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 101),
(606, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 101),
(607, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 102),
(608, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 102),
(609, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 102),
(610, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 102),
(611, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 102),
(612, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 102),
(613, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 103),
(614, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 103),
(615, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 103),
(616, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 103),
(617, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 103),
(618, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 103),
(619, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 104),
(620, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 104),
(621, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 104),
(622, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 104),
(623, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 104),
(624, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 104),
(625, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 105),
(626, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 105),
(627, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 105),
(628, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 105),
(629, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 105),
(630, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 105),
(631, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 106),
(632, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 106),
(633, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 106),
(634, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 106),
(635, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 106),
(636, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 106),
(637, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 107),
(638, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 107),
(639, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 107),
(640, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 107),
(641, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 107),
(642, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 107),
(643, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 108),
(644, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 108),
(645, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 108),
(646, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 108),
(647, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 108),
(648, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 108),
(649, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 109),
(650, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 500, 1, 0, 500, 1, 2, 109),
(651, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 109),
(652, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 109),
(653, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 109),
(654, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 250, 1, 0, 250, 1, 1, 109),
(655, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 200, 1, 0, 200, 1, 6, 110),
(656, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 1000, 1, 0, 1000, 1, 4, 110),
(657, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 400, 1, 0, 400, 1, 3, 110),
(658, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:04', 5000, 1, 0, 5000, 1, 5, 110),
(659, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:05', 250, 1, 0, 250, 1, 1, 110),
(660, 'admin@jdsoft.in', '2017-04-06 12:49:04', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:05', 500, 1, 0, 500, 1, 2, 110),
(661, 'admin@jdsoft.in', '2017-04-06 12:49:05', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:05', 500, 1, 0, 500, 1, 2, 111),
(662, 'admin@jdsoft.in', '2017-04-06 12:49:05', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:05', 250, 1, 0, 250, 1, 1, 111),
(663, 'admin@jdsoft.in', '2017-04-06 12:49:05', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:05', 200, 1, 0, 200, 1, 6, 111),
(664, 'admin@jdsoft.in', '2017-04-06 12:49:05', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:05', 1000, 1, 0, 1000, 1, 4, 111),
(665, 'admin@jdsoft.in', '2017-04-06 12:49:05', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:05', 400, 1, 0, 400, 1, 3, 111),
(666, 'admin@jdsoft.in', '2017-04-06 12:49:05', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 07:19:05', 5000, 1, 0, 5000, 1, 5, 111),
(673, 'admin@jdsoft.in', '2017-04-06 18:10:44', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 12:40:44', 5000, 0, 0, 5000, 1, 5, 113),
(674, 'admin@jdsoft.in', '2017-04-06 18:10:44', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 12:40:44', 1000, 0, 0, 1000, 1, 4, 113),
(675, 'admin@jdsoft.in', '2017-04-06 18:10:44', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 12:40:44', 250, 0, 0, 250, 1, 1, 113),
(676, 'admin@jdsoft.in', '2017-04-06 18:10:44', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 12:40:44', 500, 0, 0, 500, 1, 2, 113),
(677, 'admin@jdsoft.in', '2017-04-06 18:10:44', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 12:40:44', 400, 0, 0, 400, 1, 3, 113),
(678, 'admin@jdsoft.in', '2017-04-06 18:10:44', '2017-04-06', 'admin@jdsoft.in', '2017-04-06 12:40:44', 200, 0, 0, 200, 1, 6, 113),
(679, 'admin@jdsoft.in', '2017-04-25 19:21:21', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:21', 200, 0, 0, 200, 1, 6, 114),
(680, 'admin@jdsoft.in', '2017-04-25 19:21:21', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:21', 400, 1, 0, 400, 1, 3, 114),
(681, 'admin@jdsoft.in', '2017-04-25 19:21:21', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:21', 1000, 1, 0, 1000, 1, 4, 114),
(682, 'admin@jdsoft.in', '2017-04-25 19:21:21', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:21', 5000, 1, 0, 5000, 1, 5, 114),
(683, 'admin@jdsoft.in', '2017-04-25 19:21:21', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:22', 250, 1, 0, 250, 1, 1, 114),
(684, 'admin@jdsoft.in', '2017-04-25 19:21:21', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:22', 500, 1, 0, 500, 1, 2, 114),
(685, 'admin@jdsoft.in', '2017-04-25 19:21:22', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:22', 5000, 1, 0, 5000, 1, 5, 115),
(686, 'admin@jdsoft.in', '2017-04-25 19:21:22', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:22', 1000, 1, 0, 1000, 1, 4, 115),
(687, 'admin@jdsoft.in', '2017-04-25 19:21:22', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:22', 500, 1, 0, 500, 1, 2, 115),
(688, 'admin@jdsoft.in', '2017-04-25 19:21:22', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:22', 200, 1, 0, 200, 1, 6, 115),
(689, 'admin@jdsoft.in', '2017-04-25 19:21:22', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:22', 400, 1, 0, 400, 1, 3, 115),
(690, 'admin@jdsoft.in', '2017-04-25 19:21:22', '2017-04-25', 'admin@jdsoft.in', '2017-04-25 13:51:22', 250, 1, 0, 250, 1, 1, 115);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_leave_requisition`
--

CREATE TABLE `tbl_student_leave_requisition` (
  `student_leave_requisition_id` bigint(20) NOT NULL,
  `approval_status` varchar(255) NOT NULL,
  `approval_by` varchar(255) NOT NULL,
  `created_date` date NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `partially_leave_end_date` date DEFAULT NULL,
  `partially_leave_start_date` date DEFAULT NULL,
  `leave_end_date` date NOT NULL,
  `student_leave_reason` varchar(255) NOT NULL,
  `leave_start_date` date NOT NULL,
  `approver_id` bigint(20) NOT NULL,
  `portal_task_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `student_leave_type_id` bigint(20) NOT NULL,
  `approver_comments` varchar(255) DEFAULT NULL,
  `requisition_type_id` bigint(20) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `modified_by` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_leave_requisition`
--

INSERT INTO `tbl_student_leave_requisition` (`student_leave_requisition_id`, `approval_status`, `approval_by`, `created_date`, `modified_date`, `partially_leave_end_date`, `partially_leave_start_date`, `leave_end_date`, `student_leave_reason`, `leave_start_date`, `approver_id`, `portal_task_id`, `student_id`, `student_leave_type_id`, `approver_comments`, `requisition_type_id`, `created_by`, `modified_by`) VALUES
(1, 'Pending', 'Pending', '2017-05-10', '2017-05-10 13:54:53', NULL, NULL, '2017-04-30', 'Personal Leave', '2017-04-01', 2, 21, 1, 2, NULL, 1, '', ''),
(2, 'Pending', 'Pending', '2017-05-17', '2017-05-17 10:02:35', NULL, NULL, '2017-05-31', 'Personal Leave', '2017-05-30', 3, 50, 1, 2, NULL, 1, 'anand@jdsoft.in', 'anand@jdsoft.in');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_leave_type`
--

CREATE TABLE `tbl_student_leave_type` (
  `student_leave_type_id` bigint(20) NOT NULL,
  `student_leave_type` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_leave_type`
--

INSERT INTO `tbl_student_leave_type` (`student_leave_type_id`, `student_leave_type`) VALUES
(1, 'Sick Leave'),
(2, 'Personal Leave');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_marks`
--

CREATE TABLE `tbl_student_marks` (
  `student_mark_id` bigint(20) NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `class_section_id` bigint(20) NOT NULL,
  `class_section_assesment_type_id` bigint(20) NOT NULL,
  `class_section_term_exam_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_marks`
--

INSERT INTO `tbl_student_marks` (`student_mark_id`, `academic_year_id`, `class_section_id`, `class_section_assesment_type_id`, `class_section_term_exam_id`, `institution_id`, `student_id`) VALUES
(1, 1, 4, 1, 1, 1, 113),
(2, 1, 4, 1, 2, 1, 113),
(3, 1, 4, 1, 2, 1, 113),
(4, 1, 4, 1, 3, 1, 113),
(5, 1, 4, 1, 3, 1, 113),
(6, 1, 4, 1, 3, 1, 113),
(7, 1, 4, 1, 4, 1, 113),
(8, 1, 4, 1, 4, 1, 113),
(9, 1, 4, 1, 4, 1, 113),
(10, 1, 4, 1, 4, 1, 113),
(11, 1, 4, 1, 5, 1, 113),
(12, 1, 4, 1, 5, 1, 113),
(13, 1, 4, 1, 5, 1, 113),
(14, 1, 4, 1, 5, 1, 113),
(15, 1, 4, 1, 5, 1, 113),
(16, 1, 4, 1, 6, 1, 113),
(17, 1, 4, 1, 6, 1, 113),
(18, 1, 4, 1, 6, 1, 113),
(19, 1, 4, 1, 6, 1, 113),
(20, 1, 4, 1, 6, 1, 113),
(21, 1, 4, 1, 6, 1, 113),
(22, 1, 4, 1, 1, 1, 113),
(23, 1, 4, 1, 2, 1, 113),
(24, 1, 4, 1, 3, 1, 113),
(25, 1, 4, 1, 4, 1, 113),
(26, 1, 4, 1, 5, 1, 113),
(27, 1, 4, 1, 6, 1, 113);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_marks_details`
--

CREATE TABLE `tbl_student_marks_details` (
  `type` varchar(255) NOT NULL,
  `student_marks_details_id` bigint(20) NOT NULL,
  `term_exam_grade_obtained` varchar(255) NOT NULL,
  `term_exam_grade_point_obtained` double NOT NULL,
  `term_exam_mark_obtained` double NOT NULL,
  `class_section_term_exam_activity_id` bigint(20) NOT NULL,
  `student_mark_id` bigint(20) NOT NULL,
  `class_section_coscholastic_activity_id` bigint(20) DEFAULT NULL,
  `class_section_coscholastic_area_id` bigint(20) DEFAULT NULL,
  `class_section_module_id` bigint(20) DEFAULT NULL,
  `class_section_module_skill_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_marks_details`
--

INSERT INTO `tbl_student_marks_details` (`type`, `student_marks_details_id`, `term_exam_grade_obtained`, `term_exam_grade_point_obtained`, `term_exam_mark_obtained`, `class_section_term_exam_activity_id`, `student_mark_id`, `class_section_coscholastic_activity_id`, `class_section_coscholastic_area_id`, `class_section_module_id`, `class_section_module_skill_id`) VALUES
('studentmarksdetailwithmodulebased', 1, 'S', 19, 95, 1, 1, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 2, 'S', 19.2, 96, 2, 2, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 3, 'S', 19.2, 96, 2, 3, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 4, 'S', 58.8, 98, 3, 4, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 5, 'S', 58.8, 98, 3, 5, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 6, 'S', 58.8, 98, 3, 6, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 7, 'S', 18.2, 91, 4, 7, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 8, 'S', 18.2, 91, 4, 8, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 9, 'S', 18.2, 91, 4, 9, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 10, 'S', 18.2, 91, 4, 10, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 11, 'S', 18.6, 93, 5, 11, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 12, 'S', 18.6, 93, 5, 12, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 13, 'S', 18.6, 93, 5, 13, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 14, 'S', 18.6, 93, 5, 14, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 15, 'S', 18.6, 93, 5, 15, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 16, 'S', 57.599999999999994, 96, 6, 16, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 17, 'S', 57.599999999999994, 96, 6, 18, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 18, 'S', 57.599999999999994, 96, 6, 17, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 19, 'S', 57.599999999999994, 96, 6, 19, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 20, 'S', 57.599999999999994, 96, 6, 20, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 21, 'S', 57.599999999999994, 96, 6, 21, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 22, 'S', 19, 95, 1, 22, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 23, 'S', 19.2, 96, 2, 23, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 24, 'S', 58.8, 98, 3, 24, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 25, 'S', 19.2, 96, 4, 25, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 26, 'S', 18.6, 93, 5, 26, NULL, NULL, 16, NULL),
('studentmarksdetailwithmodulebased', 27, 'S', 57, 95, 6, 27, NULL, NULL, 16, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_receipt`
--

CREATE TABLE `tbl_student_receipt` (
  `student_receipt_id` bigint(20) NOT NULL,
  `dd_date` date DEFAULT NULL,
  `total_receipt_amount` double NOT NULL,
  `cheque_bank_name` varchar(100) DEFAULT NULL,
  `cheque_branch_name` varchar(100) DEFAULT NULL,
  `cheque_date` date DEFAULT NULL,
  `cheque_number` varchar(100) DEFAULT NULL,
  `receipt_comments` varchar(100) DEFAULT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `dd_bank_name` varchar(100) DEFAULT NULL,
  `dd_branch_name` varchar(100) DEFAULT NULL,
  `dd_number` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `narration` varchar(255) DEFAULT NULL,
  `payment_cleared_date` date DEFAULT NULL,
  `payment_gateway` varchar(100) DEFAULT NULL,
  `payment_gateway_mode` varchar(100) DEFAULT NULL,
  `payment_received_date` date NOT NULL,
  `receipt_cleared_by` varchar(100) DEFAULT NULL,
  `transaction_no` varchar(100) NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `payment_mode_id` bigint(20) NOT NULL,
  `payment_status_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `student_invoice_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_receipt`
--

INSERT INTO `tbl_student_receipt` (`student_receipt_id`, `dd_date`, `total_receipt_amount`, `cheque_bank_name`, `cheque_branch_name`, `cheque_date`, `cheque_number`, `receipt_comments`, `created_by`, `created_date`, `dd_bank_name`, `dd_branch_name`, `dd_number`, `modified_by`, `modified_date`, `narration`, `payment_cleared_date`, `payment_gateway`, `payment_gateway_mode`, `payment_received_date`, `receipt_cleared_by`, `transaction_no`, `academic_year_id`, `institution_id`, `payment_mode_id`, `payment_status_id`, `student_id`, `student_invoice_id`) VALUES
(1, NULL, 1200, NULL, NULL, NULL, NULL, NULL, 'admin@jdsoft.in', '2017-04-10 15:53:05', NULL, NULL, NULL, 'admin@jdsoft.in', '2017-04-10 10:23:05', NULL, NULL, NULL, NULL, '2017-04-10', NULL, '1491819785866', 1, 1, 1, 1, 1, 1),
(2, NULL, 7350, NULL, NULL, NULL, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 15:54:13', NULL, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:24:13', NULL, NULL, NULL, NULL, '2017-04-12', NULL, '1491992653335', 1, 1, 1, 1, 112, 113),
(3, NULL, 6150, NULL, NULL, NULL, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 16:03:59', NULL, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:33:59', NULL, NULL, NULL, NULL, '2017-04-12', NULL, '1491993239495', 1, 1, 1, 1, 1, 1),
(4, NULL, 100, NULL, NULL, NULL, NULL, NULL, 'admin@jdsoft.in', '2017-04-25 19:22:10', NULL, NULL, NULL, 'admin@jdsoft.in', '2017-04-25 13:52:10', NULL, NULL, NULL, NULL, '2017-04-25', NULL, '1493128330010', 1, 1, 1, 1, 113, 114);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_receipt_detail`
--

CREATE TABLE `tbl_student_receipt_detail` (
  `student_receipt_detail_id` bigint(20) NOT NULL,
  `actual_receipt_amount` double NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `discount_amount` double DEFAULT NULL,
  `disount_applied` tinyint(1) NOT NULL,
  `discount_percentage` varchar(100) DEFAULT NULL,
  `discount_type` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `paid_receipt_amount` double NOT NULL,
  `payment_cleared_date` date DEFAULT NULL,
  `payment_received_date` date NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `fees_item_id` bigint(20) NOT NULL,
  `payment_status_id` bigint(20) NOT NULL,
  `student_invoice_detail_id` bigint(20) NOT NULL,
  `student_receipt_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_receipt_detail`
--

INSERT INTO `tbl_student_receipt_detail` (`student_receipt_detail_id`, `actual_receipt_amount`, `created_by`, `created_date`, `discount_amount`, `disount_applied`, `discount_percentage`, `discount_type`, `modified_by`, `modified_date`, `paid_receipt_amount`, `payment_cleared_date`, `payment_received_date`, `academic_year_id`, `fees_item_id`, `payment_status_id`, `student_invoice_detail_id`, `student_receipt_id`) VALUES
(1, 1000, 'admin@jdsoft.in', '2017-04-10 15:53:05', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-10 10:23:06', 1000, NULL, '2017-04-10', 1, 4, 1, 2, 1),
(2, 200, 'admin@jdsoft.in', '2017-04-10 15:53:05', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-10 10:23:06', 200, NULL, '2017-04-10', 1, 6, 1, 1, 1),
(3, 250, 'admin@jdsoft.in', '2017-04-12 15:54:13', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:24:13', 250, NULL, '2017-04-12', 1, 1, 1, 675, 2),
(4, 5000, 'admin@jdsoft.in', '2017-04-12 15:54:13', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:24:14', 5000, NULL, '2017-04-12', 1, 5, 1, 673, 2),
(5, 500, 'admin@jdsoft.in', '2017-04-12 15:54:13', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:24:14', 500, NULL, '2017-04-12', 1, 2, 1, 676, 2),
(6, 200, 'admin@jdsoft.in', '2017-04-12 15:54:13', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:24:14', 200, NULL, '2017-04-12', 1, 6, 1, 678, 2),
(7, 1000, 'admin@jdsoft.in', '2017-04-12 15:54:13', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:24:14', 1000, NULL, '2017-04-12', 1, 4, 1, 674, 2),
(8, 400, 'admin@jdsoft.in', '2017-04-12 15:54:13', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:24:14', 400, NULL, '2017-04-12', 1, 3, 1, 677, 2),
(9, 250, 'admin@jdsoft.in', '2017-04-12 16:03:59', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:33:59', 250, NULL, '2017-04-12', 1, 1, 1, 6, 3),
(10, 5000, 'admin@jdsoft.in', '2017-04-12 16:03:59', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:33:59', 5000, NULL, '2017-04-12', 1, 5, 1, 3, 3),
(11, 400, 'admin@jdsoft.in', '2017-04-12 16:03:59', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:33:59', 400, NULL, '2017-04-12', 1, 3, 1, 5, 3),
(12, 500, 'admin@jdsoft.in', '2017-04-12 16:03:59', 0, 0, NULL, NULL, 'admin@jdsoft.in', '2017-04-12 10:33:59', 500, NULL, '2017-04-12', 1, 2, 1, 4, 3),
(13, 200, 'admin@jdsoft.in', '2017-04-25 19:22:10', 100, 1, NULL, 'flat', 'admin@jdsoft.in', '2017-04-25 13:52:10', 100, NULL, '2017-04-25', 1, 6, 1, 679, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_receipt_fine`
--

CREATE TABLE `tbl_student_receipt_fine` (
  `student_receipt_fine_id` bigint(20) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `fine_amount` double NOT NULL,
  `fine_title` varchar(100) NOT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `payment_received_date` date NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `student_receipt_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_receipt_fine`
--

INSERT INTO `tbl_student_receipt_fine` (`student_receipt_fine_id`, `created_by`, `created_date`, `fine_amount`, `fine_title`, `modified_by`, `modified_date`, `payment_received_date`, `academic_year_id`, `student_receipt_id`) VALUES
(1, 'admin@jdsoft.in', '2017-04-10 15:53:05', 100, 'Fine Amount', 'admin@jdsoft.in', '2017-04-10 10:23:06', '2017-04-10', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_special_categories`
--

CREATE TABLE `tbl_student_special_categories` (
  `student_id` bigint(20) NOT NULL,
  `special_category_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_special_categories`
--

INSERT INTO `tbl_student_special_categories` (`student_id`, `special_category_id`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 1),
(23, 1),
(24, 1),
(25, 1),
(26, 1),
(27, 1),
(28, 1),
(29, 1),
(30, 2),
(31, 2),
(32, 2),
(33, 2),
(34, 2),
(35, 2),
(36, 2),
(37, 2),
(38, 2),
(39, 2),
(40, 2),
(41, 2),
(42, 2),
(43, 2),
(44, 2),
(45, 2),
(46, 2),
(47, 2),
(48, 2),
(49, 2),
(50, 2),
(51, 2),
(52, 1),
(53, 2),
(54, 2),
(55, 1),
(56, 2),
(57, 2),
(58, 2),
(59, 2),
(60, 2),
(61, 2),
(62, 2),
(63, 2),
(64, 2),
(65, 2),
(66, 2),
(67, 2),
(68, 2),
(69, 2),
(70, 2),
(71, 2),
(72, 2),
(73, 2),
(74, 2),
(75, 2),
(76, 2),
(77, 2),
(78, 2),
(79, 1),
(80, 2),
(81, 2),
(82, 2),
(83, 2),
(84, 2),
(85, 2),
(86, 2),
(87, 2),
(88, 2),
(89, 2),
(90, 2),
(91, 2),
(92, 2),
(93, 2),
(94, 2),
(95, 2),
(96, 1),
(97, 2),
(98, 2),
(99, 2),
(100, 2),
(101, 2),
(102, 2),
(103, 2),
(104, 2),
(105, 2),
(106, 2),
(107, 2),
(108, 2),
(109, 2),
(110, 2),
(111, 2),
(112, 1),
(113, 1),
(113, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student_status`
--

CREATE TABLE `tbl_student_status` (
  `student_status_id` bigint(20) NOT NULL,
  `status_title` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_student_status`
--

INSERT INTO `tbl_student_status` (`student_status_id`, `status_title`) VALUES
(1, 'Active'),
(2, 'Alumni'),
(3, 'Discontinue');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_supplier_master`
--

CREATE TABLE `tbl_supplier_master` (
  `supplier_id` bigint(20) NOT NULL,
  `address_line1` varchar(255) NOT NULL,
  `address_line2` varchar(255) NOT NULL,
  `account_number` varchar(100) DEFAULT NULL,
  `ifsc_code` varchar(100) DEFAULT NULL,
  `bank_name` varchar(100) DEFAULT NULL,
  `city` varchar(100) NOT NULL,
  `contact_number` varchar(20) NOT NULL,
  `contact_person_name` varchar(100) DEFAULT NULL,
  `country` varchar(100) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `cst_number` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `fax` varchar(30) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `last_modified_by` varchar(100) NOT NULL,
  `last_modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `pan_number` varchar(50) DEFAULT NULL,
  `post_code` varchar(10) NOT NULL,
  `scoring_field` int(11) DEFAULT NULL,
  `service_tax_number` varchar(50) DEFAULT NULL,
  `state` varchar(100) NOT NULL,
  `status` int(11) NOT NULL,
  `supplier_code` varchar(50) NOT NULL,
  `supplier_name` varchar(100) NOT NULL,
  `tin_number` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_supplier_master`
--

INSERT INTO `tbl_supplier_master` (`supplier_id`, `address_line1`, `address_line2`, `account_number`, `ifsc_code`, `bank_name`, `city`, `contact_number`, `contact_person_name`, `country`, `created_by`, `created_date`, `cst_number`, `description`, `email`, `fax`, `gender`, `last_modified_by`, `last_modified_date`, `pan_number`, `post_code`, `scoring_field`, `service_tax_number`, `state`, `status`, `supplier_code`, `supplier_name`, `tin_number`) VALUES
(1, '3/43', 'V.O.C Street', 'SBI12355', 'SBI00N234324', 'SBI BANk', 'Adelaide', '123457890', 'Jo', 'Australia', 'admin@jdsoft.in', '2017-05-23 13:36:34', 'CST23432', 'Nothing', 'joanand009@gmail.com', 'FAX234', 'Male', 'admin@jdsoft.in', '2017-05-23 08:06:34', 'PAN23424', '123546', NULL, 'STN6347', 'South Australia', 0, 'SUPLR1495526794597', 'Anand', 'TIN784156'),
(2, 'Line1', 'Lin2', 'SBI1235523', 'SBI00N23432443', 'SBI BANK', 'Tiruchirapalli', '123457890', 'Jo', 'India', 'admin@jdsoft.in', '2017-05-25 16:27:44', 'CST951357', 'Testing', 'arunbalajicse@gmail.com', 'FAX9897', 'Male', 'admin@jdsoft.in', '2017-05-25 10:57:44', 'PAN987', '987654', NULL, 'STN65791', 'Tamil Nadu', 1, 'SUPLR1495709864939', 'Arun Balaji', 'TIN98033');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tax_class`
--

CREATE TABLE `tbl_tax_class` (
  `tax_id` bigint(20) NOT NULL,
  `tax_rate` double NOT NULL,
  `tax_type_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_tax_class`
--

INSERT INTO `tbl_tax_class` (`tax_id`, `tax_rate`, `tax_type_name`) VALUES
(2, 10.6, 'Income Tax');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_term`
--

CREATE TABLE `tbl_term` (
  `term_id` bigint(20) NOT NULL,
  `term_name` varchar(150) NOT NULL,
  `exam_template_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_term`
--

INSERT INTO `tbl_term` (`term_id`, `term_name`, `exam_template_id`) VALUES
(1, 'June-Augest', 1),
(2, 'October-December', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_term_exam`
--

CREATE TABLE `tbl_term_exam` (
  `term_exam_id` bigint(20) NOT NULL,
  `term_exam_name` varchar(150) NOT NULL,
  `term_exam_percentage` double NOT NULL,
  `term_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_term_exam`
--

INSERT INTO `tbl_term_exam` (`term_exam_id`, `term_exam_name`, `term_exam_percentage`, `term_id`) VALUES
(1, 'FA1', 20, 1),
(2, 'FA2', 20, 1),
(3, 'SA1', 60, 1),
(4, 'FA3', 20, 2),
(5, 'FA4', 20, 2),
(6, 'SA2', 60, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_time_table_generator`
--

CREATE TABLE `tbl_time_table_generator` (
  `time_table_generator_id` bigint(20) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(50) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `class_section_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `academic_year_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_time_table_generator`
--

INSERT INTO `tbl_time_table_generator` (`time_table_generator_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `class_section_id`, `institution_id`, `academic_year_id`) VALUES
(51, 'admin@jdsoft.in', '2017-04-10 17:56:47', 'admin@jdsoft.in', '2017-04-10 12:26:48', 1, 1, 1),
(52, 'admin@jdsoft.in', '2017-04-10 17:56:49', 'admin@jdsoft.in', '2017-04-10 12:26:53', 2, 1, 1),
(53, 'admin@jdsoft.in', '2017-04-10 17:56:53', 'admin@jdsoft.in', '2017-04-10 12:26:57', 3, 1, 1),
(54, 'admin@jdsoft.in', '2017-05-04 10:26:03', 'admin@jdsoft.in', '2017-05-04 04:56:11', 4, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_time_table_generator_days`
--

CREATE TABLE `tbl_time_table_generator_days` (
  `time_table_generator_day_id` bigint(20) NOT NULL,
  `time_table_generator_day_name` varchar(150) NOT NULL,
  `time_table_generator_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_time_table_generator_days`
--

INSERT INTO `tbl_time_table_generator_days` (`time_table_generator_day_id`, `time_table_generator_day_name`, `time_table_generator_id`) VALUES
(249, 'Monday', 51),
(250, 'Tuesday', 51),
(251, 'Wednesday', 51),
(252, 'Thursday', 51),
(253, 'Friday', 51),
(254, 'Monday', 52),
(255, 'Tuesday', 52),
(256, 'Wednesday', 52),
(257, 'Thursday', 52),
(258, 'Friday', 52),
(259, 'Monday', 53),
(260, 'Tuesday', 53),
(261, 'Wednesday', 53),
(262, 'Thursday', 53),
(263, 'Friday', 53),
(264, 'Monday', 54),
(265, 'Tuesday', 54),
(266, 'Wednesday', 54),
(267, 'Thursday', 54),
(268, 'Friday', 54);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_time_table_generator_hours`
--

CREATE TABLE `tbl_time_table_generator_hours` (
  `time_table_generator_hour_id` bigint(20) NOT NULL,
  `time_table_generator_hour_title` varchar(150) NOT NULL,
  `time_table_generator_subject_name` varchar(150) NOT NULL,
  `module_id` bigint(20) DEFAULT NULL,
  `time_table_generator_day_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_time_table_generator_hours`
--

INSERT INTO `tbl_time_table_generator_hours` (`time_table_generator_hour_id`, `time_table_generator_hour_title`, `time_table_generator_subject_name`, `module_id`, `time_table_generator_day_id`) VALUES
(1257, '09:30-10:30', 'English-Dinesh', 1, 249),
(1258, '10:30-11:30', 'Language-Mohammed', 3, 249),
(1259, '11:30-11:45', 'English-Dinesh', 1, 249),
(1260, '12:38-13:16', 'Language-Mohammed', 3, 249),
(1261, '09:30-10:30', 'Science-Anand', 4, 250),
(1262, '10:30-11:30', 'Mathematics-Arun', 2, 250),
(1263, '11:30-11:45', 'English-Dinesh', 1, 250),
(1264, '12:38-13:16', 'Mathematics-Arun', 2, 250),
(1265, '09:30-10:30', 'Mathematics-Arun', 2, 251),
(1266, '10:30-11:30', 'Mathematics-Arun', 2, 251),
(1267, '11:30-11:45', 'Language-Mohammed', 3, 251),
(1268, '12:38-13:16', 'Science-Anand', 4, 251),
(1269, '09:30-10:30', 'Mathematics-Arun', 2, 252),
(1270, '10:30-11:30', 'Language-Mohammed', 3, 252),
(1271, '11:30-11:45', 'Social Science-Praveen', 5, 252),
(1272, '12:38-13:16', 'Language-Mohammed', 3, 252),
(1273, '09:30-10:30', 'Science-Anand', 4, 253),
(1274, '10:30-11:30', 'English-Dinesh', 1, 253),
(1275, '11:30-11:45', 'Mathematics-Arun', 2, 253),
(1276, '12:38-13:16', 'Social Science-Praveen', 5, 253),
(1277, '09:30-10:30', 'Language-Mohammed', 3, 254),
(1278, '10:30-11:30', 'English-Dinesh', 1, 254),
(1279, '11:30-11:45', 'Science-Anand', 4, 254),
(1280, '12:38-13:16', 'English-Dinesh', 1, 254),
(1281, '09:30-10:30', 'Mathematics-Arun', 2, 255),
(1282, '10:30-11:30', 'Social Science-Praveen', 5, 255),
(1283, '11:30-11:45', 'Language-Mohammed', 3, 255),
(1284, '12:38-13:16', 'Science-Anand', 4, 255),
(1285, '09:30-10:30', 'Social Science-Praveen', 5, 256),
(1286, '10:30-11:30', 'English-Dinesh', 1, 256),
(1287, '11:30-11:45', 'Mathematics-Arun', 2, 256),
(1288, '12:38-13:16', 'Language-Mohammed', 3, 256),
(1289, '09:30-10:30', 'Social Science-Praveen', 5, 257),
(1290, '10:30-11:30', 'Social Science-Praveen', 5, 257),
(1291, '11:30-11:45', 'Science-Anand', 4, 257),
(1292, '12:38-13:16', 'Social Science-Praveen', 5, 257),
(1293, '09:30-10:30', 'English-Dinesh', 1, 258),
(1294, '10:30-11:30', 'Science-Anand', 4, 258),
(1295, '11:30-11:45', 'Social Science-Praveen', 5, 258),
(1296, '12:38-13:16', 'Mathematics-Arun', 2, 258),
(1297, '09:30-10:30', 'Mathematics-Arun', 2, 259),
(1298, '10:30-11:30', 'Social Science-Praveen', 5, 259),
(1299, '11:30-11:45', 'Social Science-Praveen', 5, 259),
(1300, '12:38-13:16', 'Social Science-Praveen', 5, 259),
(1301, '09:30-10:30', 'English-Dinesh', 1, 260),
(1302, '10:30-11:30', 'Language-Mohammed', 3, 260),
(1303, '11:30-11:45', 'Science-Anand', 4, 260),
(1304, '12:38-13:16', 'Social Science-Praveen', 5, 260),
(1305, '09:30-10:30', 'Science-Anand', 4, 261),
(1306, '10:30-11:30', 'Language-Mohammed', 3, 261),
(1307, '11:30-11:45', 'Science-Anand', 4, 261),
(1308, '12:38-13:16', 'English-Dinesh', 1, 261),
(1309, '09:30-10:30', 'Language-Mohammed', 3, 262),
(1310, '10:30-11:30', 'Mathematics-Arun', 2, 262),
(1311, '11:30-11:45', 'Mathematics-Arun', 2, 262),
(1312, '12:38-13:16', 'Mathematics-Arun', 2, 262),
(1313, '09:30-10:30', 'Mathematics-Arun', 2, 263),
(1314, '10:30-11:30', 'Social Science-Praveen', 5, 263),
(1315, '11:30-11:45', 'Science-Anand', 4, 263),
(1316, '12:38-13:16', 'English-Dinesh', 1, 263),
(1317, '09:30-10:30', 'English-Jo', 1, 264),
(1318, '10:30-11:30', 'English-Jo', 1, 264),
(1319, '11:30-11:45', 'English-Jo', 1, 264),
(1320, '12:38-13:16', 'English-Jo', 1, 264),
(1321, '09:30-10:30', 'English-Jo', 1, 265),
(1322, '10:30-11:30', 'English-Jo', 1, 265),
(1323, '11:30-11:45', 'English-Jo', 1, 265),
(1324, '12:38-13:16', 'English-Jo', 1, 265),
(1325, '09:30-10:30', 'English-Jo', 1, 266),
(1326, '10:30-11:30', 'English-Jo', 1, 266),
(1327, '11:30-11:45', 'English-Jo', 1, 266),
(1328, '12:38-13:16', 'English-Jo', 1, 266),
(1329, '09:30-10:30', 'English-Jo', 1, 267),
(1330, '10:30-11:30', 'English-Jo', 1, 267),
(1331, '11:30-11:45', 'English-Jo', 1, 267),
(1332, '12:38-13:16', 'English-Jo', 1, 267),
(1333, '09:30-10:30', 'English-Jo', 1, 268),
(1334, '10:30-11:30', 'English-Jo', 1, 268),
(1335, '11:30-11:45', 'English-Jo', 1, 268),
(1336, '12:38-13:16', 'English-Jo', 1, 268);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_time_table_template`
--

CREATE TABLE `tbl_time_table_template` (
  `time_table_template_id` bigint(20) NOT NULL,
  `time_table_name` varchar(150) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_time_table_template`
--

INSERT INTO `tbl_time_table_template` (`time_table_template_id`, `time_table_name`, `institution_id`) VALUES
(1, 'Weekly TimeTable', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_time_table_template_days`
--

CREATE TABLE `tbl_time_table_template_days` (
  `time_table_template_day_id` bigint(20) NOT NULL,
  `time_table_template_day_name` varchar(150) NOT NULL,
  `time_table_template_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_time_table_template_days`
--

INSERT INTO `tbl_time_table_template_days` (`time_table_template_day_id`, `time_table_template_day_name`, `time_table_template_id`) VALUES
(5, 'Friday', 1),
(1, 'Monday', 1),
(4, 'Thursday', 1),
(2, 'Tuesday', 1),
(3, 'Wednesday', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_time_table_template_hours`
--

CREATE TABLE `tbl_time_table_template_hours` (
  `time_table_template_hour_id` bigint(20) NOT NULL,
  `time_table_template_hour_end_time` time NOT NULL,
  `time_table_template_hour_name` varchar(150) NOT NULL,
  `time_table_template_hour_start_time` time NOT NULL,
  `time_table_template_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_time_table_template_hours`
--

INSERT INTO `tbl_time_table_template_hours` (`time_table_template_hour_id`, `time_table_template_hour_end_time`, `time_table_template_hour_name`, `time_table_template_hour_start_time`, `time_table_template_id`) VALUES
(1, '10:30:00', 'Hour1', '09:30:00', 1),
(2, '11:30:00', 'Hour2', '10:30:00', 1),
(3, '11:45:00', 'Hour3', '11:30:00', 1),
(4, '13:16:00', 'Hour4', '12:38:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transfer_certificate_requisition`
--

CREATE TABLE `tbl_transfer_certificate_requisition` (
  `tc_requisition_id` bigint(20) NOT NULL,
  `approval_status` varchar(255) NOT NULL,
  `approval_by` varchar(255) NOT NULL,
  `approver_comments` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` date NOT NULL,
  `modified_by` varchar(255) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `request_reason` varchar(255) NOT NULL,
  `academic_year_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL,
  `portal_task_id` bigint(20) NOT NULL,
  `requisition_type_id` bigint(20) NOT NULL,
  `section_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `class_id` bigint(20) NOT NULL,
  `tc_approver_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_transfer_certificate_requisition`
--

INSERT INTO `tbl_transfer_certificate_requisition` (`tc_requisition_id`, `approval_status`, `approval_by`, `approver_comments`, `created_by`, `created_date`, `modified_by`, `modified_date`, `request_reason`, `academic_year_id`, `institution_id`, `portal_task_id`, `requisition_type_id`, `section_id`, `student_id`, `class_id`, `tc_approver_id`) VALUES
(1, 'Cancelled', 'Pending', NULL, 'parent.anand@jdsoft.in', '2017-05-15', 'parent.anand@jdsoft.in', '2017-05-15 08:11:12', 'Complete Education', 1, 1, 23, 3, 1, 1, 1, 1),
(2, 'Cancelled', 'Pending', NULL, 'parent.anand@jdsoft.in', '2017-05-15', 'parent.anand@jdsoft.in', '2017-05-15 09:38:40', 'Complete Education', 1, 1, 24, 3, 1, 1, 1, 1),
(3, 'Cancelled', 'Pending', NULL, 'parent.anand@jdsoft.in', '2017-05-15', 'parent.anand@jdsoft.in', '2017-05-15 09:40:10', 'Complete Education', 1, 1, 25, 3, 1, 1, 1, 1),
(4, 'Approved', 'admin@jdsoft.in', 'Ok permission granted', 'parent.anand@jdsoft.in', '2017-05-15', 'parent.anand@jdsoft.in', '2017-05-15 09:44:40', 'Complete Education', 1, 1, 26, 3, 1, 1, 1, 1),
(5, 'Rejected', 'admin@jdsoft.in', 'Not granted', 'parent.aachman@gmail.com', '2017-05-15', 'parent.aachman@gmail.com', '2017-05-15 10:38:14', 'Family Problem', 1, 1, 27, 3, 1, 2, 1, 1),
(6, 'Approved', 'admin@jdsoft.in', 'Ok', 'parent.aachman@gmail.com', '2017-05-15', 'parent.aachman@gmail.com', '2017-05-15 11:42:25', 'Complete Education', 1, 1, 30, 3, 1, 2, 1, 1),
(7, 'Approved', 'admin@jdsoft.in', 'Ok', 'parent.aachman@gmail.com', '2017-05-15', 'parent.aachman@gmail.com', '2017-05-15 11:50:13', 'Discontinue', 1, 1, 32, 3, 1, 2, 1, 1),
(8, 'Rejected', 'admin@jdsoft.in', 'Not Ok', 'parent.anand@jdsoft.in', '2017-05-15', 'parent.anand@jdsoft.in', '2017-05-15 11:52:15', 'Discontinue', 1, 1, 34, 3, 1, 1, 1, 1),
(9, 'Approved', 'admin@jdsoft.in', 'ok', 'parent.anand@jdsoft.in', '2017-05-15', 'parent.anand@jdsoft.in', '2017-05-15 11:57:51', 'Family Problem', 1, 1, 36, 3, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE `tbl_users` (
  `user_id` bigint(20) NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hash_key` varchar(255) NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `profile_picture` varchar(255) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`user_id`, `created_by`, `created_date`, `email`, `hash_key`, `last_login`, `modified_by`, `modified_date`, `name`, `password`, `profile_picture`, `status`, `institution_id`) VALUES
(1, 'default', '2017-04-03 11:46:39', 'admin@jdsoft.in', '$2a$10$63oH8zIusf2yG2h1FwRRqO78Vsv0OU.bIG/H750j.phr2NGMrIi0K', '2017-05-30 12:19:22', 'admin@jdsoft.in', '2017-05-08 06:32:09', 'Jo Anand', 'admin', '/resources/themes/images/staff-profile/149422512896858fa9b267d17a8887e0552fa75c8251f.jpg', 1, 1),
(2, 'admin@jdsoft.in', '2017-04-03 11:53:23', 'dineshponrajdpr@gmail.com', '$2a$10$0JBJeYxfB.XrdrQFkUiNwO5UoiQXBHY0uNcyYQlJA1F.8IIx8uske', '2017-05-26 10:57:56', 'admin@jdsoft.in', '2017-04-03 06:29:31', 'Dinesh Ponraj', 'staff', '/resources/themes/images/staff-profile/1491200603064Rubiks-3D-Wallpaper-HD-Free-For-Desktop-Mobile.png', 1, 1),
(3, 'admin@jdsoft.in', '2017-04-03 11:55:42', 'arunbalaji@gmail.com', '$2a$10$gXOsxTmJOtsn/Lv5oMMDo.boyMH0h3m8TATyUiQP5UX2tIEymWinW', '2017-05-19 18:54:53', 'admin@jdsoft.in', '2017-04-03 06:30:11', 'Arun Balaji', 'staff', '/resources/themes/images/staff-profile/1491200742452IMG_335465.jpg', 1, 1),
(4, 'admin@jdsoft.in', '2017-04-03 11:58:23', 'mohammeddhanveer@gmail.com', '$2a$10$XvbVHiCnaK9SkjQoZxU8K.rszE8Sf3EJSZAYcWbyc/qYfB.vfKJ5q', '2017-04-10 18:45:45', 'admin@jdsoft.in', '2017-04-03 06:30:41', 'Mohammed Dhanveer', 'staff', '/resources/themes/images/staff-profile/1491200903329Rubiks-3D-Wallpaper-HD-Free-For-Desktop-Mobile.png', 1, 1),
(5, 'admin@jdsoft.in', '2017-04-03 12:03:09', 'anandraj@gmail.com', '$2a$10$OWyFOtHkRJcEE.52X2l7DukbAWfkedwg0qOpaiH99R5akjgsOGuuW', NULL, 'admin@jdsoft.in', '2017-04-03 06:33:09', 'Anand Raj', 'staff', '/resources/themes/images/staff-profile/1491201189422IMG_335465.jpg', 1, 1),
(6, 'admin@jdsoft.in', '2017-04-03 12:04:48', 'praveenkumar@gmail.com', '$2a$10$qwkA67oaRhL2G94/OFhDc.wCS1.fmR00sO9FLka/BJDNVKQ6HBaLW', NULL, 'admin@jdsoft.in', '2017-04-03 06:34:48', 'Praveen Kumar', 'staff', '/resources/themes/images/staff-profile/149120128855858fa9b267d17a8887e0552fa75c8251f.jpg', 1, 1),
(7, 'admin@jdsoft.in', '2017-04-04 10:28:05', 'anand@jdsoft.in', '$2a$10$9HIFCIbSwAUbEwz8rD5r0e5g926BbAxVHi6LMnbZNEgBfujnOaSZ2', '2017-05-26 11:36:27', 'anand@jdsoft.in', '2017-05-09 05:28:49', 'Jo Anand', 'student', '/resources/themes/images/student-profile/149430772916958fa9b267d17a8887e0552fa75c8251f.jpg', 1, 1),
(8, 'admin@jdsoft.in', '2017-04-04 10:28:05', 'parent.anand@jdsoft.in', '$2a$10$l1v/APlAnKw7RFm0vRGkYO8BvLhVFaGiTirY3zasU7meMOlSSiPdu', '2017-05-17 15:06:39', 'admin@jdsoft.in', '2017-04-04 05:02:46', 'FN LN', 'parent', '/resources/themes/images/parent-profile/1491281885596Rubiks-3D-Wallpaper-HD-Free-For-Desktop-Mobile.png', 1, 1),
(9, 'joanand009@gmail.com', '2017-04-04 11:07:12', 'joanand009@gmail.com', '$2a$10$acwEb.A8GF7KKA2IyAnI1.hMPu7tciNliv0qSyuWVLzuqsIIZ3h5K', '2017-04-26 10:19:49', 'joanand009@gmail.com', '2017-04-04 05:37:12', 'Jo', '123', '/resources/themes/images/profile-pic/a.png', 1, 1),
(10, 'admin@jdsoft.in', '2017-04-06 10:43:55', 'parent.aachman@gmail.com', '$2a$10$IuWFiv765Im3bk.EhP/JOOdqerMCtGdRnEGxgf2QU2HP.eyPxKZjq', '2017-05-15 17:28:39', 'admin@jdsoft.in', '2017-04-10 09:04:24', 'Aachman Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(11, 'admin@jdsoft.in', '2017-04-06 10:43:54', 'aachman@gmail.com', '$2a$10$ygyb/8rhdo9gSp6WzKcfO.MN0jmggnChZ.rEPNqOqrWN7LvvPc5PG', NULL, 'admin@jdsoft.in', '2017-04-10 09:04:23', 'Aachman Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(12, 'admin@jdsoft.in', '2017-04-06 10:43:55', 'parent.aadesh@gmail.com', '$2a$10$/PuqW6jo14qyZ4ghbN5Lt.06Okno7bO4.6L6b9KDvwELHs79NyA4q', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:00', 'Aadesh Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(13, 'admin@jdsoft.in', '2017-04-06 10:43:55', 'aadesh@gmail.com', '$2a$10$5ZhRRcd1HG7/iWxeQRvStuGBzcVwB1VGgTf3.9HME/0ewV5VMyWDe', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:00', 'Aadesh Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(14, 'admin@jdsoft.in', '2017-04-06 10:43:56', 'parent.aadi@gmail.com', '$2a$10$ULQ.9w.eRViFs05hax4icupyfsT13Zo9kxpFurVeFgA3UDGBVNs/6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:00', 'Aadi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(15, 'admin@jdsoft.in', '2017-04-06 10:43:56', 'aadi@gmail.com', '$2a$10$7b/Zh1KShrJXvV.kFA2CSuUeBjc91Mx1ZKEzos0i.ZogEr077iiQq', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aadi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(16, 'admin@jdsoft.in', '2017-04-06 10:43:57', 'parent.aafreen@gmail.com', '$2a$10$1/V82SGlUJ0Di0q7tY264utvYnsnjJ2rufSmokOiqBR0.b.YTzRQi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aafreen Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(17, 'admin@jdsoft.in', '2017-04-06 10:43:57', 'aafreen@gmail.com', '$2a$10$2TRBOnBCS3mRbbVgpbhhLOj9SgY5PEPYGD9jY4eID2GEORakuUrxG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aafreen Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(18, 'admin@jdsoft.in', '2017-04-06 10:43:57', 'parent.aakar@gmail.com', '$2a$10$ykyIXSuYdVYXxlrPSwP/6.l3XK/7OkcQP91rfwDMrWt7rViYceXYK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aakar Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(19, 'admin@jdsoft.in', '2017-04-06 10:43:57', 'aakar@gmail.com', '$2a$10$X80RJaplizpkX0faW4L3VO26FF8/iYjkDoTNrnYLax9dfdSGuU4aG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aakar Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(20, 'admin@jdsoft.in', '2017-04-06 10:43:58', 'parent.aakash@gmail.com', '$2a$10$lq43Dh1Pce8eAS6jaK7QOOmRLfv/wU8SFzweTrqiroyj1dWSg7yEa', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aakash Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(21, 'admin@jdsoft.in', '2017-04-06 10:43:58', 'aakash@gmail.com', '$2a$10$0eNNWJIiSPpovrwnrRj7iODo.xZPL8a.JvI5cGM.9J29/yrqCohmK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aakash Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(22, 'admin@jdsoft.in', '2017-04-06 10:43:58', 'parent.aalap@gmail.com', '$2a$10$UAUOXPlil745Bg1LBIuOW./WO4kft2Fg3IpwhxvfiPK9QynddCEma', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aalap Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(23, 'admin@jdsoft.in', '2017-04-06 10:43:58', 'aalap@gmail.com', '$2a$10$vIhdKpv73X4/pmovEKo9K.tpoJrakVV3vCc3Ms6FVP9dgaLgaZTqO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aalap Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(24, 'admin@jdsoft.in', '2017-04-06 10:43:59', 'parent.aandaleeb@gmail.com', '$2a$10$7QBzlaTzb5mY1usW7Z45WuXsIJuIOQaps1KTlAFXzkC21JokEba4a', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aandaleeb Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(25, 'admin@jdsoft.in', '2017-04-06 10:43:59', 'aandaleeb@gmail.com', '$2a$10$TxXObElsh/1K0PRuHpuZNeMLJJdVvemBTCbeFQOocdKKNt6IbQfkO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aandaleeb Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(26, 'admin@jdsoft.in', '2017-04-06 10:44:00', 'parent.aashish@gmail.com', '$2a$10$UmrL/V/Mkvazg5jAhteuEuM3hiW7AmakiA//lbFyV64Q7J0YIzpW.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aashish Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(27, 'admin@jdsoft.in', '2017-04-06 10:43:59', 'aashish@gmail.com', '$2a$10$IilL3sqYyTTtKCUIogUJiOJj/2x5DlSEjUo7aTEnzbwMD6O90faZa', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aashish Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(28, 'admin@jdsoft.in', '2017-04-06 10:44:00', 'parent.abeer@gmail.com', '$2a$10$x3pPYqgIlPpWd/Vw0lNQtef/Ofxt6n5t0JuQOxpUPdtVmMbywWQyu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abeer Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(29, 'admin@jdsoft.in', '2017-04-06 10:44:00', 'abeer@gmail.com', '$2a$10$XCYuC.eep/MXklbUkSyLb.F7vaAUwvKsgCYFdZzrqyrWGid/tv8hi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abeer Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(30, 'admin@jdsoft.in', '2017-04-06 10:44:01', 'parent.abhay@gmail.com', '$2a$10$A37zNJSwUDIu0VB5ocp/2.t3OqNOSxwglHx1k/yEk21js1Q/ufVkK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhay Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(31, 'admin@jdsoft.in', '2017-04-06 10:44:01', 'abhay@gmail.com', '$2a$10$rP7zTiw/HFNvFQv9..q5p.jOi70wMPBZrZhXEvkwrVV/IoeNI6uou', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhay Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(32, 'admin@jdsoft.in', '2017-04-06 10:44:01', 'parent.abhayananda@gmail.com', '$2a$10$Wg8wIxpDoWHShah/HsI6Bub6eJdAUF.dlmTbWDkUINMALA7gKoDAa', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhayananda Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(33, 'admin@jdsoft.in', '2017-04-06 10:44:01', 'abhayananda@gmail.com', '$2a$10$mYfjefJS8WvmN1jq8NmwteL6huj1pindx8/UsJdn8jdxpMWNFQy0u', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhayananda Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(34, 'admin@jdsoft.in', '2017-04-06 10:44:02', 'parent.abhayaprada@gmail.com', '$2a$10$Igu68LjL/ZV0IYzexRoY8eH5uiyyzDOll2JXqxAVNmvntDM52ZvIi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhayaprada Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(35, 'admin@jdsoft.in', '2017-04-06 10:44:02', 'abhayaprada@gmail.com', '$2a$10$FEj.a6qBUO6EPqe6sT9aa./xEe6IBKkUMKElx3BSj7lp0v0LaP49W', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhayaprada Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(36, 'admin@jdsoft.in', '2017-04-06 10:44:02', 'parent.abheek@gmail.com', '$2a$10$rOpOxqDdUGhGyNwuhumhteiB6QQrDG1IdIe265GsADDDHZjgFpbZW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abheek Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(37, 'admin@jdsoft.in', '2017-04-06 10:44:02', 'abheek@gmail.com', '$2a$10$klbi5JaTCy9UVITND/.k/e9XNR9kUA.75ZiBJaSShWdPJB7OfV.nq', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abheek Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(38, 'admin@jdsoft.in', '2017-04-06 10:44:03', 'parent.abhi@gmail.com', '$2a$10$M68mgPCGGYL53sQxWLdLwuTExpXZ3zV3tU4K92.iwb94YHQ8EzfT6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(39, 'admin@jdsoft.in', '2017-04-06 10:44:03', 'abhi@gmail.com', '$2a$10$0XLXlsDLn7yoM53DnUOcwu6XQ9446TSkTvzXBcaTZ.lvjuEhvw2W2', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(40, 'admin@jdsoft.in', '2017-04-06 10:44:03', 'parent.abhibhava@gmail.com', '$2a$10$UaCFmZXzWrdgYml51nOP4OGAaJcIfdXHn4cIFQcpHW4pfjCEHK0KO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhibhava Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(41, 'admin@jdsoft.in', '2017-04-06 10:44:03', 'abhibhava@gmail.com', '$2a$10$KlBAqllThfwNdRRO11OBg.bdNxtpvLfpc6R.YITMwn6Y4evRaqutu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhibhava Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(42, 'admin@jdsoft.in', '2017-04-06 10:44:04', 'parent.abhicandra@gmail.com', '$2a$10$FX9LtifMLyXzf8ywcqOqLeNHYnL8QubU4nEUnHQ6B33Z7VxgW5GFi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhicandra Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(43, 'admin@jdsoft.in', '2017-04-06 10:44:04', 'abhicandra@gmail.com', '$2a$10$R84uprH1s4eS1bDafLj1QeJJHbtagwtjYftj3B2dpKdp3cWwyQyQm', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhicandra Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(44, 'admin@jdsoft.in', '2017-04-06 10:44:04', 'parent.abhidi@gmail.com', '$2a$10$6isA6R7Qwg/EFnlk70S87.b09snkG6aK7XoM/OMkinIh/EjuOET9y', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhidi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(45, 'admin@jdsoft.in', '2017-04-06 10:44:04', 'abhidi@gmail.com', '$2a$10$33pVE0J5x6KUVPtBiG6T1./z76KtFvNAL01BXdqE1R/wBH7vX1kWC', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhidi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(46, 'admin@jdsoft.in', '2017-04-06 10:44:05', 'parent.abhihita@gmail.com', '$2a$10$wYg9tgZcGNG1GQDRyLv2gOqe8ul5ocwHGi7kLZGs02Y.9wGIfPydC', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhihita Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(47, 'admin@jdsoft.in', '2017-04-06 10:44:05', 'abhihita@gmail.com', '$2a$10$ZWq3mb0xB/GNW12bi/a.uugt46BHrVdXxVbvWYXPJIJ.EUUWDd9Oq', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhihita Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(48, 'admin@jdsoft.in', '2017-04-06 10:44:05', 'parent.abhijat@gmail.com', '$2a$10$c/kcuf5UKViuXjONbTGiMOFJq.Fk3wTdBpcM7fqtu9ZESBxsPs9/6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhijat Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(49, 'admin@jdsoft.in', '2017-04-06 10:44:05', 'abhijat@gmail.com', '$2a$10$iRGxS08qFZ6Wg0vHax9moeuGyGta9hnXelPWNt3yBGqFunkyIyd2e', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhijat Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(50, 'admin@jdsoft.in', '2017-04-06 10:44:06', 'parent.abhijaya@gmail.com', '$2a$10$azw3/GoZr3P4JQpz7gk.WOBnsw5p3PhmydlXY1NtxZlXtjDtFTzbi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhijaya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(51, 'admin@jdsoft.in', '2017-04-06 10:44:06', 'abhijaya@gmail.com', '$2a$10$F0mXdkDjSH8jvSHQoezKT.4EmVv94AMF9hOTOtWQhmYNj/XYqWeL6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhijaya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(52, 'admin@jdsoft.in', '2017-04-06 10:44:06', 'parent.abhijit@gmail.com', '$2a$10$zdkz28DABcXyNXh4s6Dfq.GOrjEAmLDpgfByebiXTUGLnOq35gaZu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhijit Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(53, 'admin@jdsoft.in', '2017-04-06 10:44:06', 'abhijit@gmail.com', '$2a$10$89eF08byTkpGulDCV4Pf3.lzfOCTpahfvq3ZaUW1.wWeG5eoyhXZO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhijit Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(54, 'admin@jdsoft.in', '2017-04-06 10:44:07', 'parent.abhijvala@gmail.com', '$2a$10$bcGGUGoJFPFv5.0fcR3U4ebfRyPA.0Qs1FMrqmIspiK1/Wsmhbfv.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhijvala Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(55, 'admin@jdsoft.in', '2017-04-06 10:44:07', 'abhijvala@gmail.com', '$2a$10$ynBMKl.LIJuGDfDRRMhOT.tHiH48gNi88nH4okPz4isrwzZDPuWzm', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhijvala Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(56, 'admin@jdsoft.in', '2017-04-06 10:44:07', 'parent.abhilash@gmail.com', '$2a$10$.TSK46ghEX3uzN4RyEgkiu.xG.aiJfQIHiWmuOso9MiSEJwbqRXKC', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhilash Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(57, 'admin@jdsoft.in', '2017-04-06 10:44:07', 'abhilash@gmail.com', '$2a$10$3fgc7FMzsFt9j5Ecu5oWVOJ7zAl.pKFYSvHOzBlZmRtxvgwJhj/Km', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhilash Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(58, 'admin@jdsoft.in', '2017-04-06 10:44:08', 'parent.abhimand@gmail.com', '$2a$10$ZAl7k59NDyxjqZNDuqfQSOPJT2i5zsZ59vv9YLmr3fjohDwlTLHPK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhimand Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(59, 'admin@jdsoft.in', '2017-04-06 10:44:08', 'abhimand@gmail.com', '$2a$10$iFzW8DZmipr5h/JXJFsg.OonglrV1DnK48fAr5ln674qUNgU1mos6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhimand Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(60, 'admin@jdsoft.in', '2017-04-06 10:44:08', 'parent.aashika@gmail.com', '$2a$10$K1KnZU8PHhUadkOj7SH2JebqXZI3bQtfa7CIMFoLZfUlT4dI21t3a', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aashika Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(61, 'admin@jdsoft.in', '2017-04-06 10:44:08', 'aashika@gmail.com', '$2a$10$Bk1UHFkBiR4g4IhLGWVyZ.8v6yDMmaoMmSNsJN2QlU.yRyPNJ6p1i', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aashika Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(62, 'admin@jdsoft.in', '2017-04-06 10:44:09', 'parent.abha@gmail.com', '$2a$10$JmtvC5rffDY.KRYLZGPlBOQX7VczGtkLfq9.9TpzNz4RJzTjZx.sG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abha Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(63, 'admin@jdsoft.in', '2017-04-06 10:44:09', 'abha@gmail.com', '$2a$10$wH1bQ2fgrJx2b5an/T2mEudN7Wd5bQKEaTeua2OKi9wShwcfu3kQe', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abha Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(64, 'admin@jdsoft.in', '2017-04-06 10:44:10', 'parent.abhati@gmail.com', '$2a$10$h9jNwC1awX.oSjvcrmfAuOCAd6YMoedCJJjMi3PJ7MipNB17PRzuO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhati Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(65, 'admin@jdsoft.in', '2017-04-06 10:44:09', 'abhati@gmail.com', '$2a$10$lyGM0fKtKapqaFCw.zx5P.jgcQp3zjOaaub3sCjrgmmPkJeGOERku', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhati Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(66, 'admin@jdsoft.in', '2017-04-06 10:44:10', 'parent.abhaya@gmail.com', '$2a$10$dIqr7aqPTsMtuTdx8TQmoOKTh5yPVpJ.Ch5jbi1SFqCs8UngXVdu2', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhaya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(67, 'admin@jdsoft.in', '2017-04-06 10:44:10', 'abhaya@gmail.com', '$2a$10$/Rv5qq8lzOuM4jc3u5YvUO7jHfJ3LXwcku6ssvPAZXMeihkAqqV86', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhaya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(68, 'admin@jdsoft.in', '2017-04-06 10:44:11', 'parent.abhidha@gmail.com', '$2a$10$Roi1HrC3EBlU.vNtQ6AUd.h.YlgvI5TvyzH3FT5K5pKTdVpnpIlXi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhidha Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(69, 'admin@jdsoft.in', '2017-04-06 10:44:11', 'abhidha@gmail.com', '$2a$10$QUjPdSExSfyLgeebiCsTdO01c0Q9kam6qs6zbpb14xW7vqQSpjavG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhidha Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(70, 'admin@jdsoft.in', '2017-04-06 10:44:11', 'parent.abhidhya@gmail.com', '$2a$10$zhsFZfQ6dEpDUqxDOEpQL.i3fH2roERgc9j0QeGcMLz3Ok8vNPeqa', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhidhya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(71, 'admin@jdsoft.in', '2017-04-06 10:44:11', 'abhidhya@gmail.com', '$2a$10$XY9QjnZ0dWSPVTEwQ2k7N.6QbCUd28ppJcFQ591iMzsxC5LqTkCJK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhidhya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(72, 'admin@jdsoft.in', '2017-04-06 10:44:12', 'parent.abhijna@gmail.com', '$2a$10$k7d68JMhngx/qW3Pypamsu7BVSpLYnrkG/xLh2PAAgvJVvNUF7pWK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhijna Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(73, 'admin@jdsoft.in', '2017-04-06 10:44:12', 'abhijna@gmail.com', '$2a$10$MOWr1XsCAsFfiCdpxFemyO9FHyf8ojvRnYKB2IPRX4MADuyh821G.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhijna Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(74, 'admin@jdsoft.in', '2017-04-06 10:44:13', 'parent.abhilasa@gmail.com', '$2a$10$9bDcpfrYcWcCtTXkyFwVR.GDifpsef9oEL181QxBlUpcObWF3cRbe', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhilasa Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(75, 'admin@jdsoft.in', '2017-04-06 10:44:13', 'abhilasa@gmail.com', '$2a$10$4LEbctOF3QOVTA0vy8Ukf.Re9ndcrOZStgFdYKKvWE1Kv8bCfK9TO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhilasa Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(76, 'admin@jdsoft.in', '2017-04-06 10:44:14', 'parent.abhilasha@gmail.com', '$2a$10$sxJOrQzlitZU1M5VZQ1abeEsEs2GdEtaiijUPPvJmg/ZGqXqN2waK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhilasha Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(77, 'admin@jdsoft.in', '2017-04-06 10:44:14', 'abhilasha@gmail.com', '$2a$10$dVsceMVaRT2qnEAVyYwVB.iN9ENkbwtEm5uQ57hCa2y6K2hqzoN4m', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhilasha Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(78, 'admin@jdsoft.in', '2017-04-06 10:44:14', 'parent.abhinithi@gmail.com', '$2a$10$UYXdwoUXl0cbZadYPhNOM.On2DxbVqNFIaKEdtPReHRYx.DyyT60i', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhinithi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(79, 'admin@jdsoft.in', '2017-04-06 10:44:14', 'abhinithi@gmail.com', '$2a$10$yE.Ombx2F5eDRN7kk/o62eyVtR25f.jpT7vZ8W7Uu4Vbw1afjWAE6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhinithi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(80, 'admin@jdsoft.in', '2017-04-06 10:44:15', 'parent.abhiprithi@gmail.com', '$2a$10$sVwfbGNzkG3H4/ocoj9Et.FTtQuO8c8LhEqdO3vvTZMqFx2Pbz2xa', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhiprithi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(81, 'admin@jdsoft.in', '2017-04-06 10:44:15', 'abhiprithi@gmail.com', '$2a$10$lak91NBI2w0aE75BfGEMAu..OKR/Xco.bVgw86MG.99jwrCWG7O5m', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhiprithi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(82, 'admin@jdsoft.in', '2017-04-06 10:44:16', 'parent.abhirathi@gmail.com', '$2a$10$dDnNE.i7.zkYeBy5L94.9Otl9jF9uRHEx..jeqWrkUD.fcTjWjvRS', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhirathi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(83, 'admin@jdsoft.in', '2017-04-06 10:44:15', 'abhirathi@gmail.com', '$2a$10$Q/T.6S/yKOvgdYbT6gmtKeXHjNFeRIJCYLWsreqQC3TTn4Ociubv6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhirathi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(84, 'admin@jdsoft.in', '2017-04-06 10:44:16', 'parent.abhisri@gmail.com', '$2a$10$oh9S.OyQBATc7rH60SrM3eWNSaJR7GqnfodYZ3rG6UmV6m6z3qXyK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhisri Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(85, 'admin@jdsoft.in', '2017-04-06 10:44:16', 'abhisri@gmail.com', '$2a$10$CTr.1LX2AmWnZ2TBb9arHOhaBSqkEyPsFp49Y0xHN8j3JvGlagGci', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhisri Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(86, 'admin@jdsoft.in', '2017-04-06 10:44:17', 'parent.abhithi@gmail.com', '$2a$10$KY8q9HUdzvzT/JgJcvYcI.f2SNZGBlxlghpeywpEyri/MazeECg.e', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhithi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(87, 'admin@jdsoft.in', '2017-04-06 10:44:17', 'abhithi@gmail.com', '$2a$10$j2J3Y/fHpapc9EGieIBk..VCRaADQhA9gsJPICMM8HRkmnbP7iiO.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abhithi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(88, 'admin@jdsoft.in', '2017-04-06 10:44:17', 'parent.abja@gmail.com', '$2a$10$Zx21Sm9ISBVqjh3mCkh/muYHu98utRfwHY6F04ryaBBpDWEHmaE.e', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abja Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(89, 'admin@jdsoft.in', '2017-04-06 10:44:17', 'abja@gmail.com', '$2a$10$8J1xiXc8R4mDATY9qalFB.f5bLnLPo0vrI/jGyxAq9zOfS/eALKfy', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Abja Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(90, 'admin@jdsoft.in', '2017-04-06 10:44:18', 'parent.aboil@gmail.com', '$2a$10$bEsxU9xIz8rHgvg5UCcW0OvWoWNtDkTPDfRa74LAtmZ24l5SNmdnm', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aboil Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(91, 'admin@jdsoft.in', '2017-04-06 10:44:18', 'aboil@gmail.com', '$2a$10$BtcI.AiPMFuZfyNoT1ziKutTwSXHNhIPjQC2zQtLcwBJWRM0TElk6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aboil Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(92, 'admin@jdsoft.in', '2017-04-06 10:44:18', 'parent.achala@gmail.com', '$2a$10$nGHd5i4AHfdIcnfctVzDIOSGyFJyLyxTxHjTeoILY4C9GsquLlpea', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Achala Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(93, 'admin@jdsoft.in', '2017-04-06 10:44:18', 'achala@gmail.com', '$2a$10$P6p5vYCdvrExaOzxTCKAhu7uyepF5Yhjipg6bmKrHHu1wIMh1BXwG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Achala Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(94, 'admin@jdsoft.in', '2017-04-06 10:44:19', 'parent.acira@gmail.com', '$2a$10$NmcMHWWW3bCF3wWll5YSa.2Rppkz9Oq.cRnf9h5XCJvt.mXLHNQYG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Acira Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(95, 'admin@jdsoft.in', '2017-04-06 10:44:19', 'acira@gmail.com', '$2a$10$p2rDZ9JxcgfIMEs084qBn.IB/Mege10hqWghyRJmT.5bwKnJkHh6C', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Acira Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(96, 'admin@jdsoft.in', '2017-04-06 10:44:20', 'parent.adarsha@gmail.com', '$2a$10$k1XNMwwdwmRbqRDCXJ6Cb.aNPQt8DQ.6GFmbHyill6DquHnQjYheG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adarsha Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(97, 'admin@jdsoft.in', '2017-04-06 10:44:19', 'adarsha@gmail.com', '$2a$10$4Xx/pxQNyudTD/u61w8KE.gju8HMYcXoO1sn89pWkNzrMbIEkCabm', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adarsha Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(98, 'admin@jdsoft.in', '2017-04-06 10:44:20', 'parent.adhira@gmail.com', '$2a$10$RRWExXeHtGTXTbgijN0LauQDcpRlvJtO2eqpOghMhAGJZ/MT02L.a', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adhira Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(99, 'admin@jdsoft.in', '2017-04-06 10:44:20', 'adhira@gmail.com', '$2a$10$rs9yBWviGs4nmnLkcSEXcOTGYcFCIK4N63e92RKCubvQ7rWCaxTJu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adhira Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(100, 'admin@jdsoft.in', '2017-04-06 10:44:21', 'parent.adishree@gmail.com', '$2a$10$62nwfKEANydL9WHt7Sa26.YIcM8tt2/VRg3yKBTlwGIngUYzL4l0y', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adishree Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(101, 'admin@jdsoft.in', '2017-04-06 10:44:20', 'adishree@gmail.com', '$2a$10$gvxQXbwjAckujacik.HFC.ICIgiWdEVc0YgoFMpij50apk41l97ye', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adishree Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(102, 'admin@jdsoft.in', '2017-04-06 10:44:21', 'parent.aditha@gmail.com', '$2a$10$ZcIkkyGOi3vfHfDsdFNt7ezTlWUcSRjDYlAtcxxahWDx//jEuqmu6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aditha Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(103, 'admin@jdsoft.in', '2017-04-06 10:44:21', 'aditha@gmail.com', '$2a$10$F9KImREj89lIM16bMlLPZOYGtIRcxyz9ckYf0cqDpUlL0UjMGWpd2', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aditha Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(104, 'admin@jdsoft.in', '2017-04-06 10:44:22', 'parent.adithi@gmail.com', '$2a$10$ZEqxu28hc4IDgFqUhrBX6uWOVX1ZwJdtLuwp4xk4JgeafleWRVSTa', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adithi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(105, 'admin@jdsoft.in', '2017-04-06 10:44:22', 'adithi@gmail.com', '$2a$10$gaVxY2j19XujYcAv2ZsW1u3SEbZjWoSY7AKPLP5dctg/7jSgitWGu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adithi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(106, 'admin@jdsoft.in', '2017-04-06 10:44:22', 'parent.aditi@gmail.com', '$2a$10$WkrGXWyxwQKvwK0IO1CU6.Uj4cxTCLtpXYXzYh5H4TZw4P2UhA.va', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aditi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(107, 'admin@jdsoft.in', '2017-04-06 10:44:22', 'aditi@gmail.com', '$2a$10$R7xAA.EwCl76AMrRv5ykLewl53pAP/ePQeCGBELaOprxzzX1A1qFq', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aditi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(108, 'admin@jdsoft.in', '2017-04-06 10:44:23', 'parent.adrija@gmail.com', '$2a$10$ippQN27AW56/cfJbKx2E0u7ISWHtYWSml3T0x6RR2K2/vXnBmfK/q', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adrija Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(109, 'admin@jdsoft.in', '2017-04-06 10:44:23', 'adrija@gmail.com', '$2a$10$5.2RCVC79wB1GNZOhGw/FON5JlUko8amN5UVyeRENlpSUYQMLPcLW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adrija Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(110, 'admin@jdsoft.in', '2017-04-06 10:44:23', 'parent.adrika@gmail.com', '$2a$10$6RPrNUvN87Xv0mJpNxDyk.O.Pc14wxmzspPrvYBHctv8RUD2fDcmi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adrika Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(111, 'admin@jdsoft.in', '2017-04-06 10:44:23', 'adrika@gmail.com', '$2a$10$r0lR2Vnm4O3xlIIS5pbiXO4WzG6iPCxzU7RmO6f1./NKvXZhgRgrm', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adrika Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(112, 'admin@jdsoft.in', '2017-04-06 10:44:24', 'parent.advika@gmail.com', '$2a$10$WycoMunWVK9YBkpGZF2RvurbBajAC3tyNmv4jmV1q3zcVa4xzJQkW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Advika Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(113, 'admin@jdsoft.in', '2017-04-06 10:44:24', 'advika@gmail.com', '$2a$10$4FaxrHxo2ckFMmvUTVy3h.bvWQWjf.TAXf/S4WeE0SmzRq0U1SCZe', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Advika Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(114, 'admin@jdsoft.in', '2017-04-06 10:44:24', 'parent.adya@gmail.com', '$2a$10$WOHAZLH85onNZQrpXs5bde7bpcx6PJ6H5mEMLDrPrpK8vgXVmhN0C', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(115, 'admin@jdsoft.in', '2017-04-06 10:44:24', 'adya@gmail.com', '$2a$10$C6jXIYcUS80cu9ZGEYWol.HX1f/oIelu1I.ZUmAIlejKRRPeS9iTO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Adya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(116, 'admin@jdsoft.in', '2017-04-06 10:44:25', 'parent.aghanashini@gmail.com', '$2a$10$CueiyGSWUvWw4Op0ThUN6OLG36UCOWLthd53eiDEYLJcgXZXlvDDa', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aghanashini Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(117, 'admin@jdsoft.in', '2017-04-06 10:44:25', 'aghanashini@gmail.com', '$2a$10$q7I6iro0Lagla9TQZ6ly0OGNnyrxj1Mbzw8w4GjcmVBCjRQRLU3wa', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Aghanashini Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(118, 'admin@jdsoft.in', '2017-04-06 10:44:25', 'parent.agrata@gmail.com', '$2a$10$AdZm5krFWaxTylb894HAduLrjLlsaEblHKb1F01rpY7qLTLGBIO8S', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Agrata Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(119, 'admin@jdsoft.in', '2017-04-06 10:44:25', 'agrata@gmail.com', '$2a$10$oGaO61GglFPmQhSE1uPRE.CKBytv6FZzgeKWzEtzGIMp1x3N899AK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Agrata Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(120, 'admin@jdsoft.in', '2017-04-06 10:44:26', 'parent.agrima@gmail.com', '$2a$10$vzlbdQHJ17pu7wekfYsZl.PiM1BEtyQyuMpOY6z44DbVV7g3Qf26O', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Agrima Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(121, 'admin@jdsoft.in', '2017-04-06 10:44:26', 'agrima@gmail.com', '$2a$10$Lfk19jnD77Ugg6tyIZTZ9OfAYhjEtHEwaQjH2PeJvWlNlefYhQGzu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Agrima Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(122, 'admin@jdsoft.in', '2017-04-06 10:44:27', 'parent.ahalya@gmail.com', '$2a$10$TB3u2XNyJhwVDmKGxV0uAOdBgx4DpbwAEn6ys8ar8/SB.XimcWg6C', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Ahalya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(123, 'admin@jdsoft.in', '2017-04-06 10:44:27', 'ahalya@gmail.com', '$2a$10$4plDElpRV.NjkpGbGV11FeleNkmNlKe.yEdupY5mOrEDH8Y6n6x9q', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Ahalya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(124, 'admin@jdsoft.in', '2017-04-06 10:44:28', 'parent.ahilya@gmail.com', '$2a$10$kqhEojIFFbHp3RUDuLHRCuOGsE2RqH5APOeBwqIzRhLNwyXDMgvnq', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Ahilya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(125, 'admin@jdsoft.in', '2017-04-06 10:44:27', 'ahilya@gmail.com', '$2a$10$fIIxQujT87dotDvD/E3Ip.jw1yrSOzLGMx1xZSd264GDbtF0BSRyu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Ahilya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(126, 'admin@jdsoft.in', '2017-04-06 10:44:28', 'parent.ahladita@gmail.com', '$2a$10$w1Lq7wO2H2qMAriDCWBN8.bY6gZKeeIJkNXdU5cSMpvijcP22V.OC', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:01', 'Ahladita Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(127, 'admin@jdsoft.in', '2017-04-06 10:44:28', 'ahladita@gmail.com', '$2a$10$ySa6VaZm.Qs9xt7EhidlOeoMIpcTg/KhEeHDVfKLcnEA.vFPJJl.u', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahladita Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(128, 'admin@jdsoft.in', '2017-04-06 10:44:29', 'parent.ahladitha@gmail.com', '$2a$10$SsSeDD6JDW3EP.qK7nfInOaQ/Zvj/PzTctt3G8PcQs0UnvzeVpCs2', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahladitha Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(129, 'admin@jdsoft.in', '2017-04-06 10:44:29', 'ahladitha@gmail.com', '$2a$10$JrXRArYdtfiehCjGv894oOPSd8i9azJ2i/xOAmElU0jeMV1sLGQwy', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahladitha Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(130, 'admin@jdsoft.in', '2017-04-06 10:44:30', 'parent.achyuta@gmail.com', '$2a$10$pHfZ1v.KrMiS8i1aMUOa2OlkHpcU1JwdrxqNS30CSTVHvonscmpk6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Achyuta Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(131, 'admin@jdsoft.in', '2017-04-06 10:44:29', 'achyuta@gmail.com', '$2a$10$cYcofGEmf97lMTKuXxvesuNr5LCSdK26MQCyAJ1.gRsyj.5Hc894K', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Achyuta Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(132, 'admin@jdsoft.in', '2017-04-06 10:44:30', 'parent.acintya@gmail.com', '$2a$10$RrJovWNypRaMZ43HXJMW/u7vyQI/r5wLfhr45JsRLg54gws/3AgAm', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Acintya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(133, 'admin@jdsoft.in', '2017-04-06 10:44:30', 'acintya@gmail.com', '$2a$10$ti/s.oyAgJ0eYj/KWbhFTOT9deaYRE6rFAvjPN3KN9jOMLTsNzLBG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Acintya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(134, 'admin@jdsoft.in', '2017-04-06 10:44:31', 'parent.acyutaraya@gmail.com', '$2a$10$0NQOBCz5vJqnLNXtsK7Q2.ohCDIjPGcy0.dnlEny0H1zKPG2HNWB6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Acyutaraya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(135, 'admin@jdsoft.in', '2017-04-06 10:44:30', 'acyutaraya@gmail.com', '$2a$10$GpG3wGoFpQVaG/r9YGzNO.oPUCZyRGwtKSmTLLELhDj7qTisCGmUS', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Acyutaraya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(136, 'admin@jdsoft.in', '2017-04-06 10:44:31', 'parent.adalarasu@gmail.com', '$2a$10$ICA5ymI/9W33x0FZZdpsVeSFCkYmZSInSnPx0DwUBZ8cVgSrzbYD.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adalarasu Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(137, 'admin@jdsoft.in', '2017-04-06 10:44:31', 'adalarasu@gmail.com', '$2a$10$DKvKFGwYYSjOLpuVFWcfvOMPQNyAjvCijD.hg4.0tutVULKTRnzQi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adalarasu Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(138, 'admin@jdsoft.in', '2017-04-06 10:44:32', 'parent.adarsh@gmail.com', '$2a$10$5QeBzalKXT6IdpuCaBr.lu49E5pdGcHx599YNOFLSHbSBeomAZDUG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adarsh Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(139, 'admin@jdsoft.in', '2017-04-06 10:44:32', 'adarsh@gmail.com', '$2a$10$nAGKQtfIl975Vr81Fgot8Onq/H88TIx9GERMNNos.swHYSjio5D5q', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adarsh Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(140, 'admin@jdsoft.in', '2017-04-06 10:44:33', 'parent.adesh@gmail.com', '$2a$10$r5SabHzghS0gjpjs8p/zd.M9xVGQfAGDOHcxhwnMW3YyPpjGcprmS', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adesh Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(141, 'admin@jdsoft.in', '2017-04-06 10:44:33', 'adesh@gmail.com', '$2a$10$ywlUl2MMRvyJWsNBnlNqd.lHNuycGN4i.RPoltyGhJfojTZqEjruW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adesh Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(142, 'admin@jdsoft.in', '2017-04-06 10:44:34', 'parent.adhik@gmail.com', '$2a$10$BE70ZOqRJMxmxnrWSccFLuRDhizM8JPel6v2jZHvu61oWUVfdhPzu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adhik Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(143, 'admin@jdsoft.in', '2017-04-06 10:44:33', 'adhik@gmail.com', '$2a$10$9DuutlzhfaVU1TjObkSFmuP3W7QY8FTiCpNdqrRaM1k58tQOvvAyi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adhik Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(144, 'admin@jdsoft.in', '2017-04-06 10:44:34', 'parent.adhikara@gmail.com', '$2a$10$LIofgySjFdxgnjwmG/aoYe8ByyDj6jLYoszLDtAVllcFrEfKYWbJi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adhikara Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(145, 'admin@jdsoft.in', '2017-04-06 10:44:34', 'adhikara@gmail.com', '$2a$10$vji3Qn3p/WX9CCC9/fX4LO54wWhRYl/rN13vl726zWGlgjrUl9jXO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adhikara Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(146, 'admin@jdsoft.in', '2017-04-06 10:44:35', 'parent.adhipa@gmail.com', '$2a$10$soxG2rIPnuNzGeqTdJEH1eHMKjmzEtdIMBfv0VAeuVH56lPMM2pvC', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adhipa Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(147, 'admin@jdsoft.in', '2017-04-06 10:44:35', 'adhipa@gmail.com', '$2a$10$.8.Gb5xepcFihjQk2tozMOSibXDx0ZBsHID5XbF.1RS8wc8WIxlxy', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adhipa Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(148, 'admin@jdsoft.in', '2017-04-06 10:44:36', 'parent.adhita@gmail.com', '$2a$10$7dVR.qr1CAecGWznh0QdNeCy/sPcEr.hRDREDk38P2zJo9uvElTji', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adhita Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(149, 'admin@jdsoft.in', '2017-04-06 10:44:36', 'adhita@gmail.com', '$2a$10$o9eH4LmU3HO/VqEddhnPvuu34/zAcp12b1V71ZliLNmRWXab1taee', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adhita Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(150, 'admin@jdsoft.in', '2017-04-06 10:44:36', 'parent.adikavi@gmail.com', '$2a$10$H2eehWlBhOtdhQWy4mmBdu9rLy6ZyuDsM1L93DVcd.0SBT5PNafJq', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adikavi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(151, 'admin@jdsoft.in', '2017-04-06 10:44:36', 'adikavi@gmail.com', '$2a$10$EROxZPhMbayCnbMAv4fr5OXaUA0ikvh6ihICGEi1MmjYqtZM9Xedm', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adikavi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(152, 'admin@jdsoft.in', '2017-04-06 10:44:37', 'parent.adil@gmail.com', '$2a$10$uD43Ou82tsS7Z/oGTKgSy.RBEkqK5Yuq81twXdkFBXSECtGgJTjjy', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adil Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(153, 'admin@jdsoft.in', '2017-04-06 10:44:37', 'adil@gmail.com', '$2a$10$nGeTJhobIyeMLxR8OvxHVOqAeDphsetjQDooS60K17a.kq8fHCcOW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adil Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(154, 'admin@jdsoft.in', '2017-04-06 10:44:37', 'parent.adinath@gmail.com', '$2a$10$Pc2fU8L5WkWHBW7GvVYAD.3tN8zd8fYwp4mVCD4rexlQbZedkMjX.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adinath Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(155, 'admin@jdsoft.in', '2017-04-06 10:44:37', 'adinath@gmail.com', '$2a$10$/Vujiq/gNofLPhAtj0yrqe4xEDStR5CSkg4az24jqaU9RfIkmgQ/S', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adinath Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(156, 'admin@jdsoft.in', '2017-04-06 10:44:38', 'parent.adit@gmail.com', '$2a$10$ZQOk8LEyHbO.mXhLu8l57uPRge0RRydlGnC8Cfs6xdb0xiC5J4PAK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adit Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(157, 'admin@jdsoft.in', '2017-04-06 10:44:38', 'adit@gmail.com', '$2a$10$nzV/.fWkaD/iJ4duFgIlyed021Rbr/bO4IokospAIL/rbynmiXky.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adit Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(158, 'admin@jdsoft.in', '2017-04-06 10:44:39', 'parent.aditeya@gmail.com', '$2a$10$v859v5LPm5TJ0m6UBMkPHeLulp1LX1U9N92cdhv78FjFdg8VmcQze', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aditeya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(159, 'admin@jdsoft.in', '2017-04-06 10:44:38', 'aditeya@gmail.com', '$2a$10$NnBHHb.hNoWl3hyzzqgI6.9cr4bhBEbpYgRf9UOCMexfOTwmK3gkm', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aditeya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(160, 'admin@jdsoft.in', '2017-04-06 10:44:39', 'parent.aditya@gmail.com', '$2a$10$CnloqaAR0gu5jcPKw6Hb0.GeKWI.gtlO44ztNETU6C6uOTS7SOX8m', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aditya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(161, 'admin@jdsoft.in', '2017-04-06 10:44:39', 'aditya@gmail.com', '$2a$10$A5Y/8ory/7HoDXSda85Gde4OmFfKIGloHBbTxUR8gMasLXknjlIRK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aditya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(162, 'admin@jdsoft.in', '2017-04-06 10:44:40', 'parent.adityanandana@gmail.com', '$2a$10$Q0MVVcvYcolGk04BesmI7ecvFdjhoaVsDD8Ve4ipOSBZpzEY7UMA2', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adityanandana Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(163, 'admin@jdsoft.in', '2017-04-06 10:44:39', 'adityanandana@gmail.com', '$2a$10$/i477NvHnBWlASlDTt75MeTrHfBfEzjGZg9UhqFzJeKmF7DuFBic.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adityanandana Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(164, 'admin@jdsoft.in', '2017-04-06 10:44:40', 'parent.adityavardhana@gmail.com', '$2a$10$xS2nrxjen7yICC1adnL7lOBScZlvhWIpqJNIVgbeOgS7oi74op7CK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adityavardhana Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(165, 'admin@jdsoft.in', '2017-04-06 10:44:40', 'adityavardhana@gmail.com', '$2a$10$wSaCe99m.2rnVpeFNjuUpurbqXdbAx2fNjCI6uDd5MjjhxQnI7hS.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adityavardhana Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(166, 'admin@jdsoft.in', '2017-04-06 10:44:41', 'parent.adripathi@gmail.com', '$2a$10$vQG/gaNQ9nurFefbV3A67OyQhAWh5X7JQdEyPQ2OyKTcVCLUZmzbW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adripathi Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(167, 'admin@jdsoft.in', '2017-04-06 10:44:41', 'adripathi@gmail.com', '$2a$10$CRLRxQcY3bjatWEHbPLsze8DYY.e3ILCc1R5fvRtoZPgEaEeAauvi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adripathi Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(168, 'admin@jdsoft.in', '2017-04-06 10:44:42', 'parent.adwaita@gmail.com', '$2a$10$lPKLV7C9Y4T6W7Sno1eqIeH1fPz9iZCNXigdDT59GD4.E7i/5VLwG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adwaita Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(169, 'admin@jdsoft.in', '2017-04-06 10:44:42', 'adwaita@gmail.com', '$2a$10$XexKPF3iMC8sR2b35TnkKOQnX23RlUy4UvgxA9A3As3W2WCWryj0y', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adwaita Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(170, 'admin@jdsoft.in', '2017-04-06 10:44:43', 'parent.adway@gmail.com', '$2a$10$cRf47RyDWLj8MAxk63NdCeTZfe/xKeHA0D125hJRr.5Oatp1f3ALe', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adway Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(171, 'admin@jdsoft.in', '2017-04-06 10:44:42', 'adway@gmail.com', '$2a$10$NWczj3DryMoGNZfOPChLR.iZxU.rDBdPmpwdshUqlyZALIIsV0JNy', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adway Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(172, 'admin@jdsoft.in', '2017-04-06 10:44:43', 'parent.adwaya@gmail.com', '$2a$10$8PUYZKidvh2n4sgV.CmzM.MnyhZmW8j/ZOGCec./IIjx9vIlXuX1q', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adwaya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(173, 'admin@jdsoft.in', '2017-04-06 10:44:43', 'adwaya@gmail.com', '$2a$10$LBP/M6uy1DYu975WDDsaM.DP5NHmudpmxad1qety4MKpjAqnX4Pz.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Adwaya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(174, 'admin@jdsoft.in', '2017-04-06 10:44:44', 'parent.aftab,aftaab@gmail.com', '$2a$10$qeQ8ICLoOM1YIiEuvHnP7e741xsxcy5AvifDc7XQWEir1NAeTPINi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aftab,Aftaab Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(175, 'admin@jdsoft.in', '2017-04-06 10:44:44', 'aftab,aftaab@gmail.com', '$2a$10$uANz1xLfpyiKufNIdUOP6ujayVNgdiwXz57ECyMaGX0asX9aHVNxi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aftab,Aftaab Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(176, 'admin@jdsoft.in', '2017-04-06 10:44:45', 'parent.agasti, agastya@gmail.com', '$2a$10$kLFuLd5CnmxJJ1aXDWmTheACR1l9DAvWTNeejGI8aPw.t2aTw7oUi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agasti, Agastya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(177, 'admin@jdsoft.in', '2017-04-06 10:44:45', 'agasti, agastya@gmail.com', '$2a$10$IszWG/UNCD3ZcXSFZK5rYOjiLLrmuZ2GQrPdlOXgCldpJyp3JTHlO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agasti, Agastya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(178, 'admin@jdsoft.in', '2017-04-06 10:44:45', 'parent.agendra@gmail.com', '$2a$10$YXGnMReSg7fhL09dniSExOuZZ5IwWi40r9DLCcU5XlXSe1nebK3EO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agendra Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(179, 'admin@jdsoft.in', '2017-04-06 10:44:45', 'agendra@gmail.com', '$2a$10$VxT6Ixnwt7W66jVX6VEqr.aCo3lwvHKUMM0TRLbAy1LUVHX/rGyrq', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agendra Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(180, 'admin@jdsoft.in', '2017-04-06 10:44:46', 'parent.agha@gmail.com', '$2a$10$O.OBspNaHXomPGA7ot5rdeIe2UT6bzTfJ.rWpytEocQhULxrRRpgq', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agha Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(181, 'admin@jdsoft.in', '2017-04-06 10:44:46', 'agha@gmail.com', '$2a$10$jrjCKLJ4K6YkZvLZ9duPkePck8AjTTiteyIR03ACFzVCtXbc/nSGi', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agha Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(182, 'admin@jdsoft.in', '2017-04-06 10:44:46', 'parent.agharna@gmail.com', '$2a$10$.Op3pTyYcSwVhnDqNK7v9updF5VcnAbkllm9rMZyyUCL6zZi9Gh5q', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agharna Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(183, 'admin@jdsoft.in', '2017-04-06 10:44:46', 'agharna@gmail.com', '$2a$10$cosifUdKvjQwGZVGTrYUm.9iT3auyyCaAISxyJeoDdWBdiLVOpeVe', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agharna Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(184, 'admin@jdsoft.in', '2017-04-06 10:44:47', 'parent.aghat@gmail.com', '$2a$10$FFfZYiTt5CfS5La/RJZBoe9I/zdhnLledc.9cCDTe2q86V/747dom', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aghat Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(185, 'admin@jdsoft.in', '2017-04-06 10:44:47', 'aghat@gmail.com', '$2a$10$kOnZFJllsO9olQyz6AL4OeMcsxWdQ4Qt3YgLq4N4Ayef25RqWVN7C', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aghat Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(186, 'admin@jdsoft.in', '2017-04-06 10:44:48', 'parent.agneya@gmail.com', '$2a$10$2pNXS8LDd9sVzQUAhIcsLegnsHReXJuVBULUF6z.jTPuDCPlQ6fp.', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agneya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(187, 'admin@jdsoft.in', '2017-04-06 10:44:48', 'agneya@gmail.com', '$2a$10$L8YAi4RiKOIbGIO3Lp9OYeh2PXK0yznb6WROwmcDJ4BJczcq9AkHe', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agneya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(188, 'admin@jdsoft.in', '2017-04-06 10:44:48', 'parent.agnikumara@gmail.com', '$2a$10$AyTneCGq3DBOsXdW.NSSj.nnPn0tv23eOhPyFMCkv1fJnDh2BKlme', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agnikumara Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1);
INSERT INTO `tbl_users` (`user_id`, `created_by`, `created_date`, `email`, `hash_key`, `last_login`, `modified_by`, `modified_date`, `name`, `password`, `profile_picture`, `status`, `institution_id`) VALUES
(189, 'admin@jdsoft.in', '2017-04-06 10:44:48', 'agnikumara@gmail.com', '$2a$10$n0gDjMY8woHvHMWIOIW9W.98Zsrza0Mv0bSbR65Zp52To2KDWnkte', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agnikumara Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(190, 'admin@jdsoft.in', '2017-04-06 10:44:49', 'parent.agniprava@gmail.com', '$2a$10$wv7gXy8NNk4hnc9YRJQB0uAZxQWJKfU8i7v2yJzBMYtdtsiTonRru', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agniprava Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(191, 'admin@jdsoft.in', '2017-04-06 10:44:49', 'agniprava@gmail.com', '$2a$10$861A78OHumX.xBhXSLR5uu2fssN9.Ezwfw6V2OG0cPPbc1x0Pt1sW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agniprava Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(192, 'admin@jdsoft.in', '2017-04-06 10:44:49', 'parent.agrim@gmail.com', '$2a$10$G5mxNs8yke2OE5Nr.igy2O29oSUBSzKmx4oXQE2Tm0zTwtKwn2bPy', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agrim Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(193, 'admin@jdsoft.in', '2017-04-06 10:44:49', 'agrim@gmail.com', '$2a$10$a0T36XIlSTXyh3dUOu/GvuRji9IO/rYJXKZAEYf6KhgcSGH1AL3zu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agrim Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(194, 'admin@jdsoft.in', '2017-04-06 10:44:50', 'parent.agriya@gmail.com', '$2a$10$bank4tdMZ.4xm8AS984dL.gGqfxxE716k4qVyWw.FrcGuBK6f9Tuy', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agriya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(195, 'admin@jdsoft.in', '2017-04-06 10:44:50', 'agriya@gmail.com', '$2a$10$qWhJ4JAy5oOWiLxm7WpMJuqdRBjLT6gh3Ntm3VWvYQWTvSnkv5Zc6', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Agriya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(196, 'admin@jdsoft.in', '2017-04-06 10:44:50', 'parent.ahijit@gmail.com', '$2a$10$vQKVoJSVisYLVF5MSA94Y.UKZetLBK/tE6qFlv3mOgK3LUUlg3wZ2', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahijit Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(197, 'admin@jdsoft.in', '2017-04-06 10:44:50', 'ahijit@gmail.com', '$2a$10$BchHJL7/9kdO7YccoVzsyeHnbzFnWomfK370D6U.fs6IfnNQLri22', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahijit Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(198, 'admin@jdsoft.in', '2017-04-06 10:44:51', 'parent.ahilan@gmail.com', '$2a$10$1NYn2H8Xi8/81snq09u35.8dPpM/gLWUXyapHf0OIZnUrCUrAX9fO', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahilan Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(199, 'admin@jdsoft.in', '2017-04-06 10:44:51', 'ahilan@gmail.com', '$2a$10$rTxHjAF2QMgll0t8BR7AXOzj5PpycvO7MRQZO/UkBDXdRlOCsL.02', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahilan Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(200, 'admin@jdsoft.in', '2017-04-06 10:44:52', 'parent.ahmad@gmail.com', '$2a$10$fLnAX0ZLKKFWsh7LrJjR2.GFh7NCitA5u5VqWJ8UNa6t1tgTBOG0i', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahmad Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(201, 'admin@jdsoft.in', '2017-04-06 10:44:51', 'ahmad@gmail.com', '$2a$10$E79JKe0RZ.ROjZf6jMdB4OhSdtWOCFjRrvHy.S.iOph1rijbuWuvS', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahmad Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(202, 'admin@jdsoft.in', '2017-04-06 10:44:52', 'parent.ahsan@gmail.com', '$2a$10$UVc0.BmVk.Av/DFRzHMfAuOz3EGn9gAsl.hyVwlHInOuNJvt00EFu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahsan Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(203, 'admin@jdsoft.in', '2017-04-06 10:44:52', 'ahsan@gmail.com', '$2a$10$/Qtuj43MOmycN/Jiy09Z4.c/tsXt22YDDduWsqKTMkaKKRBR/wvCe', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ahsan Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(204, 'admin@jdsoft.in', '2017-04-06 10:44:53', 'parent.aijaz@gmail.com', '$2a$10$TqMurHnE/hVMWRT1TDOdM.iEfxwT6WV37ATunvl8Xi5j9Lu6bU4wW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aijaz Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(205, 'admin@jdsoft.in', '2017-04-06 10:44:53', 'aijaz@gmail.com', '$2a$10$O//Z8xrp.tB6XEFqqGO2iO9mH9YMvs6Hg1Lz8evI6y4j0q7/pQYPK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aijaz Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(206, 'admin@jdsoft.in', '2017-04-06 10:44:53', 'parent.aiman@gmail.com', '$2a$10$wTa7jY36yH1XKKBmAOIXCO06e.RD5X8ZDj.ndRsdcxQAy5xtzNSyG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aiman Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(207, 'admin@jdsoft.in', '2017-04-06 10:44:53', 'aiman@gmail.com', '$2a$10$mTxkRyYN2DDQA5H9L248hupm21ByuafKF3PISAvWSmElX.0820Ehy', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Aiman Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(208, 'admin@jdsoft.in', '2017-04-06 10:44:54', 'parent.ainesh@gmail.com', '$2a$10$o9z3xuPXzqE4TKSzpgZUhO/AiMpRM7SZAYUMyLMlUYt/7t.sKKIeC', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ainesh Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(209, 'admin@jdsoft.in', '2017-04-06 10:44:54', 'ainesh@gmail.com', '$2a$10$LX9G96MqW.SgbqVpaYKtxekMbWOvDswtvHPv9S6Ed2zYqDc.3Xs6S', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ainesh Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(210, 'admin@jdsoft.in', '2017-04-06 10:44:55', 'parent.ajamil@gmail.com', '$2a$10$cmrV505Z9EXXZDTjxLVyVeL.QOPVWEcTUseJxfrSqyS.vJ2XyKhfC', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajamil Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(211, 'admin@jdsoft.in', '2017-04-06 10:44:55', 'ajamil@gmail.com', '$2a$10$1ROUjxc8jzr4l/mLolVn4OBgrthjqKdjAYgBagqZtlysq5zrpt8AG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajamil Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(212, 'admin@jdsoft.in', '2017-04-06 10:44:55', 'parent.ajatashatru@gmail.com', '$2a$10$urWsKzQ1WM695Xw5SbgXBeKrx7fx7vD0PHbxmmxQ6o9MZUIPw8abW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajatashatru Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(213, 'admin@jdsoft.in', '2017-04-06 10:44:55', 'ajatashatru@gmail.com', '$2a$10$VqHq0px0VTTLmcI1G3uTTuHsxSu8a4rMXqh4mr4tqE1Bddia3arn2', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajatashatru Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(214, 'admin@jdsoft.in', '2017-04-06 10:44:56', 'parent.ajay@gmail.com', '$2a$10$lodiNfcsH7HgQbnMLamWsOVn3lWcFn6Yfz8QqRWQmClhAry6dHN1e', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajay Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(215, 'admin@jdsoft.in', '2017-04-06 10:44:56', 'ajay@gmail.com', '$2a$10$vQFhIwmKtUxzhDHzbUHO4.NB9RRAbg0qpNTUYPD0QOjAt5lo5keCu', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajay Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(216, 'admin@jdsoft.in', '2017-04-06 10:44:56', 'parent.ajinkya@gmail.com', '$2a$10$8rv1DTlXcN3MTWJUy9uHeOreg6KTU7mh3SwIpmjWmfk8b1HjivAhS', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajinkya Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(217, 'admin@jdsoft.in', '2017-04-06 10:44:56', 'ajinkya@gmail.com', '$2a$10$O8vXUHsmcobeVmSceSiELeQY2svQQ10naY1E.ttgXcgg.k86qz6Xm', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajinkya Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(218, 'admin@jdsoft.in', '2017-04-06 10:44:57', 'parent.ajit@gmail.com', '$2a$10$cGmyHBJKh.THr/oj3aQM1eQaKBsj1dy9RiydNQSnT2MO/XhNwmwJS', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajit Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(219, 'admin@jdsoft.in', '2017-04-06 10:44:57', 'ajit@gmail.com', '$2a$10$cAXd0khjBqLoLdlPd66MMOPNXRTmu1JvHJvPLNAcBPmv9uZf2clkK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajit Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(220, 'admin@jdsoft.in', '2017-04-06 10:44:58', 'parent.ajitabh@gmail.com', '$2a$10$n52vqG1HJ.DsU2ZFvXGg0u28iPCmFmUxbIQRzyMeH.QXwWo/0AfY2', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajitabh Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(221, 'admin@jdsoft.in', '2017-04-06 10:44:57', 'ajitabh@gmail.com', '$2a$10$Onbclr6EZwIrLyelW904K.vOPFTTSC83.Kg8f1yDwLshDEAiemCSm', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajitabh Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(222, 'admin@jdsoft.in', '2017-04-06 10:44:58', 'parent.ajitesh@gmail.com', '$2a$10$iV5quT4.cy6rw9TcUfz4t.GP7gbwIQrfqVBg7WX.fIgqcSJ9wy5NS', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajitesh Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(223, 'admin@jdsoft.in', '2017-04-06 10:44:58', 'ajitesh@gmail.com', '$2a$10$MBGcYp7yPGFv09obr003K.rYB6Ij6AS5eIPYiaLl3.qumnCjgvvZC', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajitesh Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(224, 'admin@jdsoft.in', '2017-04-06 10:44:59', 'parent.ajmal@gmail.com', '$2a$10$3PS0Bt2AoITkBCwCN1F0H.fYYy7DhdRYA8aCrvuPge6tonpGGF2aK', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajmal Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(225, 'admin@jdsoft.in', '2017-04-06 10:44:59', 'ajmal@gmail.com', '$2a$10$Rz45s6WqPBDYVNu59uETtOdLqJQ11DUNNx5EPv0XVNo1vFQwA9KGW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Ajmal Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(226, 'admin@jdsoft.in', '2017-04-06 10:44:59', 'parent.akalmash@gmail.com', '$2a$10$S4cKM29MENA5cEpbbxgwauzbrAqCmDYsIqQqPu4gD/oPBU.UIl7FG', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Akalmash Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(227, 'admin@jdsoft.in', '2017-04-06 10:44:59', 'akalmash@gmail.com', '$2a$10$KUlRF6QOaOkXa/Dc3QkFeu/C2g406BxTIslkmiYqBswAfOippQR9O', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Akalmash Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(228, 'admin@jdsoft.in', '2017-04-06 10:45:00', 'parent.akalpa@gmail.com', '$2a$10$C/AJxvnkX8V52JxdOMI9u.h9idP279FyyDUCttO7R3QvN5Zx9MtWW', NULL, 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Akalpa Null', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(229, 'admin@jdsoft.in', '2017-04-06 10:45:00', 'akalpa@gmail.com', '$2a$10$DXMPBQPK3i0N2pgQaZxquuTMQ6cmTkzq20p6yZf1HchxyL2sT1xB2', '2017-04-24 15:00:59', 'admin@jdsoft.in', '2017-04-06 05:15:02', 'Akalpa Null', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(230, 'admin@jdsoft.in', '2017-04-06 11:43:01', 'jeeva@jdsoft.in', '$2a$10$rZXd5pklc/15sMjvonSEFOe5wvLOoO0f6OrNLoSFLl5WpXeEx9Zu2', NULL, 'admin@jdsoft.in', '2017-04-06 06:13:01', 'Jeeva Anand', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(231, 'admin@jdsoft.in', '2017-04-06 11:43:01', 'parent.jeeva@jdsoft.in', '$2a$10$fBAPAaK7ZzRqoy3red11d.8JpVoHZIlmGl41/aTAl8D/XcBqYx6Xm', NULL, 'admin@jdsoft.in', '2017-04-06 06:13:01', 'Fn Ln', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(232, 'admin@jdsoft.in', '2017-04-12 18:47:34', 'sdsdsd@gmail.om', '$2a$10$33ahZ1LRNBsTtMENZEbMFOZtAvvRW8oTCCKlyJN5PcVJ60o7ahkh2', NULL, 'admin@jdsoft.in', '2017-05-17 07:53:27', 'Fdf Sds', 'student', '/resources/themes/images/profile-pic/a.png', 1, 1),
(233, 'admin@jdsoft.in', '2017-04-12 18:47:34', 'dsd@gmail.com', '$2a$10$dbDSIy5X4KaCtdcXknPD5.DG3T2AiMY6uNeBY4vcEawEwqc5Nyqge', NULL, 'admin@jdsoft.in', '2017-05-17 07:53:27', 'Dsdsd Sdsd', 'parent', '/resources/themes/images/profile-pic/a.png', 1, 1),
(234, 'default', '2017-04-28 11:47:39', 'teststtest@gmail.com', '$2a$10$ol.BHorPSCkBcZlhxv/9buT/Qnj47zmjHvtZfVY8kfbVDQfw6KIPa', NULL, 'admin@jdsoft.in', '2017-04-28 06:21:11', 'Testing Test', 'admin', '/resources/themes/images/staff-profile/149336025935158fa9b267d17a8887e0552fa75c8251f.jpg', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user_and_role_mapping`
--

CREATE TABLE `tbl_user_and_role_mapping` (
  `user_id` bigint(20) NOT NULL,
  `user_role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user_and_role_mapping`
--

INSERT INTO `tbl_user_and_role_mapping` (`user_id`, `user_role_id`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 3),
(8, 4),
(9, 5),
(10, 4),
(11, 3),
(12, 4),
(13, 3),
(14, 4),
(15, 3),
(16, 4),
(17, 3),
(18, 4),
(19, 3),
(20, 4),
(21, 3),
(22, 4),
(23, 3),
(24, 4),
(25, 3),
(26, 4),
(27, 3),
(28, 4),
(29, 3),
(30, 4),
(31, 3),
(32, 4),
(33, 3),
(34, 4),
(35, 3),
(36, 4),
(37, 3),
(38, 4),
(39, 3),
(40, 4),
(41, 3),
(42, 4),
(43, 3),
(44, 4),
(45, 3),
(46, 4),
(47, 3),
(48, 4),
(49, 3),
(50, 4),
(51, 3),
(52, 4),
(53, 3),
(54, 4),
(55, 3),
(56, 4),
(57, 3),
(58, 4),
(59, 3),
(60, 4),
(61, 3),
(62, 4),
(63, 3),
(64, 4),
(65, 3),
(66, 4),
(67, 3),
(68, 4),
(69, 3),
(70, 4),
(71, 3),
(72, 4),
(73, 3),
(74, 4),
(75, 3),
(76, 4),
(77, 3),
(78, 4),
(79, 3),
(80, 4),
(81, 3),
(82, 4),
(83, 3),
(84, 4),
(85, 3),
(86, 4),
(87, 3),
(88, 4),
(89, 3),
(90, 4),
(91, 3),
(92, 4),
(93, 3),
(94, 4),
(95, 3),
(96, 4),
(97, 3),
(98, 4),
(99, 3),
(100, 4),
(101, 3),
(102, 4),
(103, 3),
(104, 4),
(105, 3),
(106, 4),
(107, 3),
(108, 4),
(109, 3),
(110, 4),
(111, 3),
(112, 4),
(113, 3),
(114, 4),
(115, 3),
(116, 4),
(117, 3),
(118, 4),
(119, 3),
(120, 4),
(121, 3),
(122, 4),
(123, 3),
(124, 4),
(125, 3),
(126, 4),
(127, 3),
(128, 4),
(129, 3),
(130, 4),
(131, 3),
(132, 4),
(133, 3),
(134, 4),
(135, 3),
(136, 4),
(137, 3),
(138, 4),
(139, 3),
(140, 4),
(141, 3),
(142, 4),
(143, 3),
(144, 4),
(145, 3),
(146, 4),
(147, 3),
(148, 4),
(149, 3),
(150, 4),
(151, 3),
(152, 4),
(153, 3),
(154, 4),
(155, 3),
(156, 4),
(157, 3),
(158, 4),
(159, 3),
(160, 4),
(161, 3),
(162, 4),
(163, 3),
(164, 4),
(165, 3),
(166, 4),
(167, 3),
(168, 4),
(169, 3),
(170, 4),
(171, 3),
(172, 4),
(173, 3),
(174, 4),
(175, 3),
(176, 4),
(177, 3),
(178, 4),
(179, 3),
(180, 4),
(181, 3),
(182, 4),
(183, 3),
(184, 4),
(185, 3),
(186, 4),
(187, 3),
(188, 4),
(189, 3),
(190, 4),
(191, 3),
(192, 4),
(193, 3),
(194, 4),
(195, 3),
(196, 4),
(197, 3),
(198, 4),
(199, 3),
(200, 4),
(201, 3),
(202, 4),
(203, 3),
(204, 4),
(205, 3),
(206, 4),
(207, 3),
(208, 4),
(209, 3),
(210, 4),
(211, 3),
(212, 4),
(213, 3),
(214, 4),
(215, 3),
(216, 4),
(217, 3),
(218, 4),
(219, 3),
(220, 4),
(221, 3),
(222, 4),
(223, 3),
(224, 4),
(225, 3),
(226, 4),
(227, 3),
(228, 4),
(229, 3),
(230, 3),
(231, 4),
(232, 3),
(233, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user_role`
--

CREATE TABLE `tbl_user_role` (
  `user_role_id` bigint(20) NOT NULL,
  `is_default` tinyint(1) NOT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `target_type` varchar(20) DEFAULT NULL,
  `institution_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user_role`
--

INSERT INTO `tbl_user_role` (`user_role_id`, `is_default`, `role_name`, `target_type`, `institution_id`) VALUES
(1, 1, 'Administrator', 'admin', 1),
(2, 1, 'Staff', 'staff', 1),
(3, 1, 'Student', 'student', 1),
(4, 1, 'Parent', 'parent', 1),
(5, 1, 'AdmissionCandidate', 'admissioncandidate', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_visitor_id_card_generation`
--

CREATE TABLE `tbl_visitor_id_card_generation` (
  `visitor_id_card_generation_id` bigint(20) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` date NOT NULL,
  `modified_by` varchar(100) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `qr_Code` varchar(255) NOT NULL,
  `qr_Image` varchar(255) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_visitor_id_card_generation`
--

INSERT INTO `tbl_visitor_id_card_generation` (`visitor_id_card_generation_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `qr_Code`, `qr_Image`, `institution_id`) VALUES
(1, 'admin@jdsoft.in', '2017-05-08', 'admin@jdsoft.in', '2017-05-08 05:46:10', 'Visitor1494222368313', '/resources/themes/images/visitor-QRcode-image/Anand1494222368483.jpg', 1),
(2, 'admin@jdsoft.in', '2017-05-08', 'admin@jdsoft.in', '2017-05-08 06:01:17', 'Visitor232768131494223276813', '/resources/themes/images/visitor-QRcode-image/Anand1494223276814.jpg', 1),
(3, 'admin@jdsoft.in', '2017-05-08', 'admin@jdsoft.in', '2017-05-08 06:43:01', 'Visitor1494225781216', '/resources/themes/images/visitor-QRcode-image/Jo Anand1494225781216.jpg', 1),
(4, 'admin@jdsoft.in', '2017-05-08', 'admin@jdsoft.in', '2017-05-08 12:46:18', 'Visitor1494247577618', '/resources/themes/images/visitor-QRcode-image/Kumar1494247577619.png', 1),
(5, 'admin@jdsoft.in', '2017-05-08', 'admin@jdsoft.in', '2017-05-08 12:49:09', 'Visitor1494247749773', '/resources/themes/images/visitor-QRcode-image/Jos1494247749773.jpg', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_visitor_management`
--

CREATE TABLE `tbl_visitor_management` (
  `visitor_management_id` bigint(20) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` date NOT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `visitor_check_in_time` time NOT NULL,
  `visitor_check_out_time` time NOT NULL,
  `visit_date` date NOT NULL,
  `visitor_email` varchar(255) NOT NULL,
  `visitor_mobile_number` varchar(255) NOT NULL,
  `visitor_name` varchar(255) NOT NULL,
  `visitor_purpose_of_visit` varchar(255) NOT NULL,
  `visitor_whom_to_meet` varchar(255) NOT NULL,
  `visitorIDCardGenerationId` bigint(20) DEFAULT NULL,
  `visitor_type_id` bigint(20) NOT NULL,
  `institution_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_visitor_management`
--

INSERT INTO `tbl_visitor_management` (`visitor_management_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `visitor_check_in_time`, `visitor_check_out_time`, `visit_date`, `visitor_email`, `visitor_mobile_number`, `visitor_name`, `visitor_purpose_of_visit`, `visitor_whom_to_meet`, `visitorIDCardGenerationId`, `visitor_type_id`, `institution_id`) VALUES
(1, 'admin@jdsoft.in', '2017-05-08', 'admin@jdsoft.in', '2017-05-08 05:46:11', '11:15:00', '11:15:00', '2017-05-08', 'anand@gmail.com', '1234567980', 'Anand', 'Nothing', 'Principal', 1, 1, 1),
(2, 'admin@jdsoft.in', '2017-05-08', 'admin@jdsoft.in', '2017-05-08 06:01:17', '11:30:00', '11:30:00', '2017-05-08', 'anand@gmail.com', '1234567980', 'Anand', 'Nothing', 'Principal', 2, 1, 1),
(3, 'admin@jdsoft.in', '2017-05-08', 'admin@jdsoft.in', '2017-05-08 06:43:01', '12:12:00', '12:12:00', '2017-05-08', 'anand@gmail.com', '1234567980', 'Jo Anand', 'Nothing', 'Principal', 3, 1, 1),
(4, 'admin@jdsoft.in', '2017-05-08', 'admin@jdsoft.in', '2017-05-08 12:46:18', '21:15:00', '07:15:00', '2017-05-09', 'kumar@gmail.com', '789654123014444', 'Kumar', 'Nothing', 'Head Of Department', 4, 2, 1),
(5, 'admin@jdsoft.in', '2017-05-08', 'admin@jdsoft.in', '2017-05-08 12:49:09', '18:18:00', '21:18:00', '2017-05-08', 'jos@gmail.com', '3654129870', 'Jos', 'Nothing', 'Head Of Department', 5, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_visitor_type`
--

CREATE TABLE `tbl_visitor_type` (
  `visitor_type_id` bigint(20) NOT NULL,
  `visitor_type` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_visitor_type`
--

INSERT INTO `tbl_visitor_type` (`visitor_type_id`, `visitor_type`) VALUES
(1, 'Student'),
(2, 'Parent'),
(3, 'Official'),
(4, 'Other');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_academic_year`
--
ALTER TABLE `tbl_academic_year`
  ADD PRIMARY KEY (`academic_year_id`),
  ADD UNIQUE KEY `academic_year_title` (`academic_year_title`,`institution_id`),
  ADD KEY `institutionInAcademicYears` (`institution_id`);

--
-- Indexes for table `tbl_academic_year_fees_term`
--
ALTER TABLE `tbl_academic_year_fees_term`
  ADD PRIMARY KEY (`academic_year_fees_term_id`),
  ADD UNIQUE KEY `academic_year_id` (`academic_year_id`,`fees_term_title`),
  ADD KEY `academicYearFeesTermsInAcademicYear` (`academic_year_id`);

--
-- Indexes for table `tbl_admission`
--
ALTER TABLE `tbl_admission`
  ADD PRIMARY KEY (`admission_id`),
  ADD KEY `FK7EBEBCC8E2C302F2` (`admission_config_id`),
  ADD KEY `FK7EBEBCC8B2DF84F2` (`admission_status_id`),
  ADD KEY `FK7EBEBCC880BCF0D5` (`category_id`),
  ADD KEY `admissionInClass` (`class_id`),
  ADD KEY `FK7EBEBCC86AB0A2C4` (`education_level_id`),
  ADD KEY `FK7EBEBCC8BE93D9D5` (`hearedus_id`),
  ADD KEY `FK7EBEBCC8DA9A1FF5` (`religion_id`),
  ADD KEY `FK7EBEBCC864229212` (`special_category_id`),
  ADD KEY `FK7EBEBCC8515C07FF` (`sponser_id`),
  ADD KEY `FK7EBEBCC82D1F8735` (`user_id`);

--
-- Indexes for table `tbl_admission_config`
--
ALTER TABLE `tbl_admission_config`
  ADD PRIMARY KEY (`admission_config_id`),
  ADD UNIQUE KEY `admission_config_id` (`admission_config_id`),
  ADD UNIQUE KEY `admission_application_code_format` (`admission_application_code_format`),
  ADD KEY `FKE510529920743655` (`admission_process_status_id`);

--
-- Indexes for table `tbl_admission_config_class`
--
ALTER TABLE `tbl_admission_config_class`
  ADD PRIMARY KEY (`admission_config_id`,`class_id`),
  ADD KEY `classInAdmissionConfig` (`class_id`),
  ADD KEY `admissionConfigInClass` (`admission_config_id`);

--
-- Indexes for table `tbl_admission_document`
--
ALTER TABLE `tbl_admission_document`
  ADD PRIMARY KEY (`admission_document_id`),
  ADD UNIQUE KEY `admission_document_id` (`admission_document_id`),
  ADD KEY `FK383726B22FCDFC9F` (`admission_id`),
  ADD KEY `FK383726B271CBB5C2` (`admission_document_type_id`);

--
-- Indexes for table `tbl_admission_document_types`
--
ALTER TABLE `tbl_admission_document_types`
  ADD PRIMARY KEY (`admission_document_type_id`),
  ADD UNIQUE KEY `admission_document_type_id` (`admission_document_type_id`),
  ADD UNIQUE KEY `admission_document_type_title` (`admission_document_type_title`),
  ADD UNIQUE KEY `admission_document_type_title_2` (`admission_document_type_title`);

--
-- Indexes for table `tbl_admission_education_level_detail`
--
ALTER TABLE `tbl_admission_education_level_detail`
  ADD PRIMARY KEY (`admission_education_level_id`),
  ADD UNIQUE KEY `admission_education_level_id` (`admission_education_level_id`),
  ADD UNIQUE KEY `admission_id` (`admission_id`,`degree_name`),
  ADD KEY `FKC6C31FA2FCDFC9F` (`admission_id`),
  ADD KEY `FKC6C31FA6AB0A2C4` (`education_level_id`);

--
-- Indexes for table `tbl_admission_education_level_subject`
--
ALTER TABLE `tbl_admission_education_level_subject`
  ADD PRIMARY KEY (`admission_education_level_subject_id`),
  ADD KEY `FKB4EB70A32FCDFC9F` (`admission_id`),
  ADD KEY `FKB4EB70A37DCCF15B` (`admission_education_level_id`);

--
-- Indexes for table `tbl_admission_fees_payment_details`
--
ALTER TABLE `tbl_admission_fees_payment_details`
  ADD PRIMARY KEY (`fees_payment_id`),
  ADD UNIQUE KEY `admission_id` (`admission_id`,`transaction_code`),
  ADD KEY `FK61CB518E2FCDFC9F` (`admission_id`);

--
-- Indexes for table `tbl_admission_process_status`
--
ALTER TABLE `tbl_admission_process_status`
  ADD PRIMARY KEY (`admission_process_status_id`),
  ADD UNIQUE KEY `admission_process_status_id` (`admission_process_status_id`),
  ADD UNIQUE KEY `admission_process_status_title` (`admission_process_status_title`),
  ADD UNIQUE KEY `admission_process_status_title_2` (`admission_process_status_title`);

--
-- Indexes for table `tbl_admission_status`
--
ALTER TABLE `tbl_admission_status`
  ADD PRIMARY KEY (`admission_status_id`),
  ADD UNIQUE KEY `admission_status_id` (`admission_status_id`),
  ADD UNIQUE KEY `admission_status_title` (`admission_status_title`),
  ADD UNIQUE KEY `admission_status_title_2` (`admission_status_title`);

--
-- Indexes for table `tbl_assesment_type`
--
ALTER TABLE `tbl_assesment_type`
  ADD PRIMARY KEY (`assesment_type_id`),
  ADD UNIQUE KEY `assesment_type_name` (`assesment_type_name`),
  ADD UNIQUE KEY `assesment_type_code` (`assesment_type_code`);

--
-- Indexes for table `tbl_blood_group`
--
ALTER TABLE `tbl_blood_group`
  ADD PRIMARY KEY (`blood_group_id`),
  ADD UNIQUE KEY `blood_group_id` (`blood_group_id`),
  ADD UNIQUE KEY `blood_group_name` (`blood_group_name`);

--
-- Indexes for table `tbl_category`
--
ALTER TABLE `tbl_category`
  ADD PRIMARY KEY (`category_id`),
  ADD UNIQUE KEY `category_id` (`category_id`),
  ADD UNIQUE KEY `category_name` (`category_name`),
  ADD UNIQUE KEY `category_name_2` (`category_name`);

--
-- Indexes for table `tbl_class`
--
ALTER TABLE `tbl_class`
  ADD PRIMARY KEY (`class_id`),
  ADD UNIQUE KEY `class_name` (`class_name`,`institution_id`),
  ADD KEY `institutionInClasses` (`institution_id`);

--
-- Indexes for table `tbl_class_section`
--
ALTER TABLE `tbl_class_section`
  ADD PRIMARY KEY (`class_section_id`),
  ADD UNIQUE KEY `class_id` (`class_id`,`section_id`),
  ADD KEY `FKE0AE045DAEF35CBF` (`class_id`),
  ADD KEY `FKE0AE045D2D515C5F` (`section_id`),
  ADD KEY `FKE0AE045DD46003BF` (`staff_id`);

--
-- Indexes for table `tbl_class_section_assesment_type`
--
ALTER TABLE `tbl_class_section_assesment_type`
  ADD PRIMARY KEY (`class_section_assesment_type_id`),
  ADD UNIQUE KEY `class_section_id` (`class_section_id`,`class_section_assesment_name`),
  ADD KEY `classSectionAssessmentTypeInClassSection` (`class_section_id`),
  ADD KEY `classSectionAssesmentTypeInGradeSystem` (`grade_system_id`);

--
-- Indexes for table `tbl_class_section_coscholastic_activity`
--
ALTER TABLE `tbl_class_section_coscholastic_activity`
  ADD PRIMARY KEY (`class_section_coscholastic_activity_id`),
  ADD UNIQUE KEY `class_section_id` (`class_section_id`,`co_scholastic_activity_id`),
  ADD KEY `classSectionCoScholasticActivityInClassSection` (`class_section_id`),
  ADD KEY `classSectionCoScholasticActivityInCoScholasticActivity` (`co_scholastic_activity_id`);

--
-- Indexes for table `tbl_class_section_coscholastic_activity_exam`
--
ALTER TABLE `tbl_class_section_coscholastic_activity_exam`
  ADD PRIMARY KEY (`class_section_coscholastic_activity_exam_id`),
  ADD UNIQUE KEY `class_section_coscholastic_activity_id` (`class_section_coscholastic_activity_id`,`class_section_term_id`,`class_section_term_exam_id`),
  ADD KEY `classSSectionCoScholasticActivityExamInClassSectionTerm` (`class_section_term_id`),
  ADD KEY `classSectionCoScholasticActivityExamInClassSectionTermExam` (`class_section_term_exam_id`);

--
-- Indexes for table `tbl_class_section_coscholastic_area`
--
ALTER TABLE `tbl_class_section_coscholastic_area`
  ADD PRIMARY KEY (`class_section_coscholastic_area_id`),
  ADD UNIQUE KEY `class_section_id` (`class_section_id`,`co_scholastic_area_id`),
  ADD KEY `classSectionCoScholasticAreaInClassSection` (`class_section_id`),
  ADD KEY `classSectionCoScholasticAreaInCoScholasticArea` (`co_scholastic_area_id`);

--
-- Indexes for table `tbl_class_section_coscholastic_area_exam`
--
ALTER TABLE `tbl_class_section_coscholastic_area_exam`
  ADD PRIMARY KEY (`class_section_coscholastic_area_exam_id`),
  ADD UNIQUE KEY `class_section_coscholastic_area_id` (`class_section_coscholastic_area_id`,`class_section_term_id`,`class_section_term_exam_id`),
  ADD KEY `classSectionCoScholasticAreaExamInClassSectionCoScholasticArea` (`class_section_coscholastic_area_id`),
  ADD KEY `classSSectionCoScholasticAreaExamInClassSectionTerm` (`class_section_term_id`),
  ADD KEY `classSectionCoScholasticAreaExamInClassSectionTermExam` (`class_section_term_exam_id`);

--
-- Indexes for table `tbl_class_section_module`
--
ALTER TABLE `tbl_class_section_module`
  ADD PRIMARY KEY (`class_section_module_id`),
  ADD UNIQUE KEY `class_section_id` (`class_section_id`,`module_id`),
  ADD KEY `classSectionModuleInClassSection` (`class_section_id`),
  ADD KEY `classSectionModuleInModule` (`module_id`);

--
-- Indexes for table `tbl_class_section_module_exam`
--
ALTER TABLE `tbl_class_section_module_exam`
  ADD PRIMARY KEY (`class_section_module_exam_id`),
  ADD UNIQUE KEY `class_section_term_id` (`class_section_term_id`,`class_section_term_exam_id`,`class_section_module_id`),
  ADD KEY `classSectionModuleExamInClassSectionModule` (`class_section_module_id`),
  ADD KEY `classSectionModuleExamInClassSectionTerm` (`class_section_term_id`),
  ADD KEY `classSectionModuleExamInClassSectionTermExam` (`class_section_term_exam_id`);

--
-- Indexes for table `tbl_class_section_module_skill`
--
ALTER TABLE `tbl_class_section_module_skill`
  ADD PRIMARY KEY (`class_section_module_skill_id`),
  ADD UNIQUE KEY `class_section_module_id` (`class_section_module_id`,`module_skill_id`),
  ADD KEY `classSectionModuleSkillInClassSectionModule` (`class_section_module_id`),
  ADD KEY `classSectionModuleSkillInModuleSkill` (`module_skill_id`);

--
-- Indexes for table `tbl_class_section_module_skill_exam`
--
ALTER TABLE `tbl_class_section_module_skill_exam`
  ADD PRIMARY KEY (`class_section_module_skill_exam_id`),
  ADD UNIQUE KEY `class_section_term_id` (`class_section_term_id`,`class_section_term_exam_id`,`class_section_module_skill_id`),
  ADD KEY `classSectionModuleSkillExamInClassSectionModuleSkill` (`class_section_module_skill_id`),
  ADD KEY `classSectionTermInClassSectionModuleSkillExam` (`class_section_term_id`),
  ADD KEY `classSectionTermExamInClassSectionModuleSkillExam` (`class_section_term_exam_id`);

--
-- Indexes for table `tbl_class_section_module_staff`
--
ALTER TABLE `tbl_class_section_module_staff`
  ADD PRIMARY KEY (`class_section_module_staff_id`),
  ADD UNIQUE KEY `class_section_module_id` (`class_section_module_id`,`staff_id`,`academic_year_id`),
  ADD KEY `academicYearInClassSectionModuleStaff` (`academic_year_id`),
  ADD KEY `classSectionModuleInClassSectionModuleStaff` (`class_section_module_id`),
  ADD KEY `classSectionModuleStaffsInStaff` (`staff_id`);

--
-- Indexes for table `tbl_class_section_term`
--
ALTER TABLE `tbl_class_section_term`
  ADD PRIMARY KEY (`class_section_term_id`),
  ADD UNIQUE KEY `class_section_id` (`class_section_id`,`term_name`),
  ADD KEY `classSectionTermInClassSection` (`class_section_id`);

--
-- Indexes for table `tbl_class_section_term_exam`
--
ALTER TABLE `tbl_class_section_term_exam`
  ADD PRIMARY KEY (`class_section_term_exam_id`),
  ADD UNIQUE KEY `class_section_term_id` (`class_section_term_id`,`term_exam_name`),
  ADD KEY `classSectionTermExamInClassSectionTerm` (`class_section_term_id`);

--
-- Indexes for table `tbl_class_section_term_exam_activity`
--
ALTER TABLE `tbl_class_section_term_exam_activity`
  ADD PRIMARY KEY (`class_section_term_exam_activity_id`),
  ADD UNIQUE KEY `class_section_term_exam_id` (`class_section_term_exam_id`,`term_exam_activity_name`),
  ADD KEY `classSectionTermExamActivityInClassSectionTermExam` (`class_section_term_exam_id`);

--
-- Indexes for table `tbl_communication_feedback_and_others`
--
ALTER TABLE `tbl_communication_feedback_and_others`
  ADD PRIMARY KEY (`communication_feedback_and_others_id`),
  ADD UNIQUE KEY `communication_feedback_and_others_id` (`communication_feedback_and_others_id`),
  ADD KEY `communicationMessageModeInCommunicationFeedBackAndOthers` (`communication_message_mode_id`),
  ADD KEY `communicationTargetGroupInCommunicationFeedBackAndOthers` (`communication_target_group_id`),
  ADD KEY `communicationFeedBackAndOthersInInstitution` (`institution_id`),
  ADD KEY `communicationFeedBackAndOthersInPotalMessage` (`portal_message_id`);

--
-- Indexes for table `tbl_communication_feedback_and_others_archive`
--
ALTER TABLE `tbl_communication_feedback_and_others_archive`
  ADD PRIMARY KEY (`communication_feedback_and_others_archive_id`),
  ADD UNIQUE KEY `communication_feedback_and_others_archive_id` (`communication_feedback_and_others_archive_id`),
  ADD KEY `communicationNotificationArchiveInCommunicationFeedBackAndOthers` (`communication_feedback_and_others_id`),
  ADD KEY `communicationMessageModeInCommunicationFeedBackAndOthersArchives` (`communication_message_mode_id`),
  ADD KEY `communicationTargetGroupInCommunicationFeedBackAndOthersArchives` (`communication_target_group_id`),
  ADD KEY `communicationFeedBackAndOthersArchivesInInstitution` (`institution_id`);

--
-- Indexes for table `tbl_communication_feedback_and_others_archive_users`
--
ALTER TABLE `tbl_communication_feedback_and_others_archive_users`
  ADD PRIMARY KEY (`communication_feedback_and_others_archive_id`,`target_user_id`),
  ADD KEY `userInCommunicationFeedBackAndOthersArchives` (`target_user_id`),
  ADD KEY `communicationFeedBackAndOthersArchiveInUser` (`communication_feedback_and_others_archive_id`);

--
-- Indexes for table `tbl_communication_feedback_and_others_history`
--
ALTER TABLE `tbl_communication_feedback_and_others_history`
  ADD PRIMARY KEY (`communication_feedback_and_others_history_id`),
  ADD UNIQUE KEY `communication_feedback_and_others_history_id` (`communication_feedback_and_others_history_id`),
  ADD KEY `communicationFeedBackAndOthersHistoryInPotalMessage` (`portal_reply_message_id`),
  ADD KEY `userInCommunicationFeedBackAndOthersHistory` (`target_user_id`);

--
-- Indexes for table `tbl_communication_feedback_and_others_users`
--
ALTER TABLE `tbl_communication_feedback_and_others_users`
  ADD PRIMARY KEY (`communication_feedback_and_others_id`,`target_user_id`),
  ADD KEY `userInCommunicationFeedBackAndOthers` (`target_user_id`),
  ADD KEY `communicationFeedBackAndOthersInUser` (`communication_feedback_and_others_id`);

--
-- Indexes for table `tbl_communication_message_mode`
--
ALTER TABLE `tbl_communication_message_mode`
  ADD PRIMARY KEY (`communication_message_mode_id`),
  ADD UNIQUE KEY `communication_message_mode_id` (`communication_message_mode_id`),
  ADD UNIQUE KEY `communication_message_mode_title` (`communication_message_mode_title`);

--
-- Indexes for table `tbl_communication_notification`
--
ALTER TABLE `tbl_communication_notification`
  ADD PRIMARY KEY (`communication_notification_id`),
  ADD UNIQUE KEY `communication_notification_id` (`communication_notification_id`),
  ADD KEY `communicationMessageModeInCommunicationNotifications` (`communication_message_mode_id`),
  ADD KEY `communicationTargetGroupInCommunicationNotifications` (`communication_target_group_id`),
  ADD KEY `communicationNotificationsInInstitution` (`institution_id`),
  ADD KEY `communicationNotificationInPotalNotification` (`portal_notification_id`);

--
-- Indexes for table `tbl_communication_notification_archive`
--
ALTER TABLE `tbl_communication_notification_archive`
  ADD PRIMARY KEY (`communication_notification_archive_id`),
  ADD UNIQUE KEY `communication_notification_archive_id` (`communication_notification_archive_id`),
  ADD KEY `communicationMessageModeInCommunicationNotificationArchives` (`communication_message_mode_id`),
  ADD KEY `communicationNotificationArchiveInCommunicationNotification` (`communication_notification_id`),
  ADD KEY `communicationTargetGroupInCommunicationNotificationArchives` (`communication_target_group_id`),
  ADD KEY `communicationNotificationArchivesInInstitution` (`institution_id`);

--
-- Indexes for table `tbl_communication_notification_archive_users`
--
ALTER TABLE `tbl_communication_notification_archive_users`
  ADD PRIMARY KEY (`communication_notification_archive_id`,`target_user_id`),
  ADD KEY `userInCommunicationNotificationArchives` (`target_user_id`),
  ADD KEY `communicationNotificationArchiveInUser` (`communication_notification_archive_id`);

--
-- Indexes for table `tbl_communication_notification_users`
--
ALTER TABLE `tbl_communication_notification_users`
  ADD PRIMARY KEY (`communication_notification_id`,`target_user_id`),
  ADD KEY `userInCommunicationNotifications` (`target_user_id`),
  ADD KEY `communicationNotificationsInUser` (`communication_notification_id`);

--
-- Indexes for table `tbl_communication_target_group`
--
ALTER TABLE `tbl_communication_target_group`
  ADD PRIMARY KEY (`communication_target_group_id`),
  ADD UNIQUE KEY `communication_target_group_id` (`communication_target_group_id`),
  ADD UNIQUE KEY `communication_target_group_title` (`communication_target_group_title`);

--
-- Indexes for table `tbl_co_scholastic_activity`
--
ALTER TABLE `tbl_co_scholastic_activity`
  ADD PRIMARY KEY (`co_scholastic_activity_id`),
  ADD UNIQUE KEY `co_scholastic_activity_name` (`co_scholastic_activity_name`);

--
-- Indexes for table `tbl_co_scholastic_activity_indicator`
--
ALTER TABLE `tbl_co_scholastic_activity_indicator`
  ADD PRIMARY KEY (`co_scholastic_activity_indicator_id`),
  ADD UNIQUE KEY `co_scholastic_activity_indicator_name` (`co_scholastic_activity_indicator_name`,`co_scholastic_activity_id`),
  ADD KEY `coScholasticActivityIndicatorInCoScholasticActivity` (`co_scholastic_activity_id`);

--
-- Indexes for table `tbl_co_scholastic_area`
--
ALTER TABLE `tbl_co_scholastic_area`
  ADD PRIMARY KEY (`co_scholastic_area_id`),
  ADD UNIQUE KEY `co_scholastic_area_name` (`co_scholastic_area_name`);

--
-- Indexes for table `tbl_co_scholastic_area_indicator`
--
ALTER TABLE `tbl_co_scholastic_area_indicator`
  ADD PRIMARY KEY (`co_scholastic_area_indicator_id`),
  ADD UNIQUE KEY `co_scholastic_area_indicator_name` (`co_scholastic_area_indicator_name`,`co_scholastic_area_id`),
  ADD KEY `coScholasticAreaInCoScholasticAreaIndicator` (`co_scholastic_area_id`);

--
-- Indexes for table `tbl_currency`
--
ALTER TABLE `tbl_currency`
  ADD PRIMARY KEY (`iso`),
  ADD UNIQUE KEY `iso` (`iso`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `tbl_education_level`
--
ALTER TABLE `tbl_education_level`
  ADD PRIMARY KEY (`education_level_id`),
  ADD UNIQUE KEY `education_level_title` (`education_level_title`);

--
-- Indexes for table `tbl_education_level_subject`
--
ALTER TABLE `tbl_education_level_subject`
  ADD PRIMARY KEY (`education_level_subject_id`),
  ADD UNIQUE KEY `education_level_id` (`education_level_id`,`education_level_subject_title`),
  ADD KEY `FKC43271996AB0A2C4` (`education_level_id`);

--
-- Indexes for table `tbl_exam_template`
--
ALTER TABLE `tbl_exam_template`
  ADD PRIMARY KEY (`exam_template_id`),
  ADD UNIQUE KEY `exam_template_name` (`exam_template_name`),
  ADD KEY `examTemplateInInstitution` (`institution_id`);

--
-- Indexes for table `tbl_fees_item`
--
ALTER TABLE `tbl_fees_item`
  ADD PRIMARY KEY (`fees_item_id`),
  ADD UNIQUE KEY `fees_item_name` (`fees_item_name`,`institution_id`),
  ADD KEY `institutionInFeesItems` (`institution_id`),
  ADD KEY `ledgerAccountInFeesItems` (`ledger_account_id`);

--
-- Indexes for table `tbl_fees_structure`
--
ALTER TABLE `tbl_fees_structure`
  ADD PRIMARY KEY (`fees_structure_id`),
  ADD UNIQUE KEY `fees_structure_name` (`fees_structure_name`,`institution_id`),
  ADD KEY `institutionInFeesStructures` (`institution_id`);

--
-- Indexes for table `tbl_fees_structure_mapping`
--
ALTER TABLE `tbl_fees_structure_mapping`
  ADD PRIMARY KEY (`fees_structure_id`,`fees_item_id`),
  ADD KEY `feesItemsInFeesStructuress` (`fees_item_id`),
  ADD KEY `feesStructuresInFeesItems` (`fees_structure_id`);

--
-- Indexes for table `tbl_fees_term`
--
ALTER TABLE `tbl_fees_term`
  ADD PRIMARY KEY (`fees_term_id`),
  ADD UNIQUE KEY `institution_id` (`institution_id`,`fees_term_name`),
  ADD KEY `institutionInFessTerms` (`institution_id`);

--
-- Indexes for table `tbl_geographical_location`
--
ALTER TABLE `tbl_geographical_location`
  ADD PRIMARY KEY (`location_id`),
  ADD UNIQUE KEY `location_id` (`location_id`);

--
-- Indexes for table `tbl_grade_system`
--
ALTER TABLE `tbl_grade_system`
  ADD PRIMARY KEY (`grade_system_id`),
  ADD UNIQUE KEY `grade_system_name` (`grade_system_name`,`institution_id`),
  ADD KEY `gradeSystemInInstitution` (`institution_id`);

--
-- Indexes for table `tbl_grade_system_detail`
--
ALTER TABLE `tbl_grade_system_detail`
  ADD PRIMARY KEY (`grade_system_detail_id`),
  ADD UNIQUE KEY `grade_title` (`grade_title`,`grade_system_id`),
  ADD KEY `gradeSystemDetailInGradeSystem` (`grade_system_id`);

--
-- Indexes for table `tbl_heared_us`
--
ALTER TABLE `tbl_heared_us`
  ADD PRIMARY KEY (`hearedus_id`),
  ADD UNIQUE KEY `hearedus_id` (`hearedus_id`),
  ADD UNIQUE KEY `hearedus_title` (`hearedus_title`),
  ADD UNIQUE KEY `hearedus_title_2` (`hearedus_title`);

--
-- Indexes for table `tbl_houses`
--
ALTER TABLE `tbl_houses`
  ADD PRIMARY KEY (`house_id`),
  ADD UNIQUE KEY `house_id` (`house_id`),
  ADD UNIQUE KEY `house_name` (`house_name`),
  ADD UNIQUE KEY `institution_id` (`institution_id`,`house_name`),
  ADD KEY `housesInInstitution` (`institution_id`);

--
-- Indexes for table `tbl_institution`
--
ALTER TABLE `tbl_institution`
  ADD PRIMARY KEY (`institution_id`),
  ADD UNIQUE KEY `institution_id` (`institution_id`),
  ADD UNIQUE KEY `institution_name` (`institution_name`,`institution_alias_name`);

--
-- Indexes for table `tbl_institution_ledger_account`
--
ALTER TABLE `tbl_institution_ledger_account`
  ADD PRIMARY KEY (`ledger_account_id`),
  ADD UNIQUE KEY `ledger_account_name` (`ledger_account_name`,`institution_id`),
  ADD UNIQUE KEY `ledger_reference_number` (`ledger_reference_number`,`institution_id`),
  ADD KEY `institutionInInstituteLedgerAccounts` (`institution_id`);

--
-- Indexes for table `tbl_inventory_category`
--
ALTER TABLE `tbl_inventory_category`
  ADD PRIMARY KEY (`inventory_category_id`),
  ADD UNIQUE KEY `inventory_category_id` (`inventory_category_id`);

--
-- Indexes for table `tbl_inventory_item_master`
--
ALTER TABLE `tbl_inventory_item_master`
  ADD PRIMARY KEY (`item_id`),
  ADD UNIQUE KEY `item_id` (`item_id`),
  ADD UNIQUE KEY `item_code` (`item_code`),
  ADD KEY `FK822F6CEA53282F04` (`in_charge_user_id`),
  ADD KEY `FK822F6CEAB5443698` (`inventory_category_id`),
  ADD KEY `FK822F6CEA4249BC18` (`inventory_type_id`),
  ADD KEY `FK822F6CEA597F6C97` (`issue_to_user_id`),
  ADD KEY `FK822F6CEAA83D2BBE` (`tax_class_id`);

--
-- Indexes for table `tbl_inventory_purchase_order`
--
ALTER TABLE `tbl_inventory_purchase_order`
  ADD PRIMARY KEY (`purchase_order_id`),
  ADD UNIQUE KEY `purchase_order_id` (`purchase_order_id`),
  ADD UNIQUE KEY `purchase_order_no` (`purchase_order_no`),
  ADD KEY `academicYearInInventoryPurchaseOrder` (`academic_year_id`),
  ADD KEY `institutionInInventoryPurchaseOrder` (`institution_id`),
  ADD KEY `FK64F3C1342489205F` (`inventoryReceipt_inventory_receipt_id`),
  ADD KEY `supplierMasterInInventoryPurchaseOrder` (`supplier_id`);

--
-- Indexes for table `tbl_inventory_purchase_order_details`
--
ALTER TABLE `tbl_inventory_purchase_order_details`
  ADD PRIMARY KEY (`purchase_order_detail_id`),
  ADD KEY `inventoryItemMasterInInventoryPurchaseOrderDetails` (`inventory_item_master_id`),
  ADD KEY `inventoryPurchaseOrderInInventoryPurchaseOrderDetails` (`purchase_order_id`);

--
-- Indexes for table `tbl_inventory_receipt`
--
ALTER TABLE `tbl_inventory_receipt`
  ADD PRIMARY KEY (`inventory_receipt_id`),
  ADD UNIQUE KEY `inventory_receipt_id` (`inventory_receipt_id`),
  ADD KEY `academicYearInInventoryReceipt` (`academic_year_id`),
  ADD KEY `InventoryItemMasterInInventoryReceipts` (`inventory_master_id`),
  ADD KEY `inventoryReceiptInInventoryPurchaseOrder` (`inventory_purchase_order_id`),
  ADD KEY `paymentModeInInventoryReceipts` (`payment_mode_id`),
  ADD KEY `supplierMasterInInventoryReceipt` (`supplier_id`),
  ADD KEY `inventoryReceiptsInTaxClass` (`tax_id`);

--
-- Indexes for table `tbl_inventory_requisition`
--
ALTER TABLE `tbl_inventory_requisition`
  ADD PRIMARY KEY (`inventory_requisition_id`),
  ADD KEY `FKBBD71C78E42698FA` (`inventory_item_id`),
  ADD KEY `FKBBD71C7867F3C8C2` (`inventory_requistion_approver_user_id`),
  ADD KEY `FKBBD71C78BD772A4E` (`inventory_requistion_user_id`),
  ADD KEY `inventoryRequisitonInPotalTask` (`portal_task_id`);

--
-- Indexes for table `tbl_inventory_type`
--
ALTER TABLE `tbl_inventory_type`
  ADD PRIMARY KEY (`inventory_type_id`),
  ADD UNIQUE KEY `inventory_type_id` (`inventory_type_id`),
  ADD UNIQUE KEY `inventory_type` (`inventory_type`);

--
-- Indexes for table `tbl_license`
--
ALTER TABLE `tbl_license`
  ADD PRIMARY KEY (`license_id`);

--
-- Indexes for table `tbl_module`
--
ALTER TABLE `tbl_module`
  ADD PRIMARY KEY (`module_id`),
  ADD UNIQUE KEY `module_code` (`module_code`,`institution_id`),
  ADD UNIQUE KEY `module_name` (`module_name`,`institution_id`),
  ADD KEY `institutionInModules` (`institution_id`);

--
-- Indexes for table `tbl_module_plan`
--
ALTER TABLE `tbl_module_plan`
  ADD PRIMARY KEY (`module_plan_id`),
  ADD UNIQUE KEY `module_plan_id` (`module_plan_id`),
  ADD KEY `FK614D321BE4C08CD5` (`module_id`);

--
-- Indexes for table `tbl_module_plan_schedule`
--
ALTER TABLE `tbl_module_plan_schedule`
  ADD PRIMARY KEY (`module_plan_schedule_id`),
  ADD UNIQUE KEY `module_plan_schedule_id` (`module_plan_schedule_id`),
  ADD KEY `FKBCF5C03B513357EE` (`module_plan_id`);

--
-- Indexes for table `tbl_module_skill`
--
ALTER TABLE `tbl_module_skill`
  ADD PRIMARY KEY (`module_skill_id`),
  ADD UNIQUE KEY `module_skill_name` (`module_skill_name`);

--
-- Indexes for table `tbl_module_skill_indicator`
--
ALTER TABLE `tbl_module_skill_indicator`
  ADD PRIMARY KEY (`module_skill_indicator_id`),
  ADD UNIQUE KEY `module_skill_id` (`module_skill_id`,`module_skill_indicator_name`),
  ADD KEY `moduleSkillIndicatorInModuleSkill` (`module_skill_id`);

--
-- Indexes for table `tbl_moment_requisition`
--
ALTER TABLE `tbl_moment_requisition`
  ADD PRIMARY KEY (`moment_requisition_id`),
  ADD KEY `academicYearInMomentRequisition` (`academic_year_id`),
  ADD KEY `institutionInMomentRequisition` (`institution_id`),
  ADD KEY `userInMomentRequisition` (`tc_approver_id`),
  ADD KEY `FKF4972FECCFD1D58` (`requisition_type_id`),
  ADD KEY `sectionInMomentRequisition` (`section_id`),
  ADD KEY `studentInMomentRequisition` (`student_id`),
  ADD KEY `classInMomentRequisition` (`class_id`),
  ADD KEY `momentRequisitonInPotalTask` (`portal_task_id`);

--
-- Indexes for table `tbl_payment_mode`
--
ALTER TABLE `tbl_payment_mode`
  ADD PRIMARY KEY (`payment_mode_id`);

--
-- Indexes for table `tbl_payment_mode_and_payment_status_mapping`
--
ALTER TABLE `tbl_payment_mode_and_payment_status_mapping`
  ADD PRIMARY KEY (`payment_mode_id`,`payment_status_id`),
  ADD KEY `paymentStatusesInPaymentModes` (`payment_status_id`),
  ADD KEY `paymentModesInPaymentStatuses` (`payment_mode_id`);

--
-- Indexes for table `tbl_payment_status`
--
ALTER TABLE `tbl_payment_status`
  ADD PRIMARY KEY (`payment_status_id`);

--
-- Indexes for table `tbl_portal_message`
--
ALTER TABLE `tbl_portal_message`
  ADD PRIMARY KEY (`portal_message_id`),
  ADD KEY `poratlMessagesInInstitution` (`institution_id`);

--
-- Indexes for table `tbl_portal_message_users`
--
ALTER TABLE `tbl_portal_message_users`
  ADD PRIMARY KEY (`portal_message_id`,`target_user_id`),
  ADD KEY `userInPortalMessages` (`target_user_id`),
  ADD KEY `PortalMessageInUser` (`portal_message_id`);

--
-- Indexes for table `tbl_portal_notification`
--
ALTER TABLE `tbl_portal_notification`
  ADD PRIMARY KEY (`portal_notification_id`),
  ADD KEY `poratlNotificationsInInstitution` (`institution_id`);

--
-- Indexes for table `tbl_portal_notification_users`
--
ALTER TABLE `tbl_portal_notification_users`
  ADD PRIMARY KEY (`portal_notification_id`,`target_user_id`),
  ADD KEY `userInPortalNotifications` (`target_user_id`),
  ADD KEY `PortalNotificationInUser` (`portal_notification_id`);

--
-- Indexes for table `tbl_portal_reply_message`
--
ALTER TABLE `tbl_portal_reply_message`
  ADD PRIMARY KEY (`portal_reply_message_id`),
  ADD KEY `portalReplyMessagesInInstitution` (`institution_id`);

--
-- Indexes for table `tbl_portal_reply_message_users`
--
ALTER TABLE `tbl_portal_reply_message_users`
  ADD PRIMARY KEY (`portal_message_id`,`target_user_id`),
  ADD KEY `userInPortalReplyMessages` (`target_user_id`),
  ADD KEY `portalReplyMessageInUser` (`portal_message_id`);

--
-- Indexes for table `tbl_portal_task`
--
ALTER TABLE `tbl_portal_task`
  ADD PRIMARY KEY (`portal_task_id`),
  ADD KEY `portalTasksInInstitution` (`institution_id`);

--
-- Indexes for table `tbl_portal_task_users`
--
ALTER TABLE `tbl_portal_task_users`
  ADD PRIMARY KEY (`portal_task_id`,`target_user_id`),
  ADD KEY `userInPortalTasks` (`target_user_id`),
  ADD KEY `PortalTaskInUser` (`portal_task_id`);

--
-- Indexes for table `tbl_privilege`
--
ALTER TABLE `tbl_privilege`
  ADD PRIMARY KEY (`privilege_id`),
  ADD UNIQUE KEY `privilege_name` (`privilege_name`);

--
-- Indexes for table `tbl_purchase_requisition`
--
ALTER TABLE `tbl_purchase_requisition`
  ADD PRIMARY KEY (`purchase_requisition_id`),
  ADD UNIQUE KEY `purchase_requisition_id` (`purchase_requisition_id`),
  ADD KEY `purchaseRequisitonInPotalTask` (`portal_task_id`),
  ADD KEY `FK4771783FBC74DF39` (`purchase_approver_user_id`),
  ADD KEY `FK4771783F69378A89` (`purchase_requistion_user_id`),
  ADD KEY `FK4771783FCCFD1D58` (`requisition_type_id`);

--
-- Indexes for table `tbl_religion`
--
ALTER TABLE `tbl_religion`
  ADD PRIMARY KEY (`religion_id`),
  ADD UNIQUE KEY `religion_id` (`religion_id`),
  ADD UNIQUE KEY `religion_name` (`religion_name`),
  ADD UNIQUE KEY `religion_name_2` (`religion_name`);

--
-- Indexes for table `tbl_report_card_generator`
--
ALTER TABLE `tbl_report_card_generator`
  ADD PRIMARY KEY (`report_card_generator_id`),
  ADD UNIQUE KEY `student_id` (`student_id`,`report_card_generator_id`),
  ADD KEY `AcademicYearInReportCardGenerator` (`academic_year_id`),
  ADD KEY `reportCardGeneratorInClassSection` (`class_section_id`),
  ADD KEY `reportCardGeneratorInInstitution` (`institution_id`),
  ADD KEY `reportCardGeneratorInStudent` (`student_id`);

--
-- Indexes for table `tbl_report_card_generator_detail`
--
ALTER TABLE `tbl_report_card_generator_detail`
  ADD PRIMARY KEY (`report_card_detail_id`),
  ADD KEY `reportCardGeneratorDetailInReportCardGenerator` (`report_card_generator_id`),
  ADD KEY `reportCardGeneratorsModuleBasedDetailInClassSectionModule` (`class_section_module_id`);

--
-- Indexes for table `tbl_requisition_type`
--
ALTER TABLE `tbl_requisition_type`
  ADD PRIMARY KEY (`requisition_type_id`);

--
-- Indexes for table `tbl_role_privilege_mapping`
--
ALTER TABLE `tbl_role_privilege_mapping`
  ADD PRIMARY KEY (`user_role_id`,`privilege_id`),
  ADD KEY `FK82FA375896059B9F` (`privilege_id`),
  ADD KEY `FK82FA3758BF2FB7CC` (`user_role_id`);

--
-- Indexes for table `tbl_section`
--
ALTER TABLE `tbl_section`
  ADD PRIMARY KEY (`section_id`),
  ADD UNIQUE KEY `section_name` (`section_name`,`institution_id`),
  ADD KEY `institutionInSections` (`institution_id`);

--
-- Indexes for table `tbl_sick_room_requisition`
--
ALTER TABLE `tbl_sick_room_requisition`
  ADD PRIMARY KEY (`sick_room_requisition_id`),
  ADD KEY `FKBA9826588EA71164` (`academic_year_id`),
  ADD KEY `FKBA98265864C79CFF` (`institution_id`),
  ADD KEY `sickRoomRequisitonInPotalTask` (`portal_task_id`),
  ADD KEY `FKBA982658CCFD1D58` (`requisition_type_id`),
  ADD KEY `sectionInSickRoomRequisition` (`section_id`),
  ADD KEY `userInSickRoomRequisition` (`sick_room_approver_id`),
  ADD KEY `studentClassInSickRoomRequisition` (`class_id`);

--
-- Indexes for table `tbl_special_category`
--
ALTER TABLE `tbl_special_category`
  ADD PRIMARY KEY (`special_category_id`),
  ADD UNIQUE KEY `special_category_id` (`special_category_id`),
  ADD UNIQUE KEY `special_category_name` (`special_category_name`),
  ADD UNIQUE KEY `institution_id` (`institution_id`,`special_category_name`),
  ADD KEY `specialCategoriesInModule` (`institution_id`);

--
-- Indexes for table `tbl_sponser`
--
ALTER TABLE `tbl_sponser`
  ADD PRIMARY KEY (`sponser_id`),
  ADD UNIQUE KEY `sponser_id` (`sponser_id`),
  ADD UNIQUE KEY `sponser_title` (`sponser_title`),
  ADD UNIQUE KEY `sponser_title_2` (`sponser_title`);

--
-- Indexes for table `tbl_staff`
--
ALTER TABLE `tbl_staff`
  ADD PRIMARY KEY (`staff_id`),
  ADD UNIQUE KEY `staff_code` (`staff_code`,`institution_id`),
  ADD UNIQUE KEY `staff_email` (`staff_email`),
  ADD UNIQUE KEY `staff_access_no` (`staff_access_no`,`institution_id`),
  ADD KEY `approverInStaff` (`approver_id`),
  ADD KEY `bloodGroupInStaffs` (`blood_group_id`),
  ADD KEY `categoryInStaffs` (`category_id`),
  ADD KEY `staffInInstitution` (`institution_id`),
  ADD KEY `staffDesignationInStaff` (`staff_designation_id`),
  ADD KEY `staffInStaffType` (`staff_type_id`),
  ADD KEY `userInStaff` (`user_id`);

--
-- Indexes for table `tbl_staff_attendance`
--
ALTER TABLE `tbl_staff_attendance`
  ADD PRIMARY KEY (`staff_attendance_id`),
  ADD UNIQUE KEY `academic_year_id` (`academic_year_id`,`date`,`staff_id`),
  ADD KEY `academicYearInStaffAttendance` (`academic_year_id`),
  ADD KEY `staffAttendanceInInstitution` (`institution_id`),
  ADD KEY `staffAttendanceInStaff` (`staff_id`);

--
-- Indexes for table `tbl_staff_attendance_configuration`
--
ALTER TABLE `tbl_staff_attendance_configuration`
  ADD PRIMARY KEY (`staff_attendance_configuration`),
  ADD UNIQUE KEY `institution_id` (`institution_id`),
  ADD KEY `institutionInStaffAttendance` (`institution_id`);

--
-- Indexes for table `tbl_staff_attendance_punch`
--
ALTER TABLE `tbl_staff_attendance_punch`
  ADD PRIMARY KEY (`staff_attendance_punch_id`),
  ADD KEY `staffAttendancePunchInStaffAttendance` (`staff_attendance_id`);

--
-- Indexes for table `tbl_staff_bank_detail`
--
ALTER TABLE `tbl_staff_bank_detail`
  ADD PRIMARY KEY (`staff_bank_detail_id`),
  ADD KEY `FK79111A94D46003BF` (`staff_id`);

--
-- Indexes for table `tbl_staff_designation`
--
ALTER TABLE `tbl_staff_designation`
  ADD PRIMARY KEY (`staff_designation_id`),
  ADD UNIQUE KEY `staff_designation_name` (`staff_designation_name`,`institution_id`),
  ADD KEY `staffDesignationInInstitution` (`institution_id`),
  ADD KEY `staffDesignationInStaffType` (`staff_type_id`);

--
-- Indexes for table `tbl_staff_experience_detail`
--
ALTER TABLE `tbl_staff_experience_detail`
  ADD PRIMARY KEY (`staff_experience_detail_id`),
  ADD KEY `staffExperienceDetailInStaff` (`staff_id`);

--
-- Indexes for table `tbl_staff_leave_requisition`
--
ALTER TABLE `tbl_staff_leave_requisition`
  ADD PRIMARY KEY (`staff_leave_requisition_id`),
  ADD KEY `FK6F0441F45FD871FB` (`approver_id`),
  ADD KEY `communicationNotificationInPotalTask` (`portal_task_id`),
  ADD KEY `staffLeaveRequisitionsInStaff` (`staff_id`),
  ADD KEY `FK6F0441F43D1DEAC5` (`staff_leave_type_id`),
  ADD KEY `FK6F0441F4CCFD1D58` (`requisition_type_id`);

--
-- Indexes for table `tbl_staff_leave_type`
--
ALTER TABLE `tbl_staff_leave_type`
  ADD PRIMARY KEY (`staff_leave_type_id`);

--
-- Indexes for table `tbl_staff_module_attendance`
--
ALTER TABLE `tbl_staff_module_attendance`
  ADD PRIMARY KEY (`staff_module_attendance_id`),
  ADD KEY `academicYearInStaffModuleAttendance` (`academic_year_id`),
  ADD KEY `staffModuleAttendanceInClassSectionModule` (`class_section_module_id`),
  ADD KEY `staffModuleAteendanceInSection` (`section_id`),
  ADD KEY `staffModuleAteendanceInStudent` (`student_id`),
  ADD KEY `staffModuleAttendanceInStudentAttendanceType` (`student_attendance_type_id`),
  ADD KEY `staffModuleAttendanceInClass` (`class_id`);

--
-- Indexes for table `tbl_staff_moment_requisition`
--
ALTER TABLE `tbl_staff_moment_requisition`
  ADD PRIMARY KEY (`staff_moment_requisition_id`),
  ADD KEY `staffMomentRequisitonInPotalTask` (`portal_task_id`),
  ADD KEY `FK907D6DFDCCFD1D58` (`requisition_type_id`),
  ADD KEY `staffMomentRequisitionsInStaff` (`staff_id`),
  ADD KEY `userInStaffMomentRequisition` (`staff_moment_approver_id`);

--
-- Indexes for table `tbl_staff_type`
--
ALTER TABLE `tbl_staff_type`
  ADD PRIMARY KEY (`staff_type_id`),
  ADD UNIQUE KEY `staff_type_name` (`staff_type_name`);

--
-- Indexes for table `tbl_student`
--
ALTER TABLE `tbl_student`
  ADD PRIMARY KEY (`student_id`),
  ADD UNIQUE KEY `institution_id` (`institution_id`,`admission_no`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `student_class_id` (`student_class_id`,`section_id`,`roll_no`),
  ADD KEY `FKA52B4ABA2FCDFC9F` (`admission_id`),
  ADD KEY `bloodGroupInStudents` (`blood_group_id`),
  ADD KEY `categoryInStudents` (`category_id`),
  ADD KEY `institutionInStudents` (`institution_id`),
  ADD KEY `academicYearInStudents` (`academic_year_id`),
  ADD KEY `joinedclassInStudents` (`joined_class_id`),
  ADD KEY `parentInStudent` (`parent_id`),
  ADD KEY `studentInSection` (`section_id`),
  ADD KEY `classInStudents` (`student_class_id`),
  ADD KEY `studentStatusInStudents` (`student_status_id`),
  ADD KEY `studentInUser` (`user_id`),
  ADD KEY `studentInHouses` (`house_id`);

--
-- Indexes for table `tbl_student_attendance`
--
ALTER TABLE `tbl_student_attendance`
  ADD PRIMARY KEY (`student_attendance_id`),
  ADD UNIQUE KEY `attendance_date` (`attendance_date`,`student_id`),
  ADD KEY `academicYearInStudentAttendance` (`academic_year_id`),
  ADD KEY `studentAttendancesInInstitution` (`institution_id`),
  ADD KEY `studentAttendanceInSection` (`section_id`),
  ADD KEY `studentAttendancesInStudent` (`student_id`),
  ADD KEY `studentAttendancesInStudentAttendanceType` (`student_attendance_type_id`),
  ADD KEY `studentAttendanceInClass` (`class_id`);

--
-- Indexes for table `tbl_student_attendance_type`
--
ALTER TABLE `tbl_student_attendance_type`
  ADD PRIMARY KEY (`student_attendance_type_id`),
  ADD UNIQUE KEY `student_attendance_type_name` (`student_attendance_type_name`);

--
-- Indexes for table `tbl_student_id_card_generation`
--
ALTER TABLE `tbl_student_id_card_generation`
  ADD PRIMARY KEY (`student_id_card_generation_id`),
  ADD UNIQUE KEY `student_class_id` (`student_class_id`,`section_id`,`academic_year_id`,`admission_no`),
  ADD KEY `academicYearInStudentIDCardGenerations` (`academic_year_id`),
  ADD KEY `bloodGroupInStudentIDCardGenerations` (`blood_group_id`),
  ADD KEY `institutionInStudentIDCardGenerations` (`institution_id`),
  ADD KEY `studentIDCardGenerationInSection` (`section_id`),
  ADD KEY `studentIDCardGenerationInStudent` (`student_id`),
  ADD KEY `classInStudentIDCardGenerations` (`student_class_id`),
  ADD KEY `studentStatusInStudentIDCardGenerations` (`student_status_id`);

--
-- Indexes for table `tbl_student_invoice`
--
ALTER TABLE `tbl_student_invoice`
  ADD PRIMARY KEY (`student_invoice_id`),
  ADD UNIQUE KEY `invoice_no` (`invoice_no`),
  ADD KEY `academicYearInStudentInvoices` (`academic_year_id`),
  ADD KEY `feesTermInStudentInvoices` (`fees_term_id`),
  ADD KEY `institutionInStudentInvoices` (`institution_id`),
  ADD KEY `studentInStudentInvoices` (`student_id`),
  ADD KEY `FKCD5FDAA8276BD400` (`studentReceipt_student_receipt_id`);

--
-- Indexes for table `tbl_student_invoice_details`
--
ALTER TABLE `tbl_student_invoice_details`
  ADD PRIMARY KEY (`student_invoice_detail_id`),
  ADD KEY `academicYearInStudentInvoiceDetail` (`academic_year_id`),
  ADD KEY `FeesItemInStudentInvoiceDetails` (`fees_item_id`),
  ADD KEY `studentInvoiceInStudentInvoiceDetails` (`student_invoice_id`);

--
-- Indexes for table `tbl_student_leave_requisition`
--
ALTER TABLE `tbl_student_leave_requisition`
  ADD PRIMARY KEY (`student_leave_requisition_id`),
  ADD KEY `FKAB665CCF5FD871FB` (`approver_id`),
  ADD KEY `studentLeaveRequisitonInPotalTask` (`portal_task_id`),
  ADD KEY `FKAB665CCFF075949F` (`student_id`),
  ADD KEY `FKAB665CCFA2A50B25` (`student_leave_type_id`),
  ADD KEY `FKAB665CCF7C31216F` (`student_leave_type_id`),
  ADD KEY `FKAB665CCFCCFD1D58` (`requisition_type_id`);

--
-- Indexes for table `tbl_student_leave_type`
--
ALTER TABLE `tbl_student_leave_type`
  ADD PRIMARY KEY (`student_leave_type_id`);

--
-- Indexes for table `tbl_student_marks`
--
ALTER TABLE `tbl_student_marks`
  ADD PRIMARY KEY (`student_mark_id`),
  ADD UNIQUE KEY `student_mark_id` (`student_mark_id`,`class_section_term_exam_id`),
  ADD KEY `AcademicYearInStudentMark` (`academic_year_id`),
  ADD KEY `studentMarksInClassSection` (`class_section_id`),
  ADD KEY `studentMarksInClassSectionAssessmentType` (`class_section_assesment_type_id`),
  ADD KEY `studentMarksInClassSectionTermExam` (`class_section_term_exam_id`),
  ADD KEY `studentMarkInInstitution` (`institution_id`),
  ADD KEY `studentMarksInStudent` (`student_id`);

--
-- Indexes for table `tbl_student_marks_details`
--
ALTER TABLE `tbl_student_marks_details`
  ADD PRIMARY KEY (`student_marks_details_id`),
  ADD KEY `studentMarksDetailInClassSectionTermExamActivity` (`class_section_term_exam_activity_id`),
  ADD KEY `studentMarksDetailInStudentMark` (`student_mark_id`),
  ADD KEY `studentMarksModuleBasedDetailInClassSectionModule` (`class_section_module_id`),
  ADD KEY `studentMarksModuleSkillDetailInClassSectionModuleSkill` (`class_section_module_skill_id`);

--
-- Indexes for table `tbl_student_receipt`
--
ALTER TABLE `tbl_student_receipt`
  ADD PRIMARY KEY (`student_receipt_id`),
  ADD KEY `academicYearInStudentReceipts` (`academic_year_id`),
  ADD KEY `institutionInStudentReceipts` (`institution_id`),
  ADD KEY `paymentModeInStudentReceipts` (`payment_mode_id`),
  ADD KEY `paymentStatusInStudentReceipts` (`payment_status_id`),
  ADD KEY `studentInStudentReceipts` (`student_id`),
  ADD KEY `studentReceiptInStudentInvoice` (`student_invoice_id`);

--
-- Indexes for table `tbl_student_receipt_detail`
--
ALTER TABLE `tbl_student_receipt_detail`
  ADD PRIMARY KEY (`student_receipt_detail_id`),
  ADD KEY `academicYearInStudentReceiptDetail` (`academic_year_id`),
  ADD KEY `feesItemInStudentReceiptDetails` (`fees_item_id`),
  ADD KEY `paymentStatusInStudentReceiptDetail` (`payment_status_id`),
  ADD KEY `studentReceiptDetailInStudentInvoiceDetail` (`student_invoice_detail_id`),
  ADD KEY `studentReceiptInStudentReceiptDetails` (`student_receipt_id`);

--
-- Indexes for table `tbl_student_receipt_fine`
--
ALTER TABLE `tbl_student_receipt_fine`
  ADD PRIMARY KEY (`student_receipt_fine_id`),
  ADD KEY `academicYearInStudentReceiptFine` (`academic_year_id`),
  ADD KEY `studentReceiptInStudentReceiptFines` (`student_receipt_id`);

--
-- Indexes for table `tbl_student_special_categories`
--
ALTER TABLE `tbl_student_special_categories`
  ADD PRIMARY KEY (`student_id`,`special_category_id`),
  ADD KEY `specialCategoryInStudents` (`special_category_id`),
  ADD KEY `studentsInSpecialCategory` (`student_id`);

--
-- Indexes for table `tbl_student_status`
--
ALTER TABLE `tbl_student_status`
  ADD PRIMARY KEY (`student_status_id`),
  ADD UNIQUE KEY `student_status_id` (`student_status_id`),
  ADD UNIQUE KEY `status_title` (`status_title`);

--
-- Indexes for table `tbl_supplier_master`
--
ALTER TABLE `tbl_supplier_master`
  ADD PRIMARY KEY (`supplier_id`),
  ADD UNIQUE KEY `supplier_id` (`supplier_id`),
  ADD UNIQUE KEY `supplier_code` (`supplier_code`);

--
-- Indexes for table `tbl_tax_class`
--
ALTER TABLE `tbl_tax_class`
  ADD PRIMARY KEY (`tax_id`),
  ADD UNIQUE KEY `tax_type_name` (`tax_type_name`);

--
-- Indexes for table `tbl_term`
--
ALTER TABLE `tbl_term`
  ADD PRIMARY KEY (`term_id`),
  ADD UNIQUE KEY `term_name` (`term_name`,`exam_template_id`),
  ADD KEY `examTemplateInTerm` (`exam_template_id`);

--
-- Indexes for table `tbl_term_exam`
--
ALTER TABLE `tbl_term_exam`
  ADD PRIMARY KEY (`term_exam_id`),
  ADD UNIQUE KEY `term_exam_name` (`term_exam_name`,`term_id`),
  ADD KEY `termInTermExam` (`term_id`);

--
-- Indexes for table `tbl_time_table_generator`
--
ALTER TABLE `tbl_time_table_generator`
  ADD PRIMARY KEY (`time_table_generator_id`),
  ADD KEY `timeTableGeneratorsInClassSection` (`class_section_id`),
  ADD KEY `timeTableGeneratorInInstitution` (`institution_id`),
  ADD KEY `timeTableGeneratorInAcademicYear` (`academic_year_id`);

--
-- Indexes for table `tbl_time_table_generator_days`
--
ALTER TABLE `tbl_time_table_generator_days`
  ADD PRIMARY KEY (`time_table_generator_day_id`),
  ADD KEY `timeTableGeneratorDaysInTimeTableGenerator` (`time_table_generator_id`);

--
-- Indexes for table `tbl_time_table_generator_hours`
--
ALTER TABLE `tbl_time_table_generator_hours`
  ADD PRIMARY KEY (`time_table_generator_hour_id`),
  ADD KEY `timeTableGeneratorHoursInModule` (`module_id`),
  ADD KEY `timeTableGeneratorHoursInTimeTableGeneratorDays` (`time_table_generator_day_id`);

--
-- Indexes for table `tbl_time_table_template`
--
ALTER TABLE `tbl_time_table_template`
  ADD PRIMARY KEY (`time_table_template_id`),
  ADD UNIQUE KEY `time_table_name` (`time_table_name`,`institution_id`),
  ADD KEY `timeTableTemplateInInstitution` (`institution_id`);

--
-- Indexes for table `tbl_time_table_template_days`
--
ALTER TABLE `tbl_time_table_template_days`
  ADD PRIMARY KEY (`time_table_template_day_id`),
  ADD UNIQUE KEY `time_table_template_day_name` (`time_table_template_day_name`,`time_table_template_id`),
  ADD KEY `timeTableTemplateInTimeTableTemplateDays` (`time_table_template_id`);

--
-- Indexes for table `tbl_time_table_template_hours`
--
ALTER TABLE `tbl_time_table_template_hours`
  ADD PRIMARY KEY (`time_table_template_hour_id`),
  ADD UNIQUE KEY `time_table_template_hour_name` (`time_table_template_hour_name`,`time_table_template_id`),
  ADD KEY `timeTableTemplateInTimeTableTemplateHours` (`time_table_template_id`);

--
-- Indexes for table `tbl_transfer_certificate_requisition`
--
ALTER TABLE `tbl_transfer_certificate_requisition`
  ADD PRIMARY KEY (`tc_requisition_id`),
  ADD KEY `academicYearInTCRequisition` (`academic_year_id`),
  ADD KEY `institutionInTCRequisition` (`institution_id`),
  ADD KEY `tCRequisitonInPotalTask` (`portal_task_id`),
  ADD KEY `FK74B72601CCFD1D58` (`requisition_type_id`),
  ADD KEY `sectionInTCRequisition` (`section_id`),
  ADD KEY `studentInTCRequisition` (`student_id`),
  ADD KEY `classInTCRequisition` (`class_id`),
  ADD KEY `userInTCRequisition` (`tc_approver_id`);

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `institutionInUsers` (`institution_id`);

--
-- Indexes for table `tbl_user_and_role_mapping`
--
ALTER TABLE `tbl_user_and_role_mapping`
  ADD PRIMARY KEY (`user_id`,`user_role_id`),
  ADD KEY `FK1D67F3A0BF2FB7CC` (`user_role_id`),
  ADD KEY `FK1D67F3A02D1F8735` (`user_id`);

--
-- Indexes for table `tbl_user_role`
--
ALTER TABLE `tbl_user_role`
  ADD PRIMARY KEY (`user_role_id`),
  ADD UNIQUE KEY `institution_id` (`institution_id`,`role_name`),
  ADD KEY `institutionInUserRoles` (`institution_id`);

--
-- Indexes for table `tbl_visitor_id_card_generation`
--
ALTER TABLE `tbl_visitor_id_card_generation`
  ADD PRIMARY KEY (`visitor_id_card_generation_id`),
  ADD KEY `institutionInVisitorIDCardGenerations` (`institution_id`);

--
-- Indexes for table `tbl_visitor_management`
--
ALTER TABLE `tbl_visitor_management`
  ADD PRIMARY KEY (`visitor_management_id`),
  ADD KEY `visitorIDCardGenerationInvisitorManagement` (`visitorIDCardGenerationId`),
  ADD KEY `FKB8166AD57B5B647C` (`visitor_type_id`),
  ADD KEY `institutionInVisitorManagement` (`institution_id`);

--
-- Indexes for table `tbl_visitor_type`
--
ALTER TABLE `tbl_visitor_type`
  ADD PRIMARY KEY (`visitor_type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_academic_year`
--
ALTER TABLE `tbl_academic_year`
  MODIFY `academic_year_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_academic_year_fees_term`
--
ALTER TABLE `tbl_academic_year_fees_term`
  MODIFY `academic_year_fees_term_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_admission`
--
ALTER TABLE `tbl_admission`
  MODIFY `admission_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_admission_config`
--
ALTER TABLE `tbl_admission_config`
  MODIFY `admission_config_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_admission_document`
--
ALTER TABLE `tbl_admission_document`
  MODIFY `admission_document_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `tbl_admission_document_types`
--
ALTER TABLE `tbl_admission_document_types`
  MODIFY `admission_document_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_admission_education_level_detail`
--
ALTER TABLE `tbl_admission_education_level_detail`
  MODIFY `admission_education_level_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_admission_education_level_subject`
--
ALTER TABLE `tbl_admission_education_level_subject`
  MODIFY `admission_education_level_subject_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_admission_fees_payment_details`
--
ALTER TABLE `tbl_admission_fees_payment_details`
  MODIFY `fees_payment_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_admission_process_status`
--
ALTER TABLE `tbl_admission_process_status`
  MODIFY `admission_process_status_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_admission_status`
--
ALTER TABLE `tbl_admission_status`
  MODIFY `admission_status_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_assesment_type`
--
ALTER TABLE `tbl_assesment_type`
  MODIFY `assesment_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_blood_group`
--
ALTER TABLE `tbl_blood_group`
  MODIFY `blood_group_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tbl_category`
--
ALTER TABLE `tbl_category`
  MODIFY `category_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tbl_class`
--
ALTER TABLE `tbl_class`
  MODIFY `class_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_class_section`
--
ALTER TABLE `tbl_class_section`
  MODIFY `class_section_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_class_section_assesment_type`
--
ALTER TABLE `tbl_class_section_assesment_type`
  MODIFY `class_section_assesment_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_class_section_coscholastic_activity`
--
ALTER TABLE `tbl_class_section_coscholastic_activity`
  MODIFY `class_section_coscholastic_activity_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_class_section_coscholastic_activity_exam`
--
ALTER TABLE `tbl_class_section_coscholastic_activity_exam`
  MODIFY `class_section_coscholastic_activity_exam_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_class_section_coscholastic_area`
--
ALTER TABLE `tbl_class_section_coscholastic_area`
  MODIFY `class_section_coscholastic_area_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_class_section_coscholastic_area_exam`
--
ALTER TABLE `tbl_class_section_coscholastic_area_exam`
  MODIFY `class_section_coscholastic_area_exam_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_class_section_module`
--
ALTER TABLE `tbl_class_section_module`
  MODIFY `class_section_module_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `tbl_class_section_module_exam`
--
ALTER TABLE `tbl_class_section_module_exam`
  MODIFY `class_section_module_exam_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_class_section_module_skill`
--
ALTER TABLE `tbl_class_section_module_skill`
  MODIFY `class_section_module_skill_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_class_section_module_skill_exam`
--
ALTER TABLE `tbl_class_section_module_skill_exam`
  MODIFY `class_section_module_skill_exam_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_class_section_module_staff`
--
ALTER TABLE `tbl_class_section_module_staff`
  MODIFY `class_section_module_staff_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `tbl_class_section_term`
--
ALTER TABLE `tbl_class_section_term`
  MODIFY `class_section_term_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_class_section_term_exam`
--
ALTER TABLE `tbl_class_section_term_exam`
  MODIFY `class_section_term_exam_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `tbl_class_section_term_exam_activity`
--
ALTER TABLE `tbl_class_section_term_exam_activity`
  MODIFY `class_section_term_exam_activity_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_communication_feedback_and_others`
--
ALTER TABLE `tbl_communication_feedback_and_others`
  MODIFY `communication_feedback_and_others_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_communication_feedback_and_others_archive`
--
ALTER TABLE `tbl_communication_feedback_and_others_archive`
  MODIFY `communication_feedback_and_others_archive_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_communication_feedback_and_others_history`
--
ALTER TABLE `tbl_communication_feedback_and_others_history`
  MODIFY `communication_feedback_and_others_history_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_communication_message_mode`
--
ALTER TABLE `tbl_communication_message_mode`
  MODIFY `communication_message_mode_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_communication_notification`
--
ALTER TABLE `tbl_communication_notification`
  MODIFY `communication_notification_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_communication_notification_archive`
--
ALTER TABLE `tbl_communication_notification_archive`
  MODIFY `communication_notification_archive_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_communication_target_group`
--
ALTER TABLE `tbl_communication_target_group`
  MODIFY `communication_target_group_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tbl_co_scholastic_activity`
--
ALTER TABLE `tbl_co_scholastic_activity`
  MODIFY `co_scholastic_activity_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_co_scholastic_activity_indicator`
--
ALTER TABLE `tbl_co_scholastic_activity_indicator`
  MODIFY `co_scholastic_activity_indicator_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tbl_co_scholastic_area`
--
ALTER TABLE `tbl_co_scholastic_area`
  MODIFY `co_scholastic_area_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_co_scholastic_area_indicator`
--
ALTER TABLE `tbl_co_scholastic_area_indicator`
  MODIFY `co_scholastic_area_indicator_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `tbl_education_level`
--
ALTER TABLE `tbl_education_level`
  MODIFY `education_level_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `tbl_education_level_subject`
--
ALTER TABLE `tbl_education_level_subject`
  MODIFY `education_level_subject_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;
--
-- AUTO_INCREMENT for table `tbl_exam_template`
--
ALTER TABLE `tbl_exam_template`
  MODIFY `exam_template_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_fees_item`
--
ALTER TABLE `tbl_fees_item`
  MODIFY `fees_item_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_fees_structure`
--
ALTER TABLE `tbl_fees_structure`
  MODIFY `fees_structure_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_fees_term`
--
ALTER TABLE `tbl_fees_term`
  MODIFY `fees_term_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_geographical_location`
--
ALTER TABLE `tbl_geographical_location`
  MODIFY `location_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6178;
--
-- AUTO_INCREMENT for table `tbl_grade_system`
--
ALTER TABLE `tbl_grade_system`
  MODIFY `grade_system_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_grade_system_detail`
--
ALTER TABLE `tbl_grade_system_detail`
  MODIFY `grade_system_detail_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_heared_us`
--
ALTER TABLE `tbl_heared_us`
  MODIFY `hearedus_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_houses`
--
ALTER TABLE `tbl_houses`
  MODIFY `house_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_institution`
--
ALTER TABLE `tbl_institution`
  MODIFY `institution_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_institution_ledger_account`
--
ALTER TABLE `tbl_institution_ledger_account`
  MODIFY `ledger_account_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_inventory_category`
--
ALTER TABLE `tbl_inventory_category`
  MODIFY `inventory_category_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tbl_inventory_item_master`
--
ALTER TABLE `tbl_inventory_item_master`
  MODIFY `item_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_inventory_purchase_order`
--
ALTER TABLE `tbl_inventory_purchase_order`
  MODIFY `purchase_order_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_inventory_purchase_order_details`
--
ALTER TABLE `tbl_inventory_purchase_order_details`
  MODIFY `purchase_order_detail_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_inventory_receipt`
--
ALTER TABLE `tbl_inventory_receipt`
  MODIFY `inventory_receipt_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_inventory_requisition`
--
ALTER TABLE `tbl_inventory_requisition`
  MODIFY `inventory_requisition_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_inventory_type`
--
ALTER TABLE `tbl_inventory_type`
  MODIFY `inventory_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tbl_license`
--
ALTER TABLE `tbl_license`
  MODIFY `license_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_module`
--
ALTER TABLE `tbl_module`
  MODIFY `module_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_module_plan`
--
ALTER TABLE `tbl_module_plan`
  MODIFY `module_plan_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_module_plan_schedule`
--
ALTER TABLE `tbl_module_plan_schedule`
  MODIFY `module_plan_schedule_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_module_skill`
--
ALTER TABLE `tbl_module_skill`
  MODIFY `module_skill_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_module_skill_indicator`
--
ALTER TABLE `tbl_module_skill_indicator`
  MODIFY `module_skill_indicator_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `tbl_moment_requisition`
--
ALTER TABLE `tbl_moment_requisition`
  MODIFY `moment_requisition_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_payment_mode`
--
ALTER TABLE `tbl_payment_mode`
  MODIFY `payment_mode_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_payment_status`
--
ALTER TABLE `tbl_payment_status`
  MODIFY `payment_status_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_portal_message`
--
ALTER TABLE `tbl_portal_message`
  MODIFY `portal_message_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_portal_notification`
--
ALTER TABLE `tbl_portal_notification`
  MODIFY `portal_notification_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_portal_reply_message`
--
ALTER TABLE `tbl_portal_reply_message`
  MODIFY `portal_reply_message_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_portal_task`
--
ALTER TABLE `tbl_portal_task`
  MODIFY `portal_task_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT for table `tbl_privilege`
--
ALTER TABLE `tbl_privilege`
  MODIFY `privilege_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=178;
--
-- AUTO_INCREMENT for table `tbl_purchase_requisition`
--
ALTER TABLE `tbl_purchase_requisition`
  MODIFY `purchase_requisition_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_religion`
--
ALTER TABLE `tbl_religion`
  MODIFY `religion_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_report_card_generator`
--
ALTER TABLE `tbl_report_card_generator`
  MODIFY `report_card_generator_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_report_card_generator_detail`
--
ALTER TABLE `tbl_report_card_generator_detail`
  MODIFY `report_card_detail_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_requisition_type`
--
ALTER TABLE `tbl_requisition_type`
  MODIFY `requisition_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_section`
--
ALTER TABLE `tbl_section`
  MODIFY `section_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_sick_room_requisition`
--
ALTER TABLE `tbl_sick_room_requisition`
  MODIFY `sick_room_requisition_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_special_category`
--
ALTER TABLE `tbl_special_category`
  MODIFY `special_category_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_sponser`
--
ALTER TABLE `tbl_sponser`
  MODIFY `sponser_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_staff`
--
ALTER TABLE `tbl_staff`
  MODIFY `staff_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_staff_attendance`
--
ALTER TABLE `tbl_staff_attendance`
  MODIFY `staff_attendance_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `tbl_staff_attendance_configuration`
--
ALTER TABLE `tbl_staff_attendance_configuration`
  MODIFY `staff_attendance_configuration` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_staff_attendance_punch`
--
ALTER TABLE `tbl_staff_attendance_punch`
  MODIFY `staff_attendance_punch_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;
--
-- AUTO_INCREMENT for table `tbl_staff_bank_detail`
--
ALTER TABLE `tbl_staff_bank_detail`
  MODIFY `staff_bank_detail_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_staff_designation`
--
ALTER TABLE `tbl_staff_designation`
  MODIFY `staff_designation_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_staff_experience_detail`
--
ALTER TABLE `tbl_staff_experience_detail`
  MODIFY `staff_experience_detail_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_staff_leave_requisition`
--
ALTER TABLE `tbl_staff_leave_requisition`
  MODIFY `staff_leave_requisition_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tbl_staff_leave_type`
--
ALTER TABLE `tbl_staff_leave_type`
  MODIFY `staff_leave_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_staff_module_attendance`
--
ALTER TABLE `tbl_staff_module_attendance`
  MODIFY `staff_module_attendance_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=556;
--
-- AUTO_INCREMENT for table `tbl_staff_moment_requisition`
--
ALTER TABLE `tbl_staff_moment_requisition`
  MODIFY `staff_moment_requisition_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_staff_type`
--
ALTER TABLE `tbl_staff_type`
  MODIFY `staff_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_student`
--
ALTER TABLE `tbl_student`
  MODIFY `student_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;
--
-- AUTO_INCREMENT for table `tbl_student_attendance`
--
ALTER TABLE `tbl_student_attendance`
  MODIFY `student_attendance_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1224;
--
-- AUTO_INCREMENT for table `tbl_student_attendance_type`
--
ALTER TABLE `tbl_student_attendance_type`
  MODIFY `student_attendance_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_student_id_card_generation`
--
ALTER TABLE `tbl_student_id_card_generation`
  MODIFY `student_id_card_generation_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=338;
--
-- AUTO_INCREMENT for table `tbl_student_invoice`
--
ALTER TABLE `tbl_student_invoice`
  MODIFY `student_invoice_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;
--
-- AUTO_INCREMENT for table `tbl_student_invoice_details`
--
ALTER TABLE `tbl_student_invoice_details`
  MODIFY `student_invoice_detail_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=691;
--
-- AUTO_INCREMENT for table `tbl_student_leave_requisition`
--
ALTER TABLE `tbl_student_leave_requisition`
  MODIFY `student_leave_requisition_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_student_leave_type`
--
ALTER TABLE `tbl_student_leave_type`
  MODIFY `student_leave_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_student_marks`
--
ALTER TABLE `tbl_student_marks`
  MODIFY `student_mark_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `tbl_student_marks_details`
--
ALTER TABLE `tbl_student_marks_details`
  MODIFY `student_marks_details_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `tbl_student_receipt`
--
ALTER TABLE `tbl_student_receipt`
  MODIFY `student_receipt_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_supplier_master`
--
ALTER TABLE `tbl_supplier_master`
  MODIFY `supplier_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_tax_class`
--
ALTER TABLE `tbl_tax_class`
  MODIFY `tax_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_transfer_certificate_requisition`
--
ALTER TABLE `tbl_transfer_certificate_requisition`
  MODIFY `tc_requisition_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `tbl_visitor_id_card_generation`
--
ALTER TABLE `tbl_visitor_id_card_generation`
  MODIFY `visitor_id_card_generation_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_visitor_management`
--
ALTER TABLE `tbl_visitor_management`
  MODIFY `visitor_management_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_visitor_type`
--
ALTER TABLE `tbl_visitor_type`
  MODIFY `visitor_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_class_section`
--
ALTER TABLE `tbl_class_section`
  ADD CONSTRAINT `FKE0AE045DD46003BF` FOREIGN KEY (`staff_id`) REFERENCES `tbl_staff` (`staff_id`);

--
-- Constraints for table `tbl_houses`
--
ALTER TABLE `tbl_houses`
  ADD CONSTRAINT `housesInInstitution` FOREIGN KEY (`institution_id`) REFERENCES `tbl_institution` (`institution_id`);

--
-- Constraints for table `tbl_inventory_item_master`
--
ALTER TABLE `tbl_inventory_item_master`
  ADD CONSTRAINT `FK822F6CEA4249BC18` FOREIGN KEY (`inventory_type_id`) REFERENCES `tbl_inventory_type` (`inventory_type_id`),
  ADD CONSTRAINT `FK822F6CEA53282F04` FOREIGN KEY (`in_charge_user_id`) REFERENCES `tbl_users` (`user_id`),
  ADD CONSTRAINT `FK822F6CEA597F6C97` FOREIGN KEY (`issue_to_user_id`) REFERENCES `tbl_users` (`user_id`),
  ADD CONSTRAINT `FK822F6CEAA83D2BBE` FOREIGN KEY (`tax_class_id`) REFERENCES `tbl_tax_class` (`tax_id`),
  ADD CONSTRAINT `FK822F6CEAB5443698` FOREIGN KEY (`inventory_category_id`) REFERENCES `tbl_inventory_category` (`inventory_category_id`);

--
-- Constraints for table `tbl_inventory_purchase_order`
--
ALTER TABLE `tbl_inventory_purchase_order`
  ADD CONSTRAINT `FK64F3C1342489205F` FOREIGN KEY (`inventoryReceipt_inventory_receipt_id`) REFERENCES `tbl_inventory_receipt` (`inventory_receipt_id`),
  ADD CONSTRAINT `academicYearInInventoryPurchaseOrder` FOREIGN KEY (`academic_year_id`) REFERENCES `tbl_academic_year` (`academic_year_id`),
  ADD CONSTRAINT `institutionInInventoryPurchaseOrder` FOREIGN KEY (`institution_id`) REFERENCES `tbl_institution` (`institution_id`),
  ADD CONSTRAINT `supplierMasterInInventoryPurchaseOrder` FOREIGN KEY (`supplier_id`) REFERENCES `tbl_supplier_master` (`supplier_id`);

--
-- Constraints for table `tbl_inventory_purchase_order_details`
--
ALTER TABLE `tbl_inventory_purchase_order_details`
  ADD CONSTRAINT `inventoryItemMasterInInventoryPurchaseOrderDetails` FOREIGN KEY (`inventory_item_master_id`) REFERENCES `tbl_inventory_item_master` (`item_id`),
  ADD CONSTRAINT `inventoryPurchaseOrderInInventoryPurchaseOrderDetails` FOREIGN KEY (`purchase_order_id`) REFERENCES `tbl_inventory_purchase_order` (`purchase_order_id`);

--
-- Constraints for table `tbl_inventory_receipt`
--
ALTER TABLE `tbl_inventory_receipt`
  ADD CONSTRAINT `InventoryItemMasterInInventoryReceipts` FOREIGN KEY (`inventory_master_id`) REFERENCES `tbl_inventory_item_master` (`item_id`),
  ADD CONSTRAINT `academicYearInInventoryReceipt` FOREIGN KEY (`academic_year_id`) REFERENCES `tbl_academic_year` (`academic_year_id`),
  ADD CONSTRAINT `inventoryReceiptInInventoryPurchaseOrder` FOREIGN KEY (`inventory_purchase_order_id`) REFERENCES `tbl_inventory_purchase_order` (`purchase_order_id`),
  ADD CONSTRAINT `inventoryReceiptsInTaxClass` FOREIGN KEY (`tax_id`) REFERENCES `tbl_tax_class` (`tax_id`),
  ADD CONSTRAINT `paymentModeInInventoryReceipts` FOREIGN KEY (`payment_mode_id`) REFERENCES `tbl_payment_mode` (`payment_mode_id`),
  ADD CONSTRAINT `supplierMasterInInventoryReceipt` FOREIGN KEY (`supplier_id`) REFERENCES `tbl_supplier_master` (`supplier_id`);

--
-- Constraints for table `tbl_inventory_requisition`
--
ALTER TABLE `tbl_inventory_requisition`
  ADD CONSTRAINT `FKBBD71C7867F3C8C2` FOREIGN KEY (`inventory_requistion_approver_user_id`) REFERENCES `tbl_users` (`user_id`),
  ADD CONSTRAINT `FKBBD71C78BD772A4E` FOREIGN KEY (`inventory_requistion_user_id`) REFERENCES `tbl_users` (`user_id`),
  ADD CONSTRAINT `FKBBD71C78E42698FA` FOREIGN KEY (`inventory_item_id`) REFERENCES `tbl_inventory_item_master` (`item_id`),
  ADD CONSTRAINT `inventoryRequisitonInPotalTask` FOREIGN KEY (`portal_task_id`) REFERENCES `tbl_portal_task` (`portal_task_id`);

--
-- Constraints for table `tbl_moment_requisition`
--
ALTER TABLE `tbl_moment_requisition`
  ADD CONSTRAINT `FKF4972FECCFD1D58` FOREIGN KEY (`requisition_type_id`) REFERENCES `tbl_requisition_type` (`requisition_type_id`),
  ADD CONSTRAINT `academicYearInMomentRequisition` FOREIGN KEY (`academic_year_id`) REFERENCES `tbl_academic_year` (`academic_year_id`),
  ADD CONSTRAINT `classInMomentRequisition` FOREIGN KEY (`class_id`) REFERENCES `tbl_class` (`class_id`),
  ADD CONSTRAINT `institutionInMomentRequisition` FOREIGN KEY (`institution_id`) REFERENCES `tbl_institution` (`institution_id`),
  ADD CONSTRAINT `momentRequisitonInPotalTask` FOREIGN KEY (`portal_task_id`) REFERENCES `tbl_portal_task` (`portal_task_id`),
  ADD CONSTRAINT `sectionInMomentRequisition` FOREIGN KEY (`section_id`) REFERENCES `tbl_section` (`section_id`),
  ADD CONSTRAINT `studentInMomentRequisition` FOREIGN KEY (`student_id`) REFERENCES `tbl_student` (`student_id`),
  ADD CONSTRAINT `userInMomentRequisition` FOREIGN KEY (`tc_approver_id`) REFERENCES `tbl_users` (`user_id`);

--
-- Constraints for table `tbl_purchase_requisition`
--
ALTER TABLE `tbl_purchase_requisition`
  ADD CONSTRAINT `FK4771783F69378A89` FOREIGN KEY (`purchase_requistion_user_id`) REFERENCES `tbl_users` (`user_id`),
  ADD CONSTRAINT `FK4771783FBC74DF39` FOREIGN KEY (`purchase_approver_user_id`) REFERENCES `tbl_users` (`user_id`),
  ADD CONSTRAINT `FK4771783FCCFD1D58` FOREIGN KEY (`requisition_type_id`) REFERENCES `tbl_requisition_type` (`requisition_type_id`),
  ADD CONSTRAINT `purchaseRequisitonInPotalTask` FOREIGN KEY (`portal_task_id`) REFERENCES `tbl_portal_task` (`portal_task_id`);

--
-- Constraints for table `tbl_sick_room_requisition`
--
ALTER TABLE `tbl_sick_room_requisition`
  ADD CONSTRAINT `FKBA98265864C79CFF` FOREIGN KEY (`institution_id`) REFERENCES `tbl_institution` (`institution_id`),
  ADD CONSTRAINT `FKBA9826588EA71164` FOREIGN KEY (`academic_year_id`) REFERENCES `tbl_academic_year` (`academic_year_id`),
  ADD CONSTRAINT `FKBA982658CCFD1D58` FOREIGN KEY (`requisition_type_id`) REFERENCES `tbl_requisition_type` (`requisition_type_id`),
  ADD CONSTRAINT `sectionInSickRoomRequisition` FOREIGN KEY (`section_id`) REFERENCES `tbl_section` (`section_id`),
  ADD CONSTRAINT `sickRoomRequisitonInPotalTask` FOREIGN KEY (`portal_task_id`) REFERENCES `tbl_portal_task` (`portal_task_id`),
  ADD CONSTRAINT `studentClassInSickRoomRequisition` FOREIGN KEY (`class_id`) REFERENCES `tbl_class` (`class_id`),
  ADD CONSTRAINT `userInSickRoomRequisition` FOREIGN KEY (`sick_room_approver_id`) REFERENCES `tbl_users` (`user_id`);

--
-- Constraints for table `tbl_staff_leave_requisition`
--
ALTER TABLE `tbl_staff_leave_requisition`
  ADD CONSTRAINT `FK6F0441F4CCFD1D58` FOREIGN KEY (`requisition_type_id`) REFERENCES `tbl_requisition_type` (`requisition_type_id`);

--
-- Constraints for table `tbl_staff_moment_requisition`
--
ALTER TABLE `tbl_staff_moment_requisition`
  ADD CONSTRAINT `FK907D6DFDCCFD1D58` FOREIGN KEY (`requisition_type_id`) REFERENCES `tbl_requisition_type` (`requisition_type_id`),
  ADD CONSTRAINT `staffMomentRequisitionsInStaff` FOREIGN KEY (`staff_id`) REFERENCES `tbl_staff` (`staff_id`),
  ADD CONSTRAINT `staffMomentRequisitonInPotalTask` FOREIGN KEY (`portal_task_id`) REFERENCES `tbl_portal_task` (`portal_task_id`),
  ADD CONSTRAINT `userInStaffMomentRequisition` FOREIGN KEY (`staff_moment_approver_id`) REFERENCES `tbl_users` (`user_id`);

--
-- Constraints for table `tbl_student`
--
ALTER TABLE `tbl_student`
  ADD CONSTRAINT `studentInHouses` FOREIGN KEY (`house_id`) REFERENCES `tbl_houses` (`house_id`);

--
-- Constraints for table `tbl_student_leave_requisition`
--
ALTER TABLE `tbl_student_leave_requisition`
  ADD CONSTRAINT `FKAB665CCF7C31216F` FOREIGN KEY (`student_leave_type_id`) REFERENCES `tbl_student_leave_type` (`student_leave_type_id`),
  ADD CONSTRAINT `FKAB665CCFCCFD1D58` FOREIGN KEY (`requisition_type_id`) REFERENCES `tbl_requisition_type` (`requisition_type_id`);

--
-- Constraints for table `tbl_transfer_certificate_requisition`
--
ALTER TABLE `tbl_transfer_certificate_requisition`
  ADD CONSTRAINT `FK74B72601CCFD1D58` FOREIGN KEY (`requisition_type_id`) REFERENCES `tbl_requisition_type` (`requisition_type_id`),
  ADD CONSTRAINT `academicYearInTCRequisition` FOREIGN KEY (`academic_year_id`) REFERENCES `tbl_academic_year` (`academic_year_id`),
  ADD CONSTRAINT `classInTCRequisition` FOREIGN KEY (`class_id`) REFERENCES `tbl_class` (`class_id`),
  ADD CONSTRAINT `institutionInTCRequisition` FOREIGN KEY (`institution_id`) REFERENCES `tbl_institution` (`institution_id`),
  ADD CONSTRAINT `sectionInTCRequisition` FOREIGN KEY (`section_id`) REFERENCES `tbl_section` (`section_id`),
  ADD CONSTRAINT `studentInTCRequisition` FOREIGN KEY (`student_id`) REFERENCES `tbl_student` (`student_id`),
  ADD CONSTRAINT `tCRequisitonInPotalTask` FOREIGN KEY (`portal_task_id`) REFERENCES `tbl_portal_task` (`portal_task_id`),
  ADD CONSTRAINT `userInTCRequisition` FOREIGN KEY (`tc_approver_id`) REFERENCES `tbl_users` (`user_id`);

--
-- Constraints for table `tbl_visitor_id_card_generation`
--
ALTER TABLE `tbl_visitor_id_card_generation`
  ADD CONSTRAINT `institutionInVisitorIDCardGenerations` FOREIGN KEY (`institution_id`) REFERENCES `tbl_institution` (`institution_id`);

--
-- Constraints for table `tbl_visitor_management`
--
ALTER TABLE `tbl_visitor_management`
  ADD CONSTRAINT `FKB8166AD57B5B647C` FOREIGN KEY (`visitor_type_id`) REFERENCES `tbl_visitor_type` (`visitor_type_id`),
  ADD CONSTRAINT `institutionInVisitorManagement` FOREIGN KEY (`institution_id`) REFERENCES `tbl_institution` (`institution_id`),
  ADD CONSTRAINT `visitorIDCardGenerationInvisitorManagement` FOREIGN KEY (`visitorIDCardGenerationId`) REFERENCES `tbl_visitor_id_card_generation` (`visitor_id_card_generation_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
